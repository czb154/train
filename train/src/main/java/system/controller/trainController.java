package system.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import system.domain.PageBean;
import system.domain.User;
import system.domain.train;
import system.service.trainService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/train")
public class trainController {

    @Autowired
    trainService trainservice;



    @RequestMapping("/selectOther1")
    public String selectOther1(HttpSession session, @Param("train_time")String train_time, @Param("train_start") String train_start,
                              @Param("train_end") String train_end,@Param("train_type")String train_type,
                              @Param("currentPage")Integer currentPage,@Param("row") Integer row){
        System.out.println("select otherr");
        // System.out.println(train1);
        System.out.println(train_time);
        System.out.println(train_start);
        System.out.println(train_type);

        if(train_time!=null && train_time!="")session.setAttribute("train_time",train_time);
        if(train_start!=null && train_start!="") session.setAttribute("train_start",train_start);
        if(train_end!=null&& train_end!="")session.setAttribute("train_end",train_end);
        if(train_type!=null && train_type!="")session.setAttribute("train_type",train_type);
        if (currentPage==null||currentPage<=0)currentPage=1;
        if (row==null||row<=0 )row=5;
        PageBean<train> pb = trainservice.selectPB(train_time, train_start, train_end, train_type, currentPage, row);
        //List<train> trains = trainservice.selectOther(train_time, train_start, train_end, train_type);
        //session.setAttribute("trains",trains);
        session.setAttribute("pb",pb);
        System.out.println(pb);
        return  "TrainList";
    }

    @RequestMapping("/order")
    public String order(HttpSession session,@Param("train_id") String train_id){
        train train = trainservice.selectByTrain_id(train_id);
        User user=new User();
        Object user1 = session.getAttribute("user");
        if(user1!=null){
            user=(User)user1;
        }
        String order_id="12306"+System.currentTimeMillis();
        session.setAttribute("order_id",order_id);
       session.setAttribute("train",train);
       //
        return "order";
    }
    @RequestMapping("/order1")
    public String order1(HttpSession session,Integer order_number){
        User user=new User();
        Object user1 = session.getAttribute("user");
        if(user1!=null){
            user=(User)user1;
        }


        train train1=new train();
        Object train = session.getAttribute("train");
        if(train!=null){
            train1=(train)train;
        }
        String order_id1=null;
        Object order_id = session.getAttribute("order_id");
        if(order_id!=null){
            order_id1=(String)order_id;
        }


        return "order1";

    }

}
