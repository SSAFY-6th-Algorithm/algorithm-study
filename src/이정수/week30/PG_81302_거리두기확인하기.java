package week30;

import java.util.Arrays;

/**
 * ����: �Ÿ��α� Ȯ���ϱ�
 * ��ũ: https://programmers.co.kr/learn/courses/30/lessons/81302#fn1
 * 
 * Ǯ��:
 * dfs�� �ι��̵��ϴ� ���� �湮�ϴ� �������� ��� ���ص� �Ÿ� 2 ����
 * ��Ƽ���� �ִ� �ڸ��δ� �̵����� �ʰ� �׷��� ���� �ڸ��鿡 ���ؼ��� dfs�� Ž�� ����
 * 
 * 
 * �ð����⵵:
 * 
 * 
 * Ǯ�̿� �ɸ� �ð�:
 * 40m
 *
 */
public class PG_81302_�Ÿ��α�Ȯ���ϱ� {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[][] {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}})));
	}
	
	static char[][][] map;
	static boolean[][] visited;
	static int[][] delta = {{0,0,-1,1},{-1,1,0,0}};
	
	static public int[] solution(String[][] places) {
		
		map = new char[5][5][];
		
		for (int i = 0; i < places.length; i++) {
			for (int j = 0; j < places.length; j++) {
				map[i][j] = places[i][j].toCharArray();
			}
		}
		
		int[] answer = {1,1,1,1,1};
		
		for (int room = 0; room < places.length; room++) {
			label:for (int i = 0; i < answer.length; i++) {
				for (int j = 0; j < answer.length; j++) {
					// ����̸� �Ÿ� �α� Ȯ��
					if(map[room][i][j]=='P') {
						visited = new boolean[5][5];
						
						// �Ÿ��αⰡ ���������� ������
						if(dfsCheck(i,j,0, room)) {
							answer[room] = 0;
							break label;
						}
					}
				}
			}
		}
		
		
        return answer;
    }

	private static boolean dfsCheck(int i, int j, int depth, int room) {
		
		visited[i][j] = true;
		
		// ������� �Ÿ��� 2 ����ư �Ÿ� ���ϸ�
		if(depth!=0 && map[room][i][j]=='P') {
			return true;
		}
		
		if(depth==2) {
			return false;
		}
		
		for (int d = 0; d < 4; d++) {
			int newRow = i + delta[0][d];
			int newCol = j + delta[1][d];
			
			if(isValid(newRow, newCol, room)) {
				if(dfsCheck(newRow, newCol, depth+1, room)) {
					return true;
				}
			}
		}
		
		return false;
	}

	private static boolean isValid(int newRow, int newCol, int room) {
		return newRow>=0 && newCol>=0 && newRow<5 && newCol<5 && !visited[newRow][newCol] && (map[room][newRow][newCol]=='P' || map[room][newRow][newCol]=='O');
	}
}
