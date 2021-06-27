package com.baizhi.basic;

public class UserServiceImpl implements UserService{

    //private UserDAO userDAO = new UserDAOImpl();
    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void register(User user) {
        userDAO.save(user);
    }

    @Override
    public void login(String username, String password) {
        userDAO.queryUserByNameAndPassword(username, password);
    }
}
