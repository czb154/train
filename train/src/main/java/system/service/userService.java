package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.dao.trainDao;
import system.dao.userDao;
import system.domain.User;

public interface userService {

    public User selectByUser_id(String user_id);

    void insertUser(User user);
}
