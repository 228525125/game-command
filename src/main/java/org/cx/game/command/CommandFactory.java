package org.cx.game.command;

import org.cx.game.command.exception.SyntaxValidatorException;
import org.cx.game.command.expression.Calculator;
import org.dom4j.Element;

public class CommandFactory {
	
	public static WithCacheCommand getInstance(String cmd, Element cmdEl, ICommandBuffer buffer) throws SyntaxValidatorException {
		Calculator helper = new Calculator();
		
		return helper.parseForCommand(cmd, cmdEl, buffer);
	}
	
	public static AbstractCommand getInstance(String cmd, Element cmdEl) throws SyntaxValidatorException {
		Calculator helper = new Calculator();
		
		return helper.parseForCommand(cmd, cmdEl);
	}
}
