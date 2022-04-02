package itcast.service.impl;

import itcast.dao.UserDao;
import itcast.dao.UserDaoImpl;
import itcast.domain.PageBean;
import itcast.domain.User;
import itcast.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
   private UserDao dao=new UserDaoImpl();
    @Override
    public List<User> findAll() {
        //调用dao完成查询
        return dao.findAll();
    }
    @Override
    public User login(User user){
        return dao.findUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void deleteUser(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void updataUser(User user) {
        dao.update( user);
    }

    @Override
    public void delSelectedUser(String[] ids) {
       if(ids!=null&&ids.length>0){
           for (String id:ids) {
               dao.delete(Integer.parseInt(id));
           }
       }
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
       PageBean<User> pb=new PageBean<User>();
       int currentPage=Integer.parseInt(_currentPage);
       int rows=Integer.parseInt(_rows);
       if(currentPage<=0){
           currentPage=1;
       }
       pb.setRows(rows);
       int totalCount=dao.findTotalCount(condition);
       pb.setTotalCount(totalCount);
      int totalPage=totalCount % rows ==0? totalCount/rows:totalCount/rows+1;
      if(currentPage>totalPage){
          currentPage--;
      }
      int start=(currentPage-1)*rows;
        List<User> list= dao.findByPage(start,rows,condition);
        pb.setList(list);
      pb.setCurrentPage(currentPage);
    pb.setTotalPage(totalPage);
    return  pb;
    }


}
