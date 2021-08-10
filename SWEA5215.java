import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA5215 {

	static int N;
	static int L;
	static int[][] arr;
	static int max;
	static boolean[] isSelected;
	static int cnt;
	static int maxCnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {	// 테케
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());	// N : 재료 수
			L = Integer.parseInt(st.nextToken());	// L : 제한 칼로리
			
			cnt = 0;
			maxCnt = (int)Math.pow(2.0, N);	// 부분집합의 최대 카운트 구하기 (calc 함수에서 최대 카운트가 되면 return하기 위해)
			
			arr = new int[N][2];
			isSelected = new boolean[N];	// 현재 수를 선택했는지
			
			// 배열 입력 받기
			for(int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine(), " ");
				arr[n][0] = Integer.parseInt(st.nextToken());	// 햄버거 맛 점수
				arr[n][1] = Integer.parseInt(st.nextToken());	// 햄버거 칼로리
			}
			
			max = -1;	// 최대 맛 점수 초기화
			
			calc(0);	// 최대 맛 점수 구하기
			
			bw.write("#" + t + " " + max + "\n");
			bw.flush();

		}	// 테케 끝
		bw.close();
	}
	
	static void calc(int idx) {
		if(cnt+1 == maxCnt) {	// 최대 부분집합 개수가 되면 return
			return;
		}
		
		int totalS = 0;
		int totalL = 0;
		
		for(int i = 0; i < N; i++) {	// 칼로리의 합 구하기
			if(isSelected[i]) {		// 선택된 햄버거만 맛점수 합, 칼로리 합 구하기
				totalS += arr[i][0];
				totalL += arr[i][1];
			}
		}
		if(L >= totalL) {	// 제한 칼로리 이하이면 max 비교해서 구하기
			max = Math.max(max, totalS);
		}
		
		if(idx == N) {	// 인덱스 범위가 벗어나면 return
			return;
		}
		
		isSelected[idx] = true;		// 현재 햄버거를 선택했을 때
		cnt++;
		calc(idx+1);
		
		isSelected[idx] = false;	// 현재 햄버거를 선택하지 않았을 때
		cnt++;
		calc(idx+1);
	}
}