package socket.common;


import socket.pro.Messgae;
import socket.session.GameSession;
import socket.util.JsonUtilTool;

import java.util.HashMap;
import java.util.Map;

/**
 * 消息分发器，根据消息号，找到相应的消息处理器
 * @author kevin
 *
 */
public class MsgDispatcher {

	
	private Map<Integer, MsgProcessor> processorsMap = new HashMap<Integer, MsgProcessor>();
	
	public MsgDispatcher(){
		for(MsgProcessorRegister register :MsgProcessorRegister.values()){
			processorsMap.put(register.getMsgCode(), register.getMsgProcessor());
		}
		System.out.println("初始化 消息处理器成功。。。");
	}

	/**
	 * 通过协议号得到MsgProcessor
	 * @param msgCode
	 * @return
     */
	public MsgProcessor getMsgProcessor(int msgCode){
		return processorsMap.get(msgCode);
	}

	/**
	 * 派发消息协议
	 * @param gameSession
	 * @param clientRequest
     */
	public void dispatchMsg(GameSession gameSession,String message) {
		int msgCode=JsonUtilTool.fromJson(message, Messgae.class).getMsgCode();
		MsgProcessor processor = getMsgProcessor(msgCode);
		if(processor instanceof INotAuthProcessor){
			processor.handle(gameSession, message);
		}
		
	}

}
