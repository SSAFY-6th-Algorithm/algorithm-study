package week35;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * ����: �� ���
 * ��ũ: https://www.acmicpc.net/problem/2470
 * 
 * Ǯ��:
 * �������� ����
 * ���� ������ ����
 * �μ��� ���� ����� ������ ������ �������� �̵�
 * ������ ���� ������ ���������� �̵�
 * 
 * 
 * �ð����⵵:
 * O(NlogN)
 * 
 * Ǯ�̿� �ɸ� �ð�:
 * 30m
 * 
 *
 */
public class BJ_2470_�ο�� {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int N = Integer.parseInt(br.readLine());
		int[] solutions = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			solutions[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.parallelSort(solutions);
		
		int ans1 = -1;
		int ans2 = -1;
		int minSum = 2000000000;
		
		int left = 0;
        int right = N-1;
        int max = 2000000000;
 
        while(left < right) {
            int sum = solutions[left] + solutions[right];
 
            // �� ��� ����
            if(Math.abs(sum) < max) {
            	ans1 = solutions[left];
                ans2 = solutions[right];
                max = Math.abs(sum);
            }
 
            if(sum > 0)
                right--;
            else
                left++;
        }
		
		System.out.println(ans1 + " " + ans2);
	}

}
