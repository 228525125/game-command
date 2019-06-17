package org.cx.game.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import org.cx.game.command.exception.ExecuteValidatorException;
import org.cx.game.validator.Errors;
import org.cx.game.validator.IValidatable;
import org.cx.game.validator.IValidator;

public abstract class AbstractCommand extends Observable implements IValidatable{
	
	protected Object parameter = null;
	private List<IValidator> validatorList = new ArrayList<IValidator>();
	private Errors errors = new Errors();
	
	/**
	 * 
	 * @return 无返回结果的则为Null，并且要把有返回结果的命令放在组合语句的最后；
	 * @throws ValidatorException
	 */
	public Object execute() throws ExecuteValidatorException {
		/* 
		 * 执行规则验证
		 */
		doValidator();
		
		if(hasError())
			throw new ExecuteValidatorException(getErrors().getMessage());
		
		return null;
	}

	public void setParameter(Object parameter) {
		this.parameter = parameter;
	}
	
	@Override
	public void notifyObservers(Object arg) {
		// TODO Auto-generated method stub
		super.setChanged();
		super.notifyObservers(arg);
	}

	@Override
	public void addValidator(IValidator validator) {
		// TODO Auto-generated method stub
		validatorList.add(validator);
	}

	@Override
	public void deleteValidator(IValidator validator) {
		// TODO Auto-generated method stub
		validatorList.remove(validator);
	}

	@Override
	public List<IValidator> getValidators() {
		// TODO Auto-generated method stub
		return validatorList;
	}
	
	@Override
	public void doValidator() {
		// TODO Auto-generated method stub
		for(IValidator v : validatorList)
			if(!v.validate())
				errors.addError(v);
	}
	
	@Override
	public void doValidator(IValidator validator) throws ExecuteValidatorException {
		// TODO Auto-generated method stub
		if(!validator.validate())
			throw new ExecuteValidatorException(validator.getErrorMessage());
	}
	
	@Override
	public Errors getErrors() {
		// TODO Auto-generated method stub
		return errors;
	}
	
	@Override
	public Boolean hasError() {
		// TODO Auto-generated method stub
		return errors.hasError();
	}	
}
