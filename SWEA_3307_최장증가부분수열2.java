import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3307_최장증가부분수열2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		int N;
		int[] arr, LIS;
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			LIS = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int size = 0;
			for(int i = 0; i < N; i++) {
				// LIS는 모두 0으로 초기화되어있으므로 없는 수를 삽입하면 음수값의 인덱스가 반환됨
				int temp = Math.abs(Arrays.binarySearch(LIS, 0, size, arr[i])) - 1;	
				LIS[temp] = arr[i];
				
				if(temp == size)
					size++;
			}
			
			sb.append("#" + t + " " + size + "\n");
		}
		
		System.out.println(sb);
	}

}
