import java.util.Arrays;
import java.util.Scanner;
 
public class SWEA1208 {
 
    static int[] box = new int[100];
    static int dump;
    static int cnt;
     
    static int work() {
        // 높이차가 1이하이거나 dump 횟수를 다 쓰면 평탄화 완료
        if(box[99] - box[0] <= 1 || dump == cnt) 
            return (box[99] - box[0]);
        // 실행부분 - 상자 옮기기
        box[0]++;
        box[99]--;    
        cnt++;
        Arrays.sort(box);   // 오름차순
         
        return work();
    }
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int t = 1; t <= 10; t++) {
            dump = sc.nextInt();    // 덤프 횟수 1~1000
            for(int i = 0; i < 100; i++) {
                box[i] = sc.nextInt();  // 모든 상자의 높이는 1~100
            }
            cnt = 0;
            Arrays.sort(box);   // 오름차순
            System.out.println(String.format("#%d %d", t, work()));
        }
    }
}