package week25;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PG_17684_���� {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("ABABABABABABABAB")));
	}
	
	static public int[] solution(String msg) {
		
		Map<String, Integer> map = new HashMap<>() {{
			put("A",1);
			put("B",2);
			put("C",3);
			put("D",4);
			put("E",5);
			put("F",6);
			put("G",7);
			put("H",8);
			put("I",9);
			put("J",10);
			put("K",11);
			put("L",12);
			put("M",13);
			put("N",14);
			put("O",15);
			put("P",16);
			put("Q",17);
			put("R",18);
			put("S",19);
			put("T",20);
			put("U",21);
			put("V",22);
			put("W",23);
			put("X",24);
			put("Y",25);
			put("Z",26);
		}};
			
		int startPoint = 0;
		int maxLen = 1;
		int newIdx = 27;
		
		List<Integer> ansList = new LinkedList<>();
		
		while(startPoint<msg.length()) {
			
			// �������� ���� �Է°� ��ġ�ϴ� ���� �� ���ڿ� w�� ã��
			int len = Math.min(maxLen, msg.length()-startPoint);
			int idx; // ������ ���� ��ȣ
			String w;
			while(true) {
				w = msg.substring(startPoint, startPoint+len);
				if(map.containsKey(w)) {
					idx = map.get(w);
					break;
				}
				len--;
			}
			
			// w�� �ش��ϴ� ������ ���� ��ȣ�� ���
			ansList.add(idx);
			
			// �Է¿��� ó������ ���� ���� ���ڰ� �����ִٸ�(c), w+c�� �ش��ϴ� �ܾ ������ ���
			if(startPoint+len<msg.length()) {
				map.put(msg.substring(startPoint, startPoint+len+1), newIdx++);
				maxLen = Math.max(maxLen, w.length()+1);
			}
			
			// �Է¿��� w�� ����
			startPoint += len;
		}
		
		
		
        int[] answer = ansList.stream().mapToInt(i->i).toArray();
        return answer;
    }
}
