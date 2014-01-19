/**
 * WuJian
 */
package Queue;

import java.util.LinkedList;

/**
 * @author WuJian 2013年12月16日下午1:04:50
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
