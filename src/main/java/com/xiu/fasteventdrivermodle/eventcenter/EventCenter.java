package com.xiu.fasteventdrivermodle.eventcenter;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.xiu.fasteventdrivermodle.eventcenter.handler.EventHandler;

/**
 * 在事件中心,事件和处理器之间的关系表示一个hashMap,每个事件可以被多个处理器监听,而一个处理器
 * 只能监听一个事件
 * @author william
 *
 */
@Component
public class EventCenter {

	private Map<EventName, List<EventHandler>> regTable = 
			new HashMap<EventName, List<EventHandler>>();
	
	/**
	 * 向事件中心广播一个事件,驱使事件中心执行该事件的处理器
	 * @param eventName
	 * @param param
	 */
	public void fire(EventName eventName,Object ...param) {
		
		System.out.println(eventName.getName());
		
		List<EventHandler> handlerList = regTable.get(eventName);
		
		if(CollectionUtils.isEmpty(handlerList)) {
			
			System.out.println("handle is empty");
			return;
		}
		
		for(EventHandler handler : handlerList) {
			
			try {
				
				handler.handle(param);
			} catch (Exception e) {
				fire(eventName.exception_occured, e);
				
			}
			
		}
		
	}
	
	
	/**
	 * 将自己注册为事件中心的某个事件的处理器
	 * @param eventName
	 * @param handler
	 */
	public void register(EventName eventName,EventHandler handler) {
		
		List<EventHandler> handlerList = regTable.get(eventName);
		
		if(handlerList == null) {
			handlerList = new LinkedList<>();
		}
		
		handlerList.add(handler);
		regTable.put(eventName, handlerList);
		
		
	}
}
