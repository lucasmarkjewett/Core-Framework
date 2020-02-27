package com.openrsc.server.model.container;

import com.openrsc.server.constants.ItemId;
import com.openrsc.server.database.GameDatabase;
import com.openrsc.server.database.GameDatabaseException;
import com.openrsc.server.external.ItemDefinition;
import com.openrsc.server.model.entity.player.Player;
import com.openrsc.server.net.rsc.ActionSender;
import com.openrsc.server.util.rsc.DataConversions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.ByteBuffer;
import java.util.*;


public class Bank {
	/**
	 * The asynchronous logger.
	 */
	private static final Logger LOGGER = LogManager.getLogger();

	// TODO: Use an ItemContainer rather than a list here.
	private List<Item> list = Collections.synchronizedList(new ArrayList<>());
	private final Player player;
	public static int PRESET_COUNT = 2;
	public Preset[] presets = new Preset[PRESET_COUNT];

	public static class Preset {
		public Item[] inventory;
		public Item[] equipment;
		public boolean changed = false;

		public Preset(Player player) {
			inventory = new Item[Inventory.MAX_SIZE];
			equipment = new Item[Equipment.SLOT_COUNT];
		}
	}

	public Bank(final Player player) {
		this.player = player;
		for (int i = 0; i < this.presets.length; i++) {
			presets[i] = new Preset(player);
			for (int j = 0; j < presets[i].inventory.length; j++) {
				this.presets[i].inventory[j] = new Item(ItemId.NOTHING.id(), 0);
			}
			for (int j = 0; j < presets[i].equipment.length; j++) {
				this.presets[i].equipment[j] = new Item(ItemId.NOTHING.id(), 0);
			}
		}
	}

	/**
	 * Attempts to add the item to the player's Bank.
	 * Updates the database.
	 * @param item
	 * @return BOOLEAN flag if successful
	 */
	public boolean add(Item item) {
		synchronized(list) {
			try {
				//Check bounds of amount
				if (item.getAmount() <= 0) {
					return false;
				}

				Item existingStack = null;
				int index = -1;
				//Determine if there's already a spot in the bank for this item
				for (Item bankItem : list) {
					++index;
					//Check for matching catalog ID's
					if (bankItem.getCatalogId() != item.getCatalogId())
						continue;

					//Make sure the existing stack has room for more
					if (bankItem.getAmount() == Integer.MAX_VALUE)
						continue;

					//An existing stack has been found, exit the loop
					existingStack = bankItem;
					break;
				}

				if (existingStack == null) { //We need to add a new item to the list
					//Make sure they have room in the bank
					if (list.size() >= player.getBankSize())
						return false;

					//Update the database and make sure the item ID is set
					player.getWorld().getServer().getDatabase().bankAddToPlayer(player, item);

					list.add(item);

					//Update the client
					ActionSender.updateBankItem(player, index + 1, item.getCatalogId(), item.getAmount());
				} else { //There is an existing stack that can be added to
					//Check if the existing stack has enough room to hold the amount
					int remainingSize = Integer.MAX_VALUE - existingStack.getAmount();
					if (remainingSize >= item.getAmount()) { //Yes, there's enough room
						//Change the existing stack amount
						existingStack.changeAmount(player.getWorld().getServer().getDatabase(), item.getAmount());

						//Update the client
						ActionSender.updateBankItem(player, index, existingStack.getCatalogId(), existingStack.getAmount());
					} else { //No, we need to generate a new stack
						//Determine how much is left over
						item.getItemStatus().setAmount(item.getAmount() - remainingSize);
						item.setItemId(Item.ITEM_ID_UNASSIGNED);

						//Update the database and assign a new item ID
						player.getWorld().getServer().getDatabase().bankAddToPlayer(player, item);

						list.add(item);

						//Update the existing stack amount to max value
						existingStack.setAmount(player.getWorld().getServer().getDatabase(), Integer.MAX_VALUE);

						//Update the client
						ActionSender.updateBankItem(player, index, existingStack.getCatalogId(), Integer.MAX_VALUE);
						ActionSender.updateBankItem(player, list.size()-1, item.getCatalogId(), item.getAmount());
					}
				}
			} catch (GameDatabaseException ex) {
				LOGGER.error(ex.getMessage());
				return false;
			}
			return true;
		}
	}

	public boolean canHold(ArrayList<Item> items) {
		synchronized(list) {
			return (getPlayer().getBankSize() - list.size()) >= getRequiredSlots(items);
		}
	}

	public boolean canHold(Item item) {
		synchronized(list) {
			return (getPlayer().getBankSize() - list.size()) >= getRequiredSlots(item);
		}
	}

	public boolean contains(Item i) {
		synchronized(list) {
			return list.contains(i);
		}
	}

	public int countId(int catalogID) {
		synchronized(list) {
			int ret = 0;
			for (Item i : list) {
				if (i.getCatalogId() == catalogID) {
					ret += i.getAmount();
				}
			}
			return ret;
		}
	}

	public boolean full() {
		synchronized(list) {
			return list.size() >= getPlayer().getBankSize();
		}
	}

	public Item get(int index) {
		synchronized(list) {
			if (index < 0 || index >= list.size()) {
				return null;
			}
			return list.get(index);
		}
	}

	public Item get(Item item) {
		synchronized(list) {
			for (Item i : list) {
				if (item.equals(i)) {
					return i;
				}
			}
			return null;
		}
	}

	public int getFirstIndexById(int id) {
		synchronized(list) {
			for (int index = 0; index < list.size(); index++) {
				if (list.get(index).getCatalogId() == id) {
					return index;
				}
			}
			return -1;
		}
	}

	public List<Item> getItems() {
		// TODO: This should be made private and all calls converted to use API on ItemContainer. This could stay public, IF we copy the list to a new list before returning.
		synchronized(list) {
			return list;
		}
	}

	public int getRequiredSlots(Item item) {
		synchronized(list) {
			//Check if there's a stack that can be added to
			for (Item bankItem : list) {
				//Check for matching catalogID
				if (bankItem.getCatalogId() != item.getCatalogId())
					continue;

				//Make sure there's room in the stack
				if (bankItem.getAmount() == Integer.MAX_VALUE)
					continue;

				//Check if all of the stack can fit in the existing stack
				int remainingSize = Integer.MAX_VALUE - bankItem.getAmount();
				return remainingSize < item.getAmount() ? 1 : 0;
			}

			//No existing stack was found
			return 1;
		}
	}

	public int getRequiredSlots(List<Item> items) {
		synchronized(list) {
			int requiredSlots = 0;
			for (Item item : items) {
				requiredSlots += getRequiredSlots(item);
			}
			return requiredSlots;
		}
	}

	public boolean hasItemId(int id) {
		synchronized(list) {
			for (Item i : list) {
				if (i.getCatalogId() == id)
					return true;
			}

			return false;
		}
	}

	public int searchBankSlots(int catalogID) {
		synchronized (list) {
			for (int i = 0; i < list.size(); ++i) {
				if (list.get(i).getCatalogId() == catalogID)
					return i;
			}
			return -1;
		}
	}

	public ListIterator<Item> iterator() {
		synchronized(list) {
			return list.listIterator();
		}
	}

	public void remove(int index) {
		synchronized(list) {
			Item item = get(index);
			if (item == null) {
				return;
			}
			remove(item.getCatalogId(), item.getAmount());
		}
	}

	public int remove(int id, int amount) {
		synchronized(list) {
			try {
				Iterator<Item> iterator = list.iterator();
				for (int index = 0; iterator.hasNext(); index++) {
					Item i = iterator.next();
					if (id == i.getCatalogId() && amount <= i.getAmount()) {
						if (amount < i.getAmount()) {
							i.setAmount(player.getWorld().getServer().getDatabase(),i.getAmount() - amount);
						} else {
							//need a bank remove query here
							iterator.remove();
						}
						return index;
					}
				}
			} catch (GameDatabaseException ex) {
				LOGGER.error(ex.getMessage());
			}
			return -1;
		}
	}

	public int remove(Item item) {
		return remove(item.getCatalogId(), item.getAmount());
	}

	public int size() {
		synchronized(list) {
			return list.size();
		}
	}

	public boolean swap(int slot, int to) {
		synchronized(list) {
			if (slot <= 0 && to <= 0 && to == slot) {
				return false;
			}
			int idx = list.size() - 1;
			if (to > idx) {
				return false;
			}
			Item item = get(slot);
			Item item2 = get(to);
			if (item != null && item2 != null) {
				list.set(slot, item2);
				list.set(to, item);
				return true;
			}
			return false;
		}
	}

	public boolean insert(int slot, int to) {
		synchronized(list) {
			if (slot <= 0 && to <= 0 && to == slot) {
				return false;
			}
			int idx = list.size() - 1;
			if (to > idx) {
				return false;
			}
			// we reset the item in the from slot
			Item from = list.get(slot);
			Item[] array = list.toArray(new Item[list.size()]);
			if (slot >= array.length || from == null || to >= array.length) {
				return false;
			}
			array[slot] = null;
			// find which direction to shift in
			if (slot > to) {
				int shiftFrom = to;
				int shiftTo = slot;
				for (int i = (to + 1); i < slot; i++) {
					if (array[i] == null) {
						shiftTo = i;
						break;
					}
				}
				Item[] slice = new Item[shiftTo - shiftFrom];
				System.arraycopy(array, shiftFrom, slice, 0, slice.length);
				System.arraycopy(slice, 0, array, shiftFrom + 1, slice.length);
			} else {
				int sliceStart = slot + 1;
				int sliceEnd = to;
				for (int i = (sliceEnd - 1); i >= sliceStart; i--) {
					if (array[i] == null) {
						sliceStart = i;
						break;
					}
				}
				Item[] slice = new Item[sliceEnd - sliceStart + 1];
				System.arraycopy(array, sliceStart, slice, 0, slice.length);
				System.arraycopy(slice, 0, array, sliceStart - 1, slice.length);
			}
			// now fill in the target slot
			array[to] = from;
			list = new ArrayList<Item>(Arrays.asList(array));
			return true;
		}
	}

	public void setTab(int int1) {
		// TODO Auto-generated method stub

	}

	public boolean withdrawItemToInventory(int bankSlot, final int amount) {
		synchronized (list) {
			synchronized (player.getCarriedItems().getInventory().getItems()) {

				//Make sure there's an item in the slot
				Item withdrawItem = list.get(bankSlot);
				if (withdrawItem == null)
					return false;

				//Bounds checks on amount
				if (amount < 1 || countId(withdrawItem.getCatalogId()) < amount) {
					player.setSuspiciousPlayer(true, "bank deposit item amount < 0 or inventory count < amount");
					return false;
				}

				//Check the item definition
				ItemDefinition withdrawDef = withdrawItem.getDef(player.getWorld());
				if (withdrawDef == null)
					return false;

				//Make sure they have enough space in their inventory
				if (!player.getCarriedItems().getInventory().canHold(withdrawItem)) {
					player.message("You don't have room to hold everything!");
					return false;
				}

				//This is used for non-stackable withdraws of amount > 1
				int amountLeft;

				//Attempt to remove the item from the bank
				//Check if the item is non-stackable with amount > 1
				if (!withdrawDef.isStackable() && amount > 1) {
					if (remove(withdrawItem.getCatalogId(), 1) == -1)
						return false;
					amountLeft = amount - 1;
				} else {
					if (remove(withdrawItem.getCatalogId(), amount) == -1)
						return false;
					amountLeft = 0;
				}

				//Determine if we need to split the stack
				if (withdrawDef.isStackable() && withdrawItem.getAmount() > amount) { //Yes, the stack is being split
					withdrawItem = new Item(withdrawItem.getCatalogId(), amount);
				}

				if (!player.getCarriedItems().getInventory().add(withdrawItem)) {
					//The deposit failed. Re-add the items to the bank
					add(withdrawItem);
				}

				//If we need to withdraw more non-stackables then do it recursively
				if (amountLeft > 0)
					return withdrawItemToInventory(bankSlot, amountLeft);
				else
					return true;

//				Item item;
//				Inventory inventory = getPlayer().getCarriedItems().getInventory();
//				final int slot = getFirstIndexById(bankSlot);
//
//				if (getPlayer().getWorld().getServer().getEntityHandler().getItemDef(bankSlot).isStackable()) {
//					item = new Item(bankSlot, amount);
//					if (inventory.canHold(item) && remove(item) > -1) {
//						inventory.add(item, false);
//					} else {
//						getPlayer().message("You don't have room to hold everything!");
//					}
//				} else {
//					if (!getPlayer().getAttribute("swap_note", false)) {
//						for (int i = 0; i < amount; i++) {
//							if (getFirstIndexById(bankSlot) < 0) {
//								break;
//							}
//							item = new Item(bankSlot, 1);
//							if (inventory.canHold(item) && remove(item) > -1) {
//								inventory.add(item, false);
//							} else {
//								getPlayer().message("You don't have room to hold everything!");
//								break;
//							}
//						}
//					} else {
//						for (int i = 0; i < amount; i++) {
//							if (getFirstIndexById(bankSlot) < 0) {
//								break;
//							}
//							if (!getPlayer().getWorld().getServer().getEntityHandler().getItemDef(bankSlot).isNoteable()) {
//								getPlayer().message("There is no equivalent note item for that.");
//								break;
//							}
//
//							item = new Item(bankSlot, 1);
//							Item notedItem = new Item(item.getDef(getPlayer().getWorld()).getId()).asNote();
//					/*if (notedItem.getDef(getPlayer().getWorld()) == null) {
//						LOGGER.error("Mistake with the notes: " + item.getCatalogId() + " - " + notedItem.getCatalogId());
//						break;
//					}*/
//
//							if (inventory.canHold(notedItem) && remove(item) > -1) {
//								inventory.add(notedItem, false);
//							} else {
//								getPlayer().message("You don't have room to hold everything!");
//								break;
//							}
//						}
//					}
//				}
//
//				if (slot > -1) {
//					ActionSender.sendInventory(getPlayer());
//					ActionSender.updateBankItem(getPlayer(), slot, bankSlot, countId(bankSlot));
//
//					return true;
//				}
			}
		}
	}

	public boolean depositItemFromInventory(final int inventorySlot, final int amount) {
		synchronized (list) {
			synchronized (player.getCarriedItems().getInventory().getItems()) {
				//Make sure there's an item in the slot
				Item depositItem = getPlayer().getCarriedItems().getInventory().get(inventorySlot);
				if (depositItem == null)
					return false;

				//Bounds checks on amount
				if (amount < 1 || player.getCarriedItems().getInventory().countId(depositItem.getCatalogId()) < amount) {
					player.setSuspiciousPlayer(true, "bank deposit item amount < 0 or inventory count < amount");
					return false;
				}

				//Check the item definition
				ItemDefinition depositDef = depositItem.getDef(player.getWorld());
				if (depositDef == null)
					return false;

				//Make sure they have enough space in their bank to deposit it
				if (!canHold(depositItem)) {
					player.message("You don't have room for that in your bank");
					return false;
				}

				//This is used for non-stackable deposits of amount > 1
				int amountLeft;
				//Attempt to remove the item from the inventory
				//Check if the item is non-stackable with amount > 1
				if (!depositDef.isStackable() && amount > 1) {
					if (player.getCarriedItems().getInventory().remove(depositItem.getCatalogId(), 1, true) == -1)
						return false;
					amountLeft = amount - 1;
				} else {
					if (player.getCarriedItems().getInventory().remove(depositItem.getCatalogId(), amount, true) == -1)
						return false;
					amountLeft = 0;
				}

				//Determine if we need to split the stack
				if (depositDef.isStackable() && depositItem.getAmount() > amount) { //Yes, the stack is being split
					depositItem = new Item(depositItem.getCatalogId(), amount);
				}

				if (!add(depositItem)) {
					//The deposit failed. Re-add the items to the inventory
					player.getCarriedItems().getInventory().add(depositItem);
				}

				//If we need to deposit more non-stackables then do it recursively
				if (amountLeft > 0)
					return depositItemFromInventory(inventorySlot, amountLeft);
				else
					return true;
			}
		}
	}

//				if (getPlayer().getWorld().getServer().getEntityHandler().getItemDef(inventorySlot).isStackable()) {
//					if (!getPlayer().getAttribute("swap_cert", false) || !isCert(inventorySlot)) {
//						item = new Item(inventorySlot, amount);
//						Item originalItem = null;
//						if (item.getDef(getPlayer().getWorld()).getId() != -1) {
//							originalItem = new Item(item.getDef(getPlayer().getWorld()).getId(), amount);
//							inventorySlot = originalItem.getCatalogId();
//						}
//						if (bank.canHold(item) && inventory.remove(item, false) > -1) {
//							bank.add(originalItem != null ? originalItem : item);
//						} else {
//							getPlayer().message("You don't have room for that in your bank");
//							return false;
//						}
//					} else {
//						item = new Item(inventorySlot, amount);
//						Item originalItem = null;
//						if (item.getDef(getPlayer().getWorld()).getId() != -1) {
//							originalItem = new Item(item.getDef(getPlayer().getWorld()).getId(), amount);
//							inventorySlot = originalItem.getCatalogId();
//						}
//						Item removedItem = originalItem != null ? originalItem : item;
//						int uncertedID = uncertedID(removedItem.getCatalogId());
//						inventorySlot = uncertedID;
//						Item uncertedItem = new Item(uncertedID, uncertedID == removedItem.getCatalogId() ? amount : amount * 5);
//						if (bank.canHold(uncertedItem) && inventory.remove(removedItem,false) > -1) {
//							bank.add(uncertedItem);
//						} else {
//							getPlayer().message("You don't have room for that in your bank");
//							return false;
//						}
//					}
//
//				} else {
//					for (int i = 0; i < amount; i++) {
//						int idx = inventory.getLastIndexById(inventorySlot);
//						item = inventory.get(idx);
//						if (item == null) { // This shouldn't happen
//							break;
//						}
//						if (bank.canHold(item) && inventory.remove(item.getCatalogId(), item.getAmount(), false) > -1) {
//							bank.add(item);
//						} else {
//							getPlayer().message("You don't have room for that in your bank");
//							break;
//						}
//					}
//				}


	public void loadPreset(int slot, byte[] inventoryItems, byte[] equipmentItems) {
//		ByteBuffer blobData = ByteBuffer.wrap(inventoryItems);
//		byte[] itemID = new byte[2];
//		for (int i = 0; i < Inventory.MAX_SIZE; i++) {
//			itemID[0] = blobData.get();
//			if (itemID[0] == -1)
//				continue;
//			itemID[1] = blobData.get();
//			int itemIDreal = (((int) itemID[0] << 8) & 0xFF00) | (int) itemID[1] & 0xFF;
//			ItemDefinition item = player.getWorld().getServer().getEntityHandler().getItemDef(itemIDreal);
//			if (item == null)
//				continue;
//
//			presets[slot].inventory[i].setCatalogId(itemIDreal);
//			if (item.isStackable())
//				presets[slot].inventory[i].setAmount(blobData.getInt());
//			else
//				presets[slot].inventory[i].setAmount(1);
//		}
//
//		blobData = ByteBuffer.wrap(equipmentItems);
//		for (int i = 0; i < Equipment.SLOT_COUNT; i++) {
//			itemID[0] = blobData.get();
//			if (itemID[0] == -1)
//				continue;
//			itemID[1] = blobData.get();
//			int itemIDreal = (((int) itemID[0] << 8) & 0xFF00) | (int) itemID[1] & 0xFF;
//			ItemDefinition item = player.getWorld().getServer().getEntityHandler().getItemDef(itemIDreal);
//			if (item == null)
//				continue;
//
//			presets[slot].equipment[i].setCatalogId(itemIDreal);
//			if (item.isStackable())
//				presets[slot].equipment[i].setAmount(blobData.getInt());
//			else
//				presets[slot].equipment[i].setAmount(1);
//		}
	}

	public boolean isEmptyPreset(int slot) {
		for (Item inv : presets[slot].inventory) {
			if (inv.getCatalogId() != -1)
				return false;
		}
		for (Item eqp : presets[slot].equipment) {
			if (eqp.getCatalogId() != -1)
				return false;
		}
		return true;
	}

	public void attemptPresetLoadout(int slot) {
		synchronized(list) {
			synchronized (player.getCarriedItems().getInventory().getItems()) {
				synchronized (player.getCarriedItems().getEquipment().getList()) {
					Map<Integer, Integer> itemsOwned = new LinkedHashMap<>();
					Item tempItem;

					//Loop through their bank and add it to the hashmap
					for (int i = 0; i < list.size(); i++) {
						tempItem = get(i);
						if (tempItem != null) {
							if (!itemsOwned.containsKey(tempItem.getCatalogId())) {
								itemsOwned.put(tempItem.getCatalogId(), 0);
							}
							int hasAmount = itemsOwned.get(tempItem.getCatalogId());
							hasAmount += tempItem.getAmount();
							itemsOwned.put(tempItem.getCatalogId(), hasAmount);
						}
					}

					//Loop through their inventory and add it to the hashmap
					for (int i = 0; i < getPlayer().getCarriedItems().getInventory().size(); i++) {
						tempItem = getPlayer().getCarriedItems().getInventory().get(i);
						if (tempItem != null) {
							if (!itemsOwned.containsKey(tempItem.getCatalogId())) {
								itemsOwned.put(tempItem.getCatalogId(), 0);
							}
							int hasAmount = itemsOwned.get(tempItem.getCatalogId());
							hasAmount += tempItem.getAmount();
							itemsOwned.put(tempItem.getCatalogId(), hasAmount);
						}
					}

					if (getPlayer().getWorld().getServer().getConfig().WANT_EQUIPMENT_TAB) {
						//Loop through their equipment and add it to the hashmap
						for (int i = 0; i < Equipment.SLOT_COUNT; i++) {
							tempItem = getPlayer().getCarriedItems().getEquipment().get(i);
							if (tempItem != null) {
								if (!itemsOwned.containsKey(tempItem.getCatalogId())) {
									itemsOwned.put(tempItem.getCatalogId(), 0);
								}
								int hasAmount = itemsOwned.get(tempItem.getCatalogId());
								hasAmount += tempItem.getAmount();
								itemsOwned.put(tempItem.getCatalogId(), hasAmount);
							}
						}
					}

					//Make sure they have enough space - disregard edge cases
					if (itemsOwned.size() > getPlayer().getBankSize() + Inventory.MAX_SIZE) {
						getPlayer().message("Your bank and inventory are critically full. Clean up before using presets.");
						return;
					}

					for (int i = 0; i < Equipment.SLOT_COUNT; i++) {
						if (getPlayer().getCarriedItems().getEquipment().get(i) != null) {
							Item toRemove = getPlayer().getCarriedItems().getEquipment().get(i);
							getPlayer().getCarriedItems().getEquipment().remove(toRemove.getCatalogId(), toRemove.getAmount());
						}

					}

					if (getPlayer().getWorld().getServer().getConfig().WANT_EQUIPMENT_TAB) {
						//Attempt to equip the preset equipment
						int wearableId;
						for (int i = 0; i < presets[slot].equipment.length; i++) {
							Item presetEquipment = presets[slot].equipment[i];
							if (presetEquipment.getDef(getPlayer().getWorld()) == null)
								continue;

							presetEquipment.setWielded(false);
							if (itemsOwned.containsKey(presetEquipment.getCatalogId())) {
								int presetAmount = presetEquipment.getAmount();
								int ownedAmount = itemsOwned.get(presetEquipment.getCatalogId());
								if (presetAmount > ownedAmount) {
									getPlayer().message("Preset error: Requested item missing " + presetEquipment.getDef(getPlayer().getWorld()).getName());
									presetAmount = ownedAmount;
								}
								if (presetAmount > 0) {
									if (getPlayer().getSkills().getMaxStat(presetEquipment.getDef(getPlayer().getWorld()).getRequiredSkillIndex()) < presetEquipment.getDef(getPlayer().getWorld()).getRequiredLevel()) {
										getPlayer().message("Unable to equip " + presetEquipment.getDef(getPlayer().getWorld()).getName() + " due to lack of skill.");
										continue;
									}
									getPlayer().getCarriedItems().getEquipment().add(presetEquipment);
									wearableId = presetEquipment.getDef(getPlayer().getWorld()).getWearableId();
									getPlayer().updateWornItems(i,
										presetEquipment.getDef(getPlayer().getWorld()).getAppearanceId(),
										wearableId, true);
									if (presetAmount == ownedAmount) {
										itemsOwned.remove(presetEquipment.getCatalogId());
									} else {
										itemsOwned.put(presetEquipment.getCatalogId(), ownedAmount - presetAmount);
									}
								}
							} else {
								getPlayer().message("Preset error: Requested item missing " + presetEquipment.getDef(getPlayer().getWorld()).getName());
							}
						}
					}

					getPlayer().getCarriedItems().getInventory().getItems().clear();
					//Attempt to load the preset inventory
					for (int i = 0; i < presets[slot].inventory.length; i++) {
						Item presetInventory = presets[slot].inventory[i];
						if (presetInventory.getDef(getPlayer().getWorld()) == null) {
							continue;
						}
						presetInventory.setWielded(false);
						if (itemsOwned.containsKey(presetInventory.getCatalogId())) {
							int presetAmount = presetInventory.getAmount();
							int ownedAmount = itemsOwned.get(presetInventory.getCatalogId());
							if (presetAmount > ownedAmount) {
								getPlayer().message("Preset error: Requested item missing " + presetInventory.getDef(getPlayer().getWorld()).getName());
								presetAmount = ownedAmount;
							}
							if (presetAmount > 0) {
								getPlayer().getCarriedItems().getInventory().add(presetInventory, false);
								if (presetAmount == ownedAmount) {
									itemsOwned.remove(presetInventory.getCatalogId());
								} else {
									itemsOwned.put(presetInventory.getCatalogId(), ownedAmount - presetAmount);
								}
							}
						} else {
							getPlayer().message("Preset error: Requested item missing " + presetInventory.getDef(getPlayer().getWorld()).getName());
						}
					}

					Iterator<Map.Entry<Integer, Integer>> itr = itemsOwned.entrySet().iterator();

					int slotCounter = 0;
					list.clear();
					while (itr.hasNext()) {
						Map.Entry<Integer, Integer> entry = itr.next();

						if (slotCounter < getPlayer().getBankSize()) {
							//Their bank isn't full, stick it in the bank
							add(new Item(entry.getKey(), entry.getValue()));
						} else {
							//Their bank is full, stick it in their inventory
							getPlayer().getCarriedItems().getInventory().add(new Item(entry.getKey(), entry.getValue()), false);
							getPlayer().message("Your bank was too full and an item was placed into your inventory.");
						}
						slotCounter++;
					}
					getPlayer().resetBank();
				}
			}
		}
	}

	private static boolean isCert(int itemID) {
		int[] certIds = {
			/* Ores **/
			517, 518, 519, 520, 521,
			/* Bars **/
			528, 529, 530, 531, 532,
			/* Fish **/
			533, 534, 535, 536, 628, 629, 630, 631,
			/* Logs **/
			711, 712, 713,
			/* Misc **/
			1270, 1271, 1272, 1273, 1274, 1275
		};

		return DataConversions.inArray(certIds, itemID);
	}

	private static int uncertedID(int itemID) {

		if (itemID == ItemId.IRON_ORE_CERTIFICATE.id()) {
			return ItemId.IRON_ORE.id();
		} else if (itemID == ItemId.COAL_CERTIFICATE.id()) {
			return ItemId.COAL.id();
		} else if (itemID == ItemId.MITHRIL_ORE_CERTIFICATE.id()) {
			return ItemId.MITHRIL_ORE.id();
		} else if (itemID == ItemId.SILVER_CERTIFICATE.id()) {
			return ItemId.SILVER.id();
		} else if (itemID == ItemId.GOLD_CERTIFICATE.id()) {
			return ItemId.GOLD.id();
		} else if (itemID == ItemId.IRON_BAR_CERTIFICATE.id()) {
			return ItemId.IRON_BAR.id();
		} else if (itemID == ItemId.STEEL_BAR_CERTIFICATE.id()) {
			return ItemId.STEEL_BAR.id();
		} else if (itemID == ItemId.MITHRIL_BAR_CERTIFICATE.id()) {
			return ItemId.MITHRIL_BAR.id();
		} else if (itemID == ItemId.SILVER_BAR_CERTIFICATE.id()) {
			return ItemId.SILVER_BAR.id();
		} else if (itemID == ItemId.GOLD_BAR_CERTIFICATE.id()) {
			return ItemId.GOLD_BAR.id();
		} else if (itemID == ItemId.LOBSTER_CERTIFICATE.id()) {
			return ItemId.LOBSTER.id();
		} else if (itemID == ItemId.RAW_LOBSTER_CERTIFICATE.id()) {
			return ItemId.RAW_LOBSTER.id();
		} else if (itemID == ItemId.SWORDFISH_CERTIFICATE.id()) {
			return ItemId.SWORDFISH.id();
		} else if (itemID == ItemId.RAW_SWORDFISH_CERTIFICATE.id()) {
			return ItemId.RAW_SWORDFISH.id();
		} else if (itemID == ItemId.BASS_CERTIFICATE.id()) {
			return ItemId.BASS.id();
		} else if (itemID == ItemId.RAW_BASS_CERTIFICATE.id()) {
			return ItemId.RAW_BASS.id();
		} else if (itemID == ItemId.SHARK_CERTIFICATE.id()) {
			return ItemId.SHARK.id();
		} else if (itemID == ItemId.RAW_SHARK_CERTIFICATE.id()) {
			return ItemId.RAW_SHARK.id();
		} else if (itemID == ItemId.YEW_LOGS_CERTIFICATE.id()) {
			return ItemId.YEW_LOGS.id();
		} else if (itemID == ItemId.MAPLE_LOGS_CERTIFICATE.id()) {
			return ItemId.MAPLE_LOGS.id();
		} else if (itemID == ItemId.WILLOW_LOGS_CERTIFICATE.id()) {
			return ItemId.WILLOW_LOGS.id();
		} else if (itemID == ItemId.DRAGON_BONE_CERTIFICATE.id()) {
			return ItemId.DRAGON_BONES.id();
		} else if (itemID == ItemId.LIMPWURT_ROOT_CERTIFICATE.id()) {
			return ItemId.LIMPWURT_ROOT.id();
		} else if (itemID == ItemId.PRAYER_POTION_CERTIFICATE.id()) {
			return ItemId.FULL_RESTORE_PRAYER_POTION.id();
		} else if (itemID == ItemId.SUPER_ATTACK_POTION_CERTIFICATE.id()) {
			return ItemId.FULL_SUPER_ATTACK_POTION.id();
		} else if (itemID == ItemId.SUPER_DEFENSE_POTION_CERTIFICATE.id()) {
			return ItemId.FULL_SUPER_DEFENSE_POTION.id();
		} else if (itemID == ItemId.SUPER_STRENGTH_POTION_CERTIFICATE.id()) {
			return ItemId.FULL_SUPER_STRENGTH_POTION.id();
		} else {
			return itemID;
		}
	}

	public Player getPlayer() {
		return player;
	}
}
