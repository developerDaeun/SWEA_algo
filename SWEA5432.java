import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA5432 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		
		String s = null;
		char[] arr;
		char before = 0, here = 0;
		int sum, stackNum;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			s = br.readLine();
			arr = s.toCharArray();
			
			sum = 0;
			stackNum = 0;
			
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] == '(') {
					stack.push(arr[i]);
					before = '(';
					stackNum++;
				}else {	// 닫는 괄호
					if(!stack.isEmpty()) {	// 비어있지 않으면
						here = stack.peek();
						stack.pop();
						if(before=='(' && arr[i]==')') {	// 레이저일때 스택에 있는 모든 쇠막대기 갯수 더하기
							stackNum--;
							sum += stackNum;
							before = ')';
						}else {	// 쇠막대기 일때 +1
							sum++;
							stackNum--;
						}
					}
				}
			}
			stack.clear();
			System.out.println("#" + t + " " + sum);
		}
	}
}