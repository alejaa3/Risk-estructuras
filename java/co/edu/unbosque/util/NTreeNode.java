package co.edu.unbosque.util;

import java.io.Serializable;
import java.util.Objects;


public class NTreeNode <T> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3660524930770649795L;
	private int key;
	private T data;
	private MyLinkedList<NTreeNode> children;
	
	public NTreeNode() {
		// TODO Auto-generated constructor stub
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public MyLinkedList<NTreeNode> getChildren() {
		return children;
	}

	public void setChildren(MyLinkedList<NTreeNode> children) {
		this.children = children;
	}

	@Override
	public int hashCode() {
		return Objects.hash(children, data, key);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NTreeNode<T> other = (NTreeNode<T>) obj;
		return Objects.equals(children, other.children) && Objects.equals(data, other.data) && key == other.key;
	}
	
	
	
}
