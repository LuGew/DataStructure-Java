package com.lugew.list;

/**
 * 
 * @author LuGew
 * @version 2017.11.14
 * @param <E>
 */
public class ArrayList<E> extends AbstractList<E> {
	private static final int INIT_CAPACITY = 16;
	@SuppressWarnings("unchecked")
	private E[] data = (E[]) new Object[INIT_CAPACITY];

	public ArrayList() {

	}

	public ArrayList(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			add(objects[i]);
	}

	@Override
	public void add(int index, E e) {
		ensureCapacity();
		for (int i = size - 1; i >= index; i--)
			data[i + 1] = data[i];
		data[index] = e;
	}

	public void ensureCapacity() {
		if (size >= data.length) {
			@SuppressWarnings("unchecked")
			E[] newData = (E[]) new Object[2 * size + 1];
			System.arraycopy(data, 0, newData, 0, size);
			data = newData;
		}
	}

	@Override
	public E remove(int index) {
		E e = data[index];
		for (int i = index; i < size - 1; i++)
			data[i] = data[i + 1];
		data[size] = null;
		return e;
	}

	@Override
	public E set(int index, E e) {
		E old = data[index];
		data[index] = e;
		return old;
	}

	@Override
	public E get(int index) {
		return data[index];
	}

	@Override
	public int indexOf(E e) {
		for (int i = 0; i < size; i++) {
			if (e.equals(data[i]))
				return i;
		}
		return -1;
	}

	@Override
	public int lastIndexOf(E e) {
		for (int i = size - 1; i >= 0; i--) {
			if (e.equals(data[i]))
				return i;
		}
		return -1;
	}

	@Override
	public boolean contains(E e) {
		for (int i = 0; i < size; i++) {
			if (e.equals(data[i]))
				return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		data = (E[]) new Object[INIT_CAPACITY];
		size = 0;
	}

	/**
	 *  Trim this list to real size
	 */
	public void trimToSize() {
		if (size != data.length) {
			@SuppressWarnings("unchecked")
			E[] newData = (E[]) new Object[size];
			System.arraycopy(data, 0, newData, 0, size);
			data = newData;
		}
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("[");
		for (int i = 0; i < size; i++) {
			stringBuilder.append(data[i]);
			if (i < size - 1)
				stringBuilder.append(", ");
		}
		return stringBuilder.append("]").toString();
	}
}
