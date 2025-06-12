package chap01.prac;

import java.util.Scanner;

public class Prac11 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n;

		do {
			System.out.print("양의 정수를 입력해주세요: ");
			n = stdIn.nextInt();
		} while (n <= 0);

		int digit = 0;
		while (n > 0) {
			n /= 10;
			digit++;
		}
		System.out.println("그 수는 " + digit + "자리입니다.");
	}
}
