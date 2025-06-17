package chap04.practice;

import java.util.Scanner;

public class GqueueTester {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		Q6.Gqueue<String> queue = new Q6.Gqueue<>(64);

		while (true) {
			System.out.println("현재 데이터 수: " + queue.size() + " / " + queue.capacity());
			System.out.print("(1)인큐  (2)디큐  (3)피크  (4)덤프  (5)검색  (0)종료: ");

			int menu = stdIn.nextInt();
			if (menu == 0) break;

			String x;
			switch (menu) {
				case 1:
					System.out.print("데이터: ");
					x = stdIn.next();
					try {
						queue.enque(x);
					}
					catch (Q6.Gqueue.OverflowGqueueException e) {
						System.out.println("큐가 가득 찼습니다.");
					}
					break;

				case 2:
					try {
						x = queue.deque();
						System.out.println("디큐한 데이터는 " + x + "입니다.");
					} catch (Q6.Gqueue.EmptyGqueueException e) {
						System.out.println("큐가 비어있습니다.");
					}
					break;

				case 3:
					try {
						x = queue.peek();
						System.out.println("피크한 데이터는 " + x + "입니다.");
					} catch (Q6.Gqueue.EmptyGqueueException e) {
						System.out.println("큐가 비어있습니다.");
					}
					break;

				case 4:
					queue.dump();
					break;

				case 5:
					System.out.print("데이터 : ");
					x = stdIn.next();
					int n = queue.search(x);
					if (n != 0)
						System.out.printf("%d번째 데이터로 인덱스%d의 위치에 저장되어 있습니다.\n", n, queue.indexOf(x));
					else
						System.out.println("그 데이터는 등록되어 있지 않습니다.");
					break;
			}
		}
	}
}
