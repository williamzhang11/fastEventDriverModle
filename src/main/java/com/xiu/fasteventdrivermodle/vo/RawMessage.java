package com.xiu.fasteventdrivermodle.vo;

//{"id":"1","type":"502","operation":"1"}
public class RawMessage {

	public MessageType type;
	
	private String body;
	
	public static enum MessageType{
		http,mq
	}
	
	public RawMessage(String body) {
		this.body = body;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}
}
