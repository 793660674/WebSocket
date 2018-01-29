package socket.msg.request.bangding;

import com.alibaba.fastjson.JSON;

import socket.common.INotAuthProcessor;
import socket.common.MsgProcessor;
import socket.msg.response.Login.PasswordLoginResponse;
import socket.msg.response.bangding.BangDingResponse;
import socket.myBatis.services.AccountService;
import socket.pro.Account;
import socket.pro.BangDing;
import socket.pro.Messgae;
import socket.session.GameSession;
public class BangDIngMsgProcessor extends MsgProcessor implements INotAuthProcessor{
	BangDingResponse BangDingResponse;
	@Override
	public  void process(GameSession gameSession, String Message)
			throws Exception {
		BangDing bangding=new BangDing();
		Messgae message=JSON.parseObject(Message,Messgae.class);
		Account account=JSON.parseObject(message.getMessgae(),Account.class);
		if (account!=null) {
			bangding.setBangding(true);
			Account acco=gameSession.getRole(Account.class);
			acco.setPhonenum(account.getPhonenum());
			acco.setPassword(account.getPassword());
			AccountService.getInstance().updateAccount(acco);
			BangDingResponse=new BangDingResponse(gameSession, bangding);
		}else {
			bangding.setBangding(false);
			BangDingResponse=new BangDingResponse(gameSession, bangding);
		}
	}
}
