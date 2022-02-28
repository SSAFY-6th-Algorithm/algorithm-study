package week24;

import java.util.*;
class PG_67259_���ַΰǼ� {
	
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{0,0,0},{0,0,0},{0,0,0}}));
	}
     public static int solution(int[][] board) {
		int min = Integer.MAX_VALUE;  // �ּ� ���
		int[][] delt = {{-1,1,0,0},{0,0,-1,1}}; // 4���� delta ��
		int N = board.length; // ���� ũ��
		
		int[][][] visited = new int[4][N][N]; // �湮 ó�� �迭
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					visited[i][j][k] = Integer.MAX_VALUE;
				}
			}
		}
		Queue<int[]> queue = new LinkedList<>();
		
		
		queue.add(new int[] {0,0,-1,0}); // 0,0���� ����
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int r = current[0];
			int c = current[1];
			int postDirection = current[2];
			int cost = current[3];
			
			if(r==N-1 && c==N-1) {// ����
				min = Math.min(min, cost);
				continue; // �ٸ� ��� ����� �� ���� �� �����Ƿ� �������� ����
			}
					
			for (int d = 0; d < 4; d++) {
				int nr=r+delt[0][d];
				int nc=c+delt[1][d];
				int newCost = cost;
				
				if(!isValid(nr, nc, board)) continue; // ��ȿ���� ���� ��ġ�� �õ� X
				
				if(postDirection==-1) { // ������ġ���� ���� ���
					newCost += 100;
				}else if(postDirection==d) { // ������ ������ ������ ���� ����
					newCost += 100;
				}else {// ������ ������ �ٸ��� �ڳ� + ���� ����
					newCost += 600;
				}
				
				if(visited[d][nr][nc]>=newCost) { // ó�� �԰ų� �̹� ������ �ͺ��� �� ���� ������� ������ ���
					queue.add(new int[] {nr,nc,d,newCost});
					visited[d][nr][nc] = newCost;
				}
			}
		}
		
        return min;
    }

	private static boolean isValid(int nr, int nc, int[][] board) {
		return nr>=0 && nc>=0 && nr<board.length && nc<board.length && board[nr][nc]==0;
	}
}