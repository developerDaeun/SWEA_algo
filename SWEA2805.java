import java.util.Scanner;

public class SWEA2805 {

	static char[][] temp;
	static int[][] map;
	static int res = 0;
	static int N;
	
	static void add(int row, int interval) {	// 경계(start, end)만큼 숫자 더하기
		int start = N/2 - interval;
		int end = N/2 + interval;
		for(int col = start; col <= end; col++) {
			res+=map[row][col];
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {	// 테케
			N = sc.nextInt();
			temp = new char[N][N];
			map = new int[N][N];
			res = 0;
			
			// 농장 입력
			for(int i = 0; i < N; i++) {
				String s = sc.next();
				temp[i] = s.toCharArray();
			}
			
			// char 배열을 int 배열로 변환
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = temp[i][j] - 48;
				}
			}
			
			int interval = 0;
			for(int i = 0; i < N; i++) {
				add(i, interval);
				if(i < N/2) {	// N의 반보다 작은 인덱스는 간격+1
					interval++;
				}else if(i >= N/2) {	// N의 반보다 크거나 같은 인덱스는 간격-1
					interval--;
				}
			}
			
			System.out.println("#" + t + " " + res);
		}
	}
}