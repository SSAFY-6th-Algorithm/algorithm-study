package week30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * ����: ���� ����ũ ��ũ: https://www.acmicpc.net/problem/16235
 * 
 * Ǯ��:
 * ��� ������ ���̼����� �������� �����Ͽ� ��� �ֱ�
 * ĭ���� ������ ���� ������ �ʿ� ����
 * 
 * 
 * �ð����⵵:
 * O(?)
 * 
 * Ǯ�̿� �ɸ� �ð�:
 * 2h
 *
 */
public class BJ_16235_��������ũ {

	static class Tree implements Comparable<Tree> {
		int r, c, age;

		public Tree(int r, int c, int age) {
			super();
			this.r = r;
			this.c = c;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}

	}

	static int[][] ground, A;
	static List<Tree> trees;
	static Queue<Tree> deadTrees, breedingTrees;
	static int N, treeCnt;
	static int[][] delta = { { 0, 0, -1, 1, -1, 1, -1, 1 }, { -1, 1, 0, 0, -1, 1, 1, -1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		treeCnt = 0;
		A = new int[N][N];
		ground = new int[N][N];
		deadTrees = new LinkedList<>();
		breedingTrees = new LinkedList<>();
		trees = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				ground[i][j] = 5;
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());

			trees.add(new Tree(x, y, z));
			treeCnt++;
		}

		for (int year = 0; year < K; year++) {
			spring();
			summer();
			fall();
			winter();
		}

		System.out.println(treeCnt);

	}

	private static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ground[i][j] += A[i][j];
			}
		}
	}

	private static void fall() {

		while (!breedingTrees.isEmpty()) {
			Tree tree = breedingTrees.poll();
			for (int d = 0; d < 8; d++) {
				int newRow = tree.r + delta[0][d];
				int newCol = tree.c + delta[1][d];

				if (isValid(newRow, newCol)) {
					trees.add(new Tree(newRow, newCol, 1));
					treeCnt++;
				}
			}
		}

	}

	private static boolean isValid(int newRow, int newCol) {
		return newRow >= 0 && newCol >= 0 && newRow < N && newCol < N;
	}

	private static void summer() {

		// ���� ���� ������� �߰�
		while (!deadTrees.isEmpty()) {
			Tree deadTree = deadTrees.poll();
			ground[deadTree.r][deadTree.c] += deadTree.age / 2;
		}

	}

	private static void spring() {

		// ���� �������� ����
		Collections.sort(trees);

		// ���ͷ����� ����
		Iterator<Tree> it = trees.iterator();

		while (it.hasNext()) {
			Tree tree = it.next();

			// ����� ������ ���
			if (ground[tree.r][tree.c] < tree.age) {
				deadTrees.add(tree);
				it.remove();
				treeCnt--;
				continue;
			}

			// ��� ���
			ground[tree.r][tree.c] -= tree.age;
			tree.age++;

			// ���İ����� ���� ť�� �߰�
			if (tree.age % 5 == 0) {
				breedingTrees.add(tree);
			}
		}

	}
}
