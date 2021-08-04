import java.util.Scanner;

public class SWEA1873 {

	static char[][] map;	// 전체 맵 배열
	static char[] move;	// 문자 동작 배열
	static int H;
	static int W;
	static boolean shell = false;
	static int hereR = 0;	// 전차의 현재 위치
	static int hereC = 0;
	static char hereD;
	
	static void game(int row, int col, char m, char d) {	// 전차의 위치, 동작, 현재방향
		
		int r = 0, c = 0;
		
		// 전차가 맵의 범위 벗어나면 리턴
		if(row<0 || row>=H || col<0 || col>=W ) {
			return;
		}
		
		// 포탄이 벽돌벽 만나면 벽은 평지로 바뀌고 포탄 소멸
		if(map[row][col]=='*') {	// 벽돌벽
			map[row][col]='.';
			shell = true;
			return;
		}else if(map[row][col]=='#') {	// 강철벽만나면 포탄 소멸
			shell = true;
			return;
		}
		
		// 방향 틀기
		if(m=='U') {
			map[row][col] = '^';
			hereD = '^';
		}else if(m=='D') {
			map[row][col] = 'v';
			hereD = 'v';
		}else if(m=='L') {
			map[row][col] = '<';
			hereD = '<';
		}else if(m=='R') {
			map[row][col] = '>';
			hereD = '>';
		}
		
		// 다음 위치 인덱스 구하기
		if(hereD=='^') {
			r = -1;
			c = 0;
		}else if(hereD=='v') {
			r = 1;
			c = 0;
		}else if(hereD=='<') {
			r = 0;
			c = -1;
		}else if(hereD=='>') {
			r = 0;
			c = 1;
		}
		
		// 다음 위치가 평지이면 이동
		if(row+r>=0 && row+r<H & col+c>=0 & col+c<W ) {
			if(m!='S' && map[row+r][col+c] == '.') {
				map[row+r][col+c] = map[row][col];
				map[row][col] = '.';
				hereR = row+r;
				hereC = col+c;
				return;
			}else if(m=='S') {
				// 포탄일 때
				game(row+r, col+c, m, hereD);
				if(shell==true) {
					return;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
						
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			
			// 맵 크기 입력 받기
			H = sc.nextInt();
			W = sc.nextInt();
			String s;
			map = new char[H][W];
			
			// 맵 입력 받기
			for(int i = 0; i < H; i++) {
				s = sc.next();
				map[i] = s.toCharArray();
			}
			
			// 문자 동작 입력 받기
			int N = sc.nextInt();
			move = new char[N];
			s = sc.next();
			move = s.toCharArray();
			
			// 전차의 현재 위치, 방향 찾기
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					if(map[i][j]=='^' || map[i][j]=='v' || map[i][j]=='<' || map[i][j]=='>') {
						hereR = i;
						hereC = j;
						hereD = map[i][j];
					}
				}
			}
			
			// 전차 이동
			for(int i = 0; i < N; i++) {
				game(hereR, hereC, move[i], hereD);
				if(shell == true) {	// 포탄 소멸
					shell = false;
				}
			}
			
			
			// 출력
			System.out.print("#" + t + " ");
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
}