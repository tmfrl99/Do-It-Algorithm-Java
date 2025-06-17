package chap04.practice;

public class Q6 {
	public static class Gqueue<E> {
		private int max;
		private int num;
		private int front;
		private int rear;
		private E[] que;

		public static class EmptyGqueueException extends RuntimeException {
			public EmptyGqueueException() {
			}
		}

		public static class OverflowGqueueException extends RuntimeException {
			public OverflowGqueueException() {
			}
		}

		public Gqueue(int capacity) {
			max = capacity;
			num = front = rear = 0;
			try {
				que = (E[])new Object[capacity];
			} catch (OutOfMemoryError e) {
				max = 0;
			}
		}

		// 인큐
		public E enque(E e) throws OverflowGqueueException {
			if (num >= max)
				throw new OverflowGqueueException();
			que[rear++] = e;
			num++;
			if (rear == max)
				rear = 0;

			return e;
		}

		// 디큐
		public E deque() throws EmptyGqueueException {
			if (num <= 0)
				throw new EmptyGqueueException();
			E e = que[front++];
			num--;
			if (front == max)
				front = 0;
			return e;
		}

		// 피크
		public E peek() throws EmptyGqueueException {
			if (num <= 0)
				throw new EmptyGqueueException();
			return que[front];
		}

		// 인덱스 검색
		public int indexOf(E e) {
			for (int i = 0; i < num; i++) {
				int idx = (i + front) % max;
				if (que[idx].equals(e))
					return idx;
			}
			return -1;
		}

		// 큐 초기화
		public void clear() {
			num = front = rear = 0;
		}

		// 용량
		public int capacity() {
			return max;
		}

		// 데이터 수
		public int size() {
			return num;
		}

		// 비어있는지
		public boolean isEmpty() {
			return num <= 0;
		}

		// 가득찼는지
		public boolean isFull() {
			return num >= max;
		}

		// 덤프
		public void dump() {
			if (num <= 0) {
				System.out.println("큐가 비어있습니다.");
			} else {
				for (int i = 0; i < num; i++) {
					System.out.print(que[(i + front) % max] + " ");
				}
				System.out.println();
			}
		}

		// 검색
		public int search(E e) {
			for (int i = 0; i < num; i++) {
				if (que[(i + front) % max].equals(e))
					return i + 1;
			}
			return 0;
		}
	}
}
