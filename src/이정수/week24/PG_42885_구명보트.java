package week24;

import java.util.Arrays;

/**
 * ����: ����Ʈ
 * ��ũ: https://programmers.co.kr/learn/courses/30/lessons/42885
 * 
 * Ǯ��:
 * 1. �������� ����
 * 2. ���ʳ��� �ε����� �����Ͽ� �� ��ġ�� ���� limit������ ��� �Ѵ� �¿��
 * �ƴ� ��� ���ſ� ����� �¿��
 * 
 * 
 * �ð����⵵:
 * O(N)
 * 
 * Ǯ�̿� �ɸ� �ð�:
 * 20m
 *
 */

public class PG_42885_����Ʈ {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {70, 80, 50}, 100));
	}
	
	static public int solution(int[] people, int limit) {
		
		int left = 0;
		int right = people.length-1;
		
		Arrays.sort(people);
		
		int numberOfBoat = 0;
		
		while(left<=right) {
			if(people[left]+ people[right]<=limit) {
				left++;
				right--;
			}else {
				right--;
			}
			numberOfBoat++;
		}
		
        return numberOfBoat;
    }

}
