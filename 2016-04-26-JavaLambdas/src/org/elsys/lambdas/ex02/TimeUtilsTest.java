package org.elsys.lambdas.ex02;

import java.util.Arrays;
import java.util.Random;

public class TimeUtilsTest {

	public TimeUtilsTest() {
		// TODO Auto-generated constructor stub
	}

	public static int[] randomArray(int size) {
		Random random = new Random();
		int[] result = new int[size];
		for(int i=0;i<size; i++) {
			result[i] = random.nextInt();
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		int[] nums = randomArray(1000000);
		double time = TimeUtils.timeOperation(
				() -> {
					Arrays.sort(nums);
				});
		System.out.printf("time: %f sec", time);
	}
	
}
