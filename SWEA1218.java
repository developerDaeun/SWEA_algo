import java.util.Scanner;
import java.util.Stack;

public class SWEA1218 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack;
		int result = 0;
		
		for(int t = 1; t <= 10; t++) {
			stack = new Stack<>();
			int T = sc.nextInt();
			String s = sc.next();
			char[] arr = s.toCharArray();
			char c;
			
			for(int i = 0; i < arr.length; i++) {
				if(arr[i]=='(' || arr[i]=='[' || arr[i]=='{' || arr[i]=='<') {
					stack.push(arr[i]);
				}else {	// 오른쪽 괄호
					if(!stack.isEmpty()) {
						c = stack.peek();
						stack.pop();
						if((c=='(' && arr[i]==')') || (c=='[' && arr[i]==']') || (c=='{' && arr[i]=='}') || (c=='<' && arr[i]=='>')) {
							result = 1;
						}else {
							result = 0;
							break;
						}
					}else {
						result = 0;
						break;
					}
				}
			}
			
			if(!stack.isEmpty()) {
				result = 0;
			}

			System.out.println("#" + t + " " + result);
		}	
	}
}