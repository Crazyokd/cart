package pkg.ex11.service;


import pkg.ex11.domain.Book;
import pkg.ex11.domain.Cart;
import pkg.ex11.domain.Page;
import pkg.ex11.domain.User;


public interface BusinessService {

	public Book findBook(String id);
	
	public Page getBookPageData(String pagenum);

	public void buyBook(Cart cart, Book book);

	public void removeBook(Cart cart, String book_id);

	public void registerUser(User user);

	public User searchUser(String username);

	public User loginUser(String username, String password);

	public void writeCart(Cart cart, String user_id);

	public Cart readCart(String user_id);

	public boolean isRegister(String username);
}