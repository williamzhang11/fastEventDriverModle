package com.xiu.fasteventdrivermodle.resolvers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.xiu.fasteventdrivermodle.vo.Message;
import com.xiu.fasteventdrivermodle.vo.RawMessage;

@Component
public class MsgResolverList implements MsgResolver{
	 //职责链
	private List<MsgResolver> resolvers;
	
	public List<MsgResolver> getResolvers() {
		return resolvers;
	}

	public void setResolvers(List<MsgResolver> resolvers) {
		this.resolvers = resolvers;
	}

	@Override
	public boolean canResolve(RawMessage rm) {
		return true;
	}

	@Override
	public Message resolve(RawMessage rawMessage) {
		for(MsgResolver resolver: resolvers) {
            if(resolver.canResolve(rawMessage)) {
                System.out.println("NotifyType: "+rawMessage.type);
                return resolver.resolve(rawMessage);
            }
        }
        return null;
	}
	
	

}
