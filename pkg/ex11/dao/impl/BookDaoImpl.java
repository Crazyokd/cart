package pkg.ex11.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import pkg.ex11.utils.JdbcUtils;
import pkg.ex11.dao.BookDao;
import pkg.ex11.domain.Book;

public class BookDaoImpl implements BookDao {

	/* (non-Javadoc)
	 * @see dao.impl.BookDao#add(domain.Book)
	 */
	public void add(Book book){
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into book(name,author,price,image,description) values(?,?,?,?,?)";
			Object params[] = {book.getName(), book.getAuthor(), book.getPrice(), book.getImage(), book.getDescription()};
			runner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see dao.impl.BookDao#find(java.lang.String)
	 */
	public Book find(String id){
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from book where id=?";
			return runner.query(JdbcUtils.getConnection(), sql, new BeanHandler<>(Book.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public List<Book> getPageData(int startindex, int pagesize){
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from book limit ?,?";
			Object params[] = {startindex, pagesize};
			return runner.query(JdbcUtils.getConnection(), sql, new BeanListHandler<>(Book.class), params);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public int getTotalRecord(){
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select count(*) from book";
			long totalRecord = (Long)runner.query(JdbcUtils.getConnection(), sql, new ScalarHandler<>());
			return (int)totalRecord;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}
