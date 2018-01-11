package socket.msg.response;

import java.io.IOException;

import socket.context.ConnectAPI;
import socket.pro.Messgae;
import socket.session.GameSession;


public class LoginResponse{
	public LoginResponse(GameSession gameSession,Messgae message) {
		try {
			message.setMsgCode(ConnectAPI.LOGIN_RESPONSE);
			gameSession.sendMsg(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
