package socket.msg.request.Cathectic;


import socket.common.INotAuthProcessor;
import socket.common.MsgProcessor;
import socket.msg.response.Cathectic.CathecticResponse;
import socket.myBatis.services.AccountService;
import socket.myBatis.services.PrizeProbability;
import socket.session.GameSession;
import socket.util.JsonUtilTool;
import socket.util.TjUtil;
import socket.pro.Account;
import socket.pro.CatheRes;
import socket.pro.CatheResMsg;
import socket.pro.Cathectic;
import socket.pro.LoginMsg;
import socket.pro.Messgae;
public class CathecticMsgProcessor extends MsgProcessor implements INotAuthProcessor{
	CathecticResponse cathecticResponse;
	@Override
	public  void process(GameSession gameSession, String Message)
			throws Exception {
		Messgae message=JsonUtilTool.fromJson(Message, Messgae.class);
		//获取下注钱数
		String updateMoeny=(String) message.getMessgae();
		float xiazhumoeny=Float.valueOf(updateMoeny);
		
		//获取个人信息
		Account account=gameSession.getRole(Account.class);
		
		if (xiazhumoeny>Float.valueOf(account.getMoney())) {
			System.out.println("这是个杂种，在破坏");
			return;
		}
		
		System.out.println(account.getNickname()+"下注钱数"+updateMoeny);
		
		System.out.println(account.getNickname()+"当前余额"+account.getMoney());
		int randomNum = (int)Math.floor(Math.random()*100);
		//如果总盈亏是大于0的 那么不论是新用户还是老用户 中奖率都降低1成
		if (Float.valueOf(account.getPandl())>0) {
			randomNum+=10;
			System.out.println(account.getNickname()+"当前处于赢钱状态，概率降低10%");
		}else {
			randomNum-=10;
			System.out.println(account.getNickname()+"当前处于输钱状态，概率增加10%");
		}
		//回调对象
		CatheRes catheRes=new CatheRes();
		//下注对象创建 插入数据库
		Cathectic cathectic=new Cathectic();
		cathectic.setCreatetime(TjUtil.getCurrentDateTime());
		cathectic.setUserid(account.getId());
		cathectic.setMoney(updateMoeny);
		if (account.getCatheticnum()>5000) {
			//老用户 下注超过5000次 暂定35%
			if (randomNum<35) {
				System.out.println("我赢了");
				cathectic.setIswin(1);
				//随机生成0-9999 的数字 查询对应的奖励金额
				int random = (int)Math.floor(Math.random()*(PrizeProbability.prizeList.size()-1));
				int prizeId = PrizeProbability.prizeList.get(random);
				String money=PrizeProbability.prizesMap.get(prizeId);
				//获取 下注倍数
				int beishu=(int)(xiazhumoeny/0.5);
				System.out.println("老用户"+account.getNickname()+"下注倍数"+beishu);
				//获取下注倍数对应的奖励金额
				float updateMoenyfloat=Float.valueOf(money)*beishu;
				//这次下注 需要在下注表中 添加盈亏
				cathectic.setPandl((updateMoenyfloat-xiazhumoeny)+"");
				
				//修改余额和 盈亏及下注次数
				account.updateMoney(""+(updateMoenyfloat-xiazhumoeny));
				AccountService.getInstance().updateAccount(account);
				//修改回调对象的参数
				catheRes.setJiangjin(updateMoenyfloat+"");
				catheRes.setJiangpinid(prizeId+"");
				catheRes.setNowmoney(account.getMoney());
				System.out.println("奖金"+updateMoenyfloat);
			}else {
				System.out.println("我输了");
				//这次下注 需要在下注表中 添加盈亏
				cathectic.setPandl("-"+updateMoeny);
				//失败  直接扣除余额  同时也修改了 盈亏和 下注次数
				account.updateMoney("-"+updateMoeny);
				AccountService.getInstance().updateAccount(account);
				//修改回调对象的参数
				catheRes.setJiangjin("0");
				catheRes.setJiangpinid("-1");
				catheRes.setNowmoney(account.getMoney());
				System.out.println("奖金-"+updateMoeny);
			}
		} else {
			//新用户  中奖概率暂定70%
			if (randomNum<100) {
				//随机生成0-9999 的数字 查询对应的奖励金额
				int random = (int)Math.floor(Math.random()*(PrizeProbability.prizeList.size()-1));
				int prizeId = PrizeProbability.prizeList.get(random);
				String money=PrizeProbability.prizesMap.get(prizeId);
				//获取 下注倍数
				int beishu=(int)(xiazhumoeny/0.5);
				System.out.println("新用户"+account.getNickname()+"下注倍数"+beishu);
				//获取下注倍数对应的奖励金额
				float updateMoenyfloat=Float.valueOf(money)*beishu;
				//这次下注 需要在下注表中 添加盈亏
				cathectic.setPandl((updateMoenyfloat-xiazhumoeny)+"");
				//修改余额和 盈亏及下注次数
				account.updateMoney(""+(updateMoenyfloat-xiazhumoeny));
				AccountService.getInstance().updateAccount(account);
				//修改回调对象的参数
				catheRes.setJiangjin(updateMoenyfloat+"");
				catheRes.setJiangpinid(prizeId+"");
				catheRes.setNowmoney(account.getMoney());
				System.out.println("奖金"+updateMoenyfloat);
			}else {
				//这次下注 需要在下注表中 添加盈亏
				cathectic.setPandl("-"+updateMoeny);
				//失败  直接扣除余额  同时也修改了 盈亏和 下注次数
				account.updateMoney("-"+updateMoeny);
				AccountService.getInstance().updateAccount(account);
				//修改回调对象的参数
				//修改回调对象的参数
				catheRes.setJiangjin("0");
				catheRes.setJiangpinid("-1");
				catheRes.setNowmoney(account.getMoney());
				System.out.println("奖金-"+updateMoeny);
			}
		}
		//添加至下注表  cathectic对象
		AccountService.getInstance().insetcathectic(cathectic);
		//给客户端发送最新的奖励金额 和对应的中间id
		CatheResMsg catheResMsg=new CatheResMsg();
		catheResMsg.setMessgae(catheRes);
		System.out.println(account.getNickname()+"下注后修改的余额"+account.getMoney());
		cathecticResponse=new CathecticResponse(gameSession, catheResMsg);
	}
	
	
}
