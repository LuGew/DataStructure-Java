package com.lugew.list;

/**
 * 
 * @author LuGew
 *
 * @version 2017.11.13
 */
public interface List<E> {
	/**
	 * Add a new element at the end of list
	 * 
	 * @param e
	 *            element
	 */
	void add(E e);

	/**
	 * Add a new element at the specified index in this list
	 * 
	 * @param index
	 *            the specified index
	 * @param e
	 *            element
	 */
	void add(int index, E e);

	/**
	 * Remove the first occurrence of the element from this list Shift any
	 * subsequent elements to the left
	 * 
	 * @param e
	 *            element
	 * @return true if the element is removed
	 */
	boolean remove(E e);

	/**
	 * Remove the element at the specified position in this list Shift any
	 * subsequent elements to the left
	 * 
	 * @param index
	 *            the specified position
	 * @return element that was removed from the list
	 */
	E remove(int index);

	/**
	 * Replace the element at the specified position in this list with the
	 * specified element and return the new set
	 * 
	 * @param index
	 *            the specified position
	 * @param e
	 *            new element
	 * @return old element
	 */
	E set(int index, E e);

	/**
	 * get the element at the specified position in this list
	 * 
	 * @param index
	 *            the specified position
	 * @return element at the specified position
	 */
	E get(int index);

	/**
	 * Return the index of the first matching element in this list
	 * 
	 * @param e
	 *            element would be funded
	 * @return -1 if no match
	 */
	int indexOf(E e);

	/**
	 * Return the index of the last matching element in this list
	 * 
	 * @param e
	 *            element would be funded
	 * @return -1 if no match
	 */
	int lastIndexOf(E e);

	/**
	 * Return true if this list contains the element
	 * 
	 * @param e
	 *            element would be funded
	 * @return true if this list contains the element
	 */
	boolean contains(E e);

	/**
	 * Return true if this list contains no elements
	 * 
	 * @return true if this list contains no elements
	 */
	boolean isEmpty();

	/**
	 * Clear this list
	 */
	void clear();

	/**
	 * Return the number of elements in this list
	 * 
	 * @return the number of elements in this list
	 */
	int size();
}
