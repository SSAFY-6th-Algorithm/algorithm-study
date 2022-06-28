package week37;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ����: ����
 * ��ũ: https://www.acmicpc.net/problem/2559
 * 
 * Ǯ��: ������
 * 
 * 
 * �ð����⵵:O(N)
 * 
 * 
 * Ǯ�̿� �ɸ� �ð�: 20min
 * 
 *
 */
public class BJ_2559_���� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		int[] accSum = new int[N-K+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// ùK�� ���� ������
		for (int i = 0; i < K; i++) {
			accSum[0] += arr[i];
		}
		
		int max= accSum[0];
		for (int i = K; i < N; i++) {
			accSum[i-K+1] += arr[i] + accSum[i-K] - arr[i-K];
			max = Math.max(max, accSum[i-K+1]);
		}
		
		System.out.println(max);
	}

}
