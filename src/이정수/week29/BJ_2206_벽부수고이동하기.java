package week29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * ����: �� �μ��� �̵��ϱ� ��ũ: https://www.acmicpc.net/problem/2206
 * 
 * Ǯ��:
 * bfs Ž��
 * visited�迭�� ���� �ϳ� �μ� ���¿� ���� �μ��� ���� ���� �ΰ� ���
 * 
 * �ð����⵵:
 * 
 * 
 * Ǯ�̿� �ɸ� �ð�:
 * 30m
 *
 */
public class BJ_2206_���μ����̵��ϱ� {

	static int[][] map;
	static final int TRUE = 0;
	static final int FALSE = 1;
	static int N, M;
	static int[][] delta = { { 0, 0, -1, 1 }, { -1, 1, 0, 0 } };
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String[] split = in.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(split[j]);
			}
		}

		visited = new boolean[2][N][M];

		int ans = bfs();

		System.out.println(ans);
	}

	private static int bfs() {

		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] { 0, 0, 0 });
		visited[0][0][0] = true;
		
		int cnt = 1;

		while (!queue.isEmpty()) {

			int size = queue.size();

			while (size-- > 0) {
				int[] position = queue.poll();

				int row = position[0];
				int col = position[1];
				int canBreak = position[2];

				if (row == N - 1 && col == M - 1) {
					return cnt;
				}

				for (int d = 0; d < 4; d++) {
					int newRow = row + delta[0][d];
					int newCol = col + delta[1][d];

					if (isValid(newRow, newCol, canBreak)) {

						if (canBreak == TRUE) { // ���� ���� �Ⱥμ� ���
							if (map[newRow][newCol] == 1) {
								visited[1][newRow][newCol] = true;
								queue.add(new int[] { newRow, newCol, FALSE });
							} else {
								visited[0][newRow][newCol] = true;
								queue.add(new int[] { newRow, newCol, TRUE });
							}
						} else if (canBreak == FALSE && map[newRow][newCol] == 0) { // ���� �ν��� ������� ���
							visited[1][newRow][newCol] = true;
							queue.add(new int[] { newRow, newCol, FALSE });
						}

					}
				}
			}
			cnt++;

		}

		return -1;
	}

	private static boolean isValid(int newRow, int newCol, int canBreak) {
		return newRow >= 0 && newCol >= 0 && newRow < N && newCol < M && !visited[canBreak][newRow][newCol];
	}

}
