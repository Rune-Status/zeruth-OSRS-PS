package org.arcanium.tools.item;

import org.arcanium.ServerConstants;
import org.arcanium.cache.Cache;
import org.arcanium.cache.ServerStore;
import org.arcanium.cache.def.impl.ItemDefinition;
import org.arcanium.cache.def.impl.ItemDefinitionLoader;
import org.arcanium.cache.misc.buffer.ByteBufferUtils;
import org.arcanium.game.world.GameWorld;
import org.arcanium.game.world.update.flag.context.Animation;
import org.arcanium.parser.item.ItemConfiguration;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Handles the item configuration editing.
 *
 * @author Emperor
 */
public final class ItemConfigurationEditor {

    private static final Map<Integer, int[]> BONUSES = new HashMap<>();

    private static final int[] TWO_HANDED = {839, 841, 843, 845, 847, 849, 851, 853, 855, 857, 859, 861, 1237, 1239, 1241, 1243, 1245, 1247, 1249, 1251, 1253, 1255, 1257, 1259, 1261, 1263, 1307, 1309, 1311, 1313, 1315, 1317, 1319, 1419, 2883, 3095, 3096, 3097, 3098, 3099, 3100, 3101, 3170, 3171, 3172, 3173, 3174, 3175, 3176, 3190, 3192, 3194, 3196, 3198, 3200, 3202, 3204, 4037, 4039, 4084, 4153, 4158, 4212, 4214, 4215, 4216, 4217, 4218, 4219, 4220, 4221, 4222, 4223, 4236, 4580, 4582, 4584, 4718, 4726, 4734, 4747, 4755, 4827, 4886, 4887, 4888, 4889, 4890, 4910, 4911, 4912, 4913, 4914, 4934, 4935, 4936, 4937, 4938, 4958, 4959, 4960, 4961, 4962, 4982, 4983, 4984, 4985, 4986, 5016, 5704, 5706, 5708, 5710, 5712, 5714, 5716, 5718, 5720, 5722, 5724, 5726, 5728, 5730, 5734, 5736, 6082, 6526, 6528, 6587, 6599, 6609, 6724, 6760, 6762, 6764, 6773, 6774, 6775, 6776, 6777, 6778, 6779, 6817, 7158, 7439, 7639, 7640, 7641, 7642, 7643, 7644, 7645, 7646, 7647, 7648, 7668, 7671, 7673, 7679, 7804, 7809, 8650, 8652, 8654, 8656, 8658, 8660, 8662, 8664, 8666, 8668, 8670, 8672, 8674, 8676, 8678, 8680, 8971, 9044, 9046, 9048, 9050, 9705, 10146, 10147, 10148, 10149, 10150, 10280, 10282, 10284, 10735, 10858, 10887, 11235, 11259, 11694, 11696, 11698, 11700, 11716, 11730, 13117, 13118, 13119, 13120, 13121, 13122, 13123, 13124, 13125, 13126, 13127, 13128, 13129, 13130, 13131, 13132, 13133, 13134, 13135, 13136, 13137, 13138, 13139, 13140, 13141, 13142, 13143, 13144, 13145, 13146,};

    /**
     * The main method.
     *
     * @param args The arguments cast on runtime.
     * @throws Throwable When an exception occurs.
     */
    public static final void main(String... args) throws Throwable {
        System.out.println("ITEM CONFIG EDITOR LAUNCH");
        GameWorld.prompt(false);
        ItemDefinitionLoader itemDefinitionLoader = new ItemDefinitionLoader();
        itemDefinitionLoader.load();
        int[] specials = {35, 805, 859, 861, 1215, 1231, 1249, 1263, 1305, 1377, 1434, 3101, 3176, 3204, 4151, 4153, 4587, 5680, 5698, 5716, 5730, 6724, 6739, 6746, 7158, 7639, 7640, 7641, 7642, 7643, 7644, 7645, 7646, 7647, 7648, 8872, 8874, 8876, 8878, 8880, 10284, 10887, 11037, 11061, 11235, 11694, 11696, 11698, 11700, 11716, 11730, 13117, 13118, 13119, 13120, 13121, 13122, 13123, 13124, 13125, 13126, 13127, 13128, 13129, 13130, 13131, 13132, 13133, 13134, 13135, 13136, 13137, 13138, 13139, 13140, 13141, 13142, 13143, 13144, 13145, 13146, 20997, 21009, 21012, 21015, 21028, 21031};
        for (int itemId : specials) {
            ItemDefinition def = ItemDefinition.forId(itemId);
            def.getConfigurations().put(ItemConfiguration.HAS_SPECIAL, true);
        }
        int[][] data = {{35, 6}, {278, 5}, {667, 6}, {732, 18}, {746, 5}, {747, 5}, {767, 17}, {772, 1}, {800, 18}, {801, 18}, {802, 18}, {803, 18}, {804, 18}, {805, 18}, {20849, 18}, {806, 18}, {807, 18}, {808, 18}, {809, 18}, {810, 18}, {811, 18}, {812, 18}, {813, 18}, {814, 18}, {815, 18}, {816, 18}, {817, 18}, {825, 18}, {826, 18}, {827, 18}, {828, 18}, {829, 18}, {830, 18}, {831, 18}, {832, 18}, {833, 18}, {834, 18}, {835, 18}, {836, 18}, {837, 17}, {839, 16}, {841, 16}, {843, 16}, {845, 16}, {847, 16}, {849, 16}, {851, 16}, {853, 16}, {855, 16}, {857, 16}, {859, 16}, {861, 16}, {863, 18}, {864, 18}, {865, 18}, {866, 18}, {867, 18}, {868, 18}, {869, 18}, {870, 18}, {871, 18}, {872, 18}, {873, 18}, {874, 18}, {875, 18}, {876, 18}, {975, 6}, {1203, 5}, {1205, 5}, {1207, 5}, {1209, 5}, {1211, 5}, {1213, 5}, {1215, 5}, {1217, 5}, {1219, 5}, {1221, 5}, {1223, 5}, {1225, 5}, {1227, 5}, {1229, 5}, {1231, 5}, {1233, 5}, {1235, 5}, {1237, 14}, {1239, 14}, {1241, 14}, {1243, 14}, {1245, 14}, {1247, 14}, {1249, 14}, {1251, 14}, {1253, 14}, {1255, 14}, {1257, 14}, {1259, 14}, {1261, 14}, {1263, 14}, {1265, 4}, {1267, 4}, {1269, 4}, {1271, 4}, {1273, 4}, {1275, 4}, {1277, 5}, {1279, 5}, {1281, 5}, {1283, 5}, {1285, 5}, {1287, 5}, {1289, 5}, {1291, 6}, {1293, 6}, {1295, 6}, {1297, 6}, {1299, 6}, {1301, 6}, {1303, 6}, {1305, 6}, {1307, 7}, {1309, 7}, {1311, 7}, {1313, 7}, {1315, 7}, {1317, 7}, {1319, 7}, {1321, 6}, {1323, 6}, {1325, 6}, {1327, 6}, {1329, 6}, {1331, 6}, {1333, 6}, {1335, 10}, {1337, 10}, {1339, 10}, {1341, 10}, {1343, 10}, {1345, 10}, {1347, 10}, {13576, 10}, {1349, 2}, {1351, 2}, {1353, 2}, {1355, 2}, {21009, 5}, {1357, 2}, {1359, 2}, {1361, 2}, {1363, 2}, {1365, 2}, {1367, 2}, {1369, 2}, {1371, 2}, {1373, 2}, {1375, 2}, {1377, 2}, {1379, 1}, {1381, 1}, {1383, 1}, {1385, 1}, {1387, 1}, {1389, 1}, {1391, 1}, {1393, 1}, {1395, 1}, {1397, 1}, {1399, 1}, {1401, 1}, {1403, 1}, {1405, 1}, {1407, 1}, {1409, 1}, {1419, 22}, {1420, 8}, {1422, 8}, {1424, 8}, {1426, 8}, {1428, 8}, {1430, 8}, {1432, 8}, {1434, 8}, {2402, 6}, {2415, 1}, {2416, 1}, {2417, 1}, {2460, 12}, {2462, 12}, {2464, 12}, {2466, 12}, {2468, 12}, {2470, 12}, {2472, 12}, {2474, 12}, {2476, 12}, {2883, 16}, {2952, 5}, {2961, 6}, {2963, 6}, {3053, 1}, {3054, 1}, {3093, 18}, {3094, 18}, {3095, 9}, {3096, 9}, {3097, 9}, {3098, 9}, {3099, 9}, {3100, 9}, {3101, 9}, {3170, 14}, {3171, 14}, {3172, 14}, {3173, 14}, {3174, 14}, {3175, 14}, {3176, 14}, {3190, 15}, {3192, 15}, {3194, 15}, {3196, 15}, {3198, 15}, {3200, 15}, {3202, 15}, {3204, 15}, {3757, 6}, {3899, 6}, {4037, 14}, {4039, 14}, {4068, 6}, {4086, 12}, {4151, 11}, {4153, 10}, {4158, 14}, {4170, 1}, {4212, 16}, {4214, 16}, {4215, 16}, {4216, 16}, {4217, 16}, {4218, 16}, {4219, 16}, {4220, 16}, {4221, 16}, {4222, 16}, {4223, 16}, {4236, 16}, {4503, 6}, {4508, 6}, {4565, 12}, {4566, 12}, {4580, 14}, {4582, 14}, {4584, 14}, {4587, 6}, {4599, 10}, {4600, 10}, {4675, 1}, {4710, 1}, {4718, 2}, {4726, 14}, {4734, 17}, {4747, 10}, {4755, 8}, {4827, 16}, {4862, 1}, {4863, 1}, {4864, 1}, {4865, 1}, {4866, 1}, {4886, 2}, {4887, 2}, {4888, 2}, {4889, 2}, {4890, 2}, {4910, 14}, {4911, 14}, {4912, 14}, {4913, 14}, {4914, 14}, {4934, 17}, {4935, 17}, {4936, 17}, {4937, 17}, {4938, 17}, {4958, 10}, {4959, 10}, {4960, 10}, {4961, 10}, {4962, 10}, {4982, 8}, {4983, 8}, {4984, 8}, {4985, 8}, {4986, 8}, {5016, 14}, {5018, 10}, {5628, 18}, {5629, 18}, {5630, 18}, {5631, 18}, {5632, 18}, {5633, 18}, {5634, 18}, {5635, 18}, {5636, 18}, {5637, 18}, {5638, 18}, {5639, 18}, {5640, 18}, {5641, 18}, {5642, 18}, {5643, 18}, {5644, 18}, {5645, 18}, {5646, 18}, {5647, 18}, {5648, 18}, {5649, 18}, {5650, 18}, {5651, 18}, {5652, 18}, {5653, 18}, {5654, 18}, {5655, 18}, {5656, 18}, {5657, 18}, {5658, 18}, {5659, 18}, {5660, 18}, {5661, 18}, {5662, 18}, {5663, 18}, {5664, 18}, {5665, 18}, {5666, 18}, {5667, 18}, {5668, 5}, {5670, 5}, {5672, 5}, {5674, 5}, {5676, 5}, {5678, 5}, {5680, 5}, {5682, 5}, {5684, 5}, {5686, 5}, {5688, 5}, {5690, 5}, {5692, 5}, {5694, 5}, {5696, 5}, {5698, 5}, {5700, 5}, {5702, 5}, {5704, 14}, {5706, 14}, {5708, 14}, {5710, 14}, {5712, 14}, {5714, 14}, {5716, 14}, {5718, 14}, {5720, 14}, {5722, 14}, {5724, 14}, {5726, 14}, {5728, 14}, {5730, 14}, {5734, 14}, {5736, 14}, {6082, 20}, {6313, 6}, {6315, 6}, {6317, 6}, {6408, 10}, {6410, 10}, {6412, 10}, {6414, 10}, {6416, 10}, {6418, 10}, {6420, 10}, {6522, 18}, {6523, 5}, {6525, 6}, {6526, 1}, {6527, 10}, {6528, 10}, {6541, 12}, {6562, 1}, {6563, 1}, {6587, 9}, {6589, 2}, {6591, 5}, {6593, 5}, {6595, 5}, {6597, 5}, {6599, 15}, {6601, 8}, {6603, 1}, {6605, 5}, {6607, 6}, {6609, 7}, {6611, 6}, {6613, 10}, {6724, 16}, {6739, 2}, {6745, 6}, {6746, 6}, {6760, 3}, {6762, 3}, {6764, 3}, {6773, 10}, {6774, 10}, {6775, 10}, {6776, 10}, {6777, 10}, {6778, 10}, {6779, 10}, {6908, 1}, {6910, 1}, {6912, 1}, {6914, 1}, {7140, 6}, {7141, 6}, {7142, 5}, {7158, 7}, {7170, 13}, {7409, 5}, {7414, 1}, {7433, 6}, {7435, 5}, {7437, 5}, {7439, 7}, {7441, 10}, {7443, 6}, {7445, 10}, {7447, 5}, {7449, 10}, {7451, 6}, {7639, 1}, {7640, 1}, {7641, 1}, {7642, 1}, {7643, 1}, {7644, 1}, {7645, 1}, {7646, 1}, {7647, 1}, {7648, 1}, {7668, 10}, {7671, 9}, {7673, 9}, {7675, 5}, {7679, 14}, {7686, 1}, {7804, 3}, {7806, 5}, {7807, 2}, {7808, 8}, {7809, 14}, {8650, 14}, {8652, 14}, {8654, 14}, {8656, 14}, {8658, 14}, {8660, 14}, {8662, 14}, {8664, 14}, {8666, 14}, {8668, 14}, {8670, 14}, {8672, 14}, {8674, 14}, {8676, 14}, {8678, 14}, {8680, 14}, {8841, 1}, {8872, 5}, {8874, 5}, {8876, 5}, {8878, 5}, {8880, 17}, {8966, 14}, {8967, 14}, {8968, 14}, {8969, 14}, {8970, 14}, {8971, 14}, {9013, 3}, {9044, 3}, {9046, 3}, {9048, 3}, {9050, 3}, {9084, 1}, {9091, 1}, {9092, 1}, {9093, 1}, {9174, 17}, {9176, 17}, {9177, 17}, {9179, 17}, {9181, 17}, {9183, 17}, {9185, 17}, {9702, 5}, {9703, 5}, {9705, 16}, {10010, 10}, {10029, 6}, {10033, 19}, {10034, 19}, {10129, 5}, {10146, 21}, {10147, 21}, {10148, 21}, {10149, 21}, {10150, 14}, {10156, 17}, {10280, 16}, {10282, 16}, {10284, 16}, {10440, 1}, {10442, 1}, {10444, 1}, {10487, 12}, {10491, 2}, {10501, 18}, {10581, 5}, {10582, 5}, {10583, 5}, {10584, 5}, {10732, 12}, {10858, 7}, {10887, 8}, {11037, 6}, {11061, 8}, {11165, 17}, {11167, 17}, {11230, 18}, {11231, 18}, {11233, 18}, {11234, 18}, {11235, 16}, {11259, 14}, {11367, 14}, {11369, 14}, {11371, 14}, {11373, 14}, {11375, 14}, {11377, 14}, {11379, 14}, {11381, 14}, {11382, 14}, {11384, 14}, {11386, 14}, {11388, 14}, {11389, 14}, {11391, 14}, {11393, 14}, {11395, 14}, {11396, 14}, {11398, 14}, {11400, 14}, {11402, 14}, {11403, 14}, {11405, 14}, {11407, 14}, {11409, 14}, {11410, 14}, {11412, 14}, {11414, 14}, {11416, 14}, {11417, 14}, {11419, 14}, {11694, 7}, {11696, 7}, {11698, 7}, {11700, 7}, {11716, 14}, {11730, 7}, {11736, 1}, {11738, 1}, {11951, 18}, {12570, 10}, {13081, 17}, {13095, 10}, {13097, 10}, {13099, 10}, {13117, 23}, {13118, 23}, {13119, 23}, {13120, 23}, {13121, 23}, {13122, 23}, {13123, 23}, {13124, 23}, {13125, 23}, {13126, 23}, {13127, 23}, {13128, 23}, {13129, 23}, {13130, 23}, {13131, 23}, {13132, 23}, {13133, 23}, {13134, 23}, {13135, 23}, {13136, 23}, {13137, 23}, {13138, 23}, {13139, 23}, {13140, 23}, {13141, 23}, {13142, 23}, {13143, 23}, {13144, 23}, {13145, 23}, {13146, 23}, {13163, 10}, {13164, 10}, {13165, 10}, {20997, 16}};
        for (int[] items : data) {
            ItemDefinition def = ItemDefinition.forId(items[0]);
            def.getConfigurations().put(ItemConfiguration.WEAPON_INTERFACE, items[1]);
        }
        dump();
    }

    private static final int[][] ids = new int[][]{
            {4708, 4856, 4857, 4858, 4859, 4860}, {4716, 4880, 4881, 4882, 4883, 4884}, {4724, 4904, 4905, 4906, 4907, 4908}, {4732, 4928, 4929, 4930, 4931, 4932}, {4745, 4952, 4953, 4954, 4955, 4956}, {4753, 4976, 4977, 4978, 4979, 4980}, {4710, 4862, 4863, 4864, 4865, 4866}, {4718, 4886, 4887, 4888, 4889, 4890}, {4726, 4910, 4911, 4912, 4913, 4914}, {4734, 4934, 4935, 4936, 4937, 4938}, {4747, 4958, 4959, 4960, 4961, 4962}, {4755, 4982, 4983, 4984, 4985, 4986}, {4712, 4868, 4869, 4870, 4871, 4872}, {4720, 4892, 4893, 4894, 4895, 4896}, {4728, 4916, 4917, 4918, 4919, 4920}, {4736, 4940, 4941, 4942, 4943, 4944}, {4749, 4964, 4965, 4966, 4967, 4968}, {4757, 4988, 4989, 4990, 4991, 4992}, {4714, 4874, 4875, 4876, 4877, 4878}, {4722, 4898, 4899, 4900, 4901, 4902}, {4730, 4922, 4923, 4924, 4925, 4926}, {4738, 4946, 4947, 4948, 4949, 4950}, {4751, 4970, 4971, 4972, 4973, 4974}, {4759, 4994, 4995, 4996, 4997, 4998},};

    public static void fixBarrows() {
        for (int i = 0; i < ids.length; i++) {
            for (int k = 0; k < ids[i].length; k++) {
                boolean tradeable = k == 0 || k == ids[i].length - 1;
                ItemDefinition def = ItemDefinition.forId(ids[i][k]);
                if (!tradeable) {
                    System.out.println("no " + def.getName());
                    //def.getConfigurations().remove(ItemConfiguration.TRADEABLE);
                } else {
                    System.out.println(def.getName());
                    def.getConfigurations().put(ItemConfiguration.TRADEABLE, true);
                }
            }
        }
    }

    /**
     * Dumps the component definitions.
     */
    public static void dump() {
        System.out.println("Dumping " + Cache.getItemDefinitionsSize() + " item configurations...");
        ByteBuffer buffer = ByteBuffer.allocate(3145680 << 1);
        for (int id = 0; id < Cache.getItemDefinitionsSize(); id++) {
            ItemDefinition def = ItemDefinition.forId(id);
            Map<String, Object> conf = def.getConfigurations();
            if (conf.get(ItemConfiguration.TRADEABLE) == Boolean.TRUE) {
                buffer.put((byte) 1);
            }
            if (conf.get(ItemConfiguration.LENDABLE) == Boolean.TRUE) {
                buffer.put((byte) 2);
            }
            if (conf.get(ItemConfiguration.HIGH_ALCHEMY) != null) {
                buffer.put((byte) 3).putInt((int) conf.get(ItemConfiguration.HIGH_ALCHEMY));
            }
            if (conf.get(ItemConfiguration.LOW_ALCHEMY) != null) {
                buffer.put((byte) 4).putInt((int) conf.get(ItemConfiguration.LOW_ALCHEMY));
            }
            if (conf.get(ItemConfiguration.DESTROY) == Boolean.TRUE) {
                buffer.put((byte) 5);
            }
            if (conf.get(ItemConfiguration.SHOP_PRICE) != null) {
                buffer.put((byte) 6).putInt((int) conf.get(ItemConfiguration.SHOP_PRICE));
            }
            if (conf.get(ItemConfiguration.GE_PRICE) != null) {
                buffer.put((byte) 7).putInt((int) conf.get(ItemConfiguration.GE_PRICE));
            }
            if (conf.get(ItemConfiguration.EXAMINE) != null) {
                buffer.put((byte) 8);
                ByteBufferUtils.putString((String) conf.get(ItemConfiguration.EXAMINE), buffer);
            }
            if (conf.get(ItemConfiguration.WEIGHT) != null) {
                buffer.put((byte) 9).putShort((short) (((Double) conf.get(ItemConfiguration.WEIGHT)) * 1000));
            }
            if (conf.get(ItemConfiguration.BONUS) != null && !Arrays.equals(new int[15], (int[]) conf.get(ItemConfiguration.BONUS))) {
                buffer.put((byte) 10);
                int[] bonuses = (int[]) conf.get(ItemConfiguration.BONUS);
                for (int i = 0; i < bonuses.length; i++) {
                    buffer.putShort((short) bonuses[i]);
                }
            }
            if (conf.get(ItemConfiguration.ABSORB) != null) {
                buffer.put((byte) 11);
                int[] bonuses = (int[]) conf.get(ItemConfiguration.ABSORB);
                for (int i = 0; i < bonuses.length; i++) {
                    buffer.putShort((short) bonuses[i]);
                }
            }
            if (conf.get(ItemConfiguration.TWO_HANDED) == Boolean.TRUE) {
                buffer.put((byte) 12);
            }
            if (conf.get(ItemConfiguration.EQUIP_SLOT) != null) {
                buffer.put((byte) 13).put((byte) (int) ((Integer) conf.get(ItemConfiguration.EQUIP_SLOT)));
            }
            if (conf.get(ItemConfiguration.ATTACK_SPEED) != null) {
                buffer.put((byte) 14).put((byte) (int) ((Integer) conf.get(ItemConfiguration.ATTACK_SPEED)));
            }
            if (conf.get(ItemConfiguration.REMOVE_HEAD) == Boolean.TRUE) {
                buffer.put((byte) 15);
            }
            if (conf.get(ItemConfiguration.REMOVE_BEARD) == Boolean.TRUE) {
                buffer.put((byte) 16);
            }
            if (conf.get(ItemConfiguration.REMOVE_SLEEVES) == Boolean.TRUE) {
                buffer.put((byte) 17);
            }
            if (conf.get(ItemConfiguration.STAND_ANIM) != null) {
                buffer.put((byte) 18);
                buffer.putShort((short) (int) (Integer) conf.get(ItemConfiguration.STAND_ANIM));
                if (conf.get(ItemConfiguration.STAND_TURN_ANIM) != null) {
                    buffer.putShort((short) (int) (Integer) conf.get(ItemConfiguration.STAND_TURN_ANIM));
                } else {
                    buffer.putShort((short) (int) (Integer) 803);
                }
                if (conf.get(ItemConfiguration.WALK_ANIM) != null) {
                    buffer.putShort((short) (int) (Integer) conf.get(ItemConfiguration.WALK_ANIM));
                } else {
                    buffer.putShort((short) (int) (Integer) 0);
                }
                /*
                buffer.putShort((short) (int) (Integer) conf.get(ItemConfiguration.WALK_ANIM));
                buffer.putShort((short) (int) (Integer) conf.get(ItemConfiguration.RUN_ANIM));
                buffer.putShort((short) (int) (Integer) conf.get(ItemConfiguration.TURN180_ANIM));
                buffer.putShort((short) (int) (Integer) conf.get(ItemConfiguration.TURN90CW_ANIM));
                buffer.putShort((short) (int) (Integer) conf.get(ItemConfiguration.TURN90CCW_ANIM));*/
            }
            if (conf.get(ItemConfiguration.WEAPON_INTERFACE) != null) {
                buffer.put((byte) 19).put((byte) (int) ((Integer) conf.get(ItemConfiguration.WEAPON_INTERFACE)));
            }
            if (conf.get(ItemConfiguration.HAS_SPECIAL) == Boolean.TRUE) {
                buffer.put((byte) 20);
            }
            if (conf.get(ItemConfiguration.ATTACK_ANIMS) != null) {
                Animation[] anims = (Animation[]) conf.get(ItemConfiguration.ATTACK_ANIMS);
                buffer.put((byte) 21).put((byte) anims.length);
                for (Animation a : anims) {
                    buffer.putShort((short) a.getId());
                }
            }
            if (conf.get(ItemConfiguration.DESTROY_MESSAGE) != null) {
                buffer.put((byte) 22);
                String message = (String) conf.get(ItemConfiguration.DESTROY_MESSAGE);
                ByteBufferUtils.putString(message, buffer);
            }
            if (conf.get(ItemConfiguration.REQUIREMENTS) != null) {
                buffer.put((byte) 23);
                @SuppressWarnings("unchecked")
                Map<Integer, Integer> req = (Map<Integer, Integer>) conf.get(ItemConfiguration.REQUIREMENTS);
                buffer.put((byte) req.size());
                for (int skill : req.keySet()) {
                    buffer.put((byte) skill);
                    buffer.put((byte) (int) req.get(skill));
                }
            }
            if (conf.get(ItemConfiguration.GE_LIMIT) != null) {
                buffer.put((byte) 24);
                buffer.putShort((short) (int) conf.get(ItemConfiguration.GE_LIMIT));
            }
            if (conf.get(ItemConfiguration.DEFENCE_ANIMATION) != null) {
                buffer.put((byte) 25);
                buffer.putShort((short) ((Animation) conf.get(ItemConfiguration.DEFENCE_ANIMATION)).getId());
            }
            buffer.put((byte) 0);
        }
        buffer.flip();
        ServerStore.setArchive("item_config", buffer, false);
        ServerStore.createStaticStore(ServerConstants.STORE_PATH);
    }
}