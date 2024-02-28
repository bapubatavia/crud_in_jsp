package service;

import java.util.List;

import model.User;
import repository.UserDao;

public class UserImpl implements UserService{

    @Override
    public int save(User user) {
        return UserDao.save(user);
    }

    @Override
    public int update(User user) {
        return UserDao.update(user);
    
    }

    @Override
    public int delete(User user) {
        return UserDao.delete(user);

    }

    @Override
    public List<User> getAllRecords() {
        return UserDao.getAllRecords();
    }

    @Override
    public User getRecordById(int id) {
        return UserDao.getRecordById(id);

    }


}
