package org.cx.game.command;

import org.cx.game.command.exception.ExecuteValidatorException;
import org.cx.game.command.exception.SyntaxValidatorException;
import org.cx.game.command.expression.Calculator;
import org.cx.game.validator.exception.ValidatorException;
import org.dom4j.Element;

/**
 * 不带缓存的执行器
 * @author admin
 *
 */
public abstract class AbstractSimpleInvoker implements IInvoker {
	
	protected String response = "";
	
	private AbstractCommand command = null;
	
	@Override
	public String getResponse() {
		// TODO Auto-generated method stub
		return response;
	}
	
	/*
	 * 命令处理完成后执行
	 */
	protected abstract void afterHandle();
	
	protected synchronized Object handleCommand(String cmd, Element cmdEl) throws ValidatorException {
		// TODO Auto-generated method stub
		try {
			intergrityValidate(cmd);    //验证命令完整性
			
			for(String c : cmd.split(";")){
				AbstractCommand command = CommandFactory.getInstance(c, cmdEl);
				setCommand(command);
				return action();
			}
		} catch (ValidatorException e) {
			// TODO: handle exception
			throw e;
		} finally {
			afterHandle();
		}
		
		return null;
	}
	
	private void setCommand(AbstractCommand command) {
		this.command = command;
	}
	
	private Object action() throws ExecuteValidatorException {
		return this.command.execute();
	}

	private void intergrityValidate(String cmd) throws SyntaxValidatorException {
		String[] cs = cmd.split(Calculator.SPACE);
		if(cs.length==0)
			throw new SyntaxValidatorException("org.cx.game.command.Invoker.intergrityValidate");
	}

}
