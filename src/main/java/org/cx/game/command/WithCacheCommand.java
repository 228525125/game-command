package org.cx.game.command;

public class WithCacheCommand extends AbstractCommand {

	protected ICommandBuffer buffer;
	
	public WithCacheCommand(ICommandBuffer buffer) {
		super();
		// TODO Auto-generated constructor stub
		this.buffer = buffer;
	}
}
