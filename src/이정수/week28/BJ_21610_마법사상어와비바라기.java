package week28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


/**
 * ����: ������ ���� ��ٶ��
 * ��ũ: https://www.acmicpc.net/problem/21610
 * 
 * Ǯ��:
 * 
 * 
 * �ð����⵵:
 * 
 * 
 * Ǯ�̿� �ɸ� �ð�:
 * 1.5h
 *
 */
public class BJ_21610_��������ͺ�ٶ�� {
	
	static int[][] A;
	static int N;
	static int[][] delta = {{0,0,-1,-1,-1,0,1,1,1},{0,-1,-1,0,1,1,1,0,-1}}; // ��, ��, ��, ��, ��, ��, ��, ��
	
	static Queue<int[]> cloud; // ���� ��ġ
	static Set<Integer> temp; // ������ �־��� ��ġ ���
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		A = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// ��ٶ�� ����
		cloud = new LinkedList<>();
		temp = new HashSet<>();
		cloud.add(new int[] {N-1, 0});
		cloud.add(new int[] {N-1, 1});
		cloud.add(new int[] {N-2, 0});
		cloud.add(new int[] {N-2, 1});

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			moveCloud(d,s, cloud.size());
			makeItRain();
			duplicateWater();
			cloud = new LinkedList<>(); // ���� �����
			makeCloud();
		}
		
		int ans = accumulateWater();
		System.out.println(ans);
	}
	
	private static int accumulateWater() {
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				sum +=A[i][j];
			}
		}
		return sum;
	}

	private static void makeCloud() {
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				// ������ ����� ĭ���� Ȯ��
				if(temp.contains(i*N+j)) {
					continue;
				}
				
				// ���Ǿ��� 2 �̻��̸� ���� ����� ���Ǿ� ����
				if(A[i][j]>=2) {
					cloud.add(new int[] {i,j});
					A[i][j] -=2;
				}
			}
		}
		
		temp = new HashSet<>(); // ������ �־��� ��ġ ���
	}

	private static void duplicateWater() {
		for (int[] position : cloud) {
			int row = position[0];
			int col = position[1];
			
			for (int d = 2; d < 9; d+=2) {
				
				int nextRow = row + delta[0][d];
				int nextCol = col + delta[1][d];
				
				if(isValid(nextRow, nextCol) && A[nextRow][nextCol]>0) {
					A[row][col]++;
				}
			}
		}
	}


	private static boolean isValid(int nextRow, int nextCol) {
		return nextRow>=0 && nextCol>=0 && nextRow<N && nextCol<N;
	}

	private static void makeItRain() {
		for (int[] position : cloud) {
			int row = position[0];
			int col = position[1];
			A[row][col]++;
		}
	}

	private static void moveCloud(int d, int s, int size) {
		
		for (int i = 0; i < size; i++) {
			
			int[] position = cloud.poll();
			int row = position[0];
			int col = position[1];
			
			int nextRow = row + (s*delta[0][d]%N);
			if(nextRow>=N) {
				nextRow %= N;
			}else if(nextRow<0) {
				nextRow += N;
			}
			int nextCol = col + (s*delta[1][d]%N);
			if(nextCol>=N) {
				nextCol %= N;
			}else if(nextCol<0) {
				nextCol += N;
			}
			
			cloud.add(new int[] {nextRow, nextCol});
			temp.add(nextRow*N+nextCol);
		}
		
	}

}
