package chap04.practice;

public class Q4 {
	public static class IntAryQueue {
		private int max; // 큐 용량
		private int num; // 현재 데이터 수
		private int[] que; // 큐 본체

		// 에러
		public static class EmptyIntAryQueueException extends RuntimeException {
			public EmptyIntAryQueueException() {}
		}

		public static class OverflowIntAryQueueException extends RuntimeException {
			public OverflowIntAryQueueException() {}
		}

		// 생성자
		public IntAryQueue(int maxLen) {
			max = maxLen;
			num = 0;
			try {
				que = new int[maxLen];
			} catch (OutOfMemoryError e) {
				max = 0;
			}
		}

		// 인큐
		public int enque(int x) throws OverflowIntAryQueueException {
			if (num >= max)
				throw new OverflowIntAryQueueException();
			que[num++] = x;
			return x;
		}

		// 디큐
		public int deque() throws EmptyIntAryQueueException {
			if (num <= 0)
				throw new EmptyIntAryQueueException();
			int x = que[0];
			for (int i = 0; i < num - 1; i++)
				que[i] = que[i + 1];
			num--;
			return x;
		}

		// 피크
		public int peek() throws EmptyIntAryQueueException {
			if (num <= 0)
				throw new EmptyIntAryQueueException();
			return que[0];
		}

		// 인덱스 검색
		public int indexOf(int x) {
			for (int i = 0; i < num; i++) {
				if (que[i] == x)
					return i;
			}
			return -1;
		}

		// 비움
		public void clear() {
			num = 0;
		}

		// 용량
		public int capacity() {
			return max;
		}

		// 데이터 수
		public int size() {
			return num;
		}

		// 비어있는지 유무
		public boolean isEmpty() {
			return num <= 0;
		}

		// 가득 찼는지 유무
		public boolean isFull() {
			return num >= max;
		}

		// 덤프: 프런트 -> 리어 순으로 출력
		public void dump() {
			if (num <= 0)
				System.out.println("큐가 비어 있습니다.");
			else {
				for (int i = 0; i < num; i++)
					System.out.print(que[i] + " ");
				System.out.println();
			}
		}
	}
}
