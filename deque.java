
public class deque {
	int[] q;
	static int head;
	int tail;
	private int length;


	public deque(int defaultsize) {
		q = new int[defaultsize];
		head=0;
		tail=0;
	}

	public static void main(String []args){
		deque q = new deque(4);
		q.putFirst(4);
		System.out.println(head);

	}

	/*
	  put the first item
	  mmanson01
	 */
	public void putFirst(int item) {
		System.out.println(item);
		q[head] = item;
		System.out.println(q[head]);
		head++;

	}

}
