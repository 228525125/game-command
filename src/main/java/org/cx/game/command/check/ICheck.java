package org.cx.game.command.check;

import org.cx.game.command.exception.ExecuteValidatorException;
import org.cx.game.validator.IValidatable;

public interface ICheck extends IValidatable {
	
	public void check(Event event) throws ExecuteValidatorException;
	
	public Boolean isMatch(Event event) throws ExecuteValidatorException;
}
