package week26;

/**
 * ����: �ı����� ���� �ǹ�
 * ��ũ: https://programmers.co.kr/learn/courses/30/lessons/92344/solution_groups?language=java
 * 
 * Ǯ��:
 * imos �˰��� ���
 * https://driip.me/65d9b58c-bf02-44bf-8fba-54d394ed21e0
 * 
 * 
 * �ð����⵵:
 * O(S+N*M)
 * 
 * 
 * Ǯ�̿� �ɸ� �ð�:
 * 
 *
 */
public class PG_92344_�ı����������ǹ� {

	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{1,2,3},{4,5,6},{7,8,9}}, new int[][] {{1,1,1,2,2,4},{1,0,0,1,1,2},{2,2,0,2,0,100}}));
	}
	
	public static int solution(int[][] board, int[][] skill) {
		
		int[][] imos = new int[board.length+1][board[0].length+1];
		
		for (int[] sk : skill) {
			int type = sk[0];
			int r1 = sk[1];
			int c1 = sk[2];
			int r2 = sk[3];
			int c2 = sk[4];
			int degree = sk[5];
			
			if(type==1) {
				degree*=-1;
			}
			
			imos[r1][c1] += degree;		// �������
			imos[r1][c2+1] += -degree;	// �������
			imos[r2+1][c1] += -degree;	// �����ϴ�
			imos[r2+1][c2+1] += degree;	// �����ϴ�
		}
		
		// ���� ��������
		for (int i = 0; i < imos.length; i++) {
			for (int j = 1; j < imos[0].length; j++) {
				imos[i][j] += imos[i][j-1];
			}
		}
		
		// ���� ��������
		for (int j = 0; j < imos[0].length; j++) {
			for (int i = 1; i < imos.length; i++) {
				imos[i][j] += imos[i-1][j];
			}
		}
		
		int cnt = 0 ;
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] += imos[i][j];
				if(board[i][j]>0) cnt++;
			}
		}
		
        return cnt;
    }
}
