package system.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import system.domain.train;
import system.service.trainService;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestSpring {
    @Test
    public void run1(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        trainService trainservice = (trainService)ac.getBean("trainService");
        List<train> trains = trainservice.select();
        for (train train1:trains){
            System.out.println(train1);
        }
        //UserService us = (UserService) ac.getBean("userService");


    }

    @Test
    public void run2() throws ParseException {

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = format.format(new Date());
        System.out.println(s);
        System.out.println(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println(format.parse(format.format(date)));
    }
    @Test
    public void run3(){
      /*  boardServiceImpl service = new boardServiceImpl();
        System.out.println(service.findboard());*/

    }
}
