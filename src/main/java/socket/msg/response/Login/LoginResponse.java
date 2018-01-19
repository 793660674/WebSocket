package socket.msg.response.Login;

import java.io.IOException;

import socket.context.ConnectAPI;
import socket.pro.LoginMsg;
import socket.pro.Messgae;
import socket.session.GameSession;


public class LoginResponse{
	public LoginResponse(GameSession gameSession,LoginMsg message) {
		try {
			message.setMsgCode(ConnectAPI.LOGIN_RESPONSE);
			gameSession.sendMsg(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
