import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2493_stack2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		Stack<Integer> stack = new Stack<>();	//탑 높이 저장
		Stack<Integer> idx = new Stack<>();	// 탑 인덱스 저장
		
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
		int tempIdx = 0;
		
		stack.push(arr[arr.length-1]);
		idx.push(arr.length);
		
		for(int i = arr.length-2; i >= 0; i--) {	// 배열의 뒤에서 앞까지
			while(!stack.isEmpty()) {
				h = stack.peek();
				if(arr[i] < h){	// 현재 탑이 더 작을때
					break;
				}
				// 현재 탑이 더 클때 : 작은탑에 현재 탑 번호 넣기
				tempIdx = idx.peek();
				res[tempIdx-1] = i+1;
				stack.pop();
				idx.pop();
			}
			stack.push(arr[i]);	// 현재 탑 push
			idx.push(i+1);
		}
			
		for(int i = 0; i < res.length; i++) {	// 수신받은 탑이 없으면 res 배열 초기값 0 출력
			System.out.print(res[i] + " ");
		}
	}
}