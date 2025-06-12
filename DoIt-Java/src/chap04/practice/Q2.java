package chap04.practice;

public class Q2 {
	public static class Gstack<E> {
		private int max;
		private int ptr;
		private E[] stk;

		public static class EmptyGStackException extends RuntimeException {
			public EmptyGStackException() {
			}
		}

		public static class OverFlowGStackException extends RuntimeException {
			public OverFlowGStackException() {
			}
		}

		public Gstack(int capacity) {
			ptr = 0;
			max = capacity;
			try {
				stk = (E[])new Object[capacity];
			} catch (OutOfMemoryError e) {
				capacity = 0;
			}
		}

		// 푸시
		public E push(E x) throws OverFlowGStackException {
			if (ptr >= max)
				throw new OverFlowGStackException();
			return stk[ptr++] = x;
		}

		// 팝
		public E pop() throws EmptyGStackException {
			if (ptr <= 0)
				throw new EmptyGStackException();
			return stk[--ptr];
		}

		// 피크
		public E peek() {
			if (ptr <= 0)
				throw new EmptyGStackException();
			return stk[ptr - 1];
		}

		// 덤프
		public void dump() {
			if (ptr <= 0)
				System.out.println("스택이 비어있습니다.");
			else {
				for (int i = 0; i < ptr; i++)
					System.out.print(stk[i] + " ");
				System.out.println();
			}
		}

		// 검색
		public int indexOf(E x) {
			for (int i = ptr - 1; i >= 0; i--)
				if (stk[i].equals(x))
					return i;
			return -1;
		}

		// 비움
		public void clear() {
			ptr = 0;
		}

		// 용량
		public int capacity() {
			return max;
		}

		// 데이터 수
		public int size() {
			return ptr;
		}

		// 비었는지 유무
		public boolean isEmpty() {
			return ptr <= 0;
		}

		// 가득찼는지 유무
		public boolean isFull() {
			return ptr >= max;
		}
	}
}
