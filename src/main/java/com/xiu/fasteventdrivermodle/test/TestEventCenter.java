package com.xiu.fasteventdrivermodle.test;

import javax.annotation.Resource;

import com.xiu.fasteventdrivermodle.eventcenter.EventCenter;
import com.xiu.fasteventdrivermodle.eventcenter.EventName;
import com.xiu.fasteventdrivermodle.vo.RawMessage;

public class TestEventCenter {

	
    @Resource
    EventCenter eventCenter;

    public void test() {
        RawMessage rawMessage = new RawMessage("{\r\n" + 
        		"	\"id\": \"1\",\r\n" + 
        		"	\"type\": \"502\",\r\n" + 
        		"	\"operation\": \"1\"\r\n" + 
        		"}");
        
        rawMessage.setType(RawMessage.MessageType.http);
        eventCenter.fire(EventName.msg_received, rawMessage);
    }
}
