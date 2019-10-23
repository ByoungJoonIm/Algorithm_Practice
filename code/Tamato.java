package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Coordinates{
	short row;
	short col;
	
	public Coordinates(short row, short col){
		this.row = row;
		this.col = col;
	}
}

public class Tamato {
	public static int zeros = 0;
	public static void checkNeighbor(byte field[][], short row, short col, Queue<Coordinates> queue){
		if(field[row][col] == 0){
			queue.add(new Coordinates((short)(row), (short)(col)));
			field[row][col] = 1;
			zeros--;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		short M = Short.parseShort(st.nextToken());	//col
		short N = Short.parseShort(st.nextToken());	//row
		byte field[][] = new byte[N][M];
		Queue<Coordinates> queue = new LinkedList<Coordinates>();
		int days = 0;
		
		/*
		 * inputs
		 * */
		for (short i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (short j = 0; j < M; j++){
				field[i][j] = Byte.parseByte(st.nextToken());
				switch(field[i][j]){
				case 0:
					zeros++;
					break;
				case 1:
					queue.add(new Coordinates(i, j));
					break;
				}
			}
		}
		
		queue.add(new Coordinates((short)-1, (short)-1));	//end flag
		
		/*
		 * bfs
		 * */
		while(!queue.isEmpty() && zeros >= 0){
			Coordinates temp = queue.poll();
			if(temp.row == -1){		//when find end of the queue.(one cycle)
				if(queue.isEmpty())
					break;
				else{
					days++;
					queue.add(temp);
					continue;
				}
			}
			
			//boundary check
			if(temp.row > 0)
				checkNeighbor(field, (short)(temp.row - 1), (short)(temp.col), queue);
			if(temp.col > 0)
				checkNeighbor(field, (short)(temp.row), (short)(temp.col - 1), queue);
			if(temp.row < N - 1)
				checkNeighbor(field, (short)(temp.row + 1), (short)(temp.col), queue);
			if(temp.col < M - 1)
				checkNeighbor(field, (short)(temp.row), (short)(temp.col + 1), queue);
		}
		
		if(zeros == 0)
			System.out.println(days);
		else
			System.out.println(-1);
	}
}
