package org.arcanium.game.node.entity.player.link.diary;

import org.arcanium.game.component.Component;
import org.arcanium.game.container.impl.EquipmentContainer;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.item.Item;
import org.arcanium.net.packet.PacketRepository;
import org.arcanium.net.packet.context.AccessMaskContext;
import org.arcanium.net.packet.server.AccessMask;
import org.arcanium.parser.player.SavingModule;

import java.nio.ByteBuffer;

/**
 * Manages the achievement diary of a player.
 * @author Vexia
 */
public class AchievementDiaryManager implements SavingModule {

	/**
	 * The achievement diarys.
	 */
	private final AchievementDiary[] diarys = new AchievementDiary[]{
			new AchievementDiary(DiaryType.KARAMJA)
	};

	/**
	 * The player instance.
	 */
	private final Player player;

	/**
	 * Constructs a new {@Code AchievementDiary} {@Code Object}
	 *
	 * @param player the player.
	 */
	public AchievementDiaryManager(Player player) {
		this.player = player;
	}

	@Override
	public void save(ByteBuffer buffer) {
		buffer.put((byte) 1).put(((byte) diarys.length));
		for (AchievementDiary diary : diarys) {
			diary.save(buffer);
		}
		buffer.put((byte) 0);
	}

	@Override
	public void parse(ByteBuffer buffer) {
		int opcode;
		while ((opcode = buffer.get()) != 0) {
			switch (opcode) {
				case 1:
					int length = buffer.get() & 0xFF;
					for (int i = 0; i < length; i++) {
						diarys[i].parse(buffer);
					}
					break;
			}
		}
	}

	/**
	 * Opens the achievement diary tab.
	 */
	public void openTab() {
		player.getInterfaceManager().openTab(new Component(259));
		PacketRepository.send(AccessMask.class, new AccessMaskContext(player, 2, 4, 259, 0, 10));
		for (AchievementDiary diary : diarys) {
			diary.drawStatus(player);
		}
	}

	/**
	 * Induces a task update.
	 *
	 * @param player   the player.
	 * @param type     the diary type.
	 * @param level    the level.
	 * @param index    the index of the task.
	 * @param complete if it's completed.
	 */
	public void updateTask(Player player, DiaryType type, int level, int index, boolean complete) {
		getDiary(type).updateTask(player, level, index, complete);
	}

	/**
	 * Checks if a task has been completed.
	 *
	 * @param type  the diary type.
	 * @param level the level.
	 * @param index the index.
	 * @return {@code True} if completed.
	 */
	public boolean hasCompletedTask(DiaryType type, int level, int index) {
		return getDiary(type).isComplete(level, index);
	}

	/**
	 * Sets the diary at a level as started.
	 *
	 * @param type  the type of diary.
	 * @param level the level.
	 */
	public void setStarted(DiaryType type, int level) {
		getDiary(type).setStarted(level);
	}

	/**
	 * Sets the diarys achievement as completed.
	 *
	 * @param type  the type.
	 * @param level the level.
	 * @param index the index.
	 */
	public void setCompleted(DiaryType type, int level, int index) {
		getDiary(type).setCompleted(level, index);
	}

	/**
	 * Gets the achievement diary for the type.
	 *
	 * @param type the type.
	 * @return the diary object.
	 */
	public AchievementDiary getDiary(DiaryType type) {
		if (type == null) {
			return null;
		}
		for (AchievementDiary diary : diarys) {
			if (diary.getType() == type) {
				return diary;
			}
		}
		return null;
	}

	/**
	 * Gets the karamaja glove level.
	 *
	 * @return the level of the glove.
	 */
	public int getKaramjaGlove() {
		if (!hasGlove()) {
			return -1;
		}
		for (int i = 0; i < 3; i++) {
			if (player.getEquipment().containsItem(DiaryType.KARAMJA.getRewards()[i][0])) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * Checks if the player has karamaja gloves.
	 *
	 * @return the gloves.
	 */
	public boolean hasGlove() {
		Item glove = player.getEquipment().get(EquipmentContainer.SLOT_HANDS);
		return glove != null && (glove.getId() == DiaryType.KARAMJA.getRewards()[0][0].getId() || glove.getId() == DiaryType.KARAMJA.getRewards()[1][0].getId() || glove.getId() == DiaryType.KARAMJA.getRewards()[2][0].getId());
	}

	/**
	 * Checks if a diary is complete.
	 *
	 * @param type the diary type.
	 * @return {@code True} if so.
	 */
	public boolean isComplete(DiaryType type) {
		return diarys[type.ordinal()].isComplete();
	}

	/**
	 * Gets the player.
	 *
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * Gets the diarys.
	 *
	 * @return the diarys
	 */
	public AchievementDiary[] getDiarys() {
		return diarys;
	}

}
