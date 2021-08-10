import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA1228 {

	static int N;
	static List<String> list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		for(int t = 1; t <= 10; t++) {
			// 원본 암호문의 길이
			N = Integer.parseInt(br.readLine());
			
			// 원본 암호문 입력 받기
			st = new StringTokenizer(br.readLine(), " ");
			list = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				list.add(st.nextToken());
			}
			
			// 명령어의 개수
			N = Integer.parseInt(br.readLine());
			
			// 명령어 입력 받기
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				String I = st.nextToken();	// I 입력 받기
				int start = Integer.parseInt(st.nextToken());	// x의 위치
				int end = Integer.parseInt(st.nextToken()); // y개 숫자
				for(int j = 0; j < end; j++) {	// start 위치부터 암호문 삽입
					list.add(start, st.nextToken());
					start++;
				}
			}
			
			// 출력
			bw.write("#" + t + " ");
			for(int i = 0; i < 10; i++) {	// 10개 항만 출력
				bw.write(list.get(i) + " ");
			}
			bw.write("\n");
			
			bw.flush();
		}
		bw.close();
	}
}