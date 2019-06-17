package org.cx.game.command.bind;

import java.util.Map;

public interface IBinder<T> {
	
	/**
	 * 生成绑定对象的唯一身份标识
	 * @param t 被绑定对象
	 * @return 绑定对象识别信息
	 */
	public IIdentification generateIdentification(T t);
	
	/**
	 * 根据绑定对象的身份信息查找绑定对象
	 * @param playNo 游戏ID
	 * @param identify 识别信息，与generateIdentification生成的内容有关
	 * @return 绑定对象
	 */
	public T getObject(String playNo, Object identify);

}
