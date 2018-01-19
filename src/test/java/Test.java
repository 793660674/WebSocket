import java.math.BigDecimal;

public class Test {
	public static void main(String[] args) {
		String money="-"+"100.5";
		float nowmoney=Float.valueOf(money);
		String uodate="0.5";
		float updateMoney=Float.valueOf(uodate);
		BigDecimal b = new BigDecimal(updateMoney+nowmoney);
		float f1 = b.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
		System.out.println(0.5*10);
		
		
		
	}
}
