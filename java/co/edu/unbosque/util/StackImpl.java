package co.edu.unbosque.util;


import java.io.Serializable;
import java.util.Iterator;
import java.util.Objects;

public class StackImpl<E> implements Stack<E>, Iterable<E>, Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7910994094960807767L;
	private MyDequeList<E> data;

	public StackImpl() {
		data = new MyDequeList<E>();
	}

	@Override
	public void push(E info) {
		data.insertFirst(info);
	}

	@Override
	public E pop() {
		return data.removeFirst();
	}

	@Override
	public int size() {
		return data.size();
	}

	@Override
	public String toString() {
		return data.toString();
	}

	@Override
	public Iterator<E> iterator() {
		return data.iterator();
	}

	@Override
	public int hashCode() {
		return Objects.hash(data);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StackImpl<E> other = (StackImpl<E>) obj;
		return Objects.equals(data, other.data);
	}
	
	
}
