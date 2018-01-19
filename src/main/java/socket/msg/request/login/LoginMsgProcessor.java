package socket.msg.request.login;


import com.alibaba.fastjson.JSON;

import socket.common.INotAuthProcessor;
import socket.common.MsgProcessor;
import socket.myBatis.services.AccountService;
import socket.session.GameSession;
import socket.util.JsonUtilTool;
import socket.pro.Account;
import socket.pro.LoginMsg;
import socket.pro.Messgae;
import socket.msg.response.Login.LoginResponse;
public class LoginMsgProcessor extends MsgProcessor implements INotAuthProcessor{
	LoginResponse LoginResponse;
	@Override
	public  void process(GameSession gameSession, String Message)
			throws Exception {
		LoginMsg loginMsg=new LoginMsg();
		Messgae message=JSON.parseObject(Message,Messgae.class);
		Account account=JSON.parseObject(message.getMessgae(),Account.class);
		account=AccountService.getInstance().selectAccountByOpenid(account.getOpenid());
		if (account!=null) {
			gameSession.setRole(account);
			loginMsg.setAccount(account);
			LoginResponse=new LoginResponse(gameSession, loginMsg);
		}else {
			System.out.println("出错了");
		}
	}
}
