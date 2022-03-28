package week28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


/**
 * ����: �ּڰ� ã��
 * ��ũ: https://www.acmicpc.net/problem/11003
 * 
 * Ǯ��:
 * pq ���.. �ð��ʰ�...
 * 
 * �ð����⵵:
 * 
 * 
 * Ǯ�̿� �ɸ� �ð�:
 * 
 *
 */
public class BJ_11003_�ּڰ�ã��_pq {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] A = new int[N];
		st = new StringTokenizer(in.readLine());
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
			
		});
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			
			A[i] = Integer.parseInt(st.nextToken());
			pq.add(new int[] {A[i], i});
			
			
			while(pq.peek()[1]<=i-L) {
				pq.poll();
			}
			
			int D = pq.peek()[0];
			
			sb.append(D + " ");
			
		}
		
		System.out.println(sb.toString());
	}

}
