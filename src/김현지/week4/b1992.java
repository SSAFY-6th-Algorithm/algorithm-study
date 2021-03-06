package baekjoon.aug.aug17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 1992 쿼드트리
 *
 * 접근 방식:
 * 분할 정복으로 접근했습니다.
 * 4분할로 쪼개가면서 해당 영역에 같은 숫자만 있는지 확인합니다.
 * 괄호는 덩어리 하나에 괄호 하나씩 포함시킵니다.
 *
 * 시간 복잡도:
 * O(logN)
 */

public class b1992 {

    static int[][] map;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        // 배열을 입력으로 받을 경우에는 버퍼를 사용합니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        // 배열을 초기화합니다.
        for (int i = 0; i < N; ++i) {
            // 공백 없이 들어오기 때문에, 우선 char로 변경 후 형변환 해주었습니다.
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < N; ++j) {
                map[i][j] = Character.getNumericValue(input[j]);
            }
        }

        quadTree(0,0, N);
        System.out.println(sb);

    }

    // 쿼드 트리를 분할 정복으로 구하는 메소드입니다.
    // r: 시작 행, c: 시작 열, size: 배열 크기 -> 범위로 재귀처리했습니다.
    private static void quadTree(int r, int c, int size) {
        if (canZip(r, c, size)) {       // 압축이 가능하다면
            sb.append(map[r][c]);         // 현재 숫자를 결과 문자열에 저장합니다.
            return;
        }

        // size의 반을 구한다.
        int half = size / 2;

        sb.append("("); // 압축이 불가능하므로 괄호를 먼저 추가합니다.
        // 4등분으로 나누어서 재귀 처리합니다.
        quadTree(r, c, half);
        quadTree(r, c+half, half);
        quadTree(r+half, c, half);
        quadTree(r+half, c+half, half);
        sb.append(")"); // 4등분에서 모두 압축이 완료되었을 것이므로 괄호를 닫아줍니다.
    }

    // 압축이 가능한지 확인하는 메소드입니다.
    // 해당 범위에서 같은 숫자만이 존재하는지 확인하여 boolean으로 리턴합니다.
    private static boolean canZip(int r, int c, int size) {
        int num = map[r][c];

        for (int i = r; i < r+size; ++i) {
            for (int j = c; j < c+size; ++j) {
                if (num != map[i][j]) return false;
            }
        }
        return true;
    }
}
