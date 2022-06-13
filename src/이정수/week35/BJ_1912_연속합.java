package week35;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ����: ������
 * ��ũ: https://www.acmicpc.net/problem/1912
 * 
 * Ǯ��:
 * dp����
 * dp[i] = max(0���� i-1��° ���� ���� �� + i��° ���� �� , i��° ��)
 * 
 * 
 * �ð����⵵:
 * O(N)
 * 
 * 
 * Ǯ�̿� �ɸ� �ð�:
 * 30m
 *
 */
public class BJ_1912_������ {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		int[] dp = new int[n];
		
		dp[0] = Integer.parseInt(st.nextToken());
		
		int max = dp[0];
		
		for (int i = 1; i < n; i++) {
			int in = Integer.parseInt(st.nextToken());
			dp[i] = Math.max(in, dp[i-1] + in);
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
		
	}

}
