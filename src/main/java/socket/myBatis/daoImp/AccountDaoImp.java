package socket.myBatis.daoImp;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import socket.myBatis.dao.AccountMapper;
import socket.pro.Account;
import socket.pro.Cathectic;


/**
 * Created by kevin on 2016/6/21.
 */
public class AccountDaoImp implements AccountMapper {
    private SqlSessionFactory sqlSessionFactory;
    public AccountDaoImp(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
	@Override
	public int deleteByExample(String id) {
		 int flag = 0;
	        SqlSession sqlSession = sqlSessionFactory.openSession();
	        try {
	            AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
	            flag = mapper.deleteByExample(id);
	            sqlSession.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally {
	            sqlSession.close();
	        }
		return flag;
	
	}
	@Override
	public int updateAccount(Account account) {
		 int flag = 0;
	        SqlSession sqlSession = sqlSessionFactory.openSession();
	        try {
	            AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
	            flag = mapper.updateAccount(account);
	            sqlSession.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally {
	            sqlSession.close();
	        }
		return flag;
	
	
	}
	@Override
	public int insetcathectic(Cathectic cathectic) {

		 int flag = 0;
	        SqlSession sqlSession = sqlSessionFactory.openSession();
	        try {
	            AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
	            flag = mapper.insetcathectic(cathectic);
	            sqlSession.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally {
	            sqlSession.close();
	        }
		return flag;
	}
	@Override
	public Account selectAccountByOpenid(String openid) {
		Account flag = null ;
	        SqlSession sqlSession = sqlSessionFactory.openSession();
	        try {
	            AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
	            flag = mapper.selectAccountByOpenid(openid);
	            sqlSession.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally {
	            sqlSession.close();
	        }
		return flag;
	}

}
