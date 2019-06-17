package org.cx.game.command.bind;

/**
 * 绑定信息，用于服务端和客户端对象间建立对象关系
 * @author admin
 *
 */
public interface IIdentification {

	/**
	 * 查询绑定器
	 * @return
	 */
	public IBinder<?> getBinder();
	
	/**
	 * 绑定对象识别信息
	 * @return
	 */
	public Object getIdentify();
}
