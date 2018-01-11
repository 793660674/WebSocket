package socket.bootstrap;

import java.io.IOException;


import socket.common.MsgDispatcher;

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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
