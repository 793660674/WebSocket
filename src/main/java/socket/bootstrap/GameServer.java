package socket.bootstrap;

import java.io.IOException;


import socket.common.MsgDispatcher;
import socket.myBatis.services.InitServers;
import socket.myBatis.services.PrizeProbability;

public class GameServer {

	private static GameServer instance = new GameServer();
	public static MsgDispatcher msgDispatcher = new MsgDispatcher();;

	public static GameServer getInstance() {
		return instance;
	}

	public static void main(String[] args) throws IOException {
		startUp();
	}

	public static void startUp() {
		try {
			//链接数据库
			InitServers.getInstance().initServersFun();
			//初始化中奖概率
			PrizeProbability.initPrizesProbability();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
