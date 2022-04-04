package week28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ����: ����
 * ��ũ: https://www.acmicpc.net/problem/1890
 * 
 * Ǯ��:
 * dp[i][j]�� i+1�� j+1���� �����ϴ� ������
 * ������ �Ʒ��� ���ʿ��� ���������� �����̸鼭 dp���� �̿��Ͽ� ���������� �̵��ϴ� ����� ���� �Ʒ���������
 * �̵��ϴ� ����� ���� dp table�� ����
 * 
 * 
 * �ð����⵵:
 * O(N^2)
 * 
 * Ǯ�̿� �ɸ� �ð�:
 * 1h
 *
 */
public class BJ_1890_���� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int[][] board = new int[N][N];
		long[][] dp = new long[N][N];
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// ����� �ʱ�ȭ
		dp[0][0] = 1;
		
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				
				if(board[row][col]==0) {
					continue;
				}
				
				// ������ �������� �̵�
				if(col+board[row][col]<N) {
					dp[row][col+board[row][col]] += dp[row][col];
				}
				
				// �Ʒ��� �̵��ϴ� ���
				if(row+board[row][col]<N) {
					dp[row+board[row][col]][col] += dp[row][col];
				}
			}
		}
		System.out.println(dp[N-1][N-1]);
	}

}
