package socket.session;

import java.io.IOException;

import javax.websocket.Session;

import net.sf.json.JSONObject;
import socket.manager.GameSessionManager;
import socket.pro.Messgae;
import socket.util.JsonUtilTool;


public class GameSession {
	/**
	 * IoSession
	 */
	private Session session;
	
	
	private boolean isLogin=false;
	
	/**
	 *
	 */
	private Object role;
	
	
	public GameSession(Session session){
		System.out.println("我创建session了");
		this.session = session;
	}
	
	/**
	 * 发送消息给客户端
	 * @param msg
	 * @return
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public void sendMsg(Messgae msg) throws IOException  {
		if (session == null) {
			//system.out.println("session == "+session+" session.isConnected ==  "+session.isConnected()+" session.isClosing =  "+session.isClosing());
			return;
		}
		
		  this.session.getBasicRemote().sendText(JsonUtilTool.toJson(msg));
	}
	

	/**
	 *
	 * @param isLogin
     */
	public  void setLogin(boolean isLogin){
		this.isLogin=isLogin;
	}

	/**
	 * 是否登录
	 * @return
     */
	public boolean isLogin(){
		return this.isLogin;
	}

	/**
	 * 保存角色信息
	 * @param obj
     */
	public void setRole(Object obj){
		this.role = obj;
	}
	
	@SuppressWarnings("unchecked")
	/**
	 * 得到角色信息
	 */
	public <T> T getRole(Class<T> t){
		return (T)this.role;
	}
}
