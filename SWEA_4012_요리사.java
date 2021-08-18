import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_4012_요리사 {

	static int N, arr[][];	// N:식재료 수, arr:식재료 시너지 저장배열
	static int A[] = new int[2], B[] = new int[2];	// A[]:음식 A의 식재료 조합, B[]:음식 B의 식재료 조합
	static int total, totalA, totalB;	// total:음식A와 B의 시너지의 합 임시 저장 변수, totalA: 음식A의 시너지 합, totalB: 음식B의 시너지 합
	static int min;	// 음식 A와 음식 B의 시너지 차이 최소값
	static boolean[] ACheck, BCheck, CheckTemp;	// ACheck:음식 A의 식재료 체크, BCheck:음식 B의 식재료 체크, CheckTemp:음식A와 B의 식재료 임시저장 변수
	static boolean[] visited; // 각 음식 A, B의 조합에서 시너지를 구하기위한 2가지 식재료를 체크하는 배열
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());	// 테케 수 T
		
		for(int t = 1; t <= T; t++) {
			min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());	// 식재료 개수 N
			arr = new int[N][N];	// 식재료 시너지 저장 배열
			ACheck = new boolean[N];
			BCheck = new boolean[N];
			CheckTemp = new boolean[N];
			visited = new boolean[N];
			
			// 식재료 시너지 저장 배열 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			comb(0, 0);	// 음식 A의 조합 N/2개 뽑고, 남은 반을 B의 조합으로 뽑아서 시너지 합 구하기
			
			bw.write("#" + t + " " + min + "\n");
		}
		bw.close();
	}
	static void comb(int start, int cnt) {	// 음식 A의 조합 N/2개 뽑기
		if(cnt == N/2) {
			// 음식 A의 comb2에서 돌리기 위해 초기화
			total = 0;
			totalA = 0;
			
			// 음식 A의 총 시너지 합 구하기
			for(int i = 0; i < N; i++) {
				CheckTemp[i] = ACheck[i];
			}
			perm(0);
			totalA = total;
			
			// 음식 B의 조합을 A 조합이 아닌 것으로 뽑기
			for(int i = 0; i < N; i++) {
				if(!ACheck[i]) {
					BCheck[i] = true;
				}else BCheck[i] = false;
			}

			// 음식 B의 comb2에서 돌리기 위해 초기화
			total = 0;
			totalB = 0;
			
			// 음식 B의 총 시너지 합 구하기
			for(int i = 0; i < N; i++) {
				CheckTemp[i] = BCheck[i];
			}
			perm(0);
			totalB = total;
			
			// 음식 A, B의 최소 차이 값 구하기
			min = Math.min(min, Math.abs(totalA-totalB));
		
			return;
		}
		
		for(int i = start; i < N; i++) {
			ACheck[i] = true; 	// 식재료 번호 체크
			comb(i+1, cnt+1);
			ACheck[i] = false;
		}
	}
	static void perm(int cnt) {	// 음식 A의 조합 N/2개들의 각각 시너지(2개씩 묶어서) 모두 합하기 (순열)
		if(cnt == 2) {	// 2개 뽑으면
			total += arr[A[0]][A[1]]; // 뽑은 식재료 2개의 시너지 합을 더함
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i] || !CheckTemp[i]) continue;
			visited[i] = true;
			A[cnt] = i; // 현재 뽑은 식재료 2개 저장
			perm(cnt+1);
			visited[i] = false;
		}
	}
}