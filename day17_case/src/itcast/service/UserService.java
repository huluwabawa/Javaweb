package itcast.service;

import itcast.domain.PageBean;
import itcast.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @author HUAWEI
 * 用户管理的业务接口
 */
public interface UserService {
    /*
    查询所有用户信息
     */

    public List<User> findAll();
    public  User login(User user);
    public  void addUser(User user);

    void deleteUser(String id);

    User findUserById(String id);

    void updataUser(User user);

    void delSelectedUser(String[] ids);

    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
