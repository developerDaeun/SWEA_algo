import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution_1_비상구탈출 {

	static int N;
	static ArrayList<Data> exits, list;	// 비상구 위치 리스트, 사람 위치 저장 리스트
	static Data[] sList;	// 조합으로 고른 사람 저장
	static int res;
	static boolean[] v;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			exits = new ArrayList<>();
			list = new ArrayList<>();
			
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int temp = sc.nextInt();
					if(temp==1) {	// 사람 리스트에 저장
						list.add(new Data(i,j,0,0));
					}else if(temp==2) {	// 비상구 리스트에 저장
						exits.add(new Data(i,j,0,0));
					}
				}
			}
			
			sList = new Data[list.size()];
			v = new boolean[list.size()];
			res = Integer.MAX_VALUE;
			
			comb(0, 0);

			sb.append("#" + t + " " + res + "\n");
		}
		System.out.print(sb);
	}

	static void comb(int cnt, int start) {
		if(cnt == list.size()) {
			solve();
			return;
		}
		
		Data cur;
		int dist0, dist1;
		for(int i = start; i < list.size(); i++) {
			cur = list.get(i);
			
			// 0번 비상구 고른 사람을 배열에 저장
			dist0 = Math.abs(cur.r - exits.get(0).r) + Math.abs(cur.c - exits.get(0).c);
			sList[cnt] = new Data(cur.r, cur.c, 0, dist0+1);	// 비상구까지의 거리+탈출시간1초
			comb(cnt+1, i+1);
			// 1번 비상구 고른 사람을 배열에 저장
			dist1 = Math.abs(cur.r - exits.get(1).r) + Math.abs(cur.c - exits.get(1).c);
			sList[cnt] = new Data(cur.r, cur.c, 1, dist1+1);
			comb(cnt+1, i+1);
		}
	}
	
	static void solve() {
		ArrayList<Data> zeros = new ArrayList<>();	// 0번 비상구 고른 사람들
		ArrayList<Data> ones = new ArrayList<>();	// 1번 비상구 고른 사람들
		
		for(int i = 0; i < sList.length; i++) {
			if(sList[i].idx == 0)
				zeros.add(new Data(sList[i].r, sList[i].c, sList[i].idx, sList[i].dist));
			else ones.add(new Data(sList[i].r, sList[i].c, sList[i].idx, sList[i].dist));
		}
		
		// 두 비상구중 큰수구해서 최종값과 비교해 작은것으로 변경
		res = Math.min(res, Math.max(findMin(zeros), findMin(ones)));	
	}
	
	static int findMin(ArrayList<Data> list) {
		
		if(list.isEmpty()) return 0;	// 빈 리스트이면 return 0
		
		Collections.sort(list);
		
		int max = list.get(0).dist;	// 비상구까지 거리 + 탈출시간 1초
		int before = max;
		Data cur;
		for(int i = 1; i < list.size(); i++) {
			cur = list.get(i);
			if(cur.dist != before) before = cur.dist;	// 이전과 같은 시간이 아니라면 before 시간바꾸기	
			max++;
		}
		
		return max;
	}

	static class Data implements Comparable<Data>{
		int r, c, idx, dist;	// 행, 열, 몇번째 비상구인지

		public Data(int r, int c, int idx, int dist) {
			this.r = r;
			this.c = c;
			this.idx = idx;
			this.dist = dist;
		}

		@Override
		public int compareTo(Data o) {
			return this.dist - o.dist;	// 비상구와의 거리가 작은 순대로 정렬
		}
	}
}