package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q8980 {
	private static int N, C, M;

	private static class Relation implements Comparable<Relation>{
		int s;
		int e;
		int w;
		
		public Relation(String line){
			StringTokenizer st = new StringTokenizer(line);
			this.s = Integer.parseInt(st.nextToken());
			this.e = Integer.parseInt(st.nextToken());
			this.w = Integer.parseInt(st.nextToken());
		}
		
		@Override
		public int compareTo(Relation relation){
			if(this.s == relation.s){
				return this.e - relation.e;
			}
			return this.s - relation.s;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		
		Relation relations[] = new Relation[M];
		
		for (int i = 0; i < M; i++)
			relations[i] = new Relation(br.readLine());
		
		Arrays.sort(relations);
		
		int subCapacities[] = new int[N + 1];
		int curCapacity = 0;
		int lastIndex = 1;
		int rIndex = 0;
		int total = 0;
		
		for (int i = 1; i <= N; i++) {
			total += subCapacities[i];				//현재 마을에서 짐 내림
			curCapacity -= subCapacities[i];
			
			while(rIndex < relations.length && relations[rIndex].s == i){
				int remain = C - curCapacity;
				int w = relations[rIndex].w;
				int e = relations[rIndex].e;
				
				if(remain >= w){		//현재 마을에서 짐을 모두 실을 수 있는 경우
					curCapacity += w;
					subCapacities[e] += w;
					lastIndex = Math.max(lastIndex, e);
				} else {				//현재 마을에서 짐을 모두 못실어서, 먼곳에서부터 짐을 내려야하는 경우
					w -= remain;
					subCapacities[e] += remain;	//일단 실을수 있는 만큼 실음
					curCapacity = C;
					
					if(subCapacities[e] > 0)
						lastIndex = Math.max(lastIndex, e);
					
					for (int j = lastIndex; j > e; j--) {
						if(subCapacities[j] >= w){
							subCapacities[j] -= w;
							subCapacities[e] += w;
							break;
						} else {
							w -= subCapacities[j];
							subCapacities[e] += subCapacities[j];
							subCapacities[j] = 0;
						}
					}
					
					while(lastIndex > 0 && subCapacities[lastIndex] == 0)
						lastIndex--;
				}
				
				rIndex++;
			}
		}

		bw.write(total + "\n");
		
		br.close();
		bw.close();
	}
}
