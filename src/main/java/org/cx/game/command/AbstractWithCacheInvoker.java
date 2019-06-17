package org.cx.game.command;

import org.cx.game.command.exception.SyntaxValidatorException;
import org.cx.game.command.expression.Calculator;
import org.cx.game.validator.exception.ValidatorException;
import org.dom4j.Element;

public abstract class AbstractWithCacheInvoker implements IInvoker {
	
	protected String response = "";
	
	private AbstractCommand command = null;
	protected ICommandBuffer buffer = null;
	
	public AbstractWithCacheInvoker(ICommandBuffer buffer) {
		// TODO Auto-generated constructor stub
		this.buffer = buffer;
	}
	
	private void setCommand(AbstractCommand command) {
		this.command = command;
	}
	
	private Object action() throws ValidatorException {
		return this.command.execute();
	}
	
	public String getResponse() {		
		return response;
	}

	/*
	 * 命令处理完成后执行
	 */
	protected abstract void afterHandle();
	
	private void intergrityValidate(String cmd) throws SyntaxValidatorException {
		String[] cs = cmd.split(Calculator.SPACE);
		if(cs.length==0)
			throw new SyntaxValidatorException("org.cx.game.command.Invoker.intergrityValidate");
	}
	
	protected synchronized Object handleCommand(String cmd, Element cmdEl) throws ValidatorException {
		try {
			intergrityValidate(cmd);    //验证命令完整性
			
			for(String c : cmd.split(";")){
				AbstractCommand command = CommandFactory.getInstance(c, cmdEl, buffer);
				setCommand(command);
				Object result = action();
				if(null!=result)
					return result;
			}
			
			buffer.cleanParameter();     //清空缓存参数
		} catch (ValidatorException e) {
			// TODO: handle exception
			throw e;
		} finally {
			afterHandle();
		}
		
		return null;
	}
}
