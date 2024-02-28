package service;

import java.util.List;

import model.User;

public interface UserService {
    public int save(User u);
    public int update(User user);
    public int delete(User user);
    public List<User> getAllRecords();
    public User getRecordById(int id);
}
