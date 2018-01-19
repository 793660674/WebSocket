package socket.myBatis.services;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Created by kevin on 2016/6/17.
 */
public class InitServers {



    public void initServersFun() throws IOException {
        Reader reader = Resources.getResourceAsReader("myBatisConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //===============================================================
        AccountService.getInstance().initSetSession(sessionFactory);
        PrizeService.getInstance().initSetSession(sessionFactory);
    }

    private static InitServers initServers = new InitServers();

    public static InitServers getInstance(){
        return initServers;
    }
}
