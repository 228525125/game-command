package org.cx.game.command.expression;

import org.cx.game.command.AbstractCommand;
import org.cx.game.command.ICommandBuffer;
import org.cx.game.command.WithCacheCommand;
import org.cx.game.command.exception.SyntaxValidatorException;
import org.dom4j.Element;

public class Calculator {

	public static final String SPACE = " ";
	
	public AbstractCommand parseForCommand(String cmd, Element root) throws SyntaxValidatorException {
		AbstractCommand command = null;
		
		SimpleCommandExpression commandExpriession = new SimpleCommandExpression(cmd, root);   //默认第一个字段为command
		command = commandExpriession.interpreter();

		if(commandExpriession.getParamRequest()){
			ParameterExpression parameterExpression = ParameterExpressionFactory.getInstance(cmd, commandExpriession.getCommandElement()); //默认第二个字段为参数
			Object parameter = parameterExpression.interpreter();
			command.setParameter(parameter);
		}
		return command;
	}
	
	public WithCacheCommand parseForCommand(String cmd, Element root, ICommandBuffer buffer) throws SyntaxValidatorException {
		WithCacheCommand command = null;
		
		WithCacheCommandExpression commandExpriession = new WithCacheCommandExpression(cmd, root, buffer);   //默认第一个字段为command
		command = commandExpriession.interpreter();

		if(commandExpriession.getParamRequest()){
			ParameterExpression parameterExpression = ParameterExpressionFactory.getInstance(cmd, commandExpriession.getCommandElement(), buffer); //默认第二个字段为参数
			Object parameter = parameterExpression.interpreter();
			command.setParameter(parameter);
		}
		return command;
	}
}
