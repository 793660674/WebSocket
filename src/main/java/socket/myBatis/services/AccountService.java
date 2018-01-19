package socket.myBatis.services;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import socket.myBatis.dao.AccountMapper;
import socket.myBatis.daoImp.AccountDaoImp;
import socket.pro.Account;
import socket.pro.Cathectic;


/**
 * Created by kevin on 2016/6/21.
 */
public class AccountService {
    private AccountMapper accMap;

    private static AccountService accountService = new AccountService();

    public static AccountService getInstance(){
        return accountService;
    }

    public void initSetSession(SqlSessionFactory sqlSessionFactory){
        accMap = new AccountDaoImp(sqlSessionFactory);
    }


    public void deleteByExample(String id){
        try {
            accMap.deleteByExample(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void updateAccount(Account account){
        try {
            accMap.updateAccount(account);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    
    public void insetcathectic(Cathectic cathectic){
        try {
            accMap.insetcathectic(cathectic);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    
    public Account selectAccountByOpenid(String openid){
        try {
           Account account= accMap.selectAccountByOpenid(openid);
           return account;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}