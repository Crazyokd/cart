package pkg.ex11.dao;

import java.util.List;

import pkg.ex11.domain.Book;

public interface BookDao {

	void add(Book book);

	Book find(String id);
	
	public List<Book> getPageData(int startindex, int pagesize);
	
	public int getTotalRecord();

}