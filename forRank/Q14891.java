package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q14891 {
	private static final int SIZE = 8;
	private static final int SET_SIZE = 4;
	private static class Gear{
		Gear left;
		Gear right;
		int leftArm;
		int rightArm;
		int gearNumber;
		boolean isN[];
		private static int counter = 0;
		
		public Gear(String line){
			gearNumber = ++counter;
			isN = new boolean[SIZE];
			leftArm = SIZE / 4 * 3;
			rightArm = SIZE / 4;
			
			for (int i = 0; i < line.length(); i++) {
				if(line.charAt(i) == '0')
					isN[i] = true;
			}
		}
		
		public void rotation(int direction){
			int weight = SIZE - direction;
			
			leftArm = (leftArm + weight) % SIZE;
			rightArm = (rightArm + weight) % SIZE;
		}
		
		public int getScore(){
			if(isN[(leftArm + SIZE / 4) % SIZE])
				return 0;
			return 1 << (gearNumber - 1);
		}
	}
	
	private static void rotateLeft(Gear gear, int direction){
		if(gear.left != null){
			if(gear.isN[gear.leftArm] != gear.left.isN[gear.left.rightArm]){
				rotateLeft(gear.left, -direction);
				gear.left.rotation(direction);
			}
		}
	}
	
	private static void rotateRight(Gear gear, int direction){
		if(gear.right != null){
			if(gear.isN[gear.rightArm] != gear.right.isN[gear.right.leftArm]){
				rotateRight(gear.right, -direction);
				gear.right.rotation(direction);
			}
		}
	}
	
	private static void rotate(Gear gear, int direction){
		rotateLeft(gear, -direction);
		rotateRight(gear, -direction);
		gear.rotation(direction);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Gear gears[] = new Gear[SET_SIZE + 2];
		gears[0] = null;
		gears[SET_SIZE + 1] = null;
		
		for (int i = 1; i <= SET_SIZE; i++) {
			String line = br.readLine();
			gears[i] = new Gear(line);
		}
		
		for (int i = 1; i <= SET_SIZE; i++) {
			gears[i].left = gears[i - 1];
			gears[i].right = gears[i + 1];
		}
		
		int K = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int gearNumber = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());
			
			rotate(gears[gearNumber], direction);
		}
		
		int totalScore = 0;
		
		for (int i = 1; i <= SET_SIZE; i++)
			totalScore += gears[i].getScore();
			
		bw.write(totalScore + "\n");
		
		br.close();
		bw.close();
	}
}
