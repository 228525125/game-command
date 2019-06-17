package org.cx.game.command.expression;

import org.cx.game.command.ICommandBuffer;
import org.dom4j.Element;

public class WithCacheCommandParameterExpression extends ParameterExpression {
	
	private ICommandBuffer buffer = null;
	
	public WithCacheCommandParameterExpression(String cmd, Element cmdEl, ICommandBuffer buffer) {
		super(cmd, cmdEl);
		// TODO Auto-generated constructor stub
		this.buffer = buffer;
	}
	
	public ICommandBuffer getBuffer() {
		return buffer;
	}
}
