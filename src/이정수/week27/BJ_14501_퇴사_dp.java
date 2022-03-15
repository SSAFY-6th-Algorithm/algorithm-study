package week27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * ����: ���
 * ��ũ: https://www.acmicpc.net/problem/14501
 * 
 * Ǯ��: 
 * dp
 * dp[i]��  i~N �۾��� �������� �� ��� �ִ� ����
 * i=N���� 1���� �Ųٷ� ���
 * dp�� �׻� ��ƽ��ϴ�...
 * 
 * �ð����⵵:
 * O(N)
 * 
 * Ǯ�̿� �ɸ� �ð�:
 * 1h
 *
 */
public class BJ_14501_���_dp {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[] P = new int[N+2];
		int[] T = new int[N+2];
		int[] dp = new int[N+2];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int startDay = N; startDay >0; startDay--) {
			int aDayAfterendDay = startDay + T[startDay];
			
			if(aDayAfterendDay>N+1) {
				dp[startDay] =dp[startDay+1];
				continue;
						
			}
			
			dp[startDay] = Math.max(dp[startDay+1], P[startDay] + dp[aDayAfterendDay]);
		}
		
		System.out.println(dp[1]);
	}

}
