package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q1074 {
	private static int counter = 0;
	private static int r, c;
	private static boolean found;
	
	private static void split1(int row, int col, int n){
		if(!found){
			if(n == 0){
				if(r == row && c == col)
					found = true;
				else
					counter++;	
				return;
			}
				
			split1(row, col, n - 1);
			split1(row, col + (1 << (n - 1)), n - 1);
			split1(row + (1 << (n - 1)), col, n - 1);
			split1(row + (1 << (n - 1)), col + (1 << (n - 1)), n - 1);
		}
	}
	
	private static void split2(int row, int col, int n){
		if(n == 1){
			
		} else {
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		split1(0, 0, N);
		
		bw.write(counter + "\n");
		
		br.close();
		bw.close();
	}
}
