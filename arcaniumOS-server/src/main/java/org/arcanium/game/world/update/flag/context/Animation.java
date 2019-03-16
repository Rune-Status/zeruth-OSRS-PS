package org.arcanium.game.world.update.flag.context;

import org.arcanium.cache.def.impl.AnimationDefinition;
import org.arcanium.game.node.entity.impl.Animator;
import org.arcanium.game.node.object.GameObject;

/**
 * Represents an animation.
 * @author Emperor
 */
public class Animation {

    /**
     * The reset animation.
     */
    public static final Animation RESET = new Animation(-1, Animator.Priority.VERY_HIGH);

    /**
     * The priority.
     */
    private Animator.Priority priority;

    /**
     * The animation id.
     */
    private int id;

    /**
     * The animation delay.
     */
    private final int delay;

    /**
     * The animation definitions.
     */
    private AnimationDefinition definition;

    /**
     * The object to animate.
     */
    private GameObject object;

    /**
     * Constructs a new {@code Animation} {@code Object}.
     * @param id The animation id.
     */
    public Animation(int id) {
	this(id, 0, Animator.Priority.MID);
    }

    /**
     * Constructs a new {@code Animation}.
     * @param id the id.
     * @return
     */
    public static Animation create(int id) {
	return new Animation(id, 0, Animator.Priority.MID);
    }

    /**
     * Constructs a new {@code Animation} {@code Object}.
     * @param id The animation id.
     */
    public Animation(int id, Animator.Priority priority) {
	this(id, 0, priority);
    }

    /**
     * Constructs a new {@code Animation} {@code Object}.
     * @param id The animation id.
     * @param delay The animation delay.
     */
    public Animation(int id, int delay) {
	this(id, delay, Animator.Priority.MID);
    }

    /**
     * Constructs a new {@code Animation} {@code Object}.
     * @param id The animation id.
     * @param delay The animation delay.
     */
    public Animation(int id, int delay, Animator.Priority priority) {
	this.id = id;
	this.delay = delay;
	this.priority = priority;
    }

    /**
     * Gets the animation definitions of this animation.
     * @return The animation definitions.
     */
    public AnimationDefinition getDefinition() {
	if (definition == null) {
	    definition = AnimationDefinition.forId(id);
	}
	return definition;
    }

    /**
     * The duration of the animation.
     * @return The duration in ticks.
     */
    public int getDuration() {
	AnimationDefinition def = getDefinition();
	return def != null ? def.getDurationTicks() : 1;
    }

    /**
     * Get the id.
     * @return the id
     */
    public int getId() {
	return id;
    }

    /**
     * Get the delay.
     * @return the delay
     */
    public int getDelay() {
	return delay;
    }

    /**
     * Sets the id.
     * @param id
     */
    public void setId(int id) {
	this.id = id;
    }

    /**
     * @return the priority.
     */
    public Animator.Priority getPriority() {
	return priority;
    }

    /**
     * Gets the object.
     * @return The object.
     */
    public GameObject getObject() {
	return object;
    }

    /**
     * Sets the object.
     * @param object The object to set.
     */
    public void setObject(GameObject object) {
	this.object = object;
    }

    /**
     * Sets the priority.
     * @param priority The priority.
     */
    public void setPriority(Animator.Priority priority) {
	this.priority = priority;
    }
}