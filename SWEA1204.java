import java.util.Scanner;

public class SWEA1204 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] scores = new int[101];	// 101개 점수
		int T = sc.nextInt();
		int maxCount = 0;
		int result = 0;
		while(T-- > 0) {
			int TNum = sc.nextInt();	// 테케 번호
			for(int i = 0; i < 1000; i++) {
				scores[sc.nextInt()]++;
			}
			for(int i = 0; i < 101; i++) {
				if(maxCount <= scores[i]) {
					maxCount = scores[i];
					result = i;
				}
			}
			System.out.println("#" + TNum + " " + result);
			for(int i = 0; i < scores.length; i++) {
				scores[i] = 0;
			}
			maxCount = 0;
			result = 0;
		}
	}
}