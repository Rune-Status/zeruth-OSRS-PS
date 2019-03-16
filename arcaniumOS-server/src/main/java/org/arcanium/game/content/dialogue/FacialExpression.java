package org.arcanium.game.content.dialogue;

/**
 * Represents the facial expressions (the animations the entity does when
 * talking).
 * @author Emperor
 */
public enum FacialExpression {

    /**
     * The normal talking expression.
     */
    NORMAL(591), ANGRY(592), GRUMPY(593), ANNOYED(594), SNEAKY(595), SAD(610), DISTRESSED(596), HAPPY(588), NEARLY_CRYING(613), CHILD_QUESTIONABLE(7171), CHILD_BACK_AND_FORTH(7172), CHILD_NORMAL(7173), CHILD_SLOW_NOD(7174), CHILD_CRAZY_LAUGH(7175), CHILD_THINKING(7176), CHILD_SAD(7177), CHILD_BIG_EYES(7178), CHILD_LOOKING_OUT(7179);

    /**
     * The animation id.
     */
    private final int animationId;

    /**
     * Constructs a new {@code FacialExpression} {@code Object}.
     * @param animationId The animation id.
     */
    private FacialExpression(int animationId) {
	this.animationId = animationId;
    }

    /**
     * Gets the animation id.
     * @return The animation id.
     */
    public int getAnimationId() {
	return animationId;
    }
}