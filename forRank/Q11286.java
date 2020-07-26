package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q11286 {
	private static class AbsHeap{
		PriorityQueue<Integer> pq;
		
		public AbsHeap(){
			pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
				@Override
				public int compare(Integer i1, Integer i2){
					int absI1 = Math.abs(i1);
					int absI2 = Math.abs(i2);
					
					if(absI1 == absI2){
						if(i1 <= i2)
							return -1;
						return 1;
					}
						
					return absI1 - absI2;
				}
			});
		}
		
		public void push(int value){
			pq.add(value);
		}
		
		public int pop(){
			if(pq.isEmpty())
				return 0;
			return pq.poll();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		AbsHeap ah = new AbsHeap();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(br.readLine());
			
			if(value == 0)
				bw.write(ah.pop() + "\n");
			else
				ah.push(value);
		}
		
		br.close();
		bw.close();
	}
}
