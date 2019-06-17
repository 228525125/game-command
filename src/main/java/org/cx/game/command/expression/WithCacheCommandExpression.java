package org.cx.game.command.expression;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.cx.game.command.ICommandBuffer;
import org.cx.game.command.WithCacheCommand;
import org.cx.game.command.exception.SyntaxValidatorException;
import org.cx.game.command.tools.XmlUtil;
import org.dom4j.Element;

public class WithCacheCommandExpression extends CommandExpression {

	private ICommandBuffer buffer = null;
	
	public WithCacheCommandExpression(String cmd, Element root, ICommandBuffer buffer) {
		super(cmd, root);
		// TODO Auto-generated constructor stub
		this.buffer = buffer;
	}	

	@Override
	public WithCacheCommand interpreter() throws SyntaxValidatorException {
		// TODO Auto-generated method stub
		super.interpreter();
		
		WithCacheCommand ret = null;
		
		try {
			Class clazz = Class.forName(getCommandElement().attribute(XmlUtil.Command_Command_Class).getText());
			Constructor<WithCacheCommand> c = clazz.getDeclaredConstructor(new Class[]{ICommandBuffer.class});
			ret = c.newInstance(buffer);
			
			if(null!=getCommandElement().attribute(XmlUtil.Command_Command_Parameter) && XmlUtil.Command_Command_Parameter_Request.equals(getCommandElement().attribute(XmlUtil.Command_Command_Parameter).getText())){
				setParamRequest(true);
			}else{
				setParamRequest(false);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

}
