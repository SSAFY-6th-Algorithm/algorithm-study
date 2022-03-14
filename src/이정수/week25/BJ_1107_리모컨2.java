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
public class BJ_1107_������2 {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		// �� �ڸ��� ���ϱ�
		int digitsCnt = Integer.toString(N).length();
		
		boolean[] isBroke = new boolean[10];
		
		// ���峭 ��ư ���ϱ�
		for (int i = 0; i < M; i++) {
			
			isBroke[sc.nextInt()] = true;
			
		}
		
		// 100�� ä�ο��� +- ��ư���� �����ϴ� ���
		int min = Math.abs(100 - N);
		
		String[] buttons = {"0","1","2","3","4","5","6","7","8","9"};
		
		for (int i = 0; i < 999999; i++) {
			boolean flag = false;
			String numberInStr = Integer.toString(i);
			for (int j = 0; j < 10; j++) {
				if(isBroke[j] && numberInStr.contains(buttons[j])) {
					flag= true;
					break;
				}
			}
			if(flag) continue;
			
			min = Math.min(min, numberInStr.length() + Math.abs(N-i));
		}
		
		
		System.out.println(min);
	}

	
}
