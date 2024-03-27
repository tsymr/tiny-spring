package io.wf.springframework.test.bean;


public class UserService {
    private String id;
    private UserDao userDao;

    private String company;
    private String location;


    public String queryUserInfo() {
        return userDao.queryUserName(id) + ", 公司：" + company + ", 地点：" + location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
