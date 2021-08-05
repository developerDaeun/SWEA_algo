import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1225 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		Queue<Integer> que = new LinkedList<>();
		
		int TC, minus, here;
		String s = null;
		boolean check = false;
		
		for(int t = 1; t <= 10; t++) {
			minus = 1;
			check = false;
			TC = Integer.parseInt(br.readLine());
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			
			for(int i = 0; i < 8; i++) {	// 숫자 입력 받기
				que.offer(Integer.parseInt(st.nextToken()));
			}
			while(true) {
				if(check == true) {
					break;
				}
				if(minus == 6) {	// 1~5 감소해야하므로 6이되면 다시 1
					minus = 1;
				}
				here = que.peek();
				if(here - minus <= 0) {	// 0 이하가 되면 암호 생성 완료
					here = 0;
					check = true;
				}else {		// 1~5 감소
					here -= minus;
				}
				minus++;	
				que.poll();
				que.offer(here);
			}
			
			System.out.print("#" + t + " ");
			for(int i = 0; i < 8; i++) {
				here = que.peek();
				que.poll();
				System.out.print(here + " ");
			}
			System.out.println();
			que.clear();
		}
	}
}