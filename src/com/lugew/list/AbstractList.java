package com.lugew.list;

/**
 * 
 * @author LuGew
 * @version 2017.11.13
 * @param <E>
 */
public abstract class AbstractList<E> implements List<E> {
	protected int size = 0;

	@Override
	public void add(E e) {
		add(size, e);
	}

	@Override
	public boolean remove(E e) {
		if (indexOf(e) >= 0) {
			remove(indexOf(e));
			return true;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

}
