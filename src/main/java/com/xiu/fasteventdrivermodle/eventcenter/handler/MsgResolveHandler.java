package com.xiu.fasteventdrivermodle.eventcenter.handler;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.xiu.fasteventdrivermodle.eventcenter.EventName;
import com.xiu.fasteventdrivermodle.resolvers.MsgResolverList;
import com.xiu.fasteventdrivermodle.vo.Message;
import com.xiu.fasteventdrivermodle.vo.RawMessage;

/**
 * 
 *
 */
@Component
public class MsgResolveHandler extends EventHandler implements InitializingBean{

	@Resource
	private MsgResolverList resolverList;
	
	@Override
	public void handle(Object... param) {
		
		RawMessage rMessage = (RawMessage)param[0];
		
		Message message = resolverList.resolve(rMessage);
		
		eventCenter.fire(EventName.msg_resolved, message);
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		eventCenter.register(EventName.msg_received, this);
	}
	
	

}
