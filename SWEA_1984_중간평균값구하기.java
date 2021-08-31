import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1984_중간평균값구하기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[10];
		int sum;
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 10; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			sum = 0;
			for(int i = 1; i <= 8; i++) {
				sum += arr[i];
			}
			
			System.out.println("#" + t + " " + (int)Math.round((double)sum/8.0));
		}
	}

}
