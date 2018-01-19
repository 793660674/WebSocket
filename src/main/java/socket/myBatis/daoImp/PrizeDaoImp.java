package socket.myBatis.daoImp;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import socket.myBatis.dao.AccountMapper;
import socket.myBatis.dao.PrizeMapper;
import socket.pro.Account;
import socket.pro.Cathectic;
import socket.pro.Prize;


/**
 * Created by kevin on 2016/6/21.
 */
public class PrizeDaoImp implements PrizeMapper {
    private SqlSessionFactory sqlSessionFactory;
    public PrizeDaoImp(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
	@Override
	public List<Prize> selectAllPrizes() {
		List<Prize> flag = null ;
	        SqlSession sqlSession = sqlSessionFactory.openSession();
	        try {
	        	PrizeMapper mapper = sqlSession.getMapper(PrizeMapper.class);
	            flag = mapper.selectAllPrizes();
	            sqlSession.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally {
	            sqlSession.close();
	        }
		return flag;
	
	}
}
