package com.khy.example05;

public class ChildProduct<T, M, C> extends Product<T, M> { // 부모 클래스의 제네릭 타입이 2개 이므로 자신도 최소 2개 이상은 가져야 함

	// 코드는 C 부분만 작성
	
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
