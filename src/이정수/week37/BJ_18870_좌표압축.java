package week37;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * ����:
 * ��ũ:
 * 
 * Ǯ��:
 * ���� for������ �� ���ҿ� ���� �ٸ� ��� ���ҿ� ũ�� �񱳸� �ϸ� O(N^2)�ð�����
 * �ð��ʰ��� �Ͼ �� �ֽ��ϴ�. ���� ������ ����ؾ��մϴ�. ���� ����� X_i>X_j�� ����
 * �ϴ� ���� �ٸ� ��ǥ�� ������ �����Ƿ� �ߺ��� ���Ҹ� �����ָ� ���Ŀ� �ɸ��� �ð��� ����
 * �Ҽ� �ֽ��ϴ�. ���� �÷����� Set ��ü�� ������� �ڿ� ������ �����ϸ� �ε����� ������
 * ���Һ��� ���� ������ ���� ���� �ֽ��ϴ�. �� ������ ��ġ�� binary search�� ���մϴ�.
 * 
 * �ð����⵵:
 * ���Ŀ��� O(NlogN), Set��ü�� ���鶧 ������� �ð��� �ɸ����� �� �𸣰ڽ��ϴ�.
 * 
 * Ǯ�̿� �ɸ� �ð�:
 * 
 *
 */
public class BJ_18870_��ǥ���� {

	public static void main(String[] args) throws IOException {
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(bin.readLine());
		
		int[] coordinates = Arrays.asList(bin.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
		
		Set<Integer> set = new HashSet<>(Arrays.stream(coordinates).boxed().collect(Collectors.toList()));
		
		ArrayList<Integer> list = new ArrayList<>(set); //Set -> ArrayList

		Collections.sort(list); //����
		
		int[] sorted = new int[list.size()];

		for(int i = 0; i < list.size(); i++) { //ArrayList -> Array
			sorted[i] = list.get(i);
		}
		
		for(int coordinate:coordinates) {
			sb.append((Arrays.binarySearch(sorted, coordinate)+" "));
		}
		
		
		System.out.println(sb.toString());
		
	}

}
