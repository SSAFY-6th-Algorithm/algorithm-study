package week25;

import java.util.LinkedList;
import java.util.List;

public class PG_92343_�������2 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {0,0,1,1,1,0,1,0,1,0,1,1}, new int[][] {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}}));
	}
	
	static List<Integer>[] childs;
	static int[] Info;
	static int max = 0;
	
	static public int solution(int[] info, int[][] edges) {
		
		childs = new List[info.length];
		Info = info;
		
		for (int i = 0; i < edges.length; i++) {
			
			int parent = edges[i][0];
			int child = edges[i][1];
			
			if(childs[parent]==null) {
				childs[parent] = new LinkedList<Integer>();
			}
			
			childs[parent].add(child);
		}
		
		List<Integer> list= new LinkedList<Integer>();
		list.add(0);
		traversal(0, 0, 0, list);
        return max;
    }

	private static void traversal(int currentNode, int sheepCnt, int wolfCnt, List<Integer> postChilds) {
		
		// �� Ȥ�� ���� �߰�
		if(Info[currentNode]==0) sheepCnt++;
		else wolfCnt++;
		
		if(wolfCnt>=sheepCnt) return; // �Ұ��� ����
		
		max = Math.max(max, sheepCnt);
		
		// ���� Ž�� ��ġ �ĺ� ���ϱ�
		List<Integer> nextNodes = new LinkedList<Integer>();
		nextNodes.addAll(postChilds);
		
		nextNodes.remove(Integer.valueOf(currentNode)); // ���� ���� ����
		
		if(childs[currentNode]!=null) {
			for (int child : childs[currentNode]) { // ���� ����� �ڽ� ����
				nextNodes.add(child);
			}
		}
		
		for (int nextNode : nextNodes) {
			traversal(nextNode, sheepCnt, wolfCnt, nextNodes);
		}
		
	}
}
