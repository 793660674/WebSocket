package socket.manager;


import java.util.*;

import javax.websocket.Session;

import socket.session.GameSession;

/**
 * Created by kevin on 2016/6/20.
 */
public class GameSessionManager {

    public Map<Session,GameSession> sessionMap = new HashMap<Session,GameSession>();
    
    public static int topOnlineAccountCount = 0;
    
    private static GameSessionManager gameSessionManager;

    public GameSessionManager(){

    }

    /**
     *
     * @return
     */
    public static GameSessionManager getInstance(){
        if(gameSessionManager == null){
            gameSessionManager = new GameSessionManager();
        }
        return gameSessionManager;
    }

    /**
     * 存放GAMESESSION
     * @param gameSession
     * @return
     */
    public boolean putGameSessionInHashMap(GameSession gameSession,Session session){
        //Avatar avatar = gameSession.getRole(Avatar.class);
        boolean result = checkSessionIsHava(session);
        //System.out.println(" result ==> "+result);
        if(!result){
        	//System.out.println("denglu");
            sessionMap.put(session,gameSession);
            if(sessionMap.size() > topOnlineAccountCount){
            	topOnlineAccountCount = sessionMap.size();
            }
        }
        return !result;
    }

    public int getVauleSize(){
        return sessionMap.size();
    }

//    /**
//     * 通过用户得到session
//     * @param avatar
//     * @return
//     */
//    public GameSession getGameSessionFromHashMap(Avatar avatar){
//        return sessionMap.get("uuid_"+avatar.getUuId());
//    }
    /**
     *
     * @param
     * @return
     */
    public GameSession getGameSessionBySession(Session session){
        return sessionMap.get(session);
    }
//    /**
//     *
//     * @param avatar
//     */
//    public void removeGameSession(Avatar avatar){
//        //System.out.println("removeForMap");
//        GameSession gameSession =  sessionMap.get("uuid_"+avatar.getUuId());
//        if(gameSession != null){
//        	GameServerContext.remove_offLine_Character(avatar);
//        	GameServerContext.remove_onLine_Character(avatar);
//        	sessionMap.remove("uuid_"+avatar.getUuId());
//        	avatar = null;
//        }
//    }

    public List<GameSession> getAllSession(){
        List<GameSession> result = null;
        if(getVauleSize() >0) {
            result = new ArrayList<GameSession>();
            Collection<GameSession> connection = sessionMap.values();
            Iterator<GameSession> iterator = connection.iterator();
            while (iterator.hasNext()) {
                result.add(iterator.next());
            }
        }
        return result;
    }

    /**
     * 检测用户session是否存在
     * @param uuid
     * @return
     */
    public boolean checkSessionIsHava(Session session){
    	//可以用来判断是否在线****等功能
        GameSession gameSession = sessionMap.get(session);
        if(gameSession != null){
            return true;
        }
        return false;
    }

}
