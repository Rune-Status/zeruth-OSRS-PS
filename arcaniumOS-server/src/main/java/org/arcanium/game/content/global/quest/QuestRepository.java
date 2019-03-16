package org.arcanium.game.content.global.quest;

import org.arcanium.cache.misc.buffer.ByteBufferUtils;
import org.arcanium.game.content.global.quest.impl.free.*;
import org.arcanium.game.content.global.quest.impl.member.*;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.world.GameWorld;
import org.arcanium.parser.player.SavingModule;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Represents a repository of instanced player quests.
 *
 * @author 'Vexia
 */
public final class QuestRepository implements SavingModule {

    public static final boolean NEW_SAVE = true;

    /**
     * Represents the mapping of instanced quests.
     */
    private final Map<String, Quest> quests = new HashMap<String, Quest>();

    /**
     * Represents the player instance.
     */
    private final Player player;

    /**
     * Represents the synchronized quest points.
     */
    private int points = 0;

    /**
     * Constructs a new {@code QuestRepository} {@code Object}.
     *
     * @param player the player.
     */
    public QuestRepository(final Player player) {
        this.player = player;
        // FREE
        quests.put("Black Knights' Fortress", new BlackKnightsFortress(player));
        quests.put("Cook's Assistant", new CooksAssistant(player));
        quests.put("Demon Slayer", new DemonSlayer(player));
        quests.put("Doric's Quest", new DoricsQuest(player));
        quests.put("Dragon Slayer", new DragonSlayer(player));
        quests.put(ErnestTheChicken.NAME, new ErnestTheChicken(player));
        quests.put("Goblin Diplomacy", new GoblinDiplomacy(player));
        quests.put("Imp Catcher", new ImpCatcher(player));
        quests.put("The Knight's Sword", new TheKnightsSword(player));
        quests.put("Pirate's Treasure", new PiratesTreasure(player));
        quests.put("Prince Ali Rescue", new PrinceAliRescue(player));
        quests.put(RestlessGhost.NAME, new RestlessGhost(player));
        quests.put("Romeo & Juliet", new RomeoJuliet(player));
        quests.put("Rune Mysteries", new RuneMysteries(player));
        quests.put("Sheep Shearer", new SheepShearer(player));
        quests.put("Shield of Arrav", new ShieldofArrav(player));
        quests.put("Vampire Slayer", new VampireSlayer(player));
        quests.put(WitchsPotion.NAME, new WitchsPotion(player));
        // MEMBERS
        quests.put(AnimalMagnetism.NAME, new AnimalMagnetism(player));
        quests.put(DruidicRitual.NAME, new DruidicRitual(player));
        quests.put(PriestInPeril.NAME, new PriestInPeril(player));
        quests.put("Gertrude's Cat", new GertrudesCat(player));
        quests.put("Wolf Whistle", new WolfWhistle(player));
        quests.put(TouristTrap.NAME, new TouristTrap(player));
        quests.put(WaterFall.NAME, new WaterFall(player));
        quests.put(RovingElves.NAME, new RovingElves(player));
        quests.put(LostCity.NAME, new LostCity(player));
        quests.put(JunglePotion.NAME, new JunglePotion(player));
        quests.put(WhatLiesBelow.NAME, new WhatLiesBelow(player));
        quests.put(DwarfCannon.NAME, new DwarfCannon(player));
        quests.put(MerlinCrystal.NAME, new MerlinCrystal(player));
    }

    /**
     * Updates the {@link #quests} values and the information and states.
     *
     * @param player the player.
     */
    public void update(Player player) {
        if (!GameWorld.isEconomyWorld()) {
            return;
        }
        player.getConfigManager().sendVarp(101, points);
        for (Entry<String, Quest> quest : quests.entrySet()) {
            if (quest.getValue().getConfig().length < 2) {
                System.out.println("Learn to program you cunts, this threw exceptions on the server!" + quest.getKey());
                continue;
            }
            player.getConfigManager().sendVarp(quest.getValue().getConfig()[0], quest.getValue().getConfig()[1]);
        }
    }

    @Override
    public void save(ByteBuffer buffer) {
        buffer.put((byte) 1);
        buffer.putInt(points);
        for (Entry<String, Quest> quest : quests.entrySet()) {
            buffer.put((byte) 3);
            buffer.putInt(quest.getValue().getIndex());
            buffer.putInt(quest.getValue().getStage());
            buffer.putInt(quest.getValue().getState() == QuestState.COMPLETED ? 2 : quest.getValue().getState() == QuestState.STARTED ? 1 : 0);
            //System.out.println("Saving " + quest.getKey() + ", index = " + (quest.getValue().getIndex() - 1));
        }
        buffer.put((byte) 0);
    }

    @Override
    public void parse(ByteBuffer buffer) {
        int opcode;
        String name = null;
        int stage = 0;
        int state = 0;
        int index = 0;
        QuestState questState = null;
        Quest quest = null;
        while ((opcode = buffer.get() & 0xFF) != 0) {
            switch (opcode) {
                case 1:
                    points = buffer.getInt();
                    break;
                case 2://old saving
                    name = ByteBufferUtils.getString(buffer);
                    stage = buffer.getInt();
                    state = buffer.getInt();
                    questState = state == 2 ? QuestState.COMPLETED : state == 1 ? QuestState.STARTED : QuestState.NOT_STARTED;
                    quest = getQuest(name);
                    if (quest == null) {
                        System.err.println("Quest wasn't found(parser)=" + name);
                        continue;
                    }
                    quests.remove(quest);
                    quest.setStage(stage);
                    quest.setState(questState);
                    quests.put(name, quest);
                    break;
                case 3:
                    index = buffer.getInt();
                    stage = buffer.getInt();
                    state = buffer.getInt();
                    questState = state == 2 ? QuestState.COMPLETED : state == 1 ? QuestState.STARTED : QuestState.NOT_STARTED;
                    quest = getQuestIndex(index);
                    if (quest == null) {
                        break;
                    }
                    quest.setStage(stage);
                    quest.setState(questState);
                    break;
            }
        }
        syncPoints();
    }

    /**
     * Checks to see if a quest has been started.
     *
     * @param quest The quest to check.
     * @return True if the quest has been started.
     */
    public boolean isStarted(Quest quest) {
        return isStarted(quest.getName());
    }

    /**
     * Checks to see if a quest has been started.
     *
     * @param name The name of the quest to check.
     * @return True if the quest has been started.
     */
    public boolean isStarted(String name) {
        return (quests.get(name) == null ? Boolean.FALSE : quests.get(name).getState() == QuestState.STARTED);
    }

    /**
     * Checks if the quest by the given name is completed.
     *
     * @param name the name of the quest.
     * @return if the quest is completed.
     */
    public boolean isComplete(String name) {
        return isComplete(quests.get(name));
    }

    /**
     * Checks if the quest is complete.
     *
     * @param quest the quest.
     * @return the quest.
     */
    public boolean isComplete(Quest quest) {
        if (quest == null) {
            return false;
        }
        return quest.getState() == QuestState.COMPLETED;
    }

    /**
     * Increments the obtained points by the value.
     *
     * @param value the value.
     */
    public void incrementPoints(int value) {
        points += value;
    }

    /***
     * Checks if all quests are completed.
     * @return {@code True} if so.
     */
    public boolean hasCompletedAll() {
        return getPoints() >= getAvailablePoints();
    }

    /**
     * Gets the total available quest points.
     *
     * @return the points needed for a cape.
     */
    public int getAvailablePoints() {
        int points = 0;
        for (Quest quest : quests.values()) {
            if (!quest.isInDevelopment()) {
                points += quest.getQuestPoints();
            }
        }
        return points;
    }

    /**
     * Returns the <p> Quest </p> by the given name.
     *
     * @param name the name of the quest.
     * @return the quest.
     */
    public Quest getQuest(String name) {
        return quests.get(name);
    }

    /**
     * Gets the <b>Quest</b> by the index.
     *
     * @param index the index of the quest.
     * @return the quest by the button index.
     */
    public Quest getQuestIndex(int index) {
        for (Entry<String, Quest> quest : quests.entrySet()) {
            if (quest.getValue().getIndex() == index) {
                return quest.getValue();
            }
        }
        return null;
    }

    /**
     * Method used to sync the quest points.
     */
    public void syncPoints() {
        int points = 0;
        for (Quest quest : quests.values()) {
            if (quest.getState() == QuestState.COMPLETED) {
                points += quest.getQuestPoints();
            }
        }
        setPoints(points);
    }

    /**
     * Gets the points.
     *
     * @return the points.
     */
    public int getPoints() {
        return points;
    }

    /**
     * Sets the points.
     *
     * @param points the points to set.
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Gets the quests.
     *
     * @return the quest.
     */
    public Map<String, Quest> getQuests() {
        return quests;
    }

    /**
     * Gets the player.
     *
     * @return The player.
     */
    public Player getPlayer() {
        return player;
    }

}