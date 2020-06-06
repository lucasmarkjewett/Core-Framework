package com.openrsc.server.constants;

import java.util.HashMap;
import java.util.Map;

public enum SceneryId {
	NOTHING(-1),
	POINTY_TREE(0),
	LEAFY_TREE(1),
	WELL(2),
	TABLE(3),
	TREESTUMP(4),
	LADDER_GENERIC_UP(5),
	LADDER_GENERIC_DOWN(6),
	CHAIR(7),
	LOGS(8),
	LONGTABLE(9),
	THRONE(10),
	RANGE(11),
	GRAVESTONE(12),
	MOSSY_GRAVESTONE(13),
	BED_LARGE(14),
	BED_WHITE(15),
	BAR(16),
	CHEST_GENERIC_OPEN(17),
	CHEST_GENERIC_CLOSED(18),
	ALTAR(19),
	STONE_POST(20),
	WOODEN_SUPPORT(21),
	BARREL_EMPTY(22),
	BENCH_GENERIC(23),
	PAINTING_PORTRAIT(24),
	CANDLES(25),
	FOUNTAIN(26),
	PAINTING_LANDSCAPE(27),
	MILLSTONES(28),
	SHOP_COUNTER(29),
	MARKET_STALL(30),
	ARCHERY_TARGET(31),
	PALM_TREE_NICE(32),
	PALM_TREE_SHADY(33),
	FERN(34),
	CACTUS(35),
	BULLRUSHES(36),
	FLOWER(37),
	MUSHROOM(38),
	COFFIN_CLOSED(39),
	COFFIN_OPEN(40),
	STAIRS_WOODEN_GENERIC_UP(41),
	STAIRS_WOODEN_GENERIC_DOWN(42),
	STAIRS_STONE_GENERIC_UP(43),
	STAIRS_STONE_GENERIC_DOWN(44),
	RAILING_WOODEN(45),
	PILLAR_MARBLE(46),
	BOOKCASE(47),
	SINK(48),
	DUMMY(49),
	ANVIL(50),
	TORCH(51),
	HOPPER_LUMBRIDGE(52),
	CHUTE(53),
	CART(54),
	SACKS(55),
	CUPBOARD_GENERIC_CLOSED(56),
	GATE_METAL_GENERIC_CLOSED(57),
	GATE_METAL_GENERIC_OPEN(58),
	GATE_WOODEN_GENERIC_OPEN(59),
	GATE_WOODEN_GENERIC_CLOSED(60),
	SIGNPOST_VARROCK(61),
	SIGNPOST_WIZARDS_TOWER(62),
	DOOR_BANK_OPEN(63),
	DOOR_BANK_CLOSED(64),
	SIGNPOST_PLAYER_OWNED_HOUSES(65),
	SIGNPOST_LUMBRIDGE_CASTLE(66),
	BOOKCASE_SEARCHABLE(67),
	HENGE(68),
	DOLMEN(69),
	TREE_UNHEALTHY_GENERIC(70),
	CUPBOARD_GENERIC_OPEN(71),
	WHEAT(72),
	SIGN_BLUE_MOON_INN(73),
	WINDMILL_SAILS(74),
	SIGN_ESTATE_AGENT(75),
	SIGN_JOLLY_BOAR_INN(76),
	DRAIN(77),
	MANHOLE_CLOSED(78),
	MANHOLE_OPEN(79),
	PIPE(80),
	CHEST_OPEN_PHOENIX_GANG(81),
	CHEST_CLOSED_PHOENIX_GANG(82),
	BARREL_NEWTS_EYES(83),
	CUPBOARD_BLACK_ARM_CLOSED(84),
	CUPBOARD_BLACK_ARM_OPEN(85),
	FOUNTAIN_DRAYNOR_MANOR(86),
	SIGNPOST_DRAYNOR_MANOR(87),
	TREE_UNHEALTHY_APPROACHABLE(88),
	SIGN_GENERAL_STORE(89),
	SIGN_LOWES_ARCHERY_STORE(90),
	SIGN_VARROCK_CLOTHING_SHOP(91),
	SIGN_VARROCK_SWORDS(92),
	GATE_MEMBERS_RED_DRAGONS_CLOSED(93),
	GATE_MEMBERS_UNUSED(94),
	SIGN_BOBS_AXES(95),
	SIGN_STAFF_SHOP(96),
	FIRE(97),
	ROCK_GENERIC(98),
	ROCK_GENERIC2(99),
	ROCK_COPPER(100),
	ROCK_COPPER2(101),
	ROCK_IRON(102),
	ROCK_IRON2(103),
	ROCK_TIN(104),
	ROCK_TIN2(105),
	ROCK_MITHRIL(106),
	ROCK_MITHRIL2(107),
	ROCK_ADAMITE(108),
	ROCK_ADAMITE2(109),
	ROCK_COAL(110),
	ROCK_COAL2(111),
	ROCK_GOLD(112),
	ROCK_GOLD2(113),
	ROCK_CLAY(114),
	ROCK_CLAY2(115),
	WEB_CEILING(116),
	WEB_FLOOR(117),
	FURNACE(118),
	COOKS_RANGE(119),
	MACHINE(120),
	SPINNING_WHEEL(121),
	LEVER_UP_UNUSED(122), // TODO Needs name & location
	LEVER_DOWN_UNUSED(123), // TODO Needs name & location
	LEVER_A(124),
	LEVER_B(125),
	LEVER_C(126),
	LEVER_D(127),
	LEVER_E(128),
	LEVER_F(129),
	LADDER_DRAYNOR_MANOR_BASEMENT_UP(130),
	SIGNPOST_FORGE(131),
	SIGNPOST_BARBARIAN_VILLAGE(132),
	SIGNPOST_AL_KHARID(133),
	COMPOST_HEAP(134),
	COFFIN_DRANOR_MANOR_CLOSED(135),
	COFFIN_DRAYNO_MANOR_OPEN(136),
	GATE_MEMBERS_TAVERLY_CLOSED(137),
	GATE_MEMBERS_CRAFTING_GUILD_CLOSED(138),
	SIGN_BANK(139),
	CUPBOARD_DRAYNOR_GARLIC_CLOSED(140),
	CUPBOARD_DRAYNOR_GARLIC_OPEN(141),
	DOORS_SHUT(142),
	TORCH_SCARY(143),
	ALTAR_ZAMORAK(144),
	SHIELD(145),
	GRILL(146),
	CAULDRON(147),
	GRILL_LISTEN(148),
	MINECART(149),
	BUFFERS(150),
	TRAIN_TRACK_TURN(151),
	TRAIN_TRACK_JUNCTION(152),
	TRAIN_TRACK(153),
	HOLE_BLACK_KNIGHTS_FORTRESS(154),
	SHIP(155),
	SHIP_FRONT_ARDOUGNE_BRIMHAVEN(156),
	SHIP_BACK_ARDOUGNE_BRIMHAVEN(157),
	LADDER_EMERGENCY_ESCAPE(158),
	SIGN_WYDINS_GROCERY(159),
	SIGN_RUSTY_ANCHOR(160),
	SHIP_FRONT_KARAMJA_PORT_SARIM(161),
	SHIP_MIDDLE_KARAMJA_PORT_SARIM(162),
	SHIP_BACK_KARAMJA_PORT_SARIM(163),
	ROCKS_GENERIC3(164),
	ROCKS_COPPER3(165),
	ROCKS_IRON3(166),
	ROCKS_TIN3(167),
	ROCKS_MITHRIL3(168),
	ROCKS_ADAMITE3(169),
	ROCKS_COAL3(170),
	ROCKS_GOLD3(171),
	ROCKS_CLAY3(172),
	HOPPER_COOKING_GUILD(173),
	CUPBOARD_FALADOR_CASTLE_WHITE_KNIGHT_CLOSED(174),
	CUPBOARD_FALADOR_CASTLE_WHITE_KNIGHT_OPEN(175),
	ROCKS_BLURITE(176),
	ANVIL_DORIC(177),
	POTTERY_OVEN(178),
	POTTERY_WHEEL(179),
	GATE_AL_KHARID_CLOSED(180),
	GATE_GENERIC_OPEN(181),
	CRATE_BANANAS_KARAMJA(182),
	BANANA_TREE_FULL(183),
	BANANA_TREE_EMPTY(184),
	CRATE_BANANAS_PORT_SARIM(185),
	CHEST_PIRATES_TREASURE_VARROCK_OPEN(186),
	CHEST_PIRATES_TREASURE_VARROCK_CLOSED(187),
	FLOWER_PIRATES_TREASURE_FALADOR(188),
	SIGN_FISHING_SUPPLIES(189),
	SIGN_JEWELLERS(190),
	POTATO(191),
	FISH_LURE_BAIT(192),
	FISH_NET_BAIT(193),
	FISH_HARPOON_CAGE(194),
	ROCK_SILVER(195),
	ROCK_SILVER2(196),
	ROCKS_SILVER3(197),
	LADDER_MONASTERY_UP(198),
	LADDER_MONASTERY_DOWN(199),
	ALTAR_MONKS(200),
	LADDER_MELZAR_DOWN(201),
	COFFIN_GENERIC_CLOSED(202),
	COFFIN_GENERIC_OPEN(203),
	TABLE_SMASHED(204),
	FUNGUS(205),
	CHAIR_SMASHED(206),
	PILLAR_BROKEN(207),
	TREE_FALLEN(208),
	SIGN_DANGER(209),
	ROCK_RUNITE(210),
	ROCK_RUNITE2(211),
	ROCKS_RUNITE3(212),
	GRAVESTONE_LARGE(213),
	BONE_CURVED(214),
	BONE_LARGE(215),
	CARCASS(216),
	SKULL_ANIMAL(217),
	VINE_RED(218),
	VINE_RED_TURN(219),
	VINE_RED_JUNCTION(220),
	CHEST_MUDDY_KEY_OPEN(221),
	CHEST_MUDDY_KEY_CLOSED(222),
	LADDER_BLACK_HOLE_DOWN(223),
	SHIP_FRONT_LUMBRIDGE_LADY_PORT_SARIM(224),
	SHIP_BACK_LUMBRIDGE_LADY_PORT_SARIM(225),
	HOLE_BROKEN_WALL_SHIP(226),
	LADDER_BROKEN_SHIP_UP(227),
	CHEST_MELZAR_OPEN(228),
	CHEST_MELZAR_CLOSED(229),
	CHEST_DWARVEN_OPEN(230),
	CHEST_DWARVEN_CLOSED(231),
	HOLE_BROKEN_WALL_SHIP2(232),
	SHIP_FRONT_LUMBRIDGE_LADY_CRANDOR(233),
	SHIP_BACK_LUMBRIDGE_LADY_CRANDOR(234),
	ALTAR_OF_GUTHIX(235),
	CAULDRON_OF_THUNDER(236),
	TREE_LEAFY(237),
	SHIP_FRONT_ENTRANA(238),
	SHIP_MIDDLE_ENTRANA(239),
	SHIP_BACK_ENTRANA(240),
	SHIP_FRONT_PORT_SARIM(241),
	SHIP_MIDDLE_PORT_SARIM(242),
	SHIP_BACK_PORT_SARIM(243),
	LADDER_ENTRANA_DOWN(244),
	TREE_DRAMEN(245),
	HOPPER_ZANARIS(246),
	CHEST_TAVERLY_OPEN(247),
	CHEST_TAVERLY_CLOSED(248),
	LADDER_ZANARIS_MARKET_UP(249),
	SIGN_TWO_HANDED_SWORDS(250),
	SIGN_HERBALIST(251),
	GATE_MEMBERS_UNUSED2(252),
	GATE_MEMBERS_UNUSED3(253),
	GATE_MEMBERS_KARAMJA_CLOSED(254),
	DOOR_MAT(255),
	GATE_METAL_WITCHES_HOUSE_CLOSED(256),
	CAULDRON_WITCHES_HOUSE(257),
	CUPBOARD_WITCHES_HOUSE_CLOSED(258),
	CUPBOARD_WITCHES_HOUSE_OPEN(259),
	GATE_BANK_VAULT(260),
	FISH_NET_HARPOON(261),
	SIGN_HARRYS_FISHING_SHACK(262),
	CUPBOARD_BRIMHAVEN_HEROS_QUEST_CLOSED(263),
	CUPBOARD_BRIMHAVEN_HEROS_QUEST_OPEN(264),
	CHEST_BRIMHAVEN_HEROS_QUEST_OPEN(265),
	CHEST_BRIMHAVEN_HEROS_QUEST_CLOSED(266),
	SIGN_SHRIMP_AND_PARROT(267),
	SIGNPOST_PALM_STREET(268),
	ROCKSLIDE(269),
	LADDER_ICE_QUEEN_UP(270),
	FISH_LAVA(271),
	BARREL_ALE(272),
	TABLE_STURDY(273),
	FIREPLACE(274),
	EGG(275),
	EGGS(276),
	STALAGMITES(277),
	STOOL(278),
	BENCH_JAILCELL(279),
	TABLE_ROUND(280),
	TABLE_HANDY(281),
	FOUNTAIN_OF_HEROS(282),
	BUSH(283),
	HEDGE(284),
	FLOWER_COLOURFUL(285),
	PLANT(286),
	GIANT_CRYSTAL(287),
	SIGN_DEAD_MANS_CHEST(288),
	SIGN_RISING_SUN(289),
	CRATE_EMPTY(290),
	CRATE_BUCKET(291),
	SHIP_FRONT_MERCHANT(292),
	SHIP_BACK_MERCHANT(293),
	BEEHIVE(294),
	LADDER_JEWELLERY_SHOP_UP(295),
	ALTAR_ZAMORAK_WILDERNESS(296),
	SIGN_HICKTONS_ARCHERY_STORE(297),
	SIGNPOST_CAMELOT(298),
	ARCHWAY(299),
	OBELISK_OF_WATER(300),
	OBELISK_OF_FIRE(301),
	SAND_PIT(302),
	OBELISK_OF_AIR(303),
	OBELISK_OF_EARTH(304),
	GATE_MEMBERS_EDGEVILLE_DUNGEON(305),
	TREE_OAK(306),
	TREE_WILLOW(307),
	TREE_MAPLE(308),
	TREE_YEW(309),
	TREE_MAGIC(310),
	GATE_BARBARIAN_AGILITY(311),
	SIGN_FORESTERS_ARMS(312),
	FLAX(313),
	TREESTUMP_LARGE(314),
	ROCKS_GOLD(315),
	LEVER_FAMILY_CREST_DUNGEON_HALL_UP(316),
	LEVER_FAMILY_CREST_DUNGEON_ROOM_TWO_UP(317),
	LEVER_FAMILY_CREST_DUNGEON_ROOM_ONE_UP(318),
	GATE_MEMBERS_WILDERNESS_BLACK_DRAGON(319),
	SHIP_FRONT_ARDOUGNE(320),
	SHIP_BACK_ARDOUGNE(321),
	STALL_BAKERS(322),
	STALL_SILK(323),
	STALL_FUR(324),
	STALL_SILVER(325),
	STALL_SPICES(326),
	STALL_GEMS(327),
	CRATE_ARDOUGNE_TO_WIZARDS_TOWER(328),
	CRATE_ARDOUGNE_HANDELMORT_MANSION(329),
	SIGN_RPDT_DEPOT(330),
	STAIRS_STONE_UP_TRAPPED(331),
	CHEST_ARDOUGNE_TRIBAL_TOTEM_OPEN(332),
	CHEST_ARDOUGNE_TRIBAL_TOTEM_CLOSED(333),
	CHEST_CLOSED_10_GOLD(334),
	CHEST_CLOSED_NATURE_RUNE(335),
	CHEST_CLOSED_50_GOLD(336),
	CHEST_CLOSED_BLOOD_RUNE(337),
	CHEST_CLOSED_PALADIN(338),
	CHEST_OPEN_STEALING(339),
	CHEST_CLOSED_EMPTY(340),
	STALL_EMPTY(341),
	STAIRS_STONE_ARDOUGNE_CASTLE_UP(342),
	HOPPER(343), // TODO Needs name & location??
	SIGNPOST_ARDOUGNE_CITY_ZOO(344),
	SIGN_FLYING_HORSE(345),
	GATE_MEMBERS(346), // TODO Needs name
	GATE_MEMBERS_WILDERNESS_ICE_GIANT(347),
	LEVER_ARDOUGNE_TO_WILDERNESS_UP(348),
	LEVER_WILDERNESS_TO_ARDOUGNE_UP(349),
	PIPE_FISHING_CONTEST(350),
	FISH_BAIT_FISHING_CONTEST1(351),
	FISH_BAIT_FISHING_CONTEST2(352),
	FISH_BAIT_FISHING_CONTEST3(353),
	FISH_BAIT_FISHING_CONTEST4(354),
	VINE_RED_FISHING_CONTEST(355),
	GATE_MCGRUBORS_WOOD(356),
	GATE_WOODEN_FISHING_CONTEST_OPEN(357),
	GATE_WOODEN_FISHING_CONTEST_CLOSED(358),
	STAIRS_STONE_WHITE_WOLF_PASS_DOWN(359),
	CART_BROKEN(360),
	LEVER_UP_TRAPPED(361),
	CLOCK_POLE_BLUE(362),
	CLOCK_POLE_RED(363),
	CLOCK_POLE_PURPLE(364),
	CLOCK_POLE_BLACK(365),
	WALLCLOCKFACE(366),
	LEVER_BRACKET(367),
	LEVER_CLOCK_TOWER_UP(368),
	STAIRS_WOODEN_TEMPLE_OF_IKOV_DUNGEON_UP(369),
	STAIRS_WOODEN_TEMPLE_OF_IKOV_DUNGEON_DOWN(370),
	GATE_METAL_QUEST_CLOSED(371),
	GATE_METAL_QUEST_OPEN(372),
	LEVER_CLOCK_TOWER_DUNGEON_UP(373),
	LEVER_CLOCK_TOWER_DUNGEON_DOWN(374),
	FOODTROUGH(375),
	FISH_CAGE_HARPOON(376),
	SPEARWALL(377),
	SKULL_HORNED(378),
	CHEST_HEMENSTER_CLOSED(379),
	CHEST_CLOSED(380), // TODO Needs name
	CUPBOARD_GUARDS_CLOSED(381),
	CUPBOARD_GUARDS_OPEN(382),
	COAL_TRUCK(383),
	SHIP_FRONT_BRIMHAVEN(384),
	SHIP_MIDDLE_BRIMHAVEN(385),
	SHIP_BACK_BRIMHAVEN(386),
	TREE_HOUSE(387),
	BALLISTA(388),
	LARGE_SPEAR(389),
	SPIRIT_TREE(390),
	YOUNG_SPIRIT_TREE(391),
	GATE_TREE_GNOME_VILLAGE_TRACKER_2_CLOSED(392),
	WALL_KHAZARD_BATTLEFIELD_DAMAGED(393), // TODO Needs name & location
	TREE_EXOTIC1(394),
	TREE_EXOTIC2(395),
	FERN_EXOTIC1(396),
	FERN_EXOTIC2(397),
	FERN_EXOTIC3(398),
	FERN_EXOTIC4(399),
	FLY_TRAP(400),
	FERN_EXOTIC(401),
	FERN_SPIKEY(402),
	PLANT_UNUSUAL(403),
	PLANT_ODD(404),
	PLANT_JUNGLE_FOLIAGE(405),
	STONE_HEAD(406),
	TREE_DEAD(407),
	SACKS_HOLY_GRAIL(408),
	CHEST_KHAZARD_OPEN(409),
	CHEST_KHAZARD_CLOSED(410),
	DOORFRAME_CARNILLEAN(411),
	SEWER_VALVE(412),
	SEWER_VALVE2(413),
	SEWER_VALVE3(414),
	SEWER_VALVE4(415),
	SEWER_VALVE5(416),
	CAVE_ENTRANCE(417),
	LOG_BRIDGE(418),
	LOG_BRIDGE_BOTTOM(419),
	TREE_PLATFORM_BOTTOM(420),
	TREE_PLATFORM(421),
	GATE_UNUSED(422), // TODO find name and location
	TREE_PLATFORM_KING_BOLREN(423),
	TREE_PLATFORM_KING_BOLREN_BOTTOM(424),
	LOG_BRIDGE_TURN_BOTTOM(425),
	LOG_BRIDGE_TURN(426),
	TREE_PLATFORM_CENTER(427),
	TREE_PLATFORM_CENTER_BOTTOM(428),
	TRIBAL_BREW(429),
	PINEAPPLE_TREE(430),
	PINEAPPLE_TREE_EMPTY(431),
	LOG_RAFT_CLIVET(432),
	LOG_RAFT_PIPE_EXIT(433),
	TOMB_OF_HAZEEL(434),
	RANGE_CARNILLEAN(435),
	BOOKCASE_CARNILLEAN(436),
	CARNILLEAN_CHEST_OPEN(437),
	CARNILLEAN_CHEST_CLOSED(438),
	CRATE_CARNILLEAN(439),
	BUTLERS_CUPBOARD_CLOSED(440),
	BUTLERS_CUPBOARD_OPEN(441),
	GATE_WOODEN_SHEEP_HERDER_OPEN(442),
	GATE_WOODEN_SHEEP_HERDER_CLOSED(443),
	CATTLE_FURNACE(444),
	ARDOUNGE_WALL(445),
	ARDOUNGE_WALL_CORNER(446),
	DUG_UP_SOIL(447),
	PILE_OF_MUD(448),
	LARGE_SEWER_PIPE(449),
	ARDOUNGE_WALL_GATEWAY(450),
	CUPBOARD_PLAGUE_CITY_CLOSED(451),
	CUPBOARD_PLAGUE_CITY_OPEN(452),
	FISHING_CRANE(453),
	ROWBOAT_HOLGART(454),
	DAMAGED_ROWBOAT(455),
	BARREL_NEAR_ELENA(456),
	GATE_NEAR_ELENA(457),
	LADDER_SEA_PLATFORM_UP(458),
	FISHING_CRANE2(459),
	FISHING_CRANE3(460),
	WATERFALL(461),
	LEAFLESSTREE_WATERFALL1(462),
	LEAFLESSTREE_WATERFALL2(463),
	LOG_RAFT_WATERFALL(464),
	DOORS_WATERFALL(465),
	WELL_WATERFALL(466),
	TOMB_OF_GLARIAL(467),
	WATERFALL2(468),
	WATERFALL3(469),
	BOOKCASE_WATERFALL_HADLEYS_HOUSE(470),
	DOORS_WATERFALL_CLOSED(471),
	DOORS_WATERFALL_OPEN(472),
	STONE_STAND_WATERFALL(473),
	STONE_STAND_WATERFALL2(474),
	STONE_STAND_WATERFALL3(475),
	STONE_STAND_WATERFALL4(476),
	STONE_STAND_WATERFALL5(477),
	STONE_STAND_WATERFALL6(478),
	GLARIALS_GRAVESTONE(479),
	GATE_NEAR_GOLRIE_CLOSED(480),
	CRATE_NEAR_GOLRIE(481),
	LEAFLESSTREE_WATERFALL3(482),
	STATUE_OF_GLARIAL(483),
	CHALICE_OF_ETERNITY(484),
	CHALICE_OF_ETERNITY2(485),
	DOORS_CHALICE_ROOM_CLOSED(486),
	LEVER_TO_KING_BLACK_DRAGON(487),
	LEVER_FROM_KING_BLACK_DRAGON(488),
	LOG_RAFT_REMAINS(489);
	// TODO: PROPERLY NAME ALL BELOW SCENERY OBJECTS.
	/*
	TREE(490),
	RANGE(491),
	CRATE(492),
	FISH(493),
	WATCH_TOWER(494),
	SIGNPOST(495),
	ROCKS(496),
	DOORS(497),
	ROPE_LADDER(498),
	CUPBOARD(499),
	CUPBOARD(500),
	ROPE_LADDER(501),
	COOKING_POT(502),
	GALLOW(503),
	GATE(504),
	CRATE(505),
	CUPBOARD(506),
	CUPBOARD(507),
	GATE(508),
	CUPBOARD(509),
	CUPBOARD(510),
	SIGN(511),
	GRAND_TREE(512),
	GATE(513),
	GATE(514),
	ROCKS(515),
	ROCKS(516),
	ROCKS(517),
	ROCKS(518),
	ROCKS(519),
	ROCKS(520),
	ROCKS(521),
	ROCKS(522),
	ROCKS(523),
	LOG_BRIDGE(524),
	WATCH_TOWER(525),
	LOG_BRIDGE(526),
	CLIMBING_ROCKS(527),
	LEDGE(528),
	LEDGE(529),
	LOG(530),
	LOG(531),
	ROCKS(532),
	ROCKS(533),
	ROCKS(534),
	ROCKS(535),
	ROCKS(536),
	ROCKS(537),
	ROCKS(538),
	ROCKS(539),
	ROCKS(540),
	ROCKS(541),
	ROCKS(542),
	ROCKS(543),
	ROCKS(544),
	ROCKS(545),
	ROCKS(546),
	ROCKS(547),
	ROCKS(548),
	ROCKS(549),
	ROCKS(550),
	ROCKS(551),
	ROCKS(552),
	PALMTREE(553),
	SCORCHED_EARTH(554),
	ROCKS(555),
	SIGN(556),
	FISH(557),
	ROCKY_WALKWAY(558),
	ROCKY_WALKWAY(559),
	ROCKY_WALKWAY(560),
	ROCKY_WALKWAY(561),
	FIGHT_DUMMY(562),
	GATE(563),
	JUNGLE_VINE(564),
	STATUE(565),
	SIGN(566),
	GRAND_TREE(567),
	GRAND_TREE(568),
	GRAND_TREE(569),
	GRAND_TREE(570),
	GRAND_TREE(571),
	HILLSIDE_ENTRANCE(572),
	TREE(573),
	LOG_BRIDGE(574),
	TREE_PLATFORM(575),
	TREE_PLATFORM(576),
	METALIC_DUNGEON_GATE(577),
	LOG_BRIDGE(578),
	LOG_BRIDGE(579),
	WATCH_TOWER(580),
	WATCH_TOWER(581),
	SHALLOW_WATER(582),
	DOORS(583),
	GRAND_TREE(584),
	TREE_LADDER(585),
	TREE_LADDER(586),
	BLURBERRYS_COCKTAIL_BAR(587),
	GEM_ROCKS(588),
	GIANNES_PLACE(589),
	ROPESWING(590),
	NET(591),
	FRAME(592),
	TREE(593),
	TREE(594),
	TREE(595),
	CART(596),
	FENCE(597),
	BEAM(598),
	SIGN(599),
	SIGN(600),
	SIGN(601),
	SIGN(602),
	SIGN(603),
	SIGN(604),
	SIGN(605),
	SIGN(606),
	SIGN(607),
	SIGN(608),
	ROOT(609),
	ROOT(610),
	METAL_GATE(611),
	METAL_GATE(612),
	A_FARM_CART(613),
	LEDGE(614),
	LEDGE(615),
	LADDER(616),
	CAGE(617),
	GLIDER(618),
	CUPBOARD(619),
	CUPBOARD(620),
	STAIRS(621),
	GLIDER(622),
	GATE(623),
	GATE(624),
	CHAOS_ALTAR(625),
	GNOME_STRONGHOLD_GATE(626),
	ROPESWING(627),
	ROPESWING(628),
	STAIRS(629),
	STAIRS(630),
	CHEST(631),
	CHEST(632),
	PILE_OF_RUBBLE(633),
	STONE_STAND(634),
	WATCH_TOWER(635),
	PILE_OF_RUBBLE(636),
	ROOT(637),
	ROOT(638),
	ROOT(639),
	SIGN(640),
	HAMMOCK(641),
	GOAL(642),
	STONE_TILE(643),
	CHEST(644),
	CHEST(645),
	WATCH_TOWER(646),
	NET(647),
	WATCH_TOWER(648),
	WATCH_TOWER(649),
	ROPESWING(650),
	BUMPY_DIRT(651),
	PIPE(652),
	NET(653),
	PIPE(654),
	LOG(655),
	PIPE(656),
	PIPE(657),
	HANDHOLDS(658),
	LADDER(659),
	GATE(660),
	STRONGHOLD_SPIRIT_TREE(661),
	TREE(662),
	TREE(663),
	TREE(664),
	SPIKED_PIT(665),
	SPIKED_PIT(666),
	CAVE(667),
	STONE_PEBBLE(668),
	PILE_OF_RUBBLE(669),
	PILE_OF_RUBBLE(670),
	PIPE(671),
	PIPE(672),
	STONE(673),
	STONE(674),
	ROPESWING(675),
	LOG(676),
	NET(677),
	LEDGE(678),
	HANDHOLDS(679),
	LOG(680),
	LOG(681),
	ROTTEN_GALLOWS(682),
	PILE_OF_RUBBLE(683),
	ROPESWING(684),
	ROPESWING(685),
	OCKS(686),
	TREE(687),
	WELL_STACKED_ROCKS(688),
	TOMB_DOLMEN(689),
	HANDHOLDS(690),
	BRIDGE_BLOCKADE(691),
	LOG_BRIDGE(692),
	HANDHOLDS(693),
	TREE(694),
	TREE(695),
	WET_ROCKS(696),
	SMASHED_TABLE(697),
	CRUDE_RAFT(698),
	DACONIA_ROCK(699),
	STATUE(700),
	STEPPING_STONES(701),
	GATE(702),
	GATE(703),
	GATE(704),
	PIPE(705),
	ROPESWING(706),
	STONE(707),
	LEDGE(708),
	VINE(709),
	ROCKS(710),
	WOODEN_GATE(711),
	WOODEN_GATE(712),
	STONE_BRIDGE(713),
	STONE_BRIDGE(714),
	STONE_BRIDGE(715),
	STONE_BRIDGE(716),
	STONE_PLATFORM(717),
	FENCE(718),
	ROCKS(719),
	STONE_BRIDGE(720),
	STONE_BRIDGE(721),
	GATE_OF_IBAN(722),
	WOODEN_DOOR(723),
	TOMB_DOLMEN(724),
	CAVE_ENTRANCE(725),
	OLD_BRIDGE(726),
	OLD_BRIDGE(727),
	CRUMBLED_ROCK(728),
	STALAGMITE(729),
	STALAGMITE(730),
	ROCKS(731),
	LEDGE(732),
	LEVER(733),
	STALACTITE(734),
	STALACTITE(735),
	STALACTITE(736),
	ROCKS(737),
	ROCKS(738),
	ROCKS(739),
	ROCKS(740),
	ROCKS(741),
	ROCKS(742),
	ROCKS(743),
	ROCKS(744),
	ROCKS(745),
	ROCKS(746),
	ROCKS(747),
	ROCKS(748),
	ROCKS(749),
	LEDGE(750),
	LEDGE(751),
	LEDGE(752),
	LEDGE(753),
	SWAMP(754),
	SWAMP(755),
	ROCKS(756),
	ROCKS(757),
	ROCKS(758),
	ROCKS(759),
	ROCKS(760),
	ROCKS(761),
	ROCKS(762),
	ROCKS(763),
	ROCKS(764),
	ROCKS(765),
	ROCKS(766),
	PILE_OF_MUD(767),
	TRAVEL_CART(768),
	TRAVEL_CART(769),
	ROCKS(770),
	STALACTITE(771),
	ROCKS(772),
	ROCKS(773),
	ROCKS(774),
	SIGN(775),
	LADDER(776),
	GRILL(777),
	SPIKED_PIT(778),
	SIGNPOST(779),
	SHIP(780),
	SHIP(781),
	GRILL(782),
	SACKS(783),
	ZAMORAKIAN_TEMPLE(784),
	GRILL(785),
	GRILL(786),
	GRILL(787),
	GRILL(788),
	GRILL(789),
	GRILL(790),
	GRILL(791),
	ROCKS(792),
	ROCKS(793),
	TOMB_DOORS(794),
	SWAMP(795),
	ROCKS(796),
	ROCKS(797),
	STALACTITE(798),
	STALACTITE(799),
	SPIKED_PIT(800),
	LEVER(801),
	CAGE(802),
	CAGE(803),
	ROCKS(804),
	SPEAR_TRAP(805),
	ROCKS(806),
	ROCKS(807),
	ROCKS(808),
	ROCKS(809),
	ROCKS(810),
	ROCKS(811),
	LEDGE(812),
	FURNACE(813),
	WELL(814),
	PASSAGE(815),
	PASSAGE(816),
	PASSAGE(817),
	STALAGMITE(818),
	ROCKS(819),
	ROCKS(820),
	ROCKS(821),
	ROCKS(822),
	ROCKS(823),
	ROCKS(824),
	PASSAGE(825),
	SNAP_TRAP(826),
	WOODEN_PLANKS(827),
	PASSAGE(828),
	PASSAGE(829),
	FLAMES_OF_ZAMORAK(830),
	PLATFORM(831),
	ROCK(832),
	ROCK(833),
	ROCK(834),
	ROCK(835),
	WALL_GRILL(836),
	LEDGE(837),
	WALL_GRILL(838),
	DUG_UP_SOIL(839),
	DUG_UP_SOIL(840),
	PILE_OF_MUD(841),
	STALAGMITE(842),
	PILE_OF_MUD(843),
	PILE_OF_MUD(844),
	PILE_OF_MUD(845),
	PILE_OF_MUD(846),
	PILE_OF_MUD(847),
	SPIKED_PIT(848),
	ROCKS(849),
	ROCKS(850),
	ROCKS(851),
	ROCKS(852),
	ROCKS(853),
	ROCKS(854),
	ROCKS(855),
	ROCKS(856),
	ROCKS(857),
	ROCKS(858),
	ROCKS(859),
	ROCKS(860),
	LEDGE(861),
	LEDGE(862),
	LEDGE(863),
	LEDGE(864),
	LEDGE(865),
	LEDGE(866),
	BOULDER(867),
	CRATE(868),
	DOOR(869),
	PLATFORM(870),
	CAGE_REMAINS(871),
	LEDGE(872),
	PASSAGE(873),
	PASSAGE(874),
	GATE_OF_ZAMORAK(875),
	ROCKS(876),
	BRIDGE_SUPPORT(877),
	TOMB_OF_IBAN(878),
	CLAWS_OF_IBAN(879),
	BARREL(880),
	ROCK(881),
	ROCKS(882),
	ROCKS(883),
	SWAMP(884),
	CHEST(885),
	STONE_BRIDGE(886),
	CAGE(887),
	CAGE(888),
	STONE_STEPS(889),
	PILE_OF_MUD(890),
	STONE_BRIDGE(891),
	STONE_BRIDGE(892),
	STONE_BRIDGE(893),
	STONE_BRIDGE(894),
	STONE_BRIDGE(895),
	STONE_BRIDGE(896),
	STONE_BRIDGE(897),
	STONE_BRIDGE(898),
	STONE_BRIDGE(899),
	STONE_BRIDGE(900),
	STONE_BRIDGE(901),
	STONE_BRIDGE(902),
	STONE_BRIDGE(903),
	STONE_BRIDGE(904),
	STONE_BRIDGE(905),
	STONE_BRIDGE(906),
	STONE_BRIDGE(907),
	STONE_BRIDGE(908),
	STONE_BRIDGE(909),
	STONE_BRIDGE(910),
	CHEST(911),
	CHEST(912),
	PIT_OF_THE_DAMNED(913),
	OPEN_DOOR(914),
	SIGNPOST(915),
	STONE_GATE(916),
	CHEST(917),
	ZODIAC(918),
	CHEST(919),
	LADDER(920),
	STONE_STEPS(921),
	ROCK(922),
	ROCK(923),
	ROCK(924),
	TELESCOPE(925),
	GATE(926),
	SACKS(927),
	LADDER(928),
	CHEST(929),
	CHEST(930),
	BOOKCASE(931),
	IRON_GATE(932),
	LADDER(933),
	CHEST(934),
	CHEST(935),
	CHEST(936),
	CHEST(937),
	ROCKSLIDE(938),
	ALTAR(939),
	COLUMN(940),
	GRAVE_OF_SCORPIUS(941),
	BANK_CHEST(942),
	DWARF_MULTICANNON(943),
	DISTURBED_SAND(944),
	DISTURBED_SAND(945),
	DWARF_MULTICANNON_BASE(946),
	DWARF_MULTICANNON_STAND(947),
	DWARF_MULTICANNON_BARRELS(948),
	CAVE(949),
	CAVE(950),
	FENCE(951),
	SIGNPOST(952),
	ROCKS(953),
	ROCKS(954),
	CAVE_ENTRANCE(955),
	CHEST(956),
	CHEST(957),
	WOODEN_DOORS(958),
	PEDESTAL(959),
	BUSH(960),
	BUSH(961),
	STANDARD(962),
	MINING_CAVE(963),
	MINING_CAVE(964),
	ROCKS(965),
	LIFT(966),
	MINING_BARREL(967),
	HOLE(968),
	HOLE(969),
	CAVE(970),
	CAVE(971),
	CAVE(972),
	COUNTER(973),
	TRACK(974),
	CAVE(975),
	MINE_CART(976),
	LIFT_PLATFORM(977),
	CHEST(978),
	CHEST(979),
	WATCH_TOWER(980),
	LADDER(981),
	CAVE_ENTRANCE(982),
	PILE_OF_MUD(983),
	CAVE(984),
	LADDER(985),
	CRATE(986),
	CRATE(987),
	GATE(988),
	GATE(989),
	BUSH(990),
	BUSH(991),
	BUSH(992),
	BUSH(993),
	MULTICANNON(994),
	ROCKS(995),
	ROCKS(996),
	LADDER(997),
	CAVE_ENTRANCE(998),
	COUNTER(1000),
	CHEST(1001),
	CHEST(1002),
	CHEST(1003),
	CHEST(1004),
	BOOKCASE(1005),
	CAPTAINS_CHEST(1006),
	EXPERIMENTAL_ANVIL(1007),
	ROCKS(1008),
	ROCKS(1009),
	COLUMN(1010),
	WALL(1011),
	WALL(1012),
	WALL(1013),
	WALL(1014),
	LEVER(1015),
	LEVER(1016),
	WALL(1017),
	LADDER(1018),
	WALL(1019),
	GATE(1020),
	GATE(1021),
	LADDER(1022),
	SHOCK(1023),
	DESK(1024),
	CAVE(1025),
	MINING_CART(1026),
	ROCK_OF_DALGROTH(1027),
	ENTRANCE(1028),
	DRIED_CACTUS(1029),
	CLIMBING_ROCKS(1030),
	ROCKS(1031),
	LIGHTNING(1032),
	CRUDE_DESK(1033),
	HEAVY_METAL_GATE(1034),
	COUNTER(1035),
	CRUDE_BED(1036),
	FLAMES(1037),
	CARVED_ROCK(1038),
	USE(1039),
	CRATE(1040),
	CRATE(1041),
	BARREL(1042),
	BRICK(1043),
	BRICK(1044),
	BRICK(1045),
	BRICK(1046),
	BRICK(1047),
	BRICK(1048),
	BARRIER(1049),
	BURIED_SKELETON(1050),
	BRICK(1051),
	BRICK(1052),
	SPECIMEN_TRAY(1053),
	WINCH(1054),
	CRATE(1055),
	CRATE(1056),
	URN(1057),
	BURIED_SKELETON(1058),
	PANNING_POINT(1059),
	ROCKS(1060),
	SIGNPOST(1061),
	SIGNPOST(1062),
	SIGNPOST(1063),
	SIGNPOST(1064),
	SIGNPOST(1065),
	SOIL(1066),
	SOIL(1067),
	SOIL(1068),
	GATE(1069),
	SHIP(1070),
	BARREL(1071),
	LEAK(1072),
	BUSH(1073),
	BUSH(1074),
	CUPBOARD(1075),
	SACKS(1076),
	SACKS(1077),
	LEAK(1078),
	CUPBOARD(1079),
	WROUGHT_MITHRIL_GATES(1080),
	LEGENDS_HALL_DOORS(1081),
	CAMP_BED(1082),
	BARREL(1083),
	BARREL(1084),
	CHEST(1085),
	CHEST(1086),
	DENSE_JUNGLE_TREE(1087),
	JUNGLE_TREE_STUMP(1088),
	SIGNPOST(1089),
	GATE(1090),
	BOOKCASE(1091),
	DENSE_JUNGLE_TREE(1092),
	DENSE_JUNGLE_TREE(1093),
	SPRAY(1094),
	SPRAY(1095),
	WINCH(1096),
	BRICK(1097),
	ROPE(1098),
	ROPE(1099),
	DENSE_JUNGLE_PALM(1100),
	DENSE_JUNGLE_PALM(1101),
	TRAWLER_NET(1102),
	TRAWLER_NET(1103),
	BRICK(1104),
	CHEST(1105),
	CHEST(1106),
	TRAWLER_CATCH(1107),
	YOMMI_TREE(1108),
	GROWN_YOMMI_TREE(1109),
	CHOPPED_YOMMI_TREE(1110),
	TRIMMED_YOMMI_TREE(1111),
	TOTEM_POLE(1112),
	BABY_YOMMI_TREE(1113),
	FERTILE_EARTH(1114),
	ROCK_HEWN_STAIRS(1115),
	HANGING_ROPE(1116),
	ROCKS(1117),
	BOULDER(1118),
	DWARF_MULTICANNON(1119),
	DWARF_MULTICANNON_BASE(1120),
	DWARF_MULTICANNON_STAND(1121),
	DWARF_MULTICANNON_BARRELS(1122),
	ROCK(1123),
	ROCK_HEWN_STAIRS(1124),
	ROCK_HEWN_STAIRS(1125),
	ROCK_HEWN_STAIRS(1126),
	COMPOST_HEAP(1127),
	BEEHIVE(1128),
	DRAIN(1129),
	WEB(1130),
	FOUNTAIN(1131),
	SINCLAIR_CREST(1132),
	BARREL(1133),
	BARREL(1134),
	BARREL(1135),
	BARREL(1136),
	BARREL(1137),
	BARREL(1138),
	FLOUR_BARREL(1139),
	SACKS(1140),
	GATE(1141),
	DEAD_YOMMI_TREE(1142),
	CLAWSPELL(1143),
	ROCKS(1144),
	CRATE(1145),
	CAVERNOUS_OPENING(1146),
	ANCIENT_LAVA_FURNACE(1147),
	SPELLCHARGE(1148),
	ROCKS(1149),
	CUPBOARD(1150),
	SACKS(1151),
	ROCK(1152),
	SARADOMIN_STONE(1153),
	GUTHIX_STONE(1154),
	ZAMORAK_STONE(1155),
	MAGICAL_POOL(1156),
	WOODEN_BEAM(1157),
	ROPE_DOWN_INTO_DARKNESS(1158),
	CAVE_ENTRANCE(1159),
	CAVE_ENTRANCE(1160),
	ANCIENT_WOODEN_DOORS(1161),
	TABLE(1162),
	CRUDE_BED(1163),
	TALL_REEDS(1164),
	GOBLIN_FOOT_PRINTS(1165),
	DARK_METAL_GATE(1166),
	MAGICAL_POOL(1167),
	ROPE_UP(1168),
	HALF_BURIED_REMAINS(1169),
	TOTEM_POLE(1170),
	TOTEM_POLE(1171),
	COMFY_BED(1172),
	ROTTEN_YOMMI_TREE(1173),
	ROTTEN_YOMMI_TREE(1174),
	ROTTEN_YOMMI_TREE(1175),
	ROTTEN_TOTEM_POLE(1176),
	LEAFY_PALM_TREE(1177),
	GRAND_VIZIERS_DESK(1178),
	STRANGE_BARREL(1179),
	SHIP(1180),
	SHIP(1181),
	SHIP(1182),
	DIGSITE_BED(1183),
	TEA_STALL(1184),
	BOULDER(1185),
	BOULDER(1186),
	DAMAGED_EARTH(1187),
	LADDER(1188),
	LADDER(1189),
	VINE(1190),

	//RUNECRAFT_OBJECTS
	MYSTERIOUS_RUINS(1191),
	AIR_ALTAR(1192),
	MYSTERIOUS_RUINS(1193),
	MIND_ALTAR(1194),
	MYSTERIOUS_RUINS(1195),
	WATER_ALTAR(1196),
	MYSTERIOUS_RUINS(1197),
	EARTH_ALTAR(1198),
	MYSTERIOUS_RUINS(1199),
	FIRE_ALTAR(1200),
	MYSTERIOUS_RUINS(1201),
	BODY_ALTAR(1202),
	MYSTERIOUS_RUINS(1203),
	COSMIC_ALTAR(1204),
	MYSTERIOUS_RUINS(1205),
	CHAOS_ALTAR(1206),
	MYSTERIOUS_RUINS(1207),
	NATURE_ALTAR(1208),
	MYSTERIOUS_RUINS(1209),
	LAW_ALTAR(1210),
	MYSTERIOUS_RUINS(1211),
	DEATH_ALTAR(1212),
	MYSTERIOUS_RUINS(1213),
	BLOOD_ALTAR(1214),
	PORTAL(1215),
	PORTAL(1216),
	PORTAL(1217),
	PORTAL(1218),
	PORTAL(1219),
	PORTAL(1220),
	PORTAL(1221),
	PORTAL(1222),
	PORTAL(1223),
	PORTAL(1224),
	PORTAL(1225),
	PORTAL(1226),
	PORTAL(1227),
	RAW_ESSENCE(1228),
	PORTAL(1229),
	PORTAL(1230),
	PORTAL(1231),
	PORTAL(1232),
	PORTAL(1233),
	PORTAL(1234),
	PORTAL(1235),
	PORTAL(1236),


	PIPE(1237),
	PIPE(1238),

	CHRISTMAS_TREE(1239),
	DECORATED_TREE(1240),
	PINE_TREE(1241),
	TUNNEL_ENTRANCE(1242),
	ROWBOAT(1243),

//HARVESTING_OBJECTS
	//IF (CONFIG.S_WANT_HARVESTING) {
	LEMON_TREE(1244),
	LIME_TREE(1245),
	APPLE_TREE(1246),
	ORANGE_TREE(1247),
	GRAPEFRUIT_TREE(1248),
	BANANA_PALM(1249),
	COCONUT_PALM(1250),
	PAPAYA_PALM(1251),
	PINEAPPLE_PLANT(1252),
	EXHAUSTED_TREE(1253),
	EXHAUSTED_PALM(1254),
	EXHAUSTED_PALM(1255),
	EXHAUSTED_PLANT(1256),
	REDBERRY_BUSH(1257),
	CADAVABERRY_BUSH(1258),
	DWELLBERRY_BUSH(1259),
	JANGERBERRY_BUSH(1260),
	WHITEBERRY_BUSH(1261),
	DEPLETED_BUSH(1262),
	CABBAGE(1263),
	RED_CABBAGE(1264),
	WHITE_PUMPKIN(1265),
	POTATO_PLANT(1266),
	ONION_PLANT(1267),
	GARLIC_PLANT(1268),
	TOMATO_PLANT(1269),
	CORN_PLANT(1270),
	DAMAGED_GROUND(1271),
	DEPLETED_TOMATO_PLANT(1272),
	DEPLETED_CORN_PLANT(1273),
	SNAPE_GRASS(1274),
	HERB(1275),
	PUMPKIN(1276),
	SOIL_MOUND(1277),
	BARREL_OF_WATER(1278),
	COMPOST_BIN(1279),
	COMPOST_BIN(1280),
	SEA_WEED(1281),
	LIMPWURT_ROOT(1282),
	SUGAR_CANE(1283),
	MYSTERIOUS_GRAPE_VINE(1284),
	LAVA_FORGE(1285),
	ANVIL(1286),
	ROCKS(1287)

	;
*/
	private int sceneryId;

	private static final Map<Integer, SceneryId> byId = new HashMap<>();

	static {
		for (SceneryId scenery : SceneryId.values()) {
			if (byId.put(scenery.id(), scenery) != null) {
				throw new IllegalArgumentException("duplicate id: " + scenery.id());
			}
		}
	}

	public static SceneryId getById(Integer id) {
		return byId.getOrDefault(id, SceneryId.NOTHING);
	}

	/**
	 * @param sceneryId The ID of the item.
	 */
	SceneryId(int sceneryId) {
		this.sceneryId = sceneryId;
	}

	/**
	 * @return The items ID
	 */
	public int id() {
		return sceneryId;
	}
}