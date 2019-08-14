package com.gyanblog.java.set;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class HashSetImpl<T> implements Set<T> {

	private int DEFAULT_SIZE = 10;
	private Object[] setDataArr;
	
	public HashSetImpl() {
		this.setDataArr = new Object[DEFAULT_SIZE];
	}
	
	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean contains(Object o) {
		return this.setDataArr[this.getPos(o)] != null;
	}

	@Override
	public Iterator<T> iterator() {
		return null;
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@Override
	public boolean add(T e) {
		if (!this.contains(e)) {
			this.setDataArr[this.getPos(e)] = e;
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(Object o) {
		if (this.contains(o)) {
			this.setDataArr[this.getPos(o)] = null;
			return true;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object obj : c) {
			if (!this.contains(obj)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		boolean added = false;
		for (T obj : c) {
			if (this.add(obj)) {
				added = true;
			}
		}
		return added;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean removed = false;
		for (Object obj : c) {
			if (this.remove(obj)) {
				removed = true;
			}
		}
		return removed;
	}

	@Override
	public void clear() {
		
	}

	private int getPos(Object obj) {
		return obj.hashCode() % DEFAULT_SIZE;
	}
}
