package pkg.ex11.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import pkg.ex11.utils.JdbcUtils;
import pkg.ex11.dao.UserDao;
import pkg.ex11.domain.User;

public class UserDaoImpl implements UserDao {

	/* (non-Javadoc)
	 * @see dao.impl.UserDao#add(domain.User)
	 */
	public void add(User user){
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into user(username,password,phone,email) values(?,?,?,?)";
			Object params[] = {user.getUsername(), user.getPassword(), user.getPhone(), user.getEmail()};
			runner.update(sql, params);
		} catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public User search(String username){
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from user where username=?";
			return runner.query(JdbcUtils.getConnection(), sql, new BeanHandler<>(User.class), username);
		} catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public User search(String username, String password){
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from user where username=? and password=?";
			Object params[] = {username, password};
			return runner.query(JdbcUtils.getConnection(), sql, new BeanHandler<>(User.class), params);
		} catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
