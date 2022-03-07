package week25;

import java.util.Scanner;

/**
 * ����: ������
 * ��ũ: https://www.acmicpc.net/problem/1107
 * 
 * Ǯ��:
 * 
 * 
 * �ð����⵵:
 * 
 * 
 * Ǯ�̿� �ɸ� �ð�:
 * 
 *
 */
public class BJ_1107_������ {
	
	static int min, N, digitsCnt;
	static int[] buttons;
	static boolean[] isBroke = new boolean[10];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int M = sc.nextInt();
		
		// �� �ڸ��� ���ϱ�
		digitsCnt = Integer.toString(N).length();
		
		// ���峭 ��ư ���ϱ�
		for (int i = 0; i < M; i++) {
			
			isBroke[sc.nextInt()] = true;
			
		}
		
		// 100�� ä�ο��� +- ��ư���� �����ϴ� ���
		min = Math.abs(100 - N);
		
		// �ߺ�����
		permutationWithRepition(0, 0);
		
		System.out.println(min);
	}

	
	// �ߺ�����
	private static void permutationWithRepition(int depth, int result) {
		
		if(depth>=digitsCnt-1) {
			min = Math.min(min, Integer.toString(result).length() + Math.abs(N - result)); // �ּ� Ƚ�� ����
			if(depth==digitsCnt+1) return;
		}
		
		for (int i = 0; i < 10; i++) {
			if(isBroke[i]) continue;
			permutationWithRepition(depth+1, (result*10)+i);
		}
		
	}

}
