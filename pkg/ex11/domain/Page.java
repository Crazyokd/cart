package pkg.ex11.domain;

import java.util.List;

public class Page {
	
	private int totalpage; 
	private int pagesize = 3; //页面大小
	private int totalrecord; //总记录数
	private int pagenum;	//查询的页码
	private List<Book> list; 
	private int startpage; //起始页号
	private int endpage;
	private int startindex; 
	
	public Page(int pagenum, int totalrecord){
		this.pagenum = pagenum;
		this.totalrecord = totalrecord;
		//总页数
		this.totalpage = 1 + (this.totalrecord - 1) / this.pagesize;
		//
		this.startindex = (this.pagenum - 1) * this.pagesize;
		
		this.startpage = 1;
		this.endpage = this.totalpage;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getTotalrecord() {
		return totalrecord;
	}

	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
	}

	public int getPagenum() {
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}

	public List<Book> getList() {
		return list;
	}

	public void setList(List<Book> list) {
		this.list = list;
	}

	public int getStartpage() {
		return startpage;
	}

	public void setStartpage(int startpage) {
		this.startpage = startpage;
	}

	public int getEndpage() {
		return endpage;
	}

	public void setEndpage(int endpage) {
		this.endpage = endpage;
	}

	public int getStartindex() {
		return startindex;
	}

	public void setStartindex(int startindex) {
		this.startindex = startindex;
	}
}