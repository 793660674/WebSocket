package socket.pro;

import java.math.BigDecimal;

public class Account {
	private int id;//
	private String openid;//微信唯一识别标志
	private String nickname;//昵称
	private String headIcon;//头像地址
	private String city;//城市
	private String createtime;//创建时间
	private String money;//钱数
	private int catheticnum;//下注次数
	private String pandl;//盈亏
	private String phonenum;//手机号码

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getHeadIcon() {
		return headIcon;
	}

	public void setHeadIcon(String headIcon) {
		this.headIcon = headIcon;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getMoney() {
		return money;
	}


	public String getPandl() {
		return pandl;
	}

	public void setPandl(String pandl) {
		this.pandl = pandl;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	
	
	
	public int getCatheticnum() {
		return catheticnum;
	}

	public  void updateMoney(String money){
		//将字符串类型的float 转为 float 类型
		float nowmoney=Float.valueOf(this.money);
		float updateMoney=Float.valueOf(money);
		//四舍五入 保留1位小数
		BigDecimal b = new BigDecimal(updateMoney+nowmoney);
		float f1 = b.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
		this.money=f1+"";
		
		float nowpandl=Float.valueOf(this.pandl);
		BigDecimal bdd = new BigDecimal(updateMoney+nowpandl);
		float Nowpandl = bdd.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
		this.pandl=Nowpandl+"";
		
		this.catheticnum+=1;
	}
	
	
}
