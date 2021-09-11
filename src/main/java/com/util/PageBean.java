package com.util;

/**
 * ��ҳ������
 *
 */
public class PageBean {

	private int page = 1;// ҳ��

	private int rows = 10;// ҳ��С

	private int total = 0;// �ܼ�¼��

	private boolean pagination = true;// �Ƿ��ҳ

	public PageBean() {
		super();
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setTotal(String total) {
		this.total = Integer.parseInt(total);
	}

	public boolean isPagination() {
		return pagination;
	}

	public void setPagination(boolean pagination) {
		this.pagination = pagination;
	}

	/**
	 * �����ʼ��¼���±�
	 * 
	 * @return
	 */
	public int getStartIndex() {
		return (this.page - 1) * this.rows;
	}

	@Override
	public String toString() {
		return "PageBean [page=" + page + ", rows=" + rows + ", total=" + total + ", pagination=" + pagination + "]";
	}

}
