package chap04.practice;

public class Q3 {
	public static class DoubleHeadStack {
		private final int capacity;
		private int[] stk;
		private int ptrA;
		private int ptrB;

		public enum AorB {StackA, StackB};

		public static class EmptyDoubleHeadStackException extends RuntimeException {
			EmptyDoubleHeadStackException() {}
		}

		public static class OverflowDoubleHeadStackException extends RuntimeException {
			OverflowDoubleHeadStackException() {}
		}

		public DoubleHeadStack(int maxLen) {
			ptrA = 0;
			ptrB = maxLen - 1;
			capacity = maxLen;
			try {
				stk = new int[maxLen];
			} catch (OutOfMemoryError e) {
				maxLen = 0;
			}
		}

		// 푸시
		public int push(AorB sw, int x) throws OverflowDoubleHeadStackException {
			if (ptrA >= ptrB - 1)
				throw new OverflowDoubleHeadStackException();
			switch (sw) {
				case StackA:
					stk[ptrA++] = x;
					break;
				case StackB:
					stk[ptrB--] = x;
					break;
			}
			return x;
		}

		// 팝
		public int pop(AorB sw) throws EmptyDoubleHeadStackException {
			int x = 0;
			switch (sw) {
				case StackA:
					if (ptrA <= 0)
						throw new EmptyDoubleHeadStackException();
					x = stk[--ptrA];
					break;
					
				case StackB:
					if (ptrB >= capacity)
						throw new EmptyDoubleHeadStackException();
					x = stk[++ptrB];
					break;
			}
			return x;
		}

		// 피크
		public int peek(AorB sw) throws EmptyDoubleHeadStackException {
			int x = 0;
			switch (sw) {
				case StackA:
					if (ptrA <= 0)
						throw new EmptyDoubleHeadStackException();
					x = stk[ptrA - 1];
					break;
					
				case StackB:
					if (ptrB >= capacity)
						throw new EmptyDoubleHeadStackException();
					x = stk[ptrB + 1];
					break;
			}
			return x;
		}

		// 덤프
		public void dump(AorB sw) throws EmptyDoubleHeadStackException {
			switch (sw) {
				case StackA:
					if (ptrA <= 0)
						throw new EmptyDoubleHeadStackException();
					for (int i = 0; i < ptrA; i++)
						System.out.print(stk[i] + " ");
					System.out.println();
					break;
					
				case StackB:
					if (ptrA >= capacity)
						throw new EmptyDoubleHeadStackException();

					for (int i = capacity - 1; i > ptrB; i--)
						System.out.print(stk[i] + " ");
					System.out.println();
					break;
			}
		}

		// 검색
		public int indexOf(AorB sw, int x) throws EmptyDoubleHeadStackException {
			int idx = -1;
			switch (sw){
				case StackA:
					if (ptrA <= 0)
						throw new EmptyDoubleHeadStackException();
					for (int i = ptrA - 1; i >= 0; i--)
						if (stk[i] == x)
							idx = i;
					break;
					
				case StackB:
					if (ptrA >= capacity)
						throw new EmptyDoubleHeadStackException();
					for (int i = ptrB + 1; i < capacity; i++)
						if (stk[i] == x)
							idx = i;
					break;
			}
			return idx;
		}

		// 초기화
		public void clear(AorB sw) {
			switch (sw) {
				case StackA:
					ptrA = 0;
					break;
				case StackB:
					ptrB = capacity - 1;
					break;
			}
		}

		// 용량
		public int capacity() {
			return capacity;
		}

		// 크기
		public int size(AorB sw) {
			int x = 0;
			switch (sw) {
				case StackA:
					x = ptrA;
					break;
				case StackB:
					x = capacity - ptrB - 1;
					break;
			}
			return x;
		}

		// 비었는지
		public boolean isEmpty(AorB sw) {
			boolean x = false;
			switch (sw) {
				case StackA:
					if (ptrA <= 0)
						x = true;
					break;
				case StackB:
					if (ptrB >= capacity)
						x = true;
					break;
			}
			return x;
		}

		// 가득 찼는지
		public boolean isFull() {
			return ptrA >= ptrB + 1;
		}
	}
}
