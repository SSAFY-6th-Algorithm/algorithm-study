package week27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * ����: ��ȥ��
 * ��ũ: https://www.acmicpc.net/problem/5567
 * 
 * Ǯ��:
 * ģ�����踦 ��Ÿ���� ������ boolean �迭 ����
 * ����̿� ģ���� ��� ģ���� ģ���� Ȯ��
 * 
 * �ð����⵵:
 * O(N^2)
 * 
 * Ǯ�̿� �ɸ� �ð�:
 * 20m
 *
 */
public class BJ_5567_��ȥ�� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		int m = Integer.parseInt(in.readLine());
		
		boolean[][] friendRelationTable = new boolean[n+1][n+1]; // ģ�� ���� ���̺�
		
		for (int i = 0; i < m; i++) {
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			friendRelationTable[a][b] = true;
			friendRelationTable[b][a] = true;
			
		}
		
		
		boolean[] visited = new boolean[n+1]; // ���� ����
		int cnt = 0; // �����ϴ� ���� ī��Ʈ ����
		
		
		for (int i = 2; i <= n; i++) {
			
			if(friendRelationTable[1][i]) { // ����̿� ģ�� �����̸� 
				// ���� �����ڿ� ���Ե��� �ʾҴٸ� ����
				if(!visited[i]) {
					cnt++;
					visited[i] = true;
				}
				
				for (int j = 2; j <= n; j++) { // ģ���� ģ���� Ȯ��
					if(friendRelationTable[i][j] && !visited[j]) {
						cnt++;
						visited[j] = true;
					}
				}
				
			}
			
		}
		
		System.out.println(cnt);
		
	}

}
