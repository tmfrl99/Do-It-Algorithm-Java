package chap05.practice;

import java.util.Scanner;

public class Q6 {
	static String[] name = {"A", "B", "C"};

	static void move(int no, int x, int y) {
		if (no > 1)
			move (no - 1, x, 6 - x - y);

		System.out.println("원반[" + no + "]을 " + name[x - 1] + "기둥에서 " + name[y - 1] + "기둥으로 옮김");

		if (no > 1)
			move(no - 1, 6 - x - y, y);
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("하노이의 탑");
		System.out.print("원반의 개수 : ");
		int n = stdIn.nextInt();

		move(n, 1, 3);
	}
}
