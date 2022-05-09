package week31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ����: ���͸�Ī
 * ��ũ: https://www.acmicpc.net/problem/1007
 * 
 * Ǯ��:
 * SUM(vectors) = SUM(��� ����) - SUM(��� ������)
 * ���� �� �з��� ������ ��� ���� ������ ������ �ջ� ���
 * 
 * 
 * �ð����⵵:
 * 
 * 
 * Ǯ�̿� �ɸ� �ð�:
 * 2h
 *
 */
public class BJ_1007_���͸�Ī {
	
	static boolean[] visited;
	static int N;
	static double min;
	static int[][] dots;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for (int testCase = 0; testCase < T; testCase++) {
			
			N = Integer.parseInt(in.readLine());
			dots = new int[N][2];
			min = Double.MAX_VALUE;
			visited = new boolean[N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				dots[i][0] = Integer.parseInt(st.nextToken());
				dots[i][1] = Integer.parseInt(st.nextToken());
			}
			
			combination(0,0);
			System.out.println(min);
			
		}
	}

	private static void combination(int depth, int start) {
		if(depth==N/2) {
			int[] vectorSum = {0,0};
			for (int i = 0; i < N; i++) {
				if(visited[i]) {
					vectorSum[0] += dots[i][0];
					vectorSum[1] += dots[i][1];
				}else {
					vectorSum[0] -= dots[i][0];
					vectorSum[1] -= dots[i][1];
				}
			}
			
			min = Math.min(min, Math.sqrt(Math.pow(vectorSum[0],2) + Math.pow(vectorSum[1], 2)));
			return;
		}
		
		for (int i = start; i < N; i++) {
			if(visited[i]) {
				continue;
			}
			visited[i] = true;
			combination(depth+1, i+1);
			visited[i] = false;
		}
	}


}
