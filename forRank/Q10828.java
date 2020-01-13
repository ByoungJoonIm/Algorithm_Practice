package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q10828 {
	private static int n;
	private static class Stack{
		private int size;
		private int top;
		private int stack[];
		
		public Stack(){
			size = 0;
			top = -1;
			stack = new int[n];
		}
		
		public void push(int value){
			stack[++top] = value;
			size++;
		}
		
		public int pop(){
			if(top < 0)
				return -1;
			size--;
			return stack[top--];
		}
		
		public int getSize(){
			return size;
		}
		
		public int isEmpty(){
			return (top == -1) ? 1 : 0;
		}
		
		public int top(){
			if(top < 0)
				return -1;
			return stack[top];
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		Stack stack = new Stack();
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			if(command.equals("push")){
				int value = Integer.parseInt(st.nextToken());
				stack.push(value);
			} else if(command.equals("pop")){
				bw.write(stack.pop() + "\n");
			} else if(command.equals("size")){
				bw.write(stack.getSize() + "\n");
			} else if(command.equals("empty")){
				bw.write(stack.isEmpty() + "\n");
			} else if(command.equals("top")){
				bw.write(stack.top() + "\n");
			}
		}
		
		br.close();
		bw.close();
	}
}
