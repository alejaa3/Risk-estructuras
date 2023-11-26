package co.edu.unbosque.util;


import java.io.Serializable;
import java.util.Iterator;
import java.util.Objects;

public class QueueImpl<E> implements Queue<E>, Iterable<E>, Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7760428976514881156L;
	private MyDequeList<E> data;

	public QueueImpl() {
		data = new MyDequeList<E>();
	}

	@Override
	public void enqueue(E info) {
		data.insertFirst(info);
	}

	@Override
	public E dequeue() {
		return data.removeLast();
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
		QueueImpl<E> other = (QueueImpl<E>) obj;
		return Objects.equals(data, other.data);
	}
	
	
}
