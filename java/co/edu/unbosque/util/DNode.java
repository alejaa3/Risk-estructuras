package co.edu.unbosque.util;

import java.io.Serializable;
import java.util.Objects;

public class DNode<E> implements Serializable {
	private DNode<E> next;
	private DNode<E> previous;
	private E info;

	public DNode(DNode<E> next, E info) {
		this.next = next;
		this.info = info;
	}

	public DNode(E elem) {
		this(null, elem);
	}

	public DNode() {
		// TODO Auto-generated constructor stub
	}

	public DNode<E> getNext() {
		return next;
	}

	public void setNext(DNode<E> next) {
		this.next = next;
	}

	public DNode<E> getPrevious() {
		return previous;
	}

	public void setPrevious(DNode<E> previous) {
		this.previous = previous;
	}

	public E getInfo() {
		return info;
	}

	public void setInfo(E info) {
		this.info = info;
	}
	
	public String toString() {
		if (info != null) {
			return info.toString();
		} else {
			return null;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(info, next, previous);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DNode<E> other = (DNode<E>) obj;
		return Objects.equals(info, other.info) && Objects.equals(next, other.next)
				&& Objects.equals(previous, other.previous);
	}
	
	
	
	
}