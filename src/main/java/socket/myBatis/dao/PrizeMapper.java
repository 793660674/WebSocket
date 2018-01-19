package socket.myBatis.dao;

import java.util.List;

import socket.pro.Prize;


public interface PrizeMapper {
    /**
     * 获取所有的奖品信息
     * @return
     */
    List<Prize> selectAllPrizes();
}