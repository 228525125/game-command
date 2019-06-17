package org.cx.game.command.bind;

/**
 * 自动绑定的对象需要实现该接口
 * @author admin
 *
 */
public interface IBinding {

	/**
	 * 用于识别绑定对象的标记
	 * @return
	 */
	public Object getBid();
}
