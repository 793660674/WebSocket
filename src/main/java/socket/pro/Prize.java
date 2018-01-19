package socket.pro;

public class Prize {
	private int id;
	private int prize_name;
	private int probability;
	private String money;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrize_name() {
		return prize_name;
	}

	public void setPrize_name(int prize_name) {
		this.prize_name = prize_name;
	}

	public int getProbability() {
		return probability;
	}

	public void setProbability(int probability) {
		this.probability = probability;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

}
