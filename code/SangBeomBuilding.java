package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class BuilngCoord{
	byte height;
	byte row;
	byte col;
	
	public BuilngCoord(byte height, byte row, byte col) {
		this.height = height;
		this.row = row;
		this.col = col;
	}
}

public class SangBeomBuilding {
	private static byte L;
	private static byte R;
	private static byte C;
	private static boolean building[][][];
		
	private static void addNext(Queue<BuilngCoord> queue, BuilngCoord next){
		byte height = next.height;
		byte row = next.row;
		byte col = next.col;
		
		if(height >= 0 && row >= 0 && col >= 0 && height < L && row < R && col < C){	//boundary check
			if(!building[height][row][col]){
				queue.add(next);
				building[height][row][col] = true;
			}
				
		}
	}

	//bfs algorithm
	private static int escape(BuilngCoord start, BuilngCoord end){
		Queue<BuilngCoord> queue = new LinkedList<BuilngCoord>();
		int minPathLen = 0;
		
		addNext(queue, start);
		queue.add(new BuilngCoord((byte)-1, (byte)-1, (byte)-1));	//queue end flag
		
		while(!queue.isEmpty()){
			BuilngCoord temp = queue.poll();
			if(temp.height == -1){
				if(queue.isEmpty())
					break;
				minPathLen++;
				queue.add(temp);
				continue;
			}
			
			if(temp.height == end.height && temp.row == end.row && temp.col == end.col)	//end check
				return minPathLen;
			
			addNext(queue, new BuilngCoord((byte)(temp.height - 1), temp.row, temp.col));
			addNext(queue, new BuilngCoord(temp.height, temp.row, (byte)(temp.col - 1)));
			addNext(queue, new BuilngCoord(temp.height, (byte)(temp.row - 1), temp.col));
			addNext(queue, new BuilngCoord((byte)(temp.height + 1), temp.row, temp.col));
			addNext(queue, new BuilngCoord(temp.height, temp.row, (byte)(temp.col + 1)));
			addNext(queue, new BuilngCoord(temp.height, (byte)(temp.row + 1), temp.col));
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Byte.parseByte(st.nextToken());	//height
			R = Byte.parseByte(st.nextToken());	//row
			C = Byte.parseByte(st.nextToken());	//column
			
			if(L == 0 && R == 0 && C == 0)
				break;	
			
			building = new boolean[L][R][C];
			BuilngCoord start = null;
			BuilngCoord end = null;
			
			/*
			 * inputs
			 * true : visited
			 * false : can visit
			 * */
			for (byte i = 0; i < L; i++) {
				for (byte j = 0; j < R; j++) {
					String row = br.readLine();
					for (byte k = 0; k < C; k++) {
						char cell = row.charAt(k);
						switch(cell){
						case '#':
							building[i][j][k] = true;
							break;
						case 'S':
							start = new BuilngCoord(i, j, k);
							break;
						case 'E':
							end = new BuilngCoord(i, j, k);
							break;
						}
					}
				}
				br.readLine();
			}
			
			int rs = escape(start, end);
			if(rs > 0)
				bw.write("Escaped in " + rs +" minute(s)." + "\n");
			else
				bw.write("Trapped!" + "\n");
		}
		br.close();
		bw.close();
	}
}
