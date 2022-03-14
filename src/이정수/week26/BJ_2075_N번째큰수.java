package week26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * ����: N��° ū ��
 * ��ũ: https://www.acmicpc.net/problem/2075
 * 
 * Ǯ��:
 * ���ڷᱸ���� ũ������� ����
 * 
 * �ð����⵵:
 * O(NlogN)
 * 
 * Ǯ�̿� �ɸ� �ð�:
 *  30min
 *
 */
public class BJ_2075_N��°ū�� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				pq.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		for (int i = 0; i < N-1; i++) {
			pq.poll();
		}
		
		System.out.println(pq.poll());
		
	}

}
