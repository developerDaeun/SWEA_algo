import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2493_stack {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> idx = new Stack<>();
		
		// N 입력
		String N;
		N = br.readLine();
		int[] arr = new int[Integer.parseInt(N)];
		int[] res = new int[arr.length];
		
		// 탑 높이 입력
		N = br.readLine();
		st = new StringTokenizer(N, " ");
		
		// 탑 배열 생성
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int h = 0;
		
		stack.push(arr[0]);
		idx.push(1);
		
		for(int i = 1; i < arr.length; i++) {
			while(!stack.isEmpty()) {
				h = stack.peek();
				if(h > arr[i]){	// 현재 탑이 더 작을때
					res[i] = idx.peek();
					break;
				}
				// 현재 탑이 더 클때
				stack.pop();
				idx.pop();
			}
			stack.push(arr[i]);
			idx.push(i+1);
		}
			
		for(int i = 0; i < res.length; i++) {	// 수신받은 탑이 없으면 res 배열 초기값 0 출력
			System.out.print(res[i] + " ");
		}
	}
}