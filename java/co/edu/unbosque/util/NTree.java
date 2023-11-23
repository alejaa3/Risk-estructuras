package co.edu.unbosque.util;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class NTree<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5220381449600137497L;
	private NTreeNode<T> root;

	public NTree() {
		// TODO Auto-generated constructor stub
	}

	public NTree(NTreeNode<T> root) {
		super();
		this.root = root;
	}

	public NTreeNode<T> addNewNode(NTreeNode<T> node) {
		NTreeNode<T> temporaly = node;

		temporaly.setKey(node.getKey());

		this.root = temporaly;
		return temporaly;
	}

	public void atravesarArbolNiveles(NTreeNode<T> raiz) {
		if (raiz == null) {
			return;
		}
		Queue<NTreeNode<T>> cola = new LinkedList<NTreeNode<T>>();
		cola.offer(raiz);
		while (!cola.isEmpty()) {
			int n = cola.size();
			while (n > 0) {
				NTreeNode<T> current = cola.poll();
				System.out.print(current.getKey() + " ");
				for (int i = 0; i < current.getChildren().size(); i++) {
					cola.offer(current.getChildren().get(i));
				}
				n--;
			}
			System.out.println();
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(root);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NTree<T> other = (NTree<T>) obj;
		return Objects.equals(root, other.root);
	}

}
