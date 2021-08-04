import java.util.Scanner;

public class SWEA2001 {

	static int map[][];
	static int max;
	static int N;
	static int M;
	static int row;
	static int col;
	
	static void kill() {	// row, col: 현재 파리채 시작 위치
		
		int sum = 0;
		
		// 범위 벗어나면 리턴
		if(row+M-1 >= N) {	
			return;
		}
		
		// 현재 파리채 영역 안의 파리 합 구하기
		for(int i = row; i < row+M; i++) {
			for(int j = col; j < col+M; j++) {
				sum += map[i][j];
			}
		}
		
		// 최대 파리 수 구하기
		if(max < sum) {	
			max = sum;
		}
		
		if(col+1+M-1 >= N) {	// 다음 파리채의 col이 범위를 벗어나면 row + 1
			row = row+1;
			col = 0;
		}else {
			col++;
		}
		
		kill();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();	// 영역
			M = sc.nextInt();	// 파리채 크기
			
			max = 0;	// 최대 잡은 파리 개수
			row = 0;	// 파리채의 현재 위치
			col = 0;
			
			// 영역 입력 받기
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			kill();
			
			System.out.println("#" + t + " " + max);
		}
	}
}