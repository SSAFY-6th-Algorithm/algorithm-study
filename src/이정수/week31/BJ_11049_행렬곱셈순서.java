package week31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ����: ��� ���� ����
 * ��ũ: https://www.acmicpc.net/problem/11049
 * 
 * Ǯ��:
 * dp[i][j] : i~j����� ���� �ּڰ�
 * dp[i][j] = dp[i][k] + dp[k+1][j] + (i ����� row) * (k+1 ����� row) * (j ����� col) 
 * 
 * �ð����⵵:
 * O(N^3)
 * 
 * Ǯ�̿� �ɸ� �ð�:
 * 2h
 *
 */
public class BJ_11049_��İ������� {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int[][] matrix = new int[N][2];
		int[][] dp = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			matrix[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < N-i; j++) {
				int min = Integer.MAX_VALUE;
				for (int k = 0; k < i; k++) {
					min = Math.min(min, dp[j][j+k] + dp[j+k+1][j+i] + matrix[j][0] * matrix[j+k+1][0] * matrix[j+i][1]);
				}
				dp[j][j+i] = min;
			}
		}
		
		
		System.out.println(dp[0][N-1]);
		
	}

}
