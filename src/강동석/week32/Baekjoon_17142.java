package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 연구소 3
/*
 * 조합을 이용하여 가능한 모든 경우의 수를 실행한다.
 * 바이러스 확산 시 0으로 된 칸이 다 채워지면 2로 된 칸이 남아있어도 종료해야한다.
 * 기존의 최적화 값보다 더 긴 시간 이동 시 가지치기를 이용하였다.
 */
public class Baekjoon_17142 {

	static int N,M,size,emptyCnt,answer;
	static int[][] map;
	static int[] comb;
	static ArrayList<int[]> pos;
	static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}}; // 상,우,하,좌
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		map = new int[N][N];
		comb = new int[M];
		pos = new ArrayList<int[]>();
		for(int i=0; i<N; ++i) {
			str = br.readLine().split(" ");
			for(int j=0; j<N; ++j) {
				map[i][j] = Integer.parseInt(str[j]);
				if(map[i][j]==2) { // 바이러스 활성가능 위치 저장
					pos.add(new int[] {i,j});
				}else if(map[i][j]==0) { // 벽의 갯수 저장
					emptyCnt++;
				}
			}
		}
		size = pos.size();
		answer = Integer.MAX_VALUE;
		combination(0,0);
		if(answer==Integer.MAX_VALUE) {
			answer = -1;
		}
		System.out.println(answer);
	}
	
	public static void combination(int n, int idx) {
		if(n==M) { // 위치 M개 선택했으면
			bfs();
			return;
		}
		
		for(int i=idx; i<size; ++i) {
			comb[n] = i;
			combination(n+1, i+1);
		}
	}
	
	public static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][N];
		for(int idx : comb) {
			int[] cur = pos.get(idx);
			q.add(cur);
		}
		int dist = -1;
		int cnt = 0; // 0을 채우는 갯수
		while(!q.isEmpty()) {
			dist++; // 거리증가
			if(dist>=answer) break; // 가지치기, 기존보다 더 멀리가면 더 이상 비교 X
			int size = q.size();
			while(size-->0) {
				int[] cur = q.poll();
				int r = cur[0];
				int c = cur[1];
				if(visited[r][c]) continue;
				visited[r][c] = true;
				if(map[r][c]==0) cnt++; // 빈칸이면 갯수 증가
				if(cnt==emptyCnt) {
					answer = dist;
					return; // 빈칸 다 채우면 종료
				}
				for(int d=0; d<4; ++d) {
					int nr = r+dir[d][0];
					int nc = c+dir[d][1];
					if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc]) continue; // 경계 및 방문체크
					if(map[nr][nc]!=1) { // 다음칸이 벽이 아니면
						q.offer(new int[] {nr,nc});
					}
				}
			}
		}
	}
}