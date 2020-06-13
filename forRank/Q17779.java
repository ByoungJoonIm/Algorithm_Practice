package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q17779 {
	private static final int SIZE = 5;
	
	private static int N;
	private static int map[][];
	
	private static int getDist(int x, int y, int d1, int d2){
		int sum[] = new int[SIZE + 1];	//0 ~ 5
		int tempMap[][] = new int[N + 1][N + 1];
		
		//선거구 범위 구하기
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				boolean isNotBoundary = true;
				
				for (int i = 0; i <= d1 && isNotBoundary; i++) {
					for (int j = 0; j <= d2 && isNotBoundary; j++) {
						if((x + i == r && y - i == c) ||
								(x + j == r && y + j == c) ||
								(x + d1 + j == r && y - d1 + j == c) ||
								(x + d2 + i == r && y + d2 - i == c)){
							isNotBoundary = false;
							tempMap[r][c] = 5;
							break;
						}
					}
				}
				
				if(isNotBoundary){
					if(r < x + d1 && c <= y){
						tempMap[r][c] = 1;
					}
					else if(r <= x + d2 && y < c){
						tempMap[r][c] = 2;
					}					
					else if(x + d1 <= r && c < y - d1 + d2){
						tempMap[r][c] = 3;
					}
					else if(x + d2 < r && y - d1 + d2 <= c){
						tempMap[r][c] = 4;
					}
				}
			}
		}

		//5번 선거구 안쪽을 5로 채움
		for (int i = 1; i <= N; i++) {
			int s = -1;
			int e = -1;
			for (int j = 1; j <= N; j++) {
				if(tempMap[i][j] == 5){
					if(s == -1){
						s = j;
					} else if(e == -1){
						e = j;
						for (int k = s; k <= e; k++) {
							tempMap[i][k] = 5;
						}
					}
				}
			}
		}
		
		//각 선서구의 인원수 합 구하기
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				sum[tempMap[i][j]] += map[i][j];
			}
		}
		
		Arrays.sort(sum);
		
		return sum[5] - sum[1];
	}
	
	private static int getMinDist(){
		int minDist = Integer.MAX_VALUE;
		
		for (int d1 = 1; d1 <= N; d1++) {
			for (int d2 = 1; d2 <= N; d2++) {
				for (int x = 1; x + d1 + d2 <= N; x++) {
					for (int y = 1; y <= N; y++) {
						if(1 <= y - d1 && y + 2 <= N){
							minDist = Math.min(minDist, getDist(x, y, d1, d2));	
						}
					}
				}
			}
		}
		
		return minDist;
	}
	
	private static void printMap(int map[][]){
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bw.write(getMinDist() + "\n");
		
		br.close();
		bw.close();
	}
}
