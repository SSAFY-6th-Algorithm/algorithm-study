package week26;

import java.util.PriorityQueue;

/**
 * ����: �� �ʰ�
 * ��ũ: https://programmers.co.kr/learn/courses/30/lessons/42626
 * 
 * Ǯ��:
 * ���ڷᱸ���� pq�� ������ ���ں� ������������ ����
 * ��� ������ ���ں� ������ k�̻��� �ɶ�����
 * pq���� �ΰ��� ������ ������ ���ο� ���� ���ϱ�
 * 
 * 
 * �ð����⵵:
 * 
 * 
 * Ǯ�̿� �ɸ� �ð�:
 * 
 *
 */
public class PG_42626_���ʰ� {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 2, 3, 9, 10, 12}, 7));
	}
	
	static public int solution(int[] scoville, int K) {
		
		int numberOfFoodBelowK = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		// pq �ʱ�ȭ
		for (int i = 0; i < scoville.length; i++) {
			int scovilleOfFood = scoville[i];
			if(scovilleOfFood<K) {
				numberOfFoodBelowK++;
			}
			pq.add(scovilleOfFood);
		}
		
		int cnt = 0; // ���� Ƚ��
		
		while(numberOfFoodBelowK>0 && pq.size()>1) { // k������ ������ �ְ� ������ ������ 1������ ���� ��
			int sum = pq.poll() + pq.poll()*2;
			if(sum>=K) {
				numberOfFoodBelowK -=2;
			}else {
				numberOfFoodBelowK--;
			}
			
			pq.add(sum);
			cnt++;
		}
		
		if(numberOfFoodBelowK>0) return -1;
		
        return cnt;
    }
}
