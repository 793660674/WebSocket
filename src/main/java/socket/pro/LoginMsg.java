package socket.pro;

public class LoginMsg {
	private int msgCode;
	private Account  messgae;
	public int getMsgCode() {
		return msgCode;
	}
	public void setMsgCode(int msgCode) {
		this.msgCode = msgCode;
	}
	public Account getAccount() {
		return messgae;
	}
	public void setAccount(Account account) {
		this.messgae = account;
	}
	
}
