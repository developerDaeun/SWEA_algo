import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_2005_파스칼의삼각형 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		int N;
		int[][] arr;
		
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t + "\n" + "1\n");
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			
			arr[0][0] = 1;
			
			for(int i = 1; i < N; i++) {
				for(int j = 0; j <= i; j++) {
					if(i-1>=0 && j-1>=0) {
						arr[i][j] += arr[i-1][j-1];
					}
					if(i-1>=0) {
						arr[i][j] += arr[i-1][j];
					}
					sb.append(arr[i][j] + " ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}