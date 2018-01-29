package socket.msg.response.bangding;

import java.io.IOException;

import socket.context.ConnectAPI;
import socket.pro.BangDing;
import socket.pro.LoginMsg;
import socket.pro.Messgae;
import socket.session.GameSession;


public class BangDingResponse{
	public BangDingResponse(GameSession gameSession,BangDing BangDing) {
		try {
			BangDing.setMsgCode(ConnectAPI.BANGDING_RESPONSE);
			gameSession.sendMsg(BangDing);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
