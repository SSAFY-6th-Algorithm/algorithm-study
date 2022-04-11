package week29;

import java.util.Scanner;

/**
 * ����: ������׷�
 * ��ũ: https://www.acmicpc.net/problem/1725
 * 
 * Ǯ��:
 * ���� ����
 * ���ݾ� �����Ͽ� ���� ���׸�Ʈ���� ���� �� �ִ� ���� ū ���簢���� ����
 * �����ʿ��� ���� ū ���� ���ϴ� ������ �����ϴ� ����ū ���簢���� ���̸� ���Ͽ�
 * ���� ū ���� ����
 * 
 * �ð����⵵:
 * 
 * 
 * Ǯ�̿� �ɸ� �ð�:
 * 
 *
 */

public class BJ_1725_������׷� {
	
	static int[] histogram;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		histogram = new int[N];
		
		for (int i = 0; i < N; i++) {
			histogram[i] = sc.nextInt();
		}
		
		int ans = getMaxRectangleArea(0,N-1);
		
		System.out.println(ans);
	}

	private static int getMaxRectangleArea(int from, int to) {
		
		if(from==to) {
			return histogram[from];
		}
		
		int left = (from+to)/2;
		int right = left;
		
		// ���� �κ� �ִ� ���簢�� ����
		int leftMaxRectangleArea = getMaxRectangleArea(from, left);
		
		// ������ �κ� �ִ� ���簢�� ����
		int rightMaxRectangleArea = getMaxRectangleArea(right+1, to);
		
		// ��ġ�� �κ��� �����ϴ� �ִ� ���簢�� ����
		int maxArea = histogram[right];
		int height = histogram[right];
		
		while(left>from && right<to) {
			
			if(histogram[left-1]>histogram[right+1]) {
				left--;
				height = Math.min(height, histogram[left]);
				
			}else {
				right++;
				height = Math.min(height, histogram[right]);
			}
			
			maxArea = Math.max(maxArea, (right-left+1) * height);
			
		}
		
		while(right<to) {
			right++;
			height = Math.min(height, histogram[right]);
			maxArea = Math.max(maxArea, (right-left+1) * height);
		}
		
		while(left>from) {
			left--;
			height = Math.min(height, histogram[left]);
			maxArea = Math.max(maxArea, (right-left+1) * height);
		}
		
		return Math.max(Math.max(leftMaxRectangleArea, rightMaxRectangleArea), maxArea);
		
	}

}
