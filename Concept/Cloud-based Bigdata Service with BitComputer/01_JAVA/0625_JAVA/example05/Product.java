package com.khy.example05;

public class Product<T, M> {

	private T type;
	private M model;
	/**
	 * @return the type
	 */
	public T getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(T type) {
		this.type = type;
	}
	/**
	 * @return the model
	 */
	public M getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(M model) {
		this.model = model;
	}
}
