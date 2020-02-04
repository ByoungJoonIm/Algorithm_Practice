package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q10866 {
	private static class Node{
		int value;
		Node next;
		Node pre;
		
		public Node(int value){
			this.value = value;
			next = null;
			pre = null;
		}
	}
	
	private static class Deque{
		Node front;
		Node back;
		int size;
		
		public Deque(){
			front = null;
			back = null;
			size = 0;
		}
		
		public void pushFront(int X){
			Node newNode = new Node(X);

			newNode.next = front;
			if(front != null)
				front.pre = newNode;
			front = newNode;
			
			if(back == null)
				back = newNode;
			
			size++;
		}

		public void pushBack(int X){
			Node newNode = new Node(X);

			newNode.pre = back;
			if(back != null)
				back.next = newNode;	
			back = newNode;
			
			if(front == null)
				front = newNode;
			
			size++;
		}

		public int popFront(){
			if(front == null)
				return -1;
			
			Node temp = front;
			front = front.next;
			if(front != null)
				front.pre = null;
			else
				back = null;
			
			size--;
			
			return temp.value;
		}

		public int popBack(){
			if(back == null)
				return -1;
			
			Node temp = back;
			back = temp.pre;
			if(back != null)
				back.next = null;
			else
				front = null;
			
			size--;
			
			return temp.value;
		}

		public int isEmpty(){
			if(front == null)	//or back == null
				return 1;
			return 0;
		}

		public int peekFront(){
			if(front == null)
				return -1;
			return front.value;
		}

		public int peekBack(){
			if(back == null)
				return -1;
			return back.value;
		}
		
		public int getSize(){
			return size;
		}

	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Deque deque = new Deque();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch(st.nextToken()){
			case "push_front":
				deque.pushFront(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				deque.pushBack(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				bw.write(deque.popFront() + "\n");
				break;
			case "pop_back":
				bw.write(deque.popBack() + "\n");
				break;
			case "size":
				bw.write(deque.getSize() + "\n");
				break;
			case "empty":
				bw.write(deque.isEmpty() + "\n");
				break;
			case "front":
				bw.write(deque.peekFront() + "\n");
				break;
			case "back":
				bw.write(deque.peekBack() + "\n");
				break;
			}
		}
		
		br.close();
		bw.close();
	}
}
