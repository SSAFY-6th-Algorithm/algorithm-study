package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 트리 수정
/*
 * 트리의 지름: 두 노드간의 모든 경로 중에서 최장 경로, 지름이 여러개 존재할 수 있다.
 * 트리의 지름을 구하는 법을 알아야만 거의 해결가능한 문제이다.
 * 지름을 구하는 법은 다음과 같다.
 * 	1. 아무 노드에서 가장 먼 노드를 찾는다.
 * 	2. 1번에서 찾은 노드는 무조건 지름의 양끝 노드 중 하나이므로,
 * 		해당 노드에서 가장 멀리 있는 노드까지의 길이가 지름이다.
 */
public class Baekjoon_12912 {

	static int N;
	static long answer;
	static boolean[] chosen,visited;
	static ArrayList<int[]>[] adjlist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		chosen = new boolean[N];
		adjlist = new ArrayList[N];
		for(int i=0; i<N; ++i) {
			adjlist[i] = new ArrayList<int[]>();
		}
		String[] line;
		for(int i=1; i<N; ++i) {
			line = br.readLine().split(" ");
			int from = Integer.parseInt(line[0]);
			int to = Integer.parseInt(line[1]);
			int cost = Integer.parseInt(line[2]);
			adjlist[from].add(new int[] {to, cost}); 
			adjlist[to].add(new int[] {from, cost}); 
		}
		chosen[0] = true;
		chooseEdge(0); // 끊을 간선을 하나씩 선택
		
		System.out.println(answer);
	}
	
	public static void chooseEdge(int n) {
		chosen[n] = true;
		
		for(int[] node: adjlist[n]) {
			int next = node[0];
			if(chosen[next]) continue; // 방문했으면 무시
			long sum = getSumDiameter(n,next);
			answer = Math.max(answer,sum+node[1]);
			chooseEdge(next);
		}
	}
	
	public static long getSumDiameter(int a, int b) {
		long diaA = getDiameter(a,b);
		long diaB = getDiameter(b,a);
		return diaA+diaB;
	}
	
	static int node; // 가장 먼 노드
	static long maxLen; // 가장 먼 길이
	
	public static long getDiameter(int n1, int n2) { // n2를 막고 n1노드가 포함된 트리의 지름의 길이를 반환
		visited = new boolean[N];
		visited[n2] = true;
		node = n1; // 자신으로 제일 먼 노드 초기화
		maxLen = 0;
		dfs(n1,0); // n에서 제일 먼 노드와 거리 찾기
		
		visited = new boolean[N];
		visited[n2] = true;
		maxLen = 0; // 길이 초기화
		dfs(node,0); // node에서 제일 먼 노드와 거리 찾기
		return maxLen; // 지름 반환
	}
	
	public static void dfs(int n, long sum) {
		visited[n] = true;
		if(maxLen<sum) {
			maxLen=sum;
			node = n;
		}
		
		for(int[] node : adjlist[n]) {
			int to = node[0];
			int cost = node[1];
			if(!visited[to]) {
				dfs(to, sum+cost);
			}
		}
	}
}