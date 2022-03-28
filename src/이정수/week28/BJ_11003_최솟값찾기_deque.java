package week28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * ����: �ּڰ� ã��
 * ��ũ: https://www.acmicpc.net/problem/11003
 * 
 * Ǯ��:
 * deque ���
 * 
 * �ð����⵵:
 * 
 * 
 * Ǯ�̿� �ɸ� �ð�:
 * 
 *
 */

public class BJ_11003_�ּڰ�ã��_deque {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] A = new int[N];
		st = new StringTokenizer(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		Deque<int[]> deque = new ArrayDeque<int[]>();
		
		for (int i = 0; i < N; i++) {
			
			A[i] = Integer.parseInt(st.nextToken());
			
			// deque�ȿ� �ִ� ������ ���� �ִ� ������ ���������� ������
			while(!deque.isEmpty() && deque.peekLast()[0]>=A[i]) {
				deque.pollLast();
			}
			
			deque.offer(new int[] {A[i], i});
			
			while(deque.peek()[1]<=i-L) { // �����̵� ������ ������ �Ѵ� ������ ����
				deque.poll();
			}
			
			int D = deque.peek()[0];
			
			sb.append(D + " ");
			
		}
		
		System.out.println(sb.toString());
	}

}
