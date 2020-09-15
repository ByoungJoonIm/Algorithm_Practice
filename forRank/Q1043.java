package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1043 {
	private static final int KNOWN = 0;
	
	private static int N, M;
	private static ArrayList<Integer> party[];
	
	private static int parent[];
	private static int level[];
	
	private static void initUnion(){
		parent = new int[N + 1];
		level = new int[N + 1];
		
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
			level[i] = 1;
		}
	}
	
	private static int findUnion(int u){
		if(parent[u] == u)
			return u;
		
		return parent[u] = findUnion(parent[u]);
	}
	
	private static void mergeUnion(int u, int v){
		u = findUnion(u);
		v = findUnion(v);
		
		if(u == v)
			return;
		
		if(level[u] > level[v]){
			int temp = u;
			u = v;
			v = temp;
		}
		
		parent[u] = v;
		
		if(level[u] == level[v])
			level[v]++;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		party = new ArrayList[M];
		
		initUnion();
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());	//이미 아는 사람 수
		for (int i = 0; i < T; i++)
			mergeUnion(Integer.parseInt(st.nextToken()), KNOWN);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			party[i] = new ArrayList<Integer>(size);
			
			for (int j = 0; j < size; j++)
				party[i].add(Integer.parseInt(st.nextToken()));
		}

		//파티에 참여한 사람을 모두 한 그룹으로 만듦
		for (int i = 0; i < party.length; i++) {
			if(party[i].size() > 1){
				int firstElem = party[i].get(0);
				
				for (int j = 1; j < party[i].size(); j++)
					mergeUnion(firstElem, party[i].get(j));
			}
		}
		
		int counter = 0;
		
		for (int i = 0; i < party.length; i++) {
			if(party[i].size() > 0){
				if(findUnion(party[i].get(0)) != findUnion(KNOWN))
					counter++;
			}
		}
		
		bw.write(counter + "\n");
		
		br.close();
		bw.close();
	}
}
