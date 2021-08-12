import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
class Solution {
 
    static boolean[] isSelectedRow = new boolean[9];
    static boolean[] isSelectedCol = new boolean[9];
    static boolean[] isSelected = new boolean[9];
     
    static char[][] map;
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         
        int T = Integer.parseInt(br.readLine());
        map = new char[9][9];
         
        for(int t = 1; t <= T; t++) {
            // 스도쿠 입력 받기
            for(int i = 0; i < 9; i++) {
                String s = br.readLine();
                for(int j = 0; j < 9; j++) {
                    map[i][j] = s.charAt(j*2);
                }
            }
            bw.write("#" + t + " " + calc() + "\n");
        }
        bw.close();
    }
 
    static int calc() {
         
        for(int idx = 0; idx < 9; idx++) {
            for(int i = 0; i < 9; i++) { // 가로,세로 숫자 체크
                isSelectedRow[map[idx][i]-'0'-1] = true;
                isSelectedCol[map[i][idx]-'0'-1] = true;
            }
             
            for(int i = 0; i < 9; i++) { // 가로,세로 숫자 중 한개라도 없으면 false 리턴
                if(isSelectedRow[i]==false || isSelectedCol[i]==false) return 0;
                else {  // 원래대로 돌려놓기
                    isSelectedRow[i] = false;
                    isSelectedCol[i] = false;
                }
            }
        }
         
        // 9개 돌기
        for(int i = 0; i < 9; i=i+3) {
            for(int j = 0; j < 9; j=j+3) {
                //3*3 개씩
                for(int k = 0; k < 3; k++) {
                    for(int r = 0; r < 3; r++) {
                        isSelected[map[i+k][j+r]-'0'-1] = true;
                         
                    }
                }
                // 한개라도 없으면 false 리턴
                for(int k = 0; k < 9; k++) {
                    if(isSelected[k]==false) return 0;
                    else isSelected[k] = false; // 원래대로 돌려놓기
                }
            }
        }
        return 1;
    }
}