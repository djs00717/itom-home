import com.chinadrtv.itom.model.UserInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * Created by djs on 2017/11/18.
 */

public class TestJndi {

    @Test
    public   void jndi() {

        UserInfo u=new UserInfo();
        u.setPassWord("aaa");
        u.setLoginName("nameaaa");




        Configuration ccc=new Configuration().configure();
        SessionFactory sessionFactory=ccc.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction tx=session.beginTransaction();
        session.save(u);
        tx.commit();
        session.close();
        sessionFactory.close();


        System.out.println(u.toString());
    }

    @Test
public void testjj(){
    Connection connOracle = null;
    try {
        //1、初始化名称查找上下文
        Context ctx = new InitialContext();
        //InitialContext ctx = new InitialContext();亦可
        //2、通过JNDI名称找到DataSource,对名称进行定位java:comp/env是必须加的,后面跟的是DataSource名
                /*
                DataSource名在web.xml文件中的<res-ref-name>oracleDataSource</res-ref-name>进行了配置
                 <!--Oracle数据库JNDI数据源引用 -->
                 <resource-ref>
                      <description>Oracle DB Connection</description>
                      <res-ref-name>oracleDataSource</res-ref-name>
                      <res-type>javax.sql.DataSource</res-type>
                      <res-auth>Container</res-auth>
                 </resource-ref>
                */
        DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/OmsDS");
        //3、通过DataSource取得一个连接
        connOracle = ds.getConnection();
        System.out.println("Oracle Connection pool connected !!");
        //4、操作数据库
    } catch (NamingException e) {
        System.out.println(e.getMessage());
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        //5、关闭数据库，关闭的时候是将连接放回到连接池之中
        try {
            connOracle.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

}
