package ie.aphral.service;

import ie.aphral.dao.UserDao;
import ie.aphral.entities.Student;
import ie.aphral.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User save(String email, String password, String role, String firstName, String lastName) {
        if(userDao.existsById(email)){
            return null;
        }
        User newUser = new User( email, password, role, firstName, lastName);
        return userDao.save(newUser);
    }
}
