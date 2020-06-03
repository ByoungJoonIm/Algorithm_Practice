package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q12100 {
	private static int N;
	private static final int LEFT = 0;
	private static final int RIGHT = 1;
	private static final int UP = 2;
	private static final int DOWN = 3;
	private static int maxValue;
	
	private static int[][] copyMap(int originMap[][]){
		int copiedMap[][] = new int[originMap.length][originMap[0].length];
		
		for (int i = 0; i < copiedMap.length; i++)
			copiedMap[i] = originMap[i].clone();
		
		return copiedMap;
	}
	
	private static void mergePhase(int map[][], int direction){
		if(direction == LEFT){
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(map[i][j] == map[i][j + 1]){
						map[i][j]*= 2;
						map[i][j + 1] = 0;
						j++;
					}
				}
			}	
		} else if(direction == RIGHT){
			for (int i = 1; i <= N; i++) {
				for (int j = N; j > 0; j--) {
					if(map[i][j] == map[i][j - 1]){
						map[i][j]*= 2;
						map[i][j - 1] = 0;
						j--;
					}
				}
			}
		} else if(direction == UP){
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(map[j][i] == map[j + 1][i]){
						map[j][i]*= 2;
						map[j + 1][i] = 0;
						j++;
					}
				}
			}
		} else if(direction == DOWN){
			for (int i = 1; i <= N; i++) {
				for (int j = N; j > 0; j--) {
					if(map[j][i] == map[j - 1][i]){
						map[j][i]*= 2;
						map[j - 1][i] = 0;
						j--;
					}
				}
			}
		}
	}
	
	private static void movePhase(int map[][], int direction){
		if(direction == LEFT){
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(map[i][j] == 0){
						boolean noMore = true;
						for (int k = j + 1; k <= N; k++) {
							if(map[i][k] > 0){
								map[i][j] = map[i][k];
								map[i][k] = 0;
								noMore = false;
								break;
							}
						}
						if(noMore)
							break;
					}
				}
			}
		} else if(direction == RIGHT){
			for (int i = 1; i <= N; i++) {
				for (int j = N; j > 0; j--) {
					if(map[i][j] == 0){
						boolean noMore = true;
						for (int k = j - 1; k > 0; k--) {
							if(map[i][k] > 0){
								map[i][j] = map[i][k];
								map[i][k] = 0;
								noMore = false;
								break;
							}
						}
						if(noMore)
							break;
					}
				}
			}
		} else if(direction == UP){
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(map[j][i] == 0){
						boolean noMore = true;
						for (int k = j + 1; k <= N; k++) {
							if(map[k][i] > 0){
								map[j][i] = map[k][i];
								map[k][i] = 0;
								noMore = false;
								break;
							}
						}
						if(noMore)
							break;
					}
				}
			}
		} else if(direction == DOWN){
			for (int i = 1; i <= N; i++) {
				for (int j = N; j > 0; j--) {
					if(map[j][i] == 0){
						boolean noMore = true;
						for (int k = j - 1; k > 0; k--) {
							if(map[k][i] > 0){
								map[j][i] = map[k][i];
								map[k][i] = 0;
								noMore = false;
								break;
							}
						}
						if(noMore)
							break;
					}
				}
			}
		}
	}
	
	private static int findMaxValue(int map[][]){
		int maxValue = -1;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++)
				maxValue = Math.max(maxValue, map[i][j]);
		}
		
		return maxValue;
	}
	
	private static void solve(int depth, int map[][]){
		if(depth == 5){
			maxValue = Math.max(maxValue, findMaxValue(map));
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int copiedMap[][] = copyMap(map);
			movePhase(copiedMap, i);
			mergePhase(copiedMap, i);
			movePhase(copiedMap, i);
			solve(depth + 1, copiedMap);
		}
	}

	//for debug
	private static void solveTest(int map[][]){
		mergePhase(map, DOWN);
		printMap(map);
		System.out.println();
		movePhase(map, DOWN);
		printMap(map);
		
		System.out.println("------------------------------------------");
		
		mergePhase(map, DOWN);
		printMap(map);
		System.out.println();
		movePhase(map, DOWN);
		printMap(map);
		
		System.out.println("------------------------------------------");
		
		mergePhase(map, DOWN);
		printMap(map);
		System.out.println();
		movePhase(map, DOWN);
		printMap(map);
		
		System.out.println("------------------------------------------");
		
		mergePhase(map, LEFT);
		printMap(map);
		System.out.println();
		movePhase(map, LEFT);
		printMap(map);
		
		System.out.println("------------------------------------------");
		
		mergePhase(map, LEFT);
		printMap(map);
		System.out.println();
		movePhase(map, LEFT);
		printMap(map);
		
//		System.out.println(findMaxValue(map));
	}
	
	//for debug
	private static void printMap(int map[][]){
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		int map[][] = new int[N + 2][N + 2];
		
		//테두리를 -1로 채우기
		Arrays.fill(map[0], -1);
		Arrays.fill(map[N + 1], -1);
		
		for (int i = 1; i <= N; i++) {
			map[i][0] = -1;
			map[i][N + 1] = -1;
		}
		
		//입력
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//algorithm
		maxValue = -1;
//		solve(0, map);
		solveTest(map);
		
		bw.write(maxValue + "\n");
		
		br.close();
		bw.close();
	}
}
