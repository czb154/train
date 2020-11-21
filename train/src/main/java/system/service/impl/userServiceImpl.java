package system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.dao.userDao;
import system.domain.User;
import system.service.userService;
@Service("userService")
public class userServiceImpl implements userService {
@Autowired
userDao userdao;

    /**
     * 根据id查用户
     * @param user_id
     * @return
     */
    @Override
    public User selectByUser_id(String user_id) {
        return userdao.selectByUser_id(user_id) ;

    }

    @Override
    public void insertUser(User user) {
        userdao.insertUser(user);
    }
}
