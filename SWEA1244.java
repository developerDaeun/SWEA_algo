import java.util.Scanner;

public class SWEA1244 {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int N = sc.nextInt();   // 스위치 갯수
        int[] s = new int[N];
         
        for(int i = 0; i < N; i++) { // 스위치 입력
            s[i] = sc.nextInt();
        }
        int p = sc.nextInt();   // 학생 수
        for(int i = 0; i < p; i++) {
            int sex = sc.nextInt();
            int num = sc.nextInt();
            
            if(s[num - 1] == 0) {  // 처음에는 남학생, 여학생 둘다 받은 숫자 위치 상태 바꿈
                s[num - 1] = 1;
            }else {
                s[num - 1] = 0;
            }
            
            if(sex == 1) {  // 남학생
                for(int j = num+1; j < N + 1; j++) {   // 배수를 구하므로 받은 수 부터 끝까지
                    if(j % num == 0) { // 배수이면 상태 바꿈
                        if(s[j - 1] == 0) {
                            s[j - 1] = 1;
                        }else {
                            s[j - 1] = 0;
                        }
                    }
                }
            }else {     // 여학생
                int temp = 1;
                for(int j = num - 1; ;) {
                    if(j-temp < 0 || j+temp >= N) {   // 범위 벗어나면 break : 만약 입력이 2이면, (1,3) (0,4) 순회
                        break;
                    }
                    if(s[j - temp] == s[j + temp]) {    // 좌우 대칭이면 상태 바꿈
                        if(s[j - temp] == 0) {
                            s[j - temp] = 1;
                            s[j + temp] = 1;
                        }else {
                            s[j - temp] = 0;
                            s[j + temp] = 0;
                        }
                    }else {	// 좌우 대칭이 아니면 break
                    	break;
                    }
                    temp++;	// 현재 입력에서 몇칸 갈건가
                }
            }
        }
        int idx = 0;
        for(int i = 0; i < s.length/20 + 1; i++) {	// 20개씩 출력
            for(int j = 0; j < 20; j++) {
                if(idx == s.length) {
                    break;
                }
                System.out.print(s[idx] + " ");
                idx++;
            }
            System.out.println();
        }
    }
}