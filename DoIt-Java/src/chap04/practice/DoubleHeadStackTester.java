package chap04.practice;

import java.util.Scanner;

public class DoubleHeadStackTester {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		Q3.DoubleHeadStack s = new Q3.DoubleHeadStack(64);

		while (true) {
			System.out.println("현재 데이터 개수 : " +
							   "A : " + s.size(Q3.DoubleHeadStack.AorB.StackA) + " / " +
							   "B : " + s.size(Q3.DoubleHeadStack.AorB.StackB));
			System.out.print("( 1) A 푸시 ( 2) A 팝 ( 3) A 피크 ( 4) A 덤프 ( 5) A 검색 ( 6) A 비움\n" +
							 "( 7) B 푸시 ( 8) B 팝 ( 9) B 피크 (10) B 덤프 (11) B 검색 (12) B 비움\n" +
							 "(13)   출력 ( 0) 종료 : ");
			
			int menu = stdIn.nextInt();
			if (menu == 0) break;

			int x, idx;
			switch (menu) {
				case 1:
					System.out.print("데이터 : ");
					x = stdIn.nextInt();
					try {
						s.push(Q3.DoubleHeadStack.AorB.StackA, x);
					} catch (Q3.DoubleHeadStack.OverflowDoubleHeadStackException e) {
						System.out.println("스택이 가득 찼습니다.");
					}
					break;

				case 2:
					try {
						x = s.pop(Q3.DoubleHeadStack.AorB.StackA);
						System.out.println("팝한 데이터는 " + x + "입니다.");
					} catch (Q3.DoubleHeadStack.EmptyDoubleHeadStackException e) {
						System.out.println("스택이 비어 있습니다.");
					}
					break;

				case 3:
					try {
						x = s.peek(Q3.DoubleHeadStack.AorB.StackA);
						System.out.println("피크한 데이터는 " + x + "입니다.");
					} catch (Q3.DoubleHeadStack.EmptyDoubleHeadStackException e) {
						System.out.println("스택이 비어 있습니다.");
					}
					break;

				case 4:
					s.dump(Q3.DoubleHeadStack.AorB.StackA);
					break;

				case 5:
					x = stdIn.nextInt();
					idx = s.indexOf(Q3.DoubleHeadStack.AorB.StackA, x);
					if (idx < 0)
						System.out.println("스택에 요소가 없습니다.");
					else
						System.out.println("꼭대기에서 " + (s.size(Q3.DoubleHeadStack.AorB.StackA) - idx) +"번째에 있습니다.");
					break;

				case 6:
					s.clear(Q3.DoubleHeadStack.AorB.StackA);
					break;

				case 7:
					System.out.print("데이터 : ");
					x = stdIn.nextInt();
					try {
						s.push(Q3.DoubleHeadStack.AorB.StackB, x);
					} catch (Q3.DoubleHeadStack.OverflowDoubleHeadStackException e) {
						System.out.println("스택이 가득 찼습니다.");
					}
					break;

				case 8:
					try {
						x = s.pop(Q3.DoubleHeadStack.AorB.StackB);
						System.out.println("팝한 데이터는 " + x + "입니다.");
					} catch (Q3.DoubleHeadStack.EmptyDoubleHeadStackException e) {
						System.out.println("스택이 비어 있습니다.");
					}
					break;

				case 9:
					try {
						x = s.peek(Q3.DoubleHeadStack.AorB.StackB);
						System.out.println("피크한 데이터는 " + x + "입니다.");
					} catch (Q3.DoubleHeadStack.EmptyDoubleHeadStackException e) {
						System.out.println("스택이 비어 있습니다.");
					}
					break;

				case 10:
					s.dump(Q3.DoubleHeadStack.AorB.StackB);
					break;

				case 11:
					x = stdIn.nextInt();
					idx = s.indexOf(Q3.DoubleHeadStack.AorB.StackB, x);
					if (idx < 0)
						System.out.println("스택에 요소가 없습니다.");
					else
						System.out.println("꼭대기에서 " + (s.size(Q3.DoubleHeadStack.AorB.StackB) - (s.capacity() - idx) + 1) +"번째에 있습니다.");
					break;

				case 12:
					s.clear(Q3.DoubleHeadStack.AorB.StackB);
					break;

				case 13:													// 데이터 출력
					System.out.println("용량 : " + s.capacity());
					System.out.println("A의 데이터수 : " + s.size(Q3.DoubleHeadStack.AorB.StackA));
					System.out.println("B의 데이터수 : " + s.size(Q3.DoubleHeadStack.AorB.StackB));
					System.out.println("A는 비어 " + (s.isEmpty(Q3.DoubleHeadStack.AorB.StackA) ? "있습니다."
						: "있지 않습니다."));
					System.out.println("B는 비어 " + (s.isEmpty(Q3.DoubleHeadStack.AorB.StackB) ? "있습니다."
						: "있지 않습니다."));
					System.out.println("가득 차 " + (s.isFull() ? "있습니다."
						: "있지 않습니다."));
					break;
			}
		}
	}
}
