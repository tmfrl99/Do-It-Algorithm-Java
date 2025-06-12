package chap02;

public class PrimeNumber2 {
	public static void main(String[] args) {
		int counter = 0; // 나눗셈 횟수
		int ptr = 0; // 찾은 소수의 개수
		int[] prime = new int[500]; // 소수 저장 배열

		prime[ptr++] = 2; // 2는 소수

		for (int n = 3; n <= 1000; n += 2) { // 홀수 대상
			int i;
			for (i = 1; i < ptr; i++) { // 이미 찾은 소수로 나누기
				counter++;
				if (n % prime[i] == 0) // 나누어떨어지면 소수가 아님
					break;
			}
			if (ptr == i) // 마지막까지 나누어떨어지지 않음
				prime[ptr++] = n; // 배열에 소수 저장
		}

		for (int i = 0; i < ptr; i++)
			System.out.println(prime[i]);

		System.out.println("나눗셈을 수행한 횟수: " + counter);
	}
}
