package itcast.dao;

import itcast.domain.User;
import itcast.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author WEI
 */
public class UserDaoImpl implements UserDao{
   private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> findAll() {
       String sql="select *from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
}

    @Override
    public User findUsernameAndPassword(String username, String password) {
        try {
            String sql="select *from dept where name=?and password=?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }


    }

    @Override
    public void add(User user) {
        String sql="insert into user values(null,?,?,?,?,?,?,null,null)";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail());

    }

    @Override
    public void delete(int id) {

        String sql="delete from user where id=?";
        template.update(sql,id);
    }

    @Override
    public User findById(int id) {
      String sql="select *from user where id=?";
      return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),id);
    }

    @Override
    public void update(User user) {
        String sql="update user set name=?,gender=?,age=?,address=?,qq=?,email=? where id=?";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getId());

    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        String sql="select count(*) from user where 1=1 ";
        StringBuilder sb=new StringBuilder(sql);
        Set<String> keySet = condition.keySet();
        List<Object> params = new ArrayList<Object>();
        for(String key : keySet){
            if("currentPage".equals(key)||"rows".equals(key)){
                continue;
            }
            String value = condition.get(key)[0];
            if(value !=null&& !"".equals(value)){
                sb.append(" and  "+key+" like ?");
                params.add("%"+value+"%");
            }
        }

        System.out.println(params);
        try {
            return template.queryForObject(sb.toString(),Integer.class,params.toArray());
        }catch (Exception e){
            return 0;
        }

    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
      String sql="select *from user  where 1=1 ";
        StringBuilder sb=new StringBuilder(sql);
        Set<String> keySet = condition.keySet();
        List<Object> params = new ArrayList<Object>();
        for(String key : keySet){
            if("currentPage".equals(key)||"rows".equals(key)){
                continue;
            }
            String value = condition.get(key)[0];
            if(value !=null&& !"".equals(value)){
                sb.append(" and  "+key+" like ?");
                params.add("%"+value+"%");
            }
        }
        sb.append(" limit ?,? ");
        params.add(start);
        params.add(rows);
        sql= sb.toString();
                try{
                    return   template.query(sql,new BeanPropertyRowMapper<User>(User.class),params.toArray());
                }catch (Exception e){
                    return null;
                }


    }
}
