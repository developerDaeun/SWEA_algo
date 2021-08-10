package supplement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1940 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int speed = 0;	// 현재 속도
            int total = 0;	// 총 이동 거리
             
            for(int i = 0; i < N; i++) {
                String command = br.readLine();
                switch(command.charAt(0)) {
                case '0' : 	// 현재 속도 유지
                	break;
                case '1' : 	// 가속
                	speed += command.charAt(2)-'0';
                	break;
                case '2' :	// 감속
                	speed -= command.charAt(2)-'0';
                	if(speed < 0) speed = 0;
                	break;
                }
                total += speed;
//                if(command != 0) {
//                    speed = Integer.parseInt(st.nextToken());
//                    if(command == 1) {
//                        totalSpeed += speed;
//                    }else {
//                        if(totalSpeed - speed >= 0)totalSpeed -= speed;
//                    }
//                }
//                total = total + totalSpeed;
            }
             
            System.out.println("#" + t + " " + total);
        }
	}
}