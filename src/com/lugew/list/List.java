package com.lugew.list;

public interface List<E> {

	void add(E e);

	void add(int index, E e);

	boolean remove(E e);

	E remove(int index);

	E set(int index, E e);

	E get(int index);

	boolean contains(E e);
	
	boolean isEmpty();
}
