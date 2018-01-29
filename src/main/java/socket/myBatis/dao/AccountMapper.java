package socket.myBatis.dao;

import socket.pro.Account;
import socket.pro.Cathectic;

public interface AccountMapper {
    int deleteByExample(String id);
    
    int updateAccount(Account account);

    int insetcathectic(Cathectic cathectic);
    
    Account selectAccountByOpenid(String openid);
    
    
    Account selectAccountByPassword(Account account);
    
}