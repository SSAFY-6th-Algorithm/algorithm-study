package week30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * ����: �� �μ��� �̵��ϱ� 4
 * ��ũ: https://www.acmicpc.net/problem/16946
 * 
 * Ǯ��:
 * �Ź� ���� �μ��� Ž���� ��� ���� ���� Ž���� �ߺ��Ͽ� ��ȿ����
 * �̸� ��������� Ž���ؼ� �������� �и��ϰ� ������ ������ ����� ������ ������ ����ð��ȿ� �̵�������
 * ĭ�� ������ ����
 * 
 * �ð����⵵:
 * O(N^2)
 * 
 * Ǯ�̿� �ɸ� �ð�:
 * 30m
 *
 */
public class BJ_16946_���μ����̵��ϱ�4 {

	static int[][] map, emptySpaceRecord;
	static int emptyIdCnt,N,M;
	static int[] emptySpaceSize;
	static int[][] delta = {{0,0,1,-1},{1,-1,0,0}};
	static Set<Integer>checkSet;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		emptySpaceRecord = new int[N][M];
		emptySpaceSize = new int[1000000];
		
		for (int i = 0; i < N; i++) {
			String line = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j)-'0';
			}
		}
		
		// �� ���� �̸� ��� �� �׷�ȭ
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// ������̰� Ž�������� ������ dfs Ž�� ����
				if(map[i][j]==0 && emptySpaceRecord[i][j]==0) {
					dfs(i,j,++emptyIdCnt);
				}
			}
		}
		
		// ������ ������ �̵������� ��ġ�� �� ���ϱ�
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==0) {
					sb.append(0);
				}else {
					checkSet = new HashSet<>(); // ���� ����� ���� ���� ��Ʈ
					int sum = 1;
					for (int d = 0; d < 4; d++) {
						int newRow = i + delta[0][d];
						int newCol = j + delta[1][d];
						
						if(isValid2(newRow, newCol)) {
							checkSet.add(emptySpaceRecord[newRow][newCol]); // ������ ����� ������ id ����
							sum += emptySpaceSize[emptySpaceRecord[newRow][newCol]]; // ������� ũ�� ���ϱ�
						}
					}
					sb.append(sum%10);
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	private static boolean isValid2(int newRow, int newCol) {
		// �� �ȿ� �ְ� �̹� Ȯ�� �� ������ �ƴ� ����� �����̸� true ����
		return newRow>=0 && newCol>=0 && newRow<N && newCol<M 
				&& !checkSet.contains(emptySpaceRecord[newRow][newCol]) && map[newRow][newCol]==0; 
	}

	private static void dfs(int i, int j, int id) {
		
		emptySpaceRecord[i][j] = id;
		emptySpaceSize[id]++;
		
		for (int d = 0; d < 4; d++) {
			int newRow = i + delta[0][d];
			int newCol = j + delta[1][d];
			
			if(isValid(newRow, newCol)) {
				
				dfs(newRow, newCol, id);
			}
		}
	}

	private static boolean isValid(int newRow, int newCol) {
		return newRow>=0 && newCol>=0 && newRow<N && newCol<M 
				&& emptySpaceRecord[newRow][newCol]==0 && map[newRow][newCol]==0;
	}

}
