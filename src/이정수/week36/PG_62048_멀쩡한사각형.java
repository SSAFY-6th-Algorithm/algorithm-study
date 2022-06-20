package week36;

/**
 * ����: ������ �簢��
 * ��ũ: https://programmers.co.kr/learn/courses/30/lessons/62048?language=java
 * 
 * 
 * 
 * �ð����⵵:
 * 
 * 
 * Ǯ�̿� �ɸ� �ð�:
 * 
 *
 */
public class PG_62048_�����ѻ簢�� {

	public static void main(String[] args) {
		System.out.println(solution(8,12));
	}
	
	static public long solution(int w, int h) {
        long answer = (long)w*h - (w + h - gcd(w,h));
        return answer;
    }

	private static int gcd(int w, int h) {
		
		int biggerNum = Math.max(w, h);
		int smallerNum = Math.min(w, h);
		
		while(biggerNum%smallerNum!=0) {
			int quotient = biggerNum / smallerNum;
			int remainder = biggerNum % smallerNum;
			
			biggerNum = smallerNum;
			smallerNum = remainder;
		}
		
		return smallerNum;
	}

}
