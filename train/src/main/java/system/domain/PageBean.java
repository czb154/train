
package system.domain;

import java.util.List;

public class PageBean<T> {
	private int totalCount;//总记录数
	private int totalPage;//总页数
	private List<T> list;
	private int currentPage;//当前页码
	private int rows;
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	@Override
	public String toString() {
		return "Page [totalCount=" + totalCount + ", totalPage=" + totalPage + ", list=" + list + ", currentPage="
				+ currentPage + ", rows=" + rows + "]";
	}
	
}
