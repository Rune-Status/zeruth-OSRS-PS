package org.arcanium.tools.impl;

import org.arcanium.ServerConstants;
import org.arcanium.cache.Cache;
import org.arcanium.cache.ServerStore;
import org.arcanium.cache.misc.buffer.ByteBufferUtils;
import org.arcanium.game.component.ComponentDefinition;
import org.arcanium.game.node.entity.player.link.InterfaceManager;
import org.arcanium.game.world.GameWorld;
import org.arcanium.net.packet.context.AccessMaskContext;
import org.arcanium.net.packet.context.ConfigContext;
import org.arcanium.net.packet.context.InterfaceContext;
import org.arcanium.net.packet.context.RunScriptContext;

import java.nio.ByteBuffer;

/**
 * Handles the component definitions editing.
 *
 * @author Emperor
 */
public final class ComponentDefinitionsEditor {

    static boolean isDumping = false;

    static final int MAIN_SLOT = InterfaceManager.MAIN_SLOT;
    static final int OVERLAY_SLOT = InterfaceManager.OVERLAY_SLOT;
    static final int CHATBOX_SLOT = InterfaceManager.CHATBOX_INTERFACE_SLOT;
    static final int SINGLE_TAB_SLOT = InterfaceManager.COMPLETE_SIDEBAR_SLOT;
    static final int CHATBOX_DEFAULT_SLOT = InterfaceManager.CHATBOX_DEFAULT_SLOT;

    static final int MAIN_SLOT_FULL = InterfaceManager.MAIN_SLOT_FULL;
    static final int OVERLAY_SLOT_FULL = InterfaceManager.OVERLAY_SLOT_FULL;
    static final int CHATBOX_SLOT_FULL = InterfaceManager.CHATBOX_INTERFACE_SLOT_FULL;
    static final int SINGLE_TAB_SLOT_FULL = InterfaceManager.COMPLETE_SIDEBAR_SLOT_FULL;
    static final int CHATBOX_DEFAULT_SLOT_FULL = InterfaceManager.CHATBOX_DEFAULT_SLOT_FULL;

    static final int ATTACK_SLOT = InterfaceManager.ATTACK_SLOT;
    static final int SKILLS_SLOT = InterfaceManager.SKILLS_SLOT;
    static final int QUEST_SLOT = InterfaceManager.QUEST_SLOT;
    static final int INV_SLOT = InterfaceManager.INV_SLOT;
    static final int EQUIPMENT_SLOT = InterfaceManager.EQUIPMENT_SLOT;
    static final int PRAYER_SLOT = InterfaceManager.PRAYER_SLOT;
    static final int MAGIC_SLOT = InterfaceManager.MAGIC_SLOT;
    static final int CLAN_SLOT = InterfaceManager.CLAN_SLOT;
    static final int FRIENDS_SLOT = InterfaceManager.FRIENDS_SLOT;
    static final int IGNORES_SLOT = InterfaceManager.IGNORES_SLOT;
    static final int LOGOUT_SLOT = InterfaceManager.LOGOUT_SLOT;
    static final int OPTIONS_SLOT = InterfaceManager.OPTIONS_SLOT;
    static final int EMOTE_SLOT = InterfaceManager.EMOTE_SLOT;
    static final int MUSIC_SLOT = InterfaceManager.MUSIC_SLOT;

    static final int ATTACK_SLOT_FULL = InterfaceManager.ATTACK_SLOT_FULL;
    static final int SKILLS_SLOT_FULL = InterfaceManager.SKILLS_SLOT_FULL;
    static final int QUEST_SLOT_FULL = InterfaceManager.QUEST_SLOT_FULL;
    static final int INV_SLOT_FULL = InterfaceManager.INV_SLOT_FULL;
    static final int EQUIPMENT_SLOT_FULL = InterfaceManager.EQUIPMENT_SLOT_FULL;
    static final int PRAYER_SLOT_FULL = InterfaceManager.PRAYER_SLOT_FULL;
    static final int MAGIC_SLOT_FULL = InterfaceManager.MAGIC_SLOT_FULL;
    static final int CLAN_SLOT_FULL = InterfaceManager.CLAN_SLOT_FULL;
    static final int FRIENDS_SLOT_FULL = InterfaceManager.FRIENDS_SLOT_FULL;
    static final int IGNORES_SLOT_FULL = InterfaceManager.IGNORES_SLOT_FULL;
    static final int LOGOUT_SLOT_FULL = InterfaceManager.LOGOUT_SLOT_FULL;
    static final int OPTIONS_SLOT_FULL = InterfaceManager.OPTIONS_SLOT_FULL;
    static final int EMOTE_SLOT_FULL = InterfaceManager.EMOTE_SLOT_FULL;
    static final int MUSIC_SLOT_FULL = InterfaceManager.MUSIC_SLOT_FULL;

    /**
     * The main method.
     *
     * @param args The arguments.
     * @throws Throwable When an exception occurs.
     */
    public static final void main(String... args) throws Throwable {
        GameWorld.prompt(false);
        System.out.println("Loaded components.");
        System.out.println(ComponentDefinition.getDefinitions().size() + " SIZE");
        ComponentDefinition def = ComponentDefinition.forId(ComponentDefinition.getDefinitions().size());

        def = ComponentDefinition.forId(7);
        def.setContext(new InterfaceContext(null, 548, CLAN_SLOT, 7, true));

        def = ComponentDefinition.forId(12);
        def.setContext(new InterfaceContext(null, 548, OVERLAY_SLOT, 12, false));
        //def.setAccessMask(new AccessMaskContext(null, 1026, 89, 12, 0, 536));

        def = ComponentDefinition.forId(13);
        def.setContext(new InterfaceContext(null, 548, OVERLAY_SLOT, 13, false));

        def = ComponentDefinition.forId(15);
        def.setContext(new InterfaceContext(null, 548, SINGLE_TAB_SLOT, 15, false));
        //def.setAccessMask(new AccessMaskContext(null, 1026, 89, 12, 0, 536));

        def = ComponentDefinition.forId(64);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 64, true));

        def = ComponentDefinition.forId(65);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 65, true));

        def = ComponentDefinition.forId(66);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 66, true));

        def = ComponentDefinition.forId(67);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 67, true));

        //Player chat dialogues without a continue button:
        def = ComponentDefinition.forId(68);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 68, true));
        def = ComponentDefinition.forId(69);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 69, true));
        def = ComponentDefinition.forId(70);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 70, true));
        def = ComponentDefinition.forId(71);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 71, true));

        def = ComponentDefinition.forId(74);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 74, true));

        def = ComponentDefinition.forId(593);
        def.setContext(new InterfaceContext(null, 548, ATTACK_SLOT, 593, true));

        def = ComponentDefinition.forId(94);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 94, true));

        def = ComponentDefinition.forId(102);
        def.setContext(new InterfaceContext(null, 548, OVERLAY_SLOT, 102, false));

        def = ComponentDefinition.forId(131);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 131, true));

        def = ComponentDefinition.forId(137);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_DEFAULT_SLOT, 137, true));

        def = ComponentDefinition.forId(140);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 140, true));

        def = ComponentDefinition.forId(148);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 148, true));

        def = ComponentDefinition.forId(149);
        def.setContext(new InterfaceContext(null, 548, INV_SLOT, 149, true));

        def = ComponentDefinition.forId(157);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 157, true));

        def = ComponentDefinition.forId(158);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 158, true));

        def = ComponentDefinition.forId(159);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 159, true));

        def = ComponentDefinition.forId(162);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_DEFAULT_SLOT, 162, true));

        def = ComponentDefinition.forId(163);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 163, true));

        def = ComponentDefinition.forId(164);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 164, true));

        def = ComponentDefinition.forId(166);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 166, true));

        def = ComponentDefinition.forId(167);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 167, true));

        def = ComponentDefinition.forId(168);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 168, true));

        def = ComponentDefinition.forId(169);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 169, true));

        def = ComponentDefinition.forId(170);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 170, true));

        def = ComponentDefinition.forId(171);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 171, true));

        def = ComponentDefinition.forId(172);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 172, true));

        def = ComponentDefinition.forId(173);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 173, true));

        def = ComponentDefinition.forId(174);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 174, true));

        def = ComponentDefinition.forId(175);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 175, true));

        def = ComponentDefinition.forId(176);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 176, true));

        def = ComponentDefinition.forId(177);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 177, true));

        def = ComponentDefinition.forId(182);
        def.setContext(new InterfaceContext(null, 548, LOGOUT_SLOT, 182, true));

        def = ComponentDefinition.forId(188);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 188, true));

        def = ComponentDefinition.forId(239);
        def.setContext(new InterfaceContext(null, 548, MUSIC_SLOT, 239, true));

        //Quiz Master Interface
        def = ComponentDefinition.forId(191);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 191, true));

        def = ComponentDefinition.forId(218);
        def.setContext(new InterfaceContext(null, 548, MAGIC_SLOT, 218, true));

        //Maze Random Overlay
        def = ComponentDefinition.forId(209);
        def.setContext(new InterfaceContext(null, 548, OVERLAY_SLOT, 209, true));

        def = ComponentDefinition.forId(210);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 210, true));

        def = ComponentDefinition.forId(211);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 211, true));

        def = ComponentDefinition.forId(212);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 212, true));

        def = ComponentDefinition.forId(213);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 213, true));

        //TODO: RUN ME AFTER PULLING BECAUSE OF THIS ONE NOT SAVED YET:
        def = ComponentDefinition.forId(214);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 214, true));

        def = ComponentDefinition.forId(228);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 228, true));

        def = ComponentDefinition.forId(230);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 230, true));

        def = ComponentDefinition.forId(232);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 232, true));

        def = ComponentDefinition.forId(234);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 234, true));

        def = ComponentDefinition.forId(241);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 241, true));

        def = ComponentDefinition.forId(242);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 242, true));

        //favour main interface
        def = ComponentDefinition.forId(243);
        def.setContext(new InterfaceContext(null, 548, MAIN_SLOT, 243, true));

        def = ComponentDefinition.forId(244);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 244, true));

        def = ComponentDefinition.forId(246);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 246, true));
        def = ComponentDefinition.forId(247);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 247, true));
        def = ComponentDefinition.forId(248);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 248, true));

        def = ComponentDefinition.forId(261);
        def.setContext(new InterfaceContext(null, 548, OPTIONS_SLOT, 261, true));

        //Character Design
        def = ComponentDefinition.forId(269);
        def.setContext(new InterfaceContext(null, 548, OVERLAY_SLOT, 269, false));

        def = ComponentDefinition.forId(541);
        def.setContext(new InterfaceContext(null, 548, PRAYER_SLOT, 541, true));

        //minigames
        def = ComponentDefinition.forId(76);
        def.setContext(new InterfaceContext(null, 548, QUEST_SLOT, 76, true));

        //achievement
        def = ComponentDefinition.forId(259);
        def.setContext(new InterfaceContext(null, 548, QUEST_SLOT, 259, true));
        def.setAccessMask(new AccessMaskContext(null, 2, 4, 259, 0, 10));

        //favour 245
        def = ComponentDefinition.forId(245);
        def.setContext(new InterfaceContext(null, 548, QUEST_SLOT, 245, true));

        //Quest Diary Sidebar Interface
        def = ComponentDefinition.forId(399);
        def.setContext(new InterfaceContext(null, 548, QUEST_SLOT, 399, true));
        def.setAccessMask(new AccessMaskContext(null, 2, 8, 399, 0, 110));

        //Shopping main interface
        def = ComponentDefinition.forId(300);
        def.setContext(new InterfaceContext(null, 548, OVERLAY_SLOT, 300, false));
        //def.setAccessMask(new AccessMaskContext(null, 1026, 89, 12, 0, 536)); was 498 access mask for shopping...

        //Shopping inventory interface
        def = ComponentDefinition.forId(301);
        def.setContext(new InterfaceContext(null, 548, SINGLE_TAB_SLOT, 301, false));
        //def.setAccessMask(new AccessMaskContext(null, 1026, 89, 12, 0, 536)); was 498 access mask for shopping...

        def = ComponentDefinition.forId(303);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 303, true));

        def = ComponentDefinition.forId(304);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 304, true));

        def = ComponentDefinition.forId(305);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 305, true));

        def = ComponentDefinition.forId(306);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 306, true));

        def = ComponentDefinition.forId(307);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 307, true));

        def = ComponentDefinition.forId(309);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 309, true));

        def = ComponentDefinition.forId(311);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 311, true));

        def = ComponentDefinition.forId(319);
        def.setContext(new InterfaceContext(null, 548, SINGLE_TAB_SLOT, 319, false));

        def = ComponentDefinition.forId(320);
        def.setContext(new InterfaceContext(null, 548, SKILLS_SLOT, 320, true));

        def = ComponentDefinition.forId(324);
        def.setContext(new InterfaceContext(null, 548, OVERLAY_SLOT, 324, false));

        def = ComponentDefinition.forId(336);
        def.setContext(new InterfaceContext(null, 548, INV_SLOT, 336, true));
        def.setAccessMask(new AccessMaskContext(null, 1026, 89, 12, 0, 536));
        def.setCs2ScriptContext(new RunScriptContext(null, 150, "IviiiIsssssssss", "", "", "", "", "", "", "", "", "Wear", -1, 0, 7, 4, 98, 22020096));

        def = ComponentDefinition.forId(371);
        def.setContext(new InterfaceContext(null, 548, MAIN_SLOT, 371, true));

        def = ComponentDefinition.forId(372);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 372, true));

        def = ComponentDefinition.forId(373);
        def.setContext(new InterfaceContext(null, 548, MAIN_SLOT, 373, true));

        def = ComponentDefinition.forId(380);
        def.setContext(new InterfaceContext(null, 548, MAIN_SLOT, 380, true));
        def.setCs2ScriptContext(new RunScriptContext(null, 570, "s", new Object[]{"Grand Exchange Item Search"}));

        def = ComponentDefinition.forId(387);
        def.setContext(new InterfaceContext(null, 548, EQUIPMENT_SLOT, 387, true));

        def = ComponentDefinition.forId(389);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 389, false));

        def = ComponentDefinition.forId(395);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 395, true));

        def = ComponentDefinition.forId(421);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 421, true));

        def = ComponentDefinition.forId(216);
        def.setContext(new InterfaceContext(null, 548, EMOTE_SLOT, 216, true));

        //Equipment Stats Screen
        def = ComponentDefinition.forId(465);
        def.setContext(new InterfaceContext(null, 548, OVERLAY_SLOT, 465, false));
        //def.setAccessMask(new AccessMaskContext(null, 1026, 89, 12, 0, 536)); //NOT IN 462/464 AFAIK?

        //Equipment Inventory Screen
        def = ComponentDefinition.forId(513);
        def.setContext(new InterfaceContext(null, 548, INV_SLOT, 513, false));

        //Used for special chatbox interfaces.
        def = ComponentDefinition.forId(519);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 519, true));

        def = ComponentDefinition.forId(532);
        def.setContext(new InterfaceContext(null, 548, MAIN_SLOT, 532, true));

        def = ComponentDefinition.forId(429);
        def.setContext(new InterfaceContext(null, 548, FRIENDS_SLOT, 429, true));

        def = ComponentDefinition.forId(432);
        def.setContext(new InterfaceContext(null, 548, IGNORES_SLOT, 432, true));

        def = ComponentDefinition.forId(553);
        def.setContext(new InterfaceContext(null, 548, OVERLAY_SLOT, 553, false));

        def = ComponentDefinition.forId(582);
        def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 582, true));

        //583 is MAX ID!

		/*def = ComponentDefinition.forId(589);
		def.setContext(new InterfaceContext(null, 548, 138, 589, true));
		def = ComponentDefinition.forId(630);
		def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 630, true));
		def = ComponentDefinition.forId(662);
		def.setContext(new InterfaceContext(null, 548, 135, 662, true));
		def = ComponentDefinition.forId(668);
		def.setContext(new InterfaceContext(null, 548, CHATBOX_SLOT, 668, true));*/

        dump();
    }

    /**
     * Dumps the component definitions.
     */
    private static void dump() {
        System.out.println("Dumping " + Cache.getInterfaceDefinitionsSize() + " components...");
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        for (int id = 0; id < Cache.getInterfaceDefinitionsSize(); id++) {
            ComponentDefinition def = ComponentDefinition.forId(id);
            if (def == null || id == 165 || id == 161) {
                buffer.put((byte) 0);
                continue;
            }
            if (def.getContext() != null) {
                if (isDumping == true) {
                    //System.out.println("def = ComponentDefinition.forId(" + id + ");");
                    // System.out.println("def.setContext(new InterfaceContext(null, " + def.getContext().getWindowId() + ", " + def.getContext().getComponentId() + ", " + id + ", " + def.getContext().isWalkable() + "));");
                } else {
                    System.out.println("Dumped component [id=" + id + "]");
                }
                buffer.put((byte) 1)
                        .putShort((short) def.getContext().getWindowId())
                        .putShort((short) def.getContext().getFixedComponentId())
                        .putShort((short) def.getContext().getInterfaceId())
                        .put((byte) (def.getContext().isWalkable() ? 1 : 0));

            } else {
                System.out.println("Dumped component [id=" + id + "].");
            }
            if (def.getAccessMask() != null) {
                buffer.put((byte) 2)
                        .putShort((short) def.getAccessMask().getId())
                        .putInt(def.getAccessMask().getChildId() << 16 | def.getAccessMask().getInterfaceId())
                        .putShort((short) def.getAccessMask().getOffset())
                        .putShort((short) def.getAccessMask().getLength());
            }
            if (def.getConfigContext().length > 0) {
                buffer.put((byte) 3)
                        .put((byte) def.getConfigContext().length);
                for (ConfigContext context : def.getConfigContext()) {
                    buffer.putShort((short) context.getId())
                            .putInt(context.getValue())
                            .put((byte) (context.isCs2() ? 1 : 0));
                }
            }
            if (def.getCs2ScriptContext() != null) {
                buffer.put((byte) 4)
                        .putShort((short) def.getCs2ScriptContext().getId());
                ByteBufferUtils.putString(def.getCs2ScriptContext().getString(), buffer);
                for (Object o : def.getCs2ScriptContext().getObjects()) {
                    if (o instanceof String) {
                        ByteBufferUtils.putString((String) o, buffer);
                    } else {
                        buffer.putInt((Integer) o);
                    }
                }
            }
            buffer.put((byte) 0);
        }
        buffer.flip();
        ServerStore.setArchive("component_config", buffer, false);
        ServerStore.createStaticStore(ServerConstants.STORE_PATH);
    }
}