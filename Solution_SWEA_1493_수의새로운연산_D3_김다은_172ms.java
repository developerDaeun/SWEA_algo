import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_SWEA_1493_수의새로운연산_D3_김다은_172ms {

	static int x, y, num;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			x = 0;
			y = 0;
			
			find(p);	// p의 좌표 구하기
			find(q);	// q의 좌표 구하기
			
			num = 0;
			end : for(int k = 1; ; k++) { 	// p+q의 좌표값을 구했으므로 그 값 구하기(num을 ++ 하면서)
				for(int i = 1, j = k; j >= 1; i++, j--) {
					num++;
					if(i==x && j==y) {	// p+q의 좌표값을 찾으면 값 출력
						bw.write("#" + t + " " + num + "\n");
						break end;
					}
				}
			}
		}
		
		bw.close();
	}
	
	static void find(int pq) {
		num = 0;
		for(int k = 1; ; k++) {
			for(int i = 1, j = k; j >= 1; i++, j--) {
				num++;
				if(num == pq) {	// 그 값에 해당하는 좌표를 찾으면 x값은 'x'에 더하고, y값은 'y'에 더함
					x = x + i;
					y = y + j;
					return;
				}
			}
		}
	}
}