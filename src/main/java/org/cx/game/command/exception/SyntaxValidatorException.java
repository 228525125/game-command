package org.cx.game.command.exception;

import org.cx.game.command.tools.I18n;
import org.cx.game.validator.exception.ValidatorException;

public class SyntaxValidatorException extends ValidatorException {

	public SyntaxValidatorException() {
		// TODO Auto-generated constructor stub		
		super(I18n.getMessage("org.cx.game.exception.SyntaxValidatorException"));
	}
	
	public SyntaxValidatorException(String description) {
		// TODO Auto-generated constructor stub
		super(I18n.getMessage(description));
	}
}
