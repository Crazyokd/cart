package pkg.ex11.service.impl;

import java.sql.SQLException;
import java.util.List;

import pkg.ex11.service.BusinessService;
import pkg.ex11.utils.DaoFactory;
import pkg.ex11.dao.BookDao;
import pkg.ex11.dao.CartItemDao;
import pkg.ex11.dao.UserDao;
import pkg.ex11.domain.Book;
import pkg.ex11.domain.Cart;
import pkg.ex11.domain.Page;
import pkg.ex11.domain.User;

public class BusinessServiceImpl implements BusinessService {
	
	private BookDao bookDao = DaoFactory.getInstance().createDao("pkg.ex11.dao.impl.BookDaoImpl", BookDao.class);
	private UserDao userDao = DaoFactory.getInstance().createDao("pkg.ex11.dao.impl.UserDaoImpl", UserDao.class);
	private CartItemDao cartItemDao = DaoFactory.getInstance().createDao("pkg.ex11.dao.impl.CartItemDaoImpl", CartItemDao.class);

	
	// public void addBook(Book book){
	// 	bookDao.add(book);
	// }
	
	public Book findBook(String id){
		return bookDao.find(id);
	}
	
	//获得分页数据
	public Page getBookPageData(String pagenum ,boolean isQuery){
		Page page = null;
		if(isQuery){
			int totalrecord = bookDao.getTotalRecord();
			if(pagenum == null){
				page = new Page(1,totalrecord);
			}else{
				page = new Page(Integer.parseInt(pagenum), totalrecord);
			}
			List<Book> list = bookDao.getPageData(page.getStartindex(), page.getPagesize());
			page.setList(list);
		}
		return page;
	}

	// 将一本书籍添加进购物车
	public void buyBook(Cart cart, Book book) {
		cart.add(book);
	}

	// 将一本书籍从购物车移除
	public void removeBook(Cart cart, String book_id){
		cart.delete(Integer.parseInt(book_id));
	}
	
	public void registerUser(User user) {
		userDao.add(user);
	}
	
	public User searchUser(String username){
		return userDao.search(username);
	}

	public User loginUser(String username, String password){
		return userDao.search(username, password);
	}

	public void writeCart(Cart cart, String user_id){
		cartItemDao.write(cart, user_id);
	}

	public Cart readCart(String user_id){
		Cart cart = null;
		try {
			cart = cartItemDao.read(user_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cart;
	}

	public boolean isRegister(String username){
		return userDao.search(username) != null;
	}
}
