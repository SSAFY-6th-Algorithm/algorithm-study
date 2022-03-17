package week27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ����: ���ϻ���
 * ��ũ: https://www.acmicpc.net/problem/10026
 * 
 * Ǯ��:
 * dfs�� �ι� ����Ͽ� ������ ���� ã��
 * ���ϻ����� ��� �ʷϻ��� �������� ���� ������ ����
 * 
 * 
 * �ð����⵵:
 * O(N^2)
 * 
 * Ǯ�̿� �ɸ� �ð�:
 * 30m
 *
 */
public class BJ_10026_���ϻ��� {
	
	static int[][] delta = {{0,0,-1,1},{-1,1,0,0}};
	static boolean[][] visited;
	static int N, normalCnt, colorBlindCnt;
	static char[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
		}
		
		// ���� �÷� ī��Ʈ
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					dfs(new char[] {map[i][j]}, i,j);
					normalCnt++;
				}
			}
		}
		
		
		// ���ϻ��� ī��Ʈ
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					if(map[i][j]=='B') {
						dfs(new char[] {map[i][j]}, i,j);
					}else {
						dfs(new char[] {'R','G'}, i,j);
					}
					colorBlindCnt++;
				}
			}
		}
		
		System.out.println(normalCnt + " " + colorBlindCnt);
		
		
		
	}

	private static void dfs(char[] candidates, int row, int col) {
		
		visited[row][col] = true;
		
		for (int d = 0; d < 4; d++) {
			int newRow = row + delta[0][d];
			int newCol = col + delta[1][d];
			
			// ��ȿ�� �ڸ��� �ƴϸ� ��ŵ
			if(!(newRow>=0 && newCol>=0 && newRow<N && newCol<N && !visited[newRow][newCol])) {
				continue;
			}
			
			// ã�� ���� �ƴϸ� ��ŵ
			if(candidates.length==2 && map[newRow][newCol]=='B') {
				continue;
			}else if(candidates.length==1 && candidates[0]!=map[newRow][newCol]){
				continue;
			}
			
			dfs(candidates, newRow, newCol);
		}
		
	}

}
