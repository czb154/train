package system.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import system.dao.trainDao;
import system.domain.train;


import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestMybatis {

    @Test
    public void run1() throws  Exception{
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder build = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = build.build(is);
        SqlSession sqlSession = factory.openSession();
        trainDao dao= sqlSession.getMapper(trainDao.class);
     /*   List<train> trains = dao.select();*/

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String s = format.format(new Date());
        Date date1 = format.parse(s);
        System.out.println(s);
        System.out.println(date);
        System.out.println(date1);
        train train1=new train();
        //train1.setTrain_start("广州");
        //train1.setTrain_end("汕头");
        //train1.setTrain_time(date);

        List<train> trains = dao.selectOther(null,s,null,null);
        for (train train2:trains){
            System.out.println(train2);
        }
      /*  UserDao userDao= sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.findAll();
        for (User user:users){
            System.out.println(user.getUsername());
        }
*/

    }
    @Test
    public void run3() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder build = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = build.build(is);
        SqlSession sqlSession = factory.openSession();
   /*     boardDao dao= sqlSession.getMapper(boardDao.class);
        String findboard = dao.findboard();
        System.out.println(findboard);*/


    }
}
