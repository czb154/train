package system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import system.dao.orderDao;
import system.domain.Order;
import system.domain.User;
import system.domain.train;
import system.service.orderService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service("orderService")
public class orderServiceImpl implements orderService {

    @Autowired
    orderDao orderdao;
    @Override
    public void insertOrder(User user, train train1, String order_id, Integer order_number) {



        Date date=new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String s = format.format(new Date());
        orderdao.insertOrder(order_id,user.getUser_id(),train1.getTrain_id(),s,order_number,order_number*train1.getTrain_price());

    }

    @Override
    public List<Order> findtrains(User user) {
        return orderdao.findtrains(user);
    }
}
