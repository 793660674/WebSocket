package socket.common;


import socket.session.GameSession;


public abstract class MsgProcessor {
	
	
	public void handle(GameSession gameSession,String message){
		try {
			process(gameSession,message);
		} catch (Exception e) {
			System.out.println("消息处理出错，msg code:"+message);
			e.printStackTrace();
		}
	}
	
	public abstract void process(GameSession gameSession,String message)throws Exception;
}
