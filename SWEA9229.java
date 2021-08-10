import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA9229 {

	static int N;
	static int M;
	static int[] arr;
	static int max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());	// 테케 입력 받기
		
		for(int t = 1; t <= TC; t++) {
			max = -1;	// 최대 무게 합 초기화
			
			// 과자개수 N, 최대 무게 M 입력 받기
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N];
			
			// 과자 무게 배열 입력 받기
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			calc(0,0,0);
			
			bw.write("#" + t + " " + max + "\n");
			bw.flush();
		}	// testCase End
		bw.close();
	}
	
	static void calc(int cnt, int idx, int total) {
		if(cnt == 2) {	// 과자 2개 고르면 max 무게 계산
			if(M >= total) {
				max = Math.max(max, total);
			}
			return;
		}
		
		if(idx == N) {	// 현재 index가 범위를 벗어나면 리턴
			return;
		}
		// 현재 과자 추가 X
		calc(cnt, idx+1, total);
		
		// 현재 과자 추가
		total += arr[idx];
		calc(cnt+1, idx+1, total);
	}
}