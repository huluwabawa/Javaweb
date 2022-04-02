package itcast.dao;

import itcast.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @author HUAWEI
 * 用户操作的dao
 */
public interface UserDao {
    public List<User> findAll();
    public User findUsernameAndPassword(String username,String password);
    public void add(User user);

    public void delete(int parseInt);

    User findById(int parseInt);

    void update(User user);

    int findTotalCount(Map<String, String[]> condition);

    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}

