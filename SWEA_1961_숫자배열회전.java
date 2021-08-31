import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1961_숫자배열회전 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		int N;
		int[][] arr, copyArr;
		String[][] res;
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			copyArr = new int[N][N];	// 복사배열
			res = new String[N][3];		// 결과배열
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int k = 0; k < 3; k++) {	// 90, 180, 270도 회전
				for(int i = 0; i < N; i++) {	// 원본배열에서 복사배열에 회전값 넣기
					for(int j = 0; j < N; j++) {
						copyArr[j][N-1-i] = arr[i][j];
					}
				}
				
				for(int i = 0; i < N; i++) {	// 원본배열에 현재 회전한 복사배열 값을 복사
					for(int j = 0; j < N; j++) {
						arr[i][j] = copyArr[i][j];
					}
				}
				
				for(int i = 0; i < N; i++) {	// 배열의 행마다 한줄로 결과배열에 저장
					StringBuilder temp = new StringBuilder();
					for(int j = 0; j < N; j++) {
						temp.append(arr[i][j]);
					}
					res[i][k] = temp.toString();	// k==0이면 0번째 열에 저장
				}
			}
			
			sb.append("#" + t + "\n");
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < 3; j++) {
					sb.append(res[i][j] + " ");
				}
				sb.append("\n");
			}
		}	
		
		System.out.println(sb);
	}
}