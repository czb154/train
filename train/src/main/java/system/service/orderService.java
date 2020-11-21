package system.service;


import system.domain.Order;
import system.domain.User;
import system.domain.train;

import java.util.List;

public interface orderService {
    void insertOrder(User user, train train1, String  order_id, Integer order_number);

    List<Order> findtrains(User user);
}
