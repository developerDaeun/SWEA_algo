import java.util.Scanner;

public class SWEA1954 {

	static int last;
	static int here;
	static int[][] arr;
	static int N;
	static void dal(int start, int end, int r, int c) {
		if(last == here) {	// 마지막까지 다 채워지면 return
			return;
		}
	
		if(r < start || r > end || c < start || c > end || arr[r][c] != 0) {	// 현재 경계를 벗어나거나 채워져있으면
			return;
		}
		// 달팽이 칸 채우기
		here++;
		arr[r][c] = here;
		
		if(c==start && r==end) { 		 // 모서리쪽 상 : 행의 끝, 열의 시작
			r = r-1;	
		}else if(c==end && r==start) { 	 // 모서리쪽 하 : 행의 시작, 열의 끝
			r = r+1;	
		}else if(r==end && c==end) {  	 // 모서리쪽 좌 : 행의 끝, 열의 끝
			c = c-1;	
		}else if(r==start && c==start){ // 모서리쪽 우 : 행의 시작, 열의 시작
			c = c+1;	
		}else if(c==start && r<end) {	// 벽쪽 상 : 행 범위, 열의 시작
			r = r-1;
		}else if(c==end && r<end) {		// 벽쪽 하 : 행 범위, 열의 끝
			r = r+1;
		}else if(r==end && c<end) {		// 벽쪽 좌 : 행의 끝, 열 범위
			c = c-1;
		}else {	// 벽쪽 우 : 행의 시작, 열 범위	(r==start && c<end)
			c = c+1;
		}
		dal(start, end, r, c);
		
		// 경계 범위 바꿈
		start = start + 1;
		end = end - 1;
		dal(start, end, start, start);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			arr = new int[N+1][N+1];
			last = N * N;
			here = 0;
			dal(1,N,1,1);
			System.out.println("#" + t);
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}