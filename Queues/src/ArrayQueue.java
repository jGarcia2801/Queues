import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<E extends Comparable <? super E>> extends AbstractQueue<E> {
	private int size;
	private int front;
	private Object [] queue;
	private final int CAPACITY = 5;
	
	public ArrayQueue() {
		size = 0;
		front = 0;
		queue = new Object [CAPACITY];
	}

	@Override
	public boolean offer(E e) {
		if(size == CAPACITY)
			return false;
		if(e == null) { // throws exception if the user tries to insert a null object, this is because null is not comparable 
			throw new NullPointerException();
		}
		int rear = (front + size) % CAPACITY;
		queue[rear] = e;
		size++;
		return true;
	}
	
	public boolean add(E e) {
		if(size == CAPACITY)
			throw new IllegalStateException();
		if(e == null) { // throws exception if the user tries to insert a null object, this is because null is not comparable 
			throw new NullPointerException();
		}
		int rear = (front + size) % CAPACITY;
		queue[rear] = e;
		size++;
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E peek() {
		if(size == 0)
			return null;
		return (E) queue[front];
	}
	
	@SuppressWarnings("unchecked")
	public E element() {
		if(size == 0)
			throw new NoSuchElementException();
		return (E) queue[front];
	}

	@SuppressWarnings("unchecked")
	@Override
	public E poll() {
		if(size == 0)
			return null;
		E result = (E) queue[front];
		queue[front] = null;
		front = (front + 1) % CAPACITY;
		size--;
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public E remove() {
		if(size == 0)
			throw new NoSuchElementException();
		E result = (E) queue[front];
		queue[front] = null;
		front = (front + 1) % CAPACITY;
		size--;
		return result;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return this.size;
	}
	
	@Override
	public String toString() {
		if (this.size == 0)
			return "[]";
		StringBuffer sb = new StringBuffer();
		sb.append('[');
		for(int i = 0; i < CAPACITY -1 ; i++) {
			sb.append(queue[i] +", ");
		}
		sb.append(queue[CAPACITY-1]);
		sb.append(']');
		return sb.toString();

	}
	
	public static void main(String[] args) {
		ArrayQueue<Integer> stack = new ArrayQueue<Integer>();
		stack.offer(1);
		stack.offer(2);
		stack.offer(3);
		stack.offer(4);
		stack.offer(5);
		stack.offer(6);
		System.out.println(stack);
		System.out.println(stack.size());
		System.out.println(stack.poll());
		System.out.println(stack);
		stack.offer(6);
		System.out.println(stack);
		System.out.println(stack.poll());
		System.out.println(stack.poll());
		System.out.println(stack.poll());
		System.out.println(stack.poll());
		System.out.println(stack);
		stack.offer(1);
		System.out.println(stack);
		System.out.println(stack.poll());
		System.out.println(stack);

	}

}
