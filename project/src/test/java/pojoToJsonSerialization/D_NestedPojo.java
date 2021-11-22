package pojoToJsonSerialization;

import java.util.List;

public class D_NestedPojo {
	
	private int page;
	private int per_page;
	private int total;
	private int total_pages;
	private List<D_NestedPojoData> data;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPer_page() {
		return per_page;
	}
	public void setPer_page(int per_page) {
		this.per_page = per_page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotal_pages() {
		return total_pages;
	}
	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}
	public List<D_NestedPojoData> getData() {
		return data;
	}
	public void setData(List<D_NestedPojoData> data) {
		this.data = data;
	}
	
	
	

	

}
