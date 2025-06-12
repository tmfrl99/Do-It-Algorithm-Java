package chap04.practice;

import java.util.Scanner;

import chap04.IntStack;

public class Q1 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntStack s = new IntStack(64);

		while (true) {
			System.out.println("현재 데이터 수 : " + s.size() + " / " + s.capacity());
			System.out.print("(0)종료  (1)푸시  (2)팝  (3)피크  (4)덤프  "
							 + "(5)인덱스 검색  (6)초기화  (7)용량  (8)현재 데이터 수  (9)비어있는지 유무  (10)가득찼는지 유무 : ");

			int menu = stdIn.nextInt();
			if (menu == 0) break;

			int x;
			switch (menu) {
				case 1:
					System.out.print("데이터 : ");
					x = stdIn.nextInt();
					try {
						s.push(x);
					} catch (IntStack.OverflowIntStackException e) {
						System.out.println("스택이 가득 찼습니다.");
					}
					break;

				case 2:
					try {
						x = s.pop();
						System.out.println("팝한 데이터는 " + x + "입니다.");
					} catch (IntStack.EmptyIntStackException e) {
						System.out.println("스택이 비어 있습니다.");
					}
					break;

				case 3:
					try {
						x = s.peek();
						System.out.println("피크한 데이터는 " + x + "입니다.");
					} catch (IntStack.EmptyIntStackException e) {
						System.out.println("스택이 비어 있습니다.");
					}
					break;

				case 4:
					s.dump();
					break;

				case 5:
					x = stdIn.nextInt();
					int idx = s.indexOf(x);
					if (idx < 0)
						System.out.println("스택에 요소가 없습니다.");
					else
						System.out.println(x + "는 stack[" + idx + "]에 있습니다.");
					break;

				case 6:
					s.clear();
					break;

				case 7:
					x = s.capacity();
					System.out.println("스택의 용량은 " + x + "입니다.");
					break;

				case 8:
					x = s.size();
					System.out.println("스택의 현재 데이터 수는 " + x + "입니다.");
					break;

				case 9:
					if (s.isEmpty())
						System.out.println("스택은 비어있습니다.");
					else
						System.out.println("스택은 비어있지 않습니다.");
					break;

				case 10:
					if (s.isFull())
						System.out.println("스택은 가득 찼습니다.");
					else
						System.out.println("스택은 가득 차지 않았습니다.");
					break;
			}
		}
	}
}
