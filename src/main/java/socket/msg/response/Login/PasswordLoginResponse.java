package socket.msg.response.Login;

import java.io.IOException;

import socket.context.ConnectAPI;
import socket.pro.BangDing;
import socket.pro.LoginMsg;
import socket.session.GameSession;


public class PasswordLoginResponse{
	public PasswordLoginResponse(GameSession gameSession,LoginMsg loginMsg) {
		try {
			loginMsg.setMsgCode(ConnectAPI.PHONELOGIN_RESPONSE);
			gameSession.sendMsg(loginMsg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
