package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q14500 {
	private static int N;
	private static int M;
	private static int maxSum;
	private static int map[][];
	
	private static final int shape[][][] = {	//shapeNum, index, (col=0,row=1)
			{{0,0}, {1,0}, {2,0}, {3,0}},
			{{0,0}, {1,0}, {0,1}, {0,2}},
			{{1,0}, {1,1}, {0,1}, {0,2}},
			{{0,0}, {0,1}, {-1,1}, {1,1}},
			{{0,0}, {1,0}, {0,1}, {1,1}}};
	
	private static final int matCircle[][][] = {
			{{1, 0},{0, 1}},		//그대로
			{{0,-1}, {1,0}},		//90도
			{{-1,0}, {0,-1}},		//180도
			{{0,1}, {-1,0}},		//270도
	};
	
	private static final int matReflect[][][] = {
			{{1, 0},{0, 1}},		//그대로
			{{1,0}, {0,-1}},		//x축 대칭
			{{-1,0}, {0,1}}			//y축 대칭			
	};
	
	private static int getSum(int shapeIndex, int matCircleIndex, int matReflectIndex, int row, int col){
		int sum = 0;
		
		for (int i = 0; i < shape[0].length; i++) {
			int matRow = (shape[shapeIndex][i][0] * matCircle[matCircleIndex][1][0] + shape[shapeIndex][i][1] * matCircle[matCircleIndex][1][1]);	//y
			int matCol = (shape[shapeIndex][i][0] * matCircle[matCircleIndex][0][0] + shape[shapeIndex][i][1] * matCircle[matCircleIndex][0][1]);	//x
			
			int tempRow = row + (matCol * matReflect[matReflectIndex][1][0] + matRow * matReflect[matReflectIndex][1][1]);
			int tempCol = col + (matCol * matReflect[matReflectIndex][0][0] + matRow * matReflect[matReflectIndex][0][1]);
			
			if(tempRow >= 0 && tempCol >= 0 && tempRow < N && tempCol < M)			
				sum += map[tempRow][tempCol];
			else
				return -1;
		}
		return sum;
	}
	
	private static void solve(){
		for (int i = 0; i < N; i++) {											
			for (int j = 0; j < M; j++) {										//각각의 좌표
				for (int k = 0; k < shape.length; k++) {						//도형 모양
					for (int l = 0; l < matCircle.length; l++) {				//회전
						for (int r = 0; r < matReflect.length; r++) {			//대칭
							maxSum = Math.max(maxSum, getSum(k, l, r, i, j));	
						}	
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		maxSum = -1;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve();
		bw.write(maxSum + "\n");
		
		br.close();
		bw.close();
	}
}
