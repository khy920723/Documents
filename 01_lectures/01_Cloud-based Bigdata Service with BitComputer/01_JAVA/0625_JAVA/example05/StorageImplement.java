package com.khy.example05;

public class StorageImplement<T> implements Storage<T> {
	
	private T[] array;

	public StorageImplement(int capacity) {
		this.array = (T[])(new Object[capacity]);
	}

	@Override
	public void add(T item, int index) {
		// TODO Auto-generated method stub
		array[index] = item;
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return array[index];
	}
	
}
