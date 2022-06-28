package week37;

import java.io.IOException;
import java.util.Scanner;

/**
 * ����: �� �����
 * ��ũ: https://www.acmicpc.net/problem/2631
 * 
 * Ǯ��:
 * LIS
 * 
 * 
 * �ð����⵵:
 * 
 * 
 * Ǯ�̿� �ɸ� �ð�:
 * 
 *
 */
public class BJ_2631_�ټ���� {

	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] children = new int[N];
		
		for (int i = 0; i < N; i++) {
			children[i] = sc.nextInt();
		}
		
		int[] dp = new int[N];
		dp[0] = 1;
		int max = 0;
		for (int i = 1; i < dp.length; i++) {
			dp[i] = 1;
			for (int j = 0; j <= i; j++) {
				if(children[j]<children[i] && dp[j]+1>dp[i]) {
					dp[i] = dp[j] +1;
				}
				max = Math.max(dp[i], max);
			}
		}
		
		System.out.println(N-max);
	}

}
