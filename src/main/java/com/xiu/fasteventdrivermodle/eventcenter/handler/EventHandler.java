package com.xiu.fasteventdrivermodle.eventcenter.handler;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;
/**
 * 事件处理器
 * 时间处理器抽象类,包含一个单例事件中心,每个处理器通过持有这个事件中心注册自己(订阅一个事件)
 * 以及唤起下一个事件操作
 */

import com.xiu.fasteventdrivermodle.eventcenter.EventCenter;


public abstract class EventHandler implements InitializingBean{
	
	@Resource
	EventCenter eventCenter;
	
	public abstract void handle(Object ... param);

}
