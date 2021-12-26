package pkg.ex11.dao.impl;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import pkg.ex11.dao.CartItemDao;
import pkg.ex11.domain.Book;
import pkg.ex11.domain.Cart;
import pkg.ex11.domain.CartItem;
import pkg.ex11.utils.JdbcUtils;

public class CartItemDaoImpl implements CartItemDao{
    public void write(Cart c, String user_id){
        QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
        //删除该用户上一次的“购物车”
        delete(user_id);
        
        //插入本次购物车
        String sql = "insert into cartitem(`book_id`,quantity,`user_id`) values(?,?,?)";
        Set<Entry<Integer,CartItem>> set = c.getMap().entrySet();
        for(Entry<Integer,CartItem> item : set){
            Object params[] = {item.getKey(), item.getValue().getQuantity(), user_id};
		    try {
                runner.update(sql, params);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
    }

    public Cart read(String user_id) throws SQLException{
        Cart cart = new Cart();
        QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
        //
        String sql = "select book.* from cartitem,book where cartitem.book_id = book.id and user_id = ?;";
        List<Book> books = runner.query(JdbcUtils.getConnection(), sql, new BeanListHandler<>(Book.class), user_id);
        sql = "select book_id,quantity,price from cartitem,book where cartitem.book_id = book.id and user_id = ?;";
        List<CartItem> items = runner.query(JdbcUtils.getConnection(), sql, new BeanListHandler<>(CartItem.class), user_id);
        
        Iterator<CartItem> c = items.iterator();
        Iterator<Book> b = books.iterator();
        while(c.hasNext() && b.hasNext()){
            cart.add(b.next(), c.next().getQuantity());
        }

        return cart;
    }

    public void delete(String user_id){
        QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "delete from cartitem where user_id = ?;";
        try {
            runner.update(JdbcUtils.getConnection(), sql, user_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}