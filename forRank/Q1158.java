package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1158 {
	private static class Node{
		int value;
		Node next;
		
		public Node(int value){
			this.value = value;
			next = null;
		}
	}
	
	private static class CircularList{
		Node head;
		Node end;
		
		public CircularList(){
			head = null;
			end = null;
		}
		
		private void insert(int value){
			Node newNode = new Node(value);

			if(end == null){
				head = newNode;
				end = newNode;
			} else {
				end.next = newNode;
				end = newNode;
			}
			newNode.next = head;
		}
		
		private void fillList(int n){
			for (int i = 1; i <= n; i++)
				insert(i);
		}
		
		public ArrayList<Integer> getArrayList(int n, int k){
			fillList(n);
			
			ArrayList<Integer> rs = new ArrayList<Integer>();
			Node before = head;
			Node cur = end;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < k; j++){
					before = cur;
					cur = cur.next;
				}
				rs.add(cur.value);
				
				before.next = cur.next;	//마지막 노드가 정상적으로 삭제되지 않지만, 이 문제에서는 고려할 필요가 없음
			}
			
			return rs;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> rs = (new CircularList()).getArrayList(N, K);
		bw.write(Arrays.toString(rs.toArray()).replace("[", "<").replace("]", ">"));
		
		br.close();
		bw.close();
	}
}
