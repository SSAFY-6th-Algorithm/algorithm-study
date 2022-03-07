package week24;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * ����: �޴� ������
 * ��ũ: https://programmers.co.kr/learn/courses/30/lessons/72411
 * 
 * Ǯ��:
 * 1. ������ ��� ���� ����
 * 2. ī��Ʈ �Ͽ� ������ �ڽ� �̾Ƴ���
 * 
 * 
 * �ð����⵵:
 * 
 * 
 * Ǯ�̿� �ɸ� �ð�:
 * 
 *
 */
public class PG_72411_�޴������� {

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(solution(new String[] {"XYZ", "XWY", "WXA"}, new int[] {2,3,4})));
	}
	
	
	static Map<String, Integer> map = new HashMap<>(); // ������ ��� �ڽ��丮 ����
	static List<String> temp, list = new LinkedList<>();
	
	static public String[] solution(String[] orders, int[] course) {
		
		// ������ ��� �������� �ڽ��丮 �ĺ��� �����
		for (String order : orders) {
			for (int numberOfMenu : course) {
				comb(order, 0, 0,  numberOfMenu, "");
			}
		}
		
		
		for (int numberOfMenu : course) {// ������ �ڽ��丮�� ���Ե� �� ��ǰ�� ��������
			
			temp = new LinkedList<>(); // �ӽú���
			int max = 0; 
			
			for (Map.Entry<String, Integer> entry : map.entrySet()) { // ��� �ڽ��丮 �ĺ������� ����
				
				if(entry.getKey().length()==numberOfMenu) { // ���� Ȯ���Ϸ����ϴ� ��ǰ ������ �ش��ϴ� �ĺ��̸�
					
					if(max<entry.getValue() && entry.getValue()>1) { // ���ݱ��� Ȯ���ߴ� �ĺ��ڽ��麸�� �󵵰� ���� 1���̻� ��������
						temp = new LinkedList<>(); // temp �ʱ�ȭ �� �߰�
						temp.add(entry.getKey());
						max = entry.getValue();
						
					}else if(max==entry.getValue()) { // ���� ���� ���� �Բ� �ֹ��� �޴� ������ ���� �����, ��� �迭�� ���
						temp.add(entry.getKey());
					}
					
				}
				
			}
			
			// �̾Ƴ� �ڽ��丮 �������Ʈ�� ���
			for (String i : temp) {
				list.add(i);
			}
		}
		
		// �迭�� ����
        String[] answer = new String[list.size()];
        for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
        Arrays.sort(answer);
        return answer;
    }



	private static void comb(String order, int depth, int start, int numberOfMenu, String result) {
		
		if(depth==numberOfMenu) {
			result = sortAsc(result);
			if(!map.containsKey(result)) {
				map.put(result, 1);
			}else {
				map.replace(result, map.get(result)+1);
			}
			return;
		}
		
		for (int i = start; i < order.length(); i++) {
			comb(order, depth+1, i+1, numberOfMenu, result + order.charAt(i));
		}
		
	}
	
	// ���ڿ��� ������������ ����
	static String sortAsc(String str) {
		char[] arr = str.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}

}
