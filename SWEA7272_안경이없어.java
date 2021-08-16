import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA7272_안경이없어 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			// 첫번째 문자열
			st = new StringTokenizer(br.readLine(), " ");
			String s1 = st.nextToken();
			s1 = compare(s1);
			
			// 두번째 문자열
			String s2 = st.nextToken();
			s2 = compare(s2);
			
			bw.write("#" + t + " " + (s1.equals(s2)?"SAME":"DIFF") + "\n"); // 같으면 SAME 다르면 DIFF 출력
			bw.flush();
		}
		bw.close();
	}

	static String compare(String s) {
		s = s.replaceAll("[ADOPQR]", "1");
		s = s.replaceAll("B", "2");
		char[] temp;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i)!='1' && s.charAt(i)!='2') {	// 1,2 빼고 나머지 0으로 대체
				temp = s.toCharArray();
				temp[i] = '0';
				s = String.valueOf(temp);
			}
		}
		return s;
	}
}