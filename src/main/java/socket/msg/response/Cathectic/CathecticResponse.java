package socket.msg.response.Cathectic;

import java.io.IOException;

import socket.context.ConnectAPI;
import socket.pro.CatheRes;
import socket.pro.CatheResMsg;
import socket.pro.LoginMsg;
import socket.pro.Messgae;
import socket.session.GameSession;


public class CathecticResponse{
	public CathecticResponse(GameSession gameSession,CatheResMsg message) {
		try {
			message.setMsgCode(ConnectAPI.CATHECTIC_RESPONSE);
			gameSession.sendMsg(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
