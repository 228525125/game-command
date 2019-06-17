package org.cx.game.command;

public interface ICommandBuffer {

	void set(Object object);

	Object get();

	void backspace();

	void clean();

	void cleanParameter();

	void setParameter(String parameterName, Object parameter);

	Object getParameter(String parameterName);

}