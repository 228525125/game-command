package org.cx.game.command;

import org.cx.game.validator.exception.ValidatorException;
import org.dom4j.Element;

public interface IInvoker {

	public String getResponse();
	
	public Object handleCommand(String cmd) throws ValidatorException;
}
