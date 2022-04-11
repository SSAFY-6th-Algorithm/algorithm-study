package week30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ����: ��ŸƮ�� ��ũ
 * ��ũ: https://www.acmicpc.net/problem/14889
 * 
 * Ǯ��:
 * 1. �������� ������
 * 	�Ѹ��� ���ΰ� N-1_C_N ���ϱ�
 * 2. ���� �ɷ�ġ���� �� ���ϱ�
 * 
 * �ð����⵵:
 * 
 * Ǯ�̿� �ɸ� �ð�:
 * 50m
 *
 */
public class BJ_14889_��ŸƮ�͸�ũ {
	
	static int[][] S;
	static int N;
	static int[][] teams;
	static boolean[] isTeam0;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		S = new int[N][N];
		teams = new int[2][N/2];
		isTeam0 = new boolean[N];
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		combination(0,0);
		
		System.out.println(min);
	}

	private static void combination(int start, int depth) {
		
		if(depth==N/2) {
			
			int idx = 0;
			
			for (int i = 0; i < N-1; i++) {
				if(!isTeam0[i]) {
					teams[1][idx++] = i;
				}
			}
			
			teams[1][N/2-1] = N-1;
			
			int team0 = 0;
			int team1 = 0;
			
			// ������ �ɷ�ġ ���� ���
			for (int i = 0; i < N/2-1; i++) {
				for (int j = i+1; j < N/2; j++) {
					
					int start1 = teams[0][i];
					int start2 = teams[0][j];
					int link1 = teams[1][i];
					int link2 = teams[1][j];
					
					team0 += (S[start1][start2] + S[start2][start1]);
					team1 += (S[link1][link2] + S[link2][link1]);
					
				}
			}
			
			min = Math.min(min, Math.abs(team0-team1));
			
			return;
		}
		
		for (int i = start; i < N-1; i++) {
			teams[0][depth] = i;
			isTeam0[i] = true;
			combination(i+1, depth+1);
			isTeam0[i] = false;
		}
	}

}
