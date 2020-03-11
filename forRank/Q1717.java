package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q1717 {
	private static int n;
	private static int m;
	private static int parent[];
	private static int level[];
	
	private static void init(){
		parent = new int[n + 1];
		level = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
			level[i] = 1;
		}
	}
	
	private static int find(int u){
		if(parent[u] == u)
			return u;
		
		return parent[u] = find(parent[u]);
	}
	
	private static void merge(int u, int v){
		u = find(u);
		v = find(v);
		
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
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		init();
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(cmd == 0){
				merge(a, b);
			} else if(cmd == 1){
				if(find(a) == find(b))
					bw.write("YES\n");
				else
					bw.write("NO\n");
			}
		}
		
		br.close();
		bw.close();
	}
}
