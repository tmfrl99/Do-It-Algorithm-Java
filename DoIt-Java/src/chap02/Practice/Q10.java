package chap02.Practice;

import chap02.PhysicalExamination;

public class Q10 {
	static final int VMAX = 21; // 시력 분포 (0.0 ~ 2.0 범위의 0.1 단위로 21개)

	static class PhysicData {
		String name; // 이름
		int height; // 키
		double vision; // 시력

		public PhysicData(String name, int height, double vision) {
			this.name = name;
			this.height = height;
			this.vision = vision;
		}
	}

	// 키의 평균값 구함
	static double aveHeight(PhysicData[] dat) {
		double sum = 0;

		for (int i = 0; i < dat.length; i++)
			sum += dat[i].height;

		return sum / dat.length;
	}

	// 시력 분포 구함
	static void distVision(PhysicData[] dat, int[] dist) {
		int i = 0;

		dist[i] = 0;

		for (i = 0; i < dat.length; i++)
			if (dat[i].vision >= 0.0 && dat[i].vision <= VMAX / 10.0)
				dist[(int)(dat[i].vision * 10)]++;
	}

	public static void main(String[] args) {
		PhysicData[] x = {
			new PhysicData("박현규", 162, 0.3),
			new PhysicData("함진아", 173, 0.35),
			new PhysicData("최윤미", 175, 2.0),
			new PhysicData("홍연의", 171, 1.5),
			new PhysicData("이수진", 168, 0.3),
			new PhysicData("김영준", 174, 1.2),
			new PhysicData("박용규", 169, 0.8),
		};
		int[] vdist = new int[VMAX];

		System.out.println("--- 신체검사 리스트 ---");
		System.out.println("이름       키     시력");
		System.out.println("--------------------");
		for (int i = 0; i < x.length; i++)
			System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);

		System.out.printf("\n평균 키: %5.1fcm\n", aveHeight(x));

		distVision(x, vdist); // 시력 분포를 구함

		System.out.println("\n 시력 분포");
		for (int i = 0; i < VMAX; i++) {
			System.out.printf("%3.1f~ : ", i / 10.0);
			for (int j = 0; j < vdist[i]; j++)
				System.out.print("*");
			System.out.println();
		}
	}
}
