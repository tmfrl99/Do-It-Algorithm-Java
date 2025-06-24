package chap05.practice;

import java.util.Scanner;

import chap05.IntStack;

public class Q5 {
	static void recur3(int n) {
		if (n > 0) {
			recur3(n - 1);
			recur3(n - 2);
			System.out.println(n);
		}
	}

	static void notRecur(int n) {
		IntStack s = new IntStack(100);
		s.push(n);

		while (!s.isEmpty()) {
			int x = s.pop();
			if (x > 0) {
				s.push(-x);

				if (x - 2 > 0)
					s.push(x - 2);

				if (x - 1 > 0)
					s.push(x - 1);
			}
			else {
				System.out.println(-x);
			}
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("정수를 입력하세요 : ");
		int x = stdIn.nextInt();

		recur3(x);

		System.out.println("-------------");

		notRecur(x);
	}
}
