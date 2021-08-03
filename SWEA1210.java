import java.util.Scanner;

public class SWEA1210 {

	static int[][] arr = new int[100][100];
	static boolean[][] visited;
	static boolean check;
	
	static void find(int r, int c) {	// c-1: 왼, c+1: 오, r+1: 아래
		if(arr[r][c] == 2) {	// 2를 찾으면
			check = true;
			return;
		}
		if(r == 99) {	// 2를 못찾고 끝까지 왔으면 return
			return;
		}
		
		visited[r][c] = true;
		
		if(c-1>=0 && arr[r][c-1]==1 && visited[r][c-1]==false) {	// 왼
			find(r,c-1);
		}else if(c+1<100 && arr[r][c+1]==1 && visited[r][c+1]==false) {	// 오
			find(r,c+1);
		}else{		// 아래
			find(r+1,c);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t = 0; t < 10; t++) {
			int T = sc.nextInt();	// 테케 번호
			for(int i = 0; i < 100; i++) {	// 배열 입력
				for(int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			// 왼, 오이면 방향 전환 / 방향 전환 후에는 아래방향으로만
			for(int i = 0; i < 100; i++) {
				if(arr[0][i] == 1) {
					visited = new boolean[100][100];
					find(0, i);
					if(check == true) {	// 2를 찾으면 break
						System.out.println("#" + T + " " + i);
						check = false;
						break;
					}
				}
			}
		}
	}
}