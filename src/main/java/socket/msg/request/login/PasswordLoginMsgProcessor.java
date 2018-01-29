package socket.msg.request.login;


import com.alibaba.fastjson.JSON;

import socket.common.INotAuthProcessor;
import socket.common.MsgProcessor;
import socket.msg.response.Login.PasswordLoginResponse;
import socket.myBatis.services.AccountService;
import socket.pro.Account;
import socket.pro.LoginMsg;
import socket.pro.Messgae;
import socket.session.GameSession;
public class PasswordLoginMsgProcessor extends MsgProcessor implements INotAuthProcessor{
	PasswordLoginResponse PasswordLoginResponse;
	@Override
	public  void process(GameSession gameSession, String Message)
			throws Exception {
		LoginMsg loginMsg=new LoginMsg();
		Messgae message=JSON.parseObject(Message,Messgae.class);
		Account account=JSON.parseObject(message.getMessgae(),Account.class);
		account=AccountService.getInstance().selectAccountByPassword(account);
		if (account!=null) {
			gameSession.setRole(account);
			loginMsg.setAccount(account);
			loginMsg.setLogin(true);
			PasswordLoginResponse=new PasswordLoginResponse(gameSession, loginMsg);
		}else {
			loginMsg.setAccount(null);
			loginMsg.setLogin(false);
			PasswordLoginResponse=new PasswordLoginResponse(gameSession, loginMsg);
		}
	}
}
