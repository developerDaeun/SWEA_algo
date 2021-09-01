import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_2007_패턴마디의길이 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			String s = br.readLine();
			
			String temp1, temp2;
			for(int i = 1; i < s.length(); i++) {
				temp1 = s.substring(0, i);
				temp2 = s.substring(i, i+i);
				if(temp1.equals(temp2)) {
					sb.append("#" + t + " " + temp1.length() + "\n");
					break;
				}
			}
		}
		System.out.println(sb);
	}
}