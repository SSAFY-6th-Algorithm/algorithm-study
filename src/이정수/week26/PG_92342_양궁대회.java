package week26;

import java.util.Arrays;

/**
 * ����: ��ô�ȸ
 * ��ũ: https://programmers.co.kr/learn/courses/30/lessons/92342
 * 
 * Ǯ��:
 * ��Ž
 * 
 * 
 * �ð����⵵:
 * ?
 * 
 * Ǯ�̿� �ɸ� �ð�:
 * 4h
 *
 */
public class PG_92342_��ô�ȸ {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(5, new int[] {2,1,1,1,0,0,0,0,0,0,0})));
	}
	
	static int[] result = {-1};
	static int N, maxScoreDiff = 0;
	static int[] Info;
	public static int[] solution(int n, int[] info) {
		
		Info = info;
		N = n; // ȭ�� n��
		
		dfs(0,0, new int[] {0,0,0,0,0,0,0,0,0,0,0}); // 10��, 9��, 8�� ..., 0��
		
		return result;
        
    }
	
	private static void dfs(int depth, int arrowCnt, int[] record) {
		
		if(depth==10) { // ��� ���ῡ ���� ȭ�� ���� Ƚ�� ����� ������
			record[10] = N - arrowCnt;
			if(result[0]==4) {
				System.out.println(Arrays.toString(result));
			}
			// ���� ���
			int[] scores = calcScore(record);
			int scoreDiff = scores[1]-scores[0];
			
			if(scoreDiff>0) {// �̰��
				
				if(maxScoreDiff<scoreDiff) { // ���� �������̺��� �� ū �������̷� �̱� ���
					result = Arrays.copyOf(record, record.length);
					maxScoreDiff = scoreDiff;
				}
				else if(maxScoreDiff==scoreDiff) { // ���� �������� �����ϸ�
					// ���� ���� ������ �� ���� ���� ��� ���ϱ�
					for (int i = 10; i >= 0; i--) {
						if(record[i]>result[i]) {
							result = Arrays.copyOf(record, record.length);
							break;
						}else if(record[i]<result[i]) {
							break;
						}
					}
				}
				
			}
			
			return;
		}
		
		int availableArrows = N-arrowCnt;
		
		for (int arrows = 0; arrows <= availableArrows; arrows++) {
			record[depth] = arrows;
			dfs(depth+1, arrowCnt+arrows, record);
		}
		
		
	}
	private static int[] calcScore(int[] record) {
		
		int scores[] = {0,0}; // {����ġ ����, ���̾� ����}
		
		for (int i = 0; i < 11; i++) {
			if(Info[i]==0 && record[i]==0) continue;
			if(Info[i]<record[i]) {
				scores[1] += 10-i;
			}else {
				scores[0] += 10-i;
			}
		}
		
		return scores;
		
	}

}
