package org.arcanium.game.node.entity.player.link;

import org.arcanium.game.component.Component;
import org.arcanium.game.node.entity.combat.equipment.WeaponInterface;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.net.packet.PacketRepository;
import org.arcanium.net.packet.context.InterfaceContext;
import org.arcanium.net.packet.context.WindowsPaneContext;
import org.arcanium.net.packet.server.CloseInterface;
import org.arcanium.net.packet.server.Interface;
import org.arcanium.net.packet.server.WindowsPane;

/**
 * Manages a player's interfaces.
 *
 * @author Emperor
 */
public final class InterfaceManager {

    /**
     * The tab ids for removing tabs...
     */
    public static final int ATTACK = 0;
    public static final int SKILLS = 1;
    public static final int QUESTS = 2;
    public static final int INVENTORY = 3;
    public static final int EQUIPMENT = 4;
    public static final int PRAYER = 5;
    public static final int MAGIC = 6;
    public static final int EMPTY = 7;
    public static final int FRIENDS = 8;
    public static final int IGNORE = 9;
    public static final int LOGOUT = 10;
    public static final int SETTINGS = 11;
    public static final int EMOTES = 12;
    public static final int MUSIC = 13;

    /**
     * SLOTS MADE BY RYAN THAT ARE CORRECT #462 ONES.
     */
    public static final int MAIN_SLOT = 20; //77 in 498
    public static final int MAIN_SLOT_FULL = 13; //77 in 498
    public static final int CHATBOX_DEFAULT_SLOT = 23; //121 in 498
    public static final int CHATBOX_INTERFACE_SLOT = 23; //120 in 498
    public static final int CHATBOX_DEFAULT_SLOT_FULL = 29; //121 in 498
    public static final int CHATBOX_INTERFACE_SLOT_FULL = 29; //120 in 498
    public static final int COMPLETE_SIDEBAR_SLOT = 63; //Was 126.
    public static final int COMPLETE_SIDEBAR_SLOT_FULL = 66; //Was 126.
    public static final int OVERLAY_SLOT = 21; //75 in 498 TODO FIND IF MAIN AND OVERLAY NEED SWAPPED?
    public static final int OVERLAY_SLOT_FULL = 14;

    /**
     * Sidebar interfaces made by Ryan.
     */
    public static final int ATTACK_SLOT = 65; //128 in 498
    public static final int SKILLS_SLOT = 66;
    public static final int QUEST_SLOT = 67;
    public static final int INV_SLOT = 68;
    public static final int EQUIPMENT_SLOT = 69;
    public static final int PRAYER_SLOT = 70;
    public static final int MAGIC_SLOT = 71;
    public static final int CLAN_SLOT = 72;
    public static final int FRIENDS_SLOT = 73;
    public static final int IGNORES_SLOT = 74;
    public static final int LOGOUT_SLOT = 75;
    public static final int OPTIONS_SLOT = 76;
    public static final int EMOTE_SLOT = 77;
    public static final int MUSIC_SLOT = 78;

    public static final int ATTACK_SLOT_FULL = 68; //128 in 498
    public static final int SKILLS_SLOT_FULL = 69;
    public static final int QUEST_SLOT_FULL = 70;
    public static final int INV_SLOT_FULL = 71;
    public static final int EQUIPMENT_SLOT_FULL = 72;
    public static final int PRAYER_SLOT_FULL = 73;
    public static final int MAGIC_SLOT_FULL = 74;
    public static final int CLAN_SLOT_FULL = 75;
    public static final int FRIENDS_SLOT_FULL = 76;
    public static final int IGNORES_SLOT_FULL = 77;
    public static final int LOGOUT_SLOT_FULL = 78;
    public static final int OPTIONS_SLOT_FULL = 79;
    public static final int EMOTE_SLOT_FULL = 80;
    public static final int MUSIC_SLOT_FULL = 81;

    /**
     * The default chat box interface.
     */
    public static final int DEFAULT_CHATBOX = 162;

    /**
     * The player.
     */
    private final Player player;

    /**
     * The windows pane.
     */
    private Component windowsPane;

    private Component orbPane = new Component(160);

    /**
     * The currently opened component.
     */
    private Component opened;

    public Component getChatbox() {
        return chatbox;
    }

    public Component getOpened() {
        return opened;
    }

    public Component getOrbPane() {
        return orbPane;
    }

    public Component getOverlay() {
        return overlay;
    }

    public Component[] getTabs() {
        return tabs;
    }

    public void setChatbox(Component chatbox) {
        this.chatbox = chatbox;
    }

    public void setOpened(Component opened) {
        this.opened = opened;
    }

    public void setOrbPane(Component orbPane) {
        this.orbPane = orbPane;
    }

    public void setOverlay(Component overlay) {
        this.overlay = overlay;
    }

    public void setCurrentTabIndex(int currentTabIndex) {
        this.currentTabIndex = currentTabIndex;
    }

    public void setSingleTab(Component singleTab) {
        this.singleTab = singleTab;
    }

    public void setTabs(Component[] tabs) {
        this.tabs = tabs;
    }

    public void setWindowsPane(Component windowsPane) {
        this.windowsPane = windowsPane;
    }

    /**
     * The tabs.
     */
    private Component[] tabs = new Component[15];

    /**
     * The chatbox component.
     */
    private Component chatbox;

    /**
     * The single tab.
     */
    private Component singleTab;

    /**
     * The overlay component.
     */
    private Component overlay;

    /**
     * The currently opened tab's index (TODO: Can probably do without this TBH).
     */
    private int currentTabIndex = 3;

    /**
     * Constructs a new {@code InterfaceManager} {@code Object}.
     *
     * @param player The player.
     */
    public InterfaceManager(Player player) {
        this.player = player;
    }

    /**
     * Opens the windows pane.
     *
     * @param windowsPane The windows pane.
     * @return The component instance.
     */
    public Component openWindowsPane(Component windowsPane) {
        this.windowsPane = windowsPane;
        PacketRepository.send(WindowsPane.class, new WindowsPaneContext(player, windowsPane.getId()));
        windowsPane.open(player);
        return windowsPane;
    }

    /**
     * Opens a component.
     *
     * @param componentId The component id.
     * @return The opened component.
     */
    public Component openComponent(int componentId) {
        return open(new Component(componentId));
    }

    /**
     * Opens a component.
     *
     * @param component The component to open.
     * @return The opened component.
     */
    public Component open(Component component) {
        int MAIN_SLOT = InterfaceManager.MAIN_SLOT;
        if (!close()) {
            return null;
        }
        if (component.getDefinition() == null) {
            PacketRepository.send(Interface.class, new InterfaceContext(player, getWindowsPane(), MAIN_SLOT, component.getId(), false));
            return opened = component;
        }
        component.getDefinition().setContext(new InterfaceContext(null, getWindowsPane(), MAIN_SLOT, component.getId(), false));
        component.open(player);
        return opened = component;
    }

    /**
     * Checks if a main interface.
     *
     * @return {@code True} if so.
     */
    public boolean isOpened() {
        return opened != null;
    }

    /**
     * Checks if the player has a chat box interface opened (disregarding default chat box).
     *
     * @return {@code True} if so.
     */
    public boolean hasChatbox() {
        return chatbox != null && chatbox.getId() != DEFAULT_CHATBOX;
    }

    /**
     * Safely closes the currently opened interface.
     */
    public boolean close() {
        if (player.getAttribute("runscript", null) != null) {
            player.removeAttribute("runscript");
            player.getPacketDispatch().sendRunScript(101, "");
        }
        if (opened != null && opened.close(player)) {
            if (opened != null && opened.getDefinition() != null && opened.getDefinition().getContext() != null) {
                if (!opened.getDefinition().getContext().isWalkable() || opened.getId() == 14) {
                    InterfaceContext context = opened.getDefinition().getContext();
                    context.setPlayer(player);
                    context.setWindowId(getWindowsPane());
                    PacketRepository.send(CloseInterface.class, context);
                }
            }
            opened = null;
        } else {
            PacketRepository.send(CloseInterface.class, new InterfaceContext(player, player.getInterfaceManager().getWindowsPane(), 21, 4, true));
        }
        return opened == null;
    }

    /**
     * Checks if the current interface is walkable.
     *
     * @return <code>True</code> if so.
     */
    public boolean isWalkable() {
        if (opened != null) {
            if (opened.getId() == 389) {
                return false;
            }
            if (opened.getDefinition().getContext() != null) {
                if (opened.getDefinition().getContext().isWalkable()) {
                    return true;
                }
            }
        }
        return true;
    }

    /**
     * Safely closes the component.
     *
     * @param component The component.
     */
    public void close(Component component) {
        if (component.close(player)) {
            InterfaceContext context = component.getDefinition().getContext();
            context.setPlayer(player);
            context.setWindowId(getWindowsPane());
            PacketRepository.send(CloseInterface.class, context);
        }
    }

    /**
     * Closes the chatbox interface.
     */
    public void closeChatbox() {
        PacketRepository.send(CloseInterface.class, new InterfaceContext(player, 162, 561, 162, false));
    }

    /**
     * Opens a tab and removes the other tabs.
     *
     * @param component The component to open.
     * @return The component.
     */
    public Component openSingleTab(Component component) {
        if (component.getDefinition().getContext() == null || (component.getDefinition().getContext().getComponentId() != COMPLETE_SIDEBAR_SLOT && component.getDefinition().getContext().getComponentId() != COMPLETE_SIDEBAR_SLOT_FULL)) {
            component.getDefinition().setContext(new InterfaceContext(null, getWindowsPane(), COMPLETE_SIDEBAR_SLOT, component.getId(), false));
        }
        component.open(player);
        return singleTab = component;
    }

    public Component openSingleTab(int id) {
        Component component = new Component(id);
        if (component.getDefinition().getContext() == null || (component.getDefinition().getContext().getComponentId() != COMPLETE_SIDEBAR_SLOT && component.getDefinition().getContext().getComponentId() != COMPLETE_SIDEBAR_SLOT_FULL)) {
            component.getDefinition().setContext(new InterfaceContext(null, getWindowsPane(), COMPLETE_SIDEBAR_SLOT, component.getId(), false));
        }
        component.open(player);
        return singleTab = component;
    }

    /**
     * Closes the current single tab opened.
     */
    public boolean closeSingleTab() {
        if (singleTab != null) {
            close(singleTab);
            singleTab = null;
        }
        return true;
    }

    /**
     * Gets the currently opened single tab.
     *
     * @return The tab opened.
     */
    public Component getSingleTab() {
        return singleTab;
    }

    /**
     * Removes the tabs.
     *
     * @param tabs The tab indexes.
     */
    public void removeTabs(int... tabs) {
        boolean changeViewedTab = false;
        for (int slot : tabs) {
            if (slot == currentTabIndex) {
                changeViewedTab = true;
            }
            Component tab = this.tabs[slot];
            if (tab != null) {
                close(tab);
                this.tabs[slot] = null;
            }
        }
        if (changeViewedTab) {
            int currentIndex = -1;
            if (this.tabs[3] == null) {
                for (int i = 0; i < this.tabs.length; i++) {
                    if (this.tabs[i] != null) {
                        currentIndex = i;
                        break;
                    }
                }
            } else {
                currentIndex = 3;
            }
            if (currentIndex > -1) {
                setViewedTab(currentIndex);
            }
        }
    }

    /**
     * Restores the tabs.
     */
    public void restoreTabs() {
/*		for (int i = 0; i < tabs.length; i++) {
            if (tabs[i] == null) {
				switch (i) {
				case 0:
					WeaponInterface inter = player.getExtension(WeaponInterface.class);
					if (inter == null) {
						player.addExtension(WeaponInterface.class, inter = new WeaponInterface(player));
					}
					openTab(0, inter);
					break;
				case 6:
					openTab(6, new Component(player.getSpellBookManager().getSpellBook())); // Magic
					break;
				case 7:
					if (player.getFamiliarManager().hasFamiliar()) {
					//	openTab(7, new Component(662));
					}
					break;
				default:
					if(i == 14)
						return; //THIS IS CHEAPHAX AF TODO REMOVE THIS AFTER YOU FIX TABS RYAN.
					openTab(i, new Component(DEFAULT_TABS[i]));
				}
			}
		}*/
        openDefaultTabs(); //TODO RYAN FIX ABOVE LOL THIS IS CHEAPHAX.
    }

    /**
     * Opens the default tabs.
     */
    public void openDefaultTabs() {
        //player.getPacketDispatch().sendInterfaceConfig(548, 51, false);
        WeaponInterface inter = player.getExtension(WeaponInterface.class);
        if (inter == null) {
            player.addExtension(WeaponInterface.class, inter = new WeaponInterface(player));
        }

        tabs[0] = inter;
        tabs[1] = new Component(320);
        tabs[2] = new Component(399);
        tabs[3] = new Component(149);
        tabs[4] = new Component(387);
        tabs[5] = new Component(541);
        tabs[6] = new Component(218);
        tabs[7] = new Component(7);
        tabs[8] = new Component(432);
        tabs[9] = new Component(429);
        tabs[10] = new Component(182);
        tabs[11] = new Component(261);
        tabs[12] = new Component(216);
        tabs[13] = new Component(239);

        if (player.getProperties().getAutocastSpell() != null) {
            inter.selectAutoSpell(inter.getAutospellId(player.getProperties().getAutocastSpell().getSpellId()), true);
        }
    }

    /**
     * Opens a tab.
     *
     * @param slot      The tab slot;
     * @param component The component.
     */
    public void openTab(int slot, Component component) {
        if (slot < 0) //CHEAPHAX AF TODO FIXME RYAN.
            return;
        if (component.getId() == 593 && !(component instanceof WeaponInterface)) {
            throw new IllegalStateException("Attack tab can only be instanced as " + WeaponInterface.class.getCanonicalName() + "!");
        }
        if (component.getDefinition().getContext() == null) {
            component.getDefinition().setContext(new InterfaceContext(null, player.getInterfaceManager().getWindowsPane(), 65 + slot, component.getId(), false));
        }
        component.open(player);
        tabs[slot] = component;
    }

    /**
     * Opens a tab.
     *
     * @param component The component to open.
     */
    public void openTab(Component component) {
        System.out.println("[Autocast] Opening tab");

        component.getDefinition().getContext().setPlayer(player);
        openTab(component.getDefinition().getContext().getComponentId() - (isResizable() ? 68 : 65), component);
    }

    public void openChatbox(int interfaceId) {
        player.getPacketDispatch().sendInterface(162, 29, interfaceId, false);
    }

    public void openChatbox(int interfaceId, int root, int child) {
        player.getPacketDispatch().sendInterface(root, child, interfaceId, false);
    }

   /* public void openChatbox(Component component) {
        player.getPacketDispatch().sendInterface(162, 546, component.getId(), false);
    }*/

    /**
     * Opens a chat box interface.
     *
     * @param componentId The component id.
     */
    public void openChatbox(int componentId, int accessChild, int length, int CS2ID, Object[] script) {
        player.getPacketDispatch().sendInterface(162, 24, componentId, false);
        player.getPacketDispatch().sendCS2Script(CS2ID, script);
        player.getPacketDispatch().sendAccessMask(1, accessChild, componentId, 0, length);
    }

    public void openChatbox(Component component) {
        if (component.getId() == DEFAULT_CHATBOX) {
            //PacketRepository.send(Interface.class, new InterfaceContext(player, WINDOWS_PANE, 120, 0, true));
            //player.getPacketDispatch().sendInterfaceConfig(548, 121, false);
            if (chatbox == null) {
                chatbox = component;
                chatbox.open(player);
            }
            chatbox = component;
            //player.getConfigManager().set(334, 1);
        } else {
            chatbox = component;
            //player.getPacketDispatch().sendInterfaceConfig(548, 121, true);
            //chatbox.getDefinition().setContext(new InterfaceContext(null, 548, component.getId() == 389 ? 115 : 120, component.getId(), true));
            //TODO FIGURE OUT WTF THIS CODE DOES ^? RYAN.
            chatbox.open(player);
        }
    }

    public void openRootChatbox() {
        if (chatbox == null) {
            chatbox = new Component(162);
            chatbox.open(player);
        }
        chatbox = new Component(162);
    }

    /**
     * Gets the component for the given component id.
     *
     * @param componentId The component id.
     * @return The component.
     */
    public Component getComponent(int componentId) {
        if (opened != null && opened.getId() == componentId) {
            return opened;
        }
        if (chatbox != null && chatbox.getId() == componentId) {
            return chatbox;
        }
        if (singleTab != null && singleTab.getId() == componentId) {
            return singleTab;
        }
        if (overlay != null && overlay.getId() == componentId) {
            return overlay;
        }
        if (windowsPane.getId() == componentId) {
            return windowsPane;
        }
        if (orbPane.getId() == componentId) {
            return orbPane;
        }
        for (Component c : tabs) {
            if (c != null && c.getId() == componentId) {
                return c;
            }
        }
        return null;
    }

    /**
     * Sets the currently viewed tab.
     *
     * @param tabIndex The tab index.
     */
    public void setViewedTab(int tabIndex) {
        if (tabs[tabIndex] == null) {
            throw new IllegalStateException("Tab at index " + tabIndex + " is null!");
        }
        currentTabIndex = tabIndex;
        switch (tabIndex) {
            case 0:
                tabIndex = 1;
                break;
            case 1:
                tabIndex = 2;
                break;
            case 2:
                tabIndex = 3;
                break;
            case 3:
                tabIndex = 0;
                break;
        }
        if (tabIndex > 9) {
            tabIndex--;
        }
        player.getPacketDispatch().sendRunScript(116, "i", tabIndex);
    }

    public int getWindowsPane() {
        if (windowsPane == null) {
            return 548;
        }
        System.out.println("[InterfaceManager] [getWindowsPane] " + windowsPane.getId());
        return windowsPane.getId();
    }

    public int getChildId(int windowPane) {
        switch (windowPane) {
            case 548:
                return 0;
            case 164:
        }
        System.out.println("[InterfaceManager] [getChildId] " + windowsPane.getId());
        return windowsPane.getId();
    }

    /**
     * Switches the player's window mode (fixed, resizable, fullscreen).
     *
     * @param windowMode The window mode.
     */
    public void switchWindowMode(int windowMode) {
        if (windowMode != player.getDetails().getClientInfo().getWindowMode()) {
            player.getDetails().getClientInfo().setWindowMode(windowMode);
            openWindowsPane(new Component(isResizable() ? 548 : 161));
            InterfaceSetManager.sendSets(player, windowMode);
        }
    }

    public boolean isResizable() {
        return player.getDetails().getClientInfo().isResizable();
    }

    /**
     * Checks if the main component opened matches the given component id.
     *
     * @param id The component id.
     * @return {@code True} if so.
     */
    public boolean hasMainComponent(int id) {
        return opened != null && opened.getId() == id;
    }

    /**
     * Opens an overlay.
     *
     * @param component The component.
     */
    public void openOverlay(Component component) {

        if (overlay != null && !overlay.close(player)) {
            return;
        }
        overlay = component;
        //		if (overlay.getDefinition().getContext() == null) {
        overlay.getDefinition().setContext(new InterfaceContext(null, player.getInterfaceManager().getWindowsPane(), OVERLAY_SLOT, component.getId(), true));
        //		}
        overlay.open(player);
    }

    /**
     * Closes the current overlay.
     */
    public void closeOverlay() {
        if (overlay != null && overlay.close(player)) {
            if (overlay.getDefinition().getContext() != null) {
                InterfaceContext context = overlay.getDefinition().getContext();
                context.setPlayer(player);
                context.setWindowId(getWindowsPane());
                PacketRepository.send(CloseInterface.class, context);
            } else {
                PacketRepository.send(CloseInterface.class, new InterfaceContext(player, getWindowsPane(), OVERLAY_SLOT, overlay.getId(), true));
            }
            overlay = null;
        }
    }

    /**
     * Checks to see if the current opened interface is the
     * quest completion interface. This is used to determine if we should
     * delay a level up.
     *
     * @return If the interface is opened {@code true},
     * otherwise {@code false}.
     */
    public boolean hasQuestCompletionInterfaceOpened() {
        return opened != null && opened.getId() == 277;
    }

    /**
     * Gets the weapon tab interface.
     *
     * @return The weapon interface.
     */
    public WeaponInterface getWeaponTab() {
        return player.getExtension(WeaponInterface.class);
    }

    /**
     * Gets the currentTabIndex.
     *
     * @return The currentTabIndex.
     */
    public int getCurrentTabIndex() {
        return currentTabIndex;
    }

}