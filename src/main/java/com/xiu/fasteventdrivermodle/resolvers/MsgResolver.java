package com.xiu.fasteventdrivermodle.resolvers;

import com.xiu.fasteventdrivermodle.vo.Message;
import com.xiu.fasteventdrivermodle.vo.RawMessage;

public interface MsgResolver {

	public boolean canResolve(RawMessage rm);
	
	public Message resolve(RawMessage rm);
	
}
