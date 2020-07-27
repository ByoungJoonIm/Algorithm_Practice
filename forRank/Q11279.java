package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q11279 {
	private static class MaxHeap{
		PriorityQueue<Integer> pq;
		
		public MaxHeap(){
			pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
				@Override
				public int compare(Integer i1, Integer i2){
					return i2 - i1;
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

		int N = Integer.parseInt(br.readLine());
		MaxHeap mh = new MaxHeap();
		
		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(br.readLine());
			
			if(value == 0){
				bw.write(mh.pop() + "\n");
			} else
				mh.push(value);
		}
		
		br.close();
		bw.close();
	}
}
