package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q10845 {
	private static class Node <T>{
		T value;
		Node<T> next;
		
		public Node(T value){
			this.value = value;
			next = null;
		}
	}
	
	private static class Queue <T>{
		Node<T> front;
		Node<T> back;
		int size;
		
		public Queue(){
			front = null;
			back = null;
			size = 0;
		}
		
		public void push(T value){
			Node<T> newNode = new Node<T>(value);
			
			if(back == null){	//or front == null
				back = front = newNode;
			} else {
				back.next = newNode;
				back = newNode;
			}
			size++;
		}
		
		public T pop(){
			Node<T> curNode = front;
			
			if(front != null){
				if(front.next == null)
					back = front = null;
				else
					front = front.next;
				size--;
				return curNode.value;
			}
			
			return null;
		}
		
		public int getSize(){
			return size;
		}
		
		public boolean isEmpty(){
			return (front == null);	//or back == null
		}
		
		public T getFront(){
			if(front == null)
				return null;
			return front.value;
		}
		
		public T getBack(){
			if(back == null)
				return null;
			return back.value;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new Queue<Integer>();
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			if(command.equals("push")){
				int value = Integer.parseInt(st.nextToken());
				queue.push(value);
			} else if(command.equals("pop")){
				Object rs = queue.pop();
				if (rs == null)
					bw.write("-1\n");
				else 
					bw.write(rs + "\n");;
			} else if(command.equals("size")){
				bw.write(queue.getSize() + "\n");
			} else if(command.equals("empty")){
				if(queue.isEmpty())
					bw.write("1\n");
				else
					bw.write("0\n");
			} else if(command.equals("front")){
				Object rs = queue.getFront();
				if( rs == null )
					bw.write("-1\n");
				else
					bw.write(rs + "\n");
			} else if(command.equals("back")){
				Object rs = queue.getBack();
				if( rs == null )
					bw.write("-1\n");
				else
					bw.write(rs + "\n");
			}
		}
		
		br.close();
		bw.close();
	}
}
