package week29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ����: ���� �ڸ���
 * ��ũ: https://www.acmicpc.net/problem/1654
 * 
 * Ǯ��:
 * upper bound
 * 
 * �ð����⵵:
 * 
 * 
 * Ǯ�̿� �ɸ� �ð�:
 * 
 *
 */
public class BJ_1654_�����ڸ��� {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] len = new int[K];
		long max = -1;
		for (int i = 0; i < K; i++) {
			len[i] = Integer.parseInt(in.readLine());
			max = Math.max(max, len[i]);
		}
		
		long left=0, right=max+1, mid = 0; // upper bound�� ���ؾ��ϹǷ� max���� ���ϴ� ���϶��� ���� max + 1�� right�� ����
		
		while(left<right) {
			mid = (left + right)/2;
			// ��������� ������ ���� ���ϱ�
			long cnt = 0;
			for (int i = 0; i < K; i++) {
				cnt += len[i]/mid;
			}
			
			if(cnt>=N) { // N�� ���� ���ų� ���� ������ ��������� ���� ���� �ø���
				left = mid+1;
			}else { // N������ ���� ������ ��������� ���� ���� ���̱�
				right = mid;
			}
		}
		
		System.out.println(left-1);
		
	}

}
