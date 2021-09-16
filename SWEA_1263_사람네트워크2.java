import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class SWEA_1263_사람네트워크2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		int N;
		int[][] map;

		int INF = 1_000_000;

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 사람 노드 수
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (i != j && map[i][j] == 0) {
						map[i][j] = INF;
					}
				}
			}

			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
					}
				}
			}

			int min = INF;
			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum = 0;
				for (int j = 0; j < N; j++) {
					sum += map[i][j];
				}
				min = Math.min(min, sum);
			}

			sb.append("#" + t + " " + min + "\n");
		}
		
		System.out.println(sb);
	}
}