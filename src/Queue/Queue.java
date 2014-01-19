/**
 * WuJian
 */
package Queue;

import java.util.LinkedList;

/**
 * @author WuJian 2013��12��16������1:04:50
 */
public class Queue<T> {
	private LinkedList<T> queue = new LinkedList<T>();

	public void enQueue(T t) {
		queue.add(t);
	}

	public T deQueue() {
		return queue.removeFirst();
	}

	public boolean isQueueEmpty() {
		return queue.isEmpty();
	}

	public boolean contains(T t) {
		return queue.contains(t);
	}
	
	

}
