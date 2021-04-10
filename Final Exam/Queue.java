// Artiom Dolghi

package Final2020S;

/*  Problem 1
 * Consider an array-based implementation of Queue. Implement the enqueue() method.
 */

class Queue {
	private int maxSize;
	private int[] queArray;
	private int front;
	private int rear;
	private int nItems;

	public Queue(int s) {
		maxSize = s;
		queArray = new int[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}

	public void enqueue(int j) {
		if (rear == maxSize - 1) {
			rear = -1;
		}
		queArray[++rear] = j;
		nItems++;
	}

	public int dequeue() {
		int temp = queArray[front++];
		if (front == maxSize)
			front = 0;
		nItems--;
		return temp;
	}

	public boolean isEmpty()
	{
		return (nItems == 0);
	}

	public void display() {
		for (int i = 0; i < nItems; i++) {
			System.out.print(queArray[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Queue theQueue = new Queue(10000); 

		theQueue.enqueue(10);
		theQueue.enqueue(20);
		theQueue.enqueue(30);
		theQueue.enqueue(40);

		theQueue.dequeue();
		theQueue.dequeue();
		
		while (!theQueue.isEmpty())  {
			long n = theQueue.dequeue();
			System.out.print(n);
			System.out.print(" ");
		}
		System.out.println("");
	}
}
