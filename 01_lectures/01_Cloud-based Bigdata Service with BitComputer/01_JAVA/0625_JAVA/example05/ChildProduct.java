package com.khy.example05;

public class ChildProduct<T, M, C> extends Product<T, M> { // �θ� Ŭ������ ���׸� Ÿ���� 2�� �̹Ƿ� �ڽŵ� �ּ� 2�� �̻��� ������ ��

	// �ڵ�� C �κи� �ۼ�
	
	private C company;

	/**
	 * @return the company
	 */
	public C getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(C company) {
		this.company = company;
	}
}
