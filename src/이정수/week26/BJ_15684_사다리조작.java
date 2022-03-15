package week26;

import java.util.Scanner;


public class BJ_15684_��ٸ����� {
	
	static int N, M, H;
	static boolean[][] ladder;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		H = sc.nextInt();
		
		int[] crossCnt = new int[N+1];
		ladder = new boolean[H+1][N+1];
		
		for (int i = 0; i < M; i++) {
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			crossCnt[b]++;
			
			ladder[a][b]=true;
			
		}
		
		
		// Ȧ���� ������ 3�� �ʰ��� �Ұ���
		int cnt=0;
		for (int cross : crossCnt) {
			if(cross%2==1) {
				cnt++;
			}
		}
		
		if(cnt>3) {
			System.out.println(-1);
			return;
		}
		
		int lines = 0;
		for (; lines < 4; lines++) {
			if(dfs(1, 1, 0, lines)) break;
		}
		
		lines = lines>3?-1:lines;	// 3���̻��̸� �Ұ���
		System.out.println(lines);
	}

	private static boolean dfs(int startRow, int startCol, int depth, int lines) {
		
		if(depth==lines) { // ���μ��� ��� ����ϸ� 
			return isCorrect(ladder);
		}
		
		int row = startRow-1;
		for (int col = startCol; col < N; col++) {
			
			while(++row<=H) {
				// �̹� ���μ��� ������ �Ұ���
				if(ladder[row][col]) {
					continue;
				}
				
				// ���ʿ� ���μ��� ������ �Ұ���
				if(ladder[row][col-1]) {
					continue;
				}
					
				// �����ʿ� ���μ��� ������ �Ұ���
				if(ladder[row][col+1]) {
					continue;
				}
				
				// ���μ� ����
				ladder[row][col] = true;
				
				if(row<H) {
					if(dfs(row+1, col, depth+1, lines)) {
						return true;
					}
				}else{
					if(dfs(1, col+1,  depth+1, lines)) {
						return true;
					}
				}
				
				ladder[row][col] = false;
				
			}
			
			row=0;
		}
		
		return false;
		
	}
	
	
	// i�� ���μ��� ����� i���� �������� Ȯ��
	private static boolean isCorrect(boolean[][] ladder) {
		
		for (int vLine = 1; vLine <= N; vLine++) {
			
			int row = 0;
			int col = vLine;
			
			while(row<=H) {
				
				if(col<N && ladder[row][col]) { // �������� ���� �� ������
					col++;
				}else if(col>0 && ladder[row][col-1]){ // �������� ���� �� ������
					col--;
				}
				
				row++;
				
			}
			
			if(vLine != col) {
				return false;
			}
			
		}
		
		return true;
	}

}
