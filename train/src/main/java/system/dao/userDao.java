package system.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import system.domain.User;

@Repository
public interface userDao {
    @Select("select * from train_user where user_id=#{user_id}")
    User selectByUser_id(String user_id);

   @Insert("insert into train_user values(#{user_id},#{user_name},#{user_password},#{user_phone},#{user_idcard})")
    void insertUser(User user);
}
