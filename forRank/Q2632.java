package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Q2632 {
	private static int m, n, target;
	
	private static void put(HashMap<Integer, Integer> hm, int value){
		if(hm.containsKey(value))
			hm.put(value, hm.get(value) + 1);
		else
			hm.put(value, 1);
	}
	
	private static void setAl(int[][] pizza, HashMap<Integer, Integer> hm, int size){
		int sum = 0;
		
		for (int i = 0; i < size; i++) {
			if(pizza[1][i] <= target){
				put(hm, pizza[1][i]);
			}
			sum += pizza[1][i];
		}
		
		for (int i = 2; i < size; i++) {	//i = 선택된 피자의 수
			for (int j = 0; j < size; j++) {	//j = 피자 인덱스
				int index = ((i - 1) + j ) % size;
				pizza[i][j] = pizza[i - 1][j] + pizza[1][index];
				
				if(pizza[i][j] <= target){
					put(hm, pizza[i][j]);
				}
			}
		}
		
		hm.put(0, 1);		//선택 안한 경우
		if(sum <= target)	//모두 선택한 경우
			hm.put(sum, 1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		target = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		int pizzaA[][] = new int[m + 1][m];
		int pizzaB[][] = new int[n + 1][n];
		HashMap<Integer, Integer> hmA = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> hmB = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < m; i++)
			pizzaA[1][i] = Integer.parseInt(br.readLine());
			
		for (int i = 0; i < n; i++)
			pizzaB[1][i] = Integer.parseInt(br.readLine());

		setAl(pizzaA, hmA, m);
		setAl(pizzaB, hmB, n);	//B는 array에 들어있어도 됨
		
		int counter = 0;
		
		Iterator<Entry<Integer, Integer>> it = hmB.entrySet().iterator();
				
		while(it.hasNext()){
			Entry<Integer, Integer> cur = it.next();
			int dist = target - cur.getKey();
			
			if(hmA.containsKey(dist))
				counter += hmA.get(dist) * cur.getValue();
		}
		
		bw.write(counter + "\n");
		
		br.close();
		bw.close();
	}
}
