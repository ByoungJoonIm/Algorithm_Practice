package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2528 {
	private static int N;	//층수
	private static int L;	//층의 길이
	private static class Floor{
		int right;
		int left;
		int len;
		int direction;
		
		public Floor(int len, int direction) {
			if(direction == 0){
				this.left = 0;
				this.right = len;
			} else if(direction == 1){
				this.left = L - len;
				this.right = L;
			}
			this.len = len;
			this.direction = direction;
		}
		
		public Floor(int left, int right, Floor floor){
			this.left = left;
			this.right = right;
			this.len = floor.len;
			this.direction = floor.direction;
		}

		public Floor getRange(int time){	//범위 구하는 것에 문제가 있어보임
			int roundWayLen = (L - len) * 2;
			if(roundWayLen == 0)
				return new Floor(left, right, this);
			time %= roundWayLen;
			
			if(time > roundWayLen / 2)
				time = roundWayLen - time;
			
			if(direction == 0){
				return new Floor(left + time, right + time, this);
			} else if(direction == 1){
				return new Floor(left - time, right - time, this);
			}
			
			return null;
		}
		
		public boolean isGoingUp(Floor floor){
			if(this.len > floor.len)
				return (this.left <= floor.left && this.right >= floor.left) || (this.left <= floor.right && this.right >= floor.right);
			else
				return (floor.left <= this.left && floor.right >= this.left) || (floor.left <= this.right && floor.right >= this.right);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		Floor floors[] = new Floor[N + 1];
		int time = 0;
		int height = 1;
		
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			floors[i] = new Floor(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Floor curFloor, nextFloor;
		while(true){
			while(height < N){
				curFloor = floors[height].getRange(time);
				nextFloor = floors[height + 1].getRange(time);
				if(curFloor.isGoingUp(nextFloor))
					height++;
				else
					break;
			}
			if(height >= N)
				break;
			time++;
		}
		
		bw.write(time + "\n");
		
		br.close();
		bw.close();
	}
}
