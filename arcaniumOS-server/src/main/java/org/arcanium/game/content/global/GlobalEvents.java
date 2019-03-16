package org.arcanium.game.content.global;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.system.task.Pulse;
import org.arcanium.game.world.GameWorld;
import org.arcanium.game.world.repository.Repository;

/**
 * The new server-wide event system. 
 * Events are to be manually started but automatically finished, on a timer, by the pulse method.
 * @author Splinter
 * @version 1.0
 */
public enum GlobalEvents {
    
    	SORCERERS_GARDEN(0, 3500, false, "Sorcerer's Garden - herbs", "Recieve double the herbs from the Sorcerer's Garden."),
    	MYSTERY_BOX(1, 3500, false, "Mystery box drop rate", "Increased chance of recieving a Mystery box drop."),
    	GRAVESTONE_PRICES(2, 2500, false, "Gravestone prices", "Gravestones are reduced in coin cost by 50%."),
    	AGILITY_TICKETS(3, 4000, false, "x2 Agility tickets", "x2 Agility tickets earned in the Brimhaven Agility Arena."),
    	SPINNING_WHEEL(4, 3500, false, "Spinning wheel xp", "Spinning wheel items give double the experience when spun."),
    	WARRIORS_GUILD(5, 3500, false, "Warrior's guild tokens", "Receive 2x the tokens from the Warrior's guild animator room."),
    	HERBLORE_CLEANING(6, 3500, false, "Herb cleaning xp", "Recieve double the experience whilst cleaning herbs."),
    	DOUBLE_PICKPOCKETING(7, 4000, false, "Pickpocketing exp", "1.5x experience whilst picking pockets."),
    	DOUBLE_EXPERIENCE(8, 3000, false, "Double experience", "Server-wide Double XP. Does not stack with your personal DXP."),
    	
    ;

    /**
     * The ID of the event.
     */
    public int id;
    
    /**
     * The timer of the event in ticks.
     */
    public int timer;
    
    /**
     * If the -specific- event is currently running.
     */
    private boolean isEventRunning;
    
    /**
     * The technical name of the event, to be displayed to the player.
     */
    public String name;
    
    /**
     * The message to display when the event becomes active.
     */
    public String message;

    /**
     * The currently active -specific- event.
     */
    public static GlobalEvents active = null;
    
    /**
     * If there is currently any event running, regardless of what it is.
     */
    public static boolean isRunning = false;
    
    
    /**
     * Constructs a new {@code GlobalEvents} {@code Object}.
     */
    GlobalEvents(int id, int timer, boolean isEventRunning, String name, String message) {
	this.id = id;
	this.timer = timer;
	this.isEventRunning = isEventRunning;
	this.name = name;
	this.message = message;
    }
    
    /**
     * Get the message to display upon starting the event.
     * @return the string.
     */
    public String getMessage(){
	return message;
    }
    
    /**
     * Get the technical name of the event.
     * @return the name.
     */
    public String getName(){
	return name;
    }
    
    /**
     * Get the ID of the given event.
     * @return the ID.
     */
    public int getId(){
	return id;
    }
    
    /**
     * Get the running time of the event
     * @return the timer
     */
    public int getTimer(){
	return timer;
    }
    
    /**
     * Set the timer
     * @return the timer
     */
    public void setTimer(int timer){
	this.timer = timer;
    }
    

    /**
     * Check to see if a -specific- event is currently running.
     * @return true if so.
     */
    public boolean isEventRunning() {
	return isEventRunning;
    }

    /**
     * Set the -specific- event to running.
     * @param true or false
     */
    public void setEventRunning(boolean isEventRunning) {
	this.isEventRunning = isEventRunning;
    }
    
    /**
     * Check to see if there is any event running.
     * @return true if so.
     */
    public boolean isRunning(){
	if(isRunning){
	    return true;
	}
	return false;
    }
    
    /**
     * Gets the GlobalEvent for a given ID.
     * @param the ID
     * @return the event
     */
    public static GlobalEvents forId(final int id) {
	for (GlobalEvents ge : GlobalEvents.values()) {
	    if (id == ge.getId()) {
		return ge;
	    }
	}
	return SORCERERS_GARDEN;
    }
    
    /**
     * Get the -specific- active running event.
     * @return the running event
     */
    public static GlobalEvents getActive(){
	return active;
    }
    
    /**
     * Sets the new active event to run.
     * @param event the Event to run.
     * @param ticks the amount of ticks to run for.
     */
    public static void setActive(GlobalEvents event, int ticks){
	if(event == null || isRunning){
	    return;
	}
	active = event; //Used for getting the active event
	isRunning = true; //Flag if there is any event running in general
	event.setEventRunning(true); //Flag if the specific event is running
	event.setTimer(ticks); 
	sendGlobalMessage(event.getMessage());
	sendGlobalMessage("This event will be active for the next "+ GlobalEvents.getActive().getTimer() / 100 +" minutes.");
	pulse(event);
    }
    
    /**
     * Stops the currently running event (if there is one) and flags the running event as inactive.
     */
    public static void stop(GlobalEvents event){
	if(event == null){
	    return;
	}
	isRunning = false;
	event.setEventRunning(false);
	sendGlobalMessage("The active event ("+event.getName()+") has concluded.");
    }
    
    /**
     * The GlobalEvent pulse -- called every 600ms.
     * @param event the running event.
     */
    public static void pulse(final GlobalEvents event){
	if(event == null){
	    return;
	}
	GameWorld.submit(new Pulse(1) {
	    int counter = event.getTimer();

	    @Override
	    public boolean pulse() {
		//Stop the pulse early if eventstop command is entered
		if(!event.isEventRunning()){
		    return true;
		}
		event.setTimer(counter);
		switch (counter--) {
		case 0:
		    GlobalEvents.stop(event);
		    return true;
		case 500://5min
		    sendGlobalMessage("The current event ("+event.getName()+") is about to end.");
		    break;
		}
		return false;
	    }
	});
    }
   
    /**
     * Send a server-wide message to all players informing them that a new event is available.
     */
    public static void sendGlobalMessage(String message){
	Repository.sendEventMessage(message);
    }
    
    /**
     * Send a a message to a single player that an event is active -- used for logging in.
     */
    public static void sendSoloMessage(Player player, String message){
	 player.sendMessage("<col=006600>[Server Event] " + message);
    }
}