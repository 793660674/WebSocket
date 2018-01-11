package socket.msg.request.login;

import socket.common.INotAuthProcessor;
import socket.common.MsgProcessor;
import socket.manager.GameSessionManager;
import socket.msg.response.LoginResponse;
import socket.session.GameSession;
import socket.util.JsonUtilTool;
import socket.pro.Messgae;
public class LoginMsgProcessor extends MsgProcessor implements INotAuthProcessor{
	LoginResponse LoginResponse;
	@Override
	public  void process(GameSession gameSession, String Message)
			throws Exception {
		Messgae message=JsonUtilTool.fromJson(Message, Messgae.class);
		gameSession.setRole(message);
		LoginResponse=new LoginResponse(gameSession, message);
	}
}
