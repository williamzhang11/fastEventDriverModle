package com.xiu.fasteventdrivermodle.eventcenter;

/**
 * 事件event
 * @author william
 *
 */
public class EventName {

	private final String name;
	
	public EventName(String name) {
		this.name = name;
	}
	
	
	public static EventName msg_received = new EventName("msg_received");
	
	public static EventName msg_resolved = new EventName("msg_resolved");
	
	public static EventName msg_stored = 	new EventName("msg_pushed");
	
	public static EventName msg_pushed = 	new EventName("msg_pushed");
	
	public static EventName exception_occured = new EventName("exception_occured");
	
	public static EventName end_and_log = new EventName("end_and_log");

	public String getName() {
		return name;
	}
	
	
	
	

	
}
