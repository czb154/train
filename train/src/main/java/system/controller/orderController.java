package system.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import system.domain.OldOrder;
import system.domain.Order;
import system.domain.User;
import system.domain.train;
import system.service.orderService;
import system.service.trainService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/order")
public class orderController {

    @Autowired
    trainService trainservice;

    @Autowired
    orderService orderservice;
    @RequestMapping("/orderview")
    public String order(HttpSession session, @Param("train_id") String train_id){
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
    @RequestMapping("/orderdeal")
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

        orderservice.insertOrder(user,train1,order_id1,order_number);

        session.setAttribute("msg_order","恭喜你，购票成功");

        return "order";

    }


    @RequestMapping("/oldorderview")
    public String oldorderview(HttpSession session){
        User user=new User();
        Object user1 = session.getAttribute("user");
        if(user1!=null){
            user=(User)user1;
        }




        List<Order> orders= orderservice.findtrains(user);

        List<OldOrder> oldOrders=new ArrayList<OldOrder>() ;

        for(Order order:orders){
            OldOrder oldOrder=new OldOrder();
            oldOrder.setOrder_id(order.getOrder_id());

            train train=trainservice.selectByTrain_id(order.getTrain_id());
            oldOrder.setTrain(train);
            oldOrder.setOrder_number(order.getOrder_number());
            oldOrders.add(oldOrder);

        }
        session.setAttribute("oldorders",oldOrders);

        return "oldorder";

    }
}
