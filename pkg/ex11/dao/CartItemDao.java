package pkg.ex11.dao;

import java.sql.SQLException;

import pkg.ex11.domain.Cart;

public interface CartItemDao {
    public void write(Cart cart, String user_id);

    public Cart read(String user_id) throws SQLException;
}
