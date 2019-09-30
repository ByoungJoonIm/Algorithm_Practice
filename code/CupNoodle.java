package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class Elem implements Comparable<Elem>{
	int deadline;
	int reward;
	
	public Elem(int deadline, int reward){
		this.deadline = deadline;
		this.reward = reward;
	}
	
	@Override
	public int compareTo(Elem elem){
		return deadline - elem.deadline;
	}
}

public class CupNoodle {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Elem> elem = new ArrayList<Elem>();		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int N;
		long rs = 0;
		
		/*
		 * inputs
		 * */
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			elem.add(new Elem(Integer.parseInt(str.split(" ")[0]), Integer.parseInt(str.split(" ")[1])));
		}
		
		/*
		 * algorithm
		 * */
		Collections.sort(elem);
		
		for (int i = 0; i < N; i++) {
			Elem temp = elem.get(i);
			pq.add(temp.reward);
			while(temp.deadline < pq.size())
				pq.poll();
		}
		
		while(!pq.isEmpty())
			rs += pq.poll();
		System.out.println(rs);
	}
}