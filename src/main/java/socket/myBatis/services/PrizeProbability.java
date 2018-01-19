package socket.myBatis.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import socket.pro.Prize;


/**
 * 奖品概率  
 * @author luck
 *
 */
public  abstract class PrizeProbability {

	public static List<Integer> prizeList = new ArrayList<Integer>();
	public static  HashMap<Integer, String> prizesMap=new HashMap<>();
	
	/**
	 * 初始化奖品概率
	 */
	public  static void initPrizesProbability(){
		 List<Prize> prizes = PrizeService.getInstance().selectAllPrizes();
		for (Prize prize : prizes) {
			prizesMap.put(prize.getId(), prize.getMoney());
			 for (int i = 0; i < prize.getProbability(); i++) {
				 prizeList.add(prize.getId());
			}
		}
		Collections.shuffle(prizeList);
	}
	/**
	 * 修改奖品概率之后更新
	 */
	public  synchronized  static void updatePrizesProbability(){
		prizeList.clear();
		initPrizesProbability();
	} 
}
