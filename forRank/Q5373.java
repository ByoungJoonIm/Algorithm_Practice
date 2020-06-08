package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 				[U]0(w)
 * 				0  1  2
 * 				3  4  5
 * 				6  7  8
 * 	[L]4(g)		[F]1(r)		[R]5(b)
 * 	36 37 38	9  10 11	45 46 47
 * 	39 40 41	12 13 14	48 49 50
 * 	42 43 44	15 16 17	51 52 53
 * 				[D]2(y)
 * 				18 19 20
 * 				21 22 23
 * 				24 25 26
 * 				[B]3(o)
 * 				27 28 29
 * 				30 31 32
 * 				33 34 35
 * 
 * index => cube[index / (SIZE * SIZE)][(index % (SIZE * SIZE)) / SIZE][index % SIZE]
 * row => (index % (SIZE * SIZE)) / SIZE
 * col => index % SIZE
 * */

public class Q5373 {
	private static final char converter[] = {'U', 'F', 'D', 'B', 'L', 'R'};
	private static final char SIDE_COLOR[] = {'w', 'r', 'y', 'o', 'g', 'b'};
	private static final int SIZE = 3;
	
	private static char cube[][][] = new char[6][SIZE][SIZE];
	
	private static final int mapping[][] = {
			{33,34,35,47,46,45,11,10,9,38,37,36},	//U
			{6,7,8,45,48,51,20,19,18,44,41,38},		//F
			{15,16,17,51,52,53,29,28,27,42,43,44},	//D
			{24,25,26,53,50,47,2,1,0,36,39,42},	//B
			{0,3,6,9,12,15,18,21,24,27,30,33},	//L
			{8,5,2,35,32,29,26,23,20,17,14,11}	//R
	};
	
	private static void initCube(){
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < SIZE; j++) {
				for (int k = 0; k < SIZE; k++)
					cube[i][j][k] = SIDE_COLOR[i];
			}
		}
	}
	
	private static int getIndex(char direction){
		for (int i = 0; i < converter.length; i++) {
			if(direction == converter[i])
				return i;
		}
		return -1;
	}
	
	private static void rotate(String step){
		int directionIndex = getIndex(step.charAt(0));
		boolean clockwise = step.charAt(1) == '+';
		int weight = clockwise ? 1 : 3;
		
		//현재 면 회전
		char tempCube[][] = new char[SIZE][SIZE];
		if(clockwise){
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++)
					tempCube[j][SIZE - 1 - i] = cube[directionIndex][i][j];
			}
		} else {
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++)
					tempCube[i][j] = cube[directionIndex][j][SIZE -1 - i];
			}
		}
		
		//인접 면 회전
		Queue<Character> queue = new LinkedList<Character>();
		for (int i = 0; i < SIZE * 4; i++){
			int index = mapping[directionIndex][i];
			queue.add(cube[index / (SIZE * SIZE)][(index % (SIZE * SIZE)) / SIZE][index % SIZE]);
		}
		
		for (int i = 0; i < SIZE * 4; i++) {
			int index = mapping[directionIndex][(i + SIZE * weight) % (SIZE * 4)];
			cube[index / (SIZE * SIZE)][(index % (SIZE * SIZE)) / SIZE][index % SIZE] = queue.poll();
		}
		
		cube[directionIndex] = tempCube;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			initCube();
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < n; j++) {
				rotate(st.nextToken());
			}
			
			for (int j = 0; j < SIZE; j++) {
				for (int k = 0; k < SIZE; k++) {
					bw.write(cube[0][j][k]);
				}
				bw.write("\n");
			}
		}
		
		br.close();
		bw.close();
	}
}
