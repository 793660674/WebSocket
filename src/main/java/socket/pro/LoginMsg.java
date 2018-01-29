package socket.pro;

public class LoginMsg {
	private int msgCode;
	private Account  messgae;
	private boolean login=false;
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
	public boolean isLogin() {
		return login;
	}
	public void setLogin(boolean login) {
		this.login = login;
	}
	
}
