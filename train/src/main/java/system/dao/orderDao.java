package system.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import org.springframework.stereotype.Repository;
import system.domain.Order;
import system.domain.User;

import java.util.List;

@Repository
public interface orderDao {

    @Insert("insert into train_order values(#{order_id},#{user_id},#{train_id},#{s},#{order_number},#{summoney})")
    void insertOrder(@Param("order_id") String order_id, @Param("user_id") String user_id,
                     @Param("train_id") String train_id,@Param("s") String s, @Param("order_number") Integer order_number,
                     @Param("summoney") Integer i);

    @Select("select * from train_order where user_id=#{user_id}")
    List<Order> findtrains(User user);
}
