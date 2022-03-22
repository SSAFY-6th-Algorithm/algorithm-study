package week27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * ����: ���
 * ��ũ: https://www.acmicpc.net/problem/2473
 * 
 * Ǯ��:
 * ����� Ư������ ���� ����
 * �� ���� ��� ����� �������� ��Ž
 * ������ �ϳ��� �̺�Ž�� �õ�
 * 
 * 
 * �ð����⵵:
 * O(NlogN)
 * 
 * Ǯ�̿� �ɸ� �ð�:
 * 2h
 *
 */
public class BJ_2473_��� {
	
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		int[] solutions = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for (int i = 0; i < N; i++) {
			solutions[i] = Integer.parseInt(st.nextToken());
		}
		
		// �������� ����
		Arrays.parallelSort(solutions);
		
		int[] ans = {0,0,0};
		long min = Long.MAX_VALUE; // �� ����� Ư������ ���� ���밪�� �ּҰ�
		
		int[] delta = {-2,-1,1,2};
		int[] delta2 = {-2,-1,0,1,2};
		
		label: for (int i = 0; i < N-1; i++) {// ��� a ����
			int a = solutions[i]; 
			for (int j = i+1; j < N; j++) {// ��� b ����
				
				int b = solutions[j]; 
				
				int target = -a-b; // �������� 0�̵Ǵ� ����� Ư����
				
				// �̺�Ž������ �ִ��� ����� ��� ã��
				int targetIdx = Arrays.binarySearch(solutions, target);
				
				// �����ϴ� ���
				if(targetIdx>=0) {
					
					if(targetIdx==i || targetIdx==j) { // �̹� ������� ���
						
						// �翷���� ��ĭ Ȯ��
						for (int d = 0; d < 4; d++) {
							
							int nextIdx = targetIdx + delta[d];
							
							if(!isValid(nextIdx, i, j)) {
								continue;
							}
							
							long sum  = (long)a+b+solutions[nextIdx];
							if(sum<0) {
								sum *=-1;
							}
							
							if(min>sum) {
								min = sum;
								ans = new int[] {a,b,solutions[nextIdx]};
							}
							
						}
					}else { // Ư������ ���� 0�� �Ǵ� ���
						
						min = 0;
						ans = new int[] {a,b,target};
						break label;
						
					}
					
				}else {// ���� ���
					
					// �翷���� ��ĭ Ȯ��
					for (int d = 0; d < 5; d++) {
						
						int nextIdx = (targetIdx*-1) - 1 + delta2[d];
						
						if(!isValid(nextIdx, i, j)) {
							continue;
						}
						
						long sum  = (long)a+b+solutions[nextIdx];
						if(sum<0) {
							sum *=-1;
						}
						
						if(min>sum) {
							min = sum;
							ans = new int[] {a,b,solutions[nextIdx]};
						}
						
					}
					
				}
			}
		}
		
		Arrays.sort(ans);
		
		System.out.println(ans[0]+" "+ans[1]+" "+ans[2]);
		
	}

	
	// ��밡���� ��ġ�� ������� Ȯ��
	private static boolean isValid(int idx, int i, int j) {
		return idx>=0 && idx<N && idx!=i && idx!=j;
	}

}
