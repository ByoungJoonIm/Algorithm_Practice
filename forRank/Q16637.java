package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Q16637 {
	private static int N;
	private static ArrayList<Integer> operand;
	private static ArrayList<Character> operator;
	private static int maxValue = -Integer.MAX_VALUE;
	
	private static void dfs(int index, boolean visited[]){
		maxValue = Math.max(maxValue, calcAll(visited));
			
		for (int i = index; i < N / 2; i++) {
			visited[i] = true;
			dfs(i + 2, visited);
			visited[i] = false;
		}
	}
	
	private static int execute(int operand1, int operand2, char operator){
		if(operator == '+')
			return operand1 + operand2;
		if(operator == '-')
			return operand1 - operand2;
		return operand1 * operand2;
	}
	
	private static void calc(ArrayList<Integer> operands, ArrayList<Character> operators, int index){
		int operand1 = operands.remove(index);
		int operand2 = operands.remove(index);
		char operator = operators.remove(index);
		
		operands.add(index, execute(operand1, operand2, operator));
	}
	
	private static int calcAll(boolean visited[]){
		ArrayList<Integer> copiedOperand = (ArrayList<Integer>)operand.clone();
		ArrayList<Character> copiedOperator = (ArrayList<Character>) operator.clone();
		
		//우선순위가 있는 것 먼저 계산
		for (int i = N / 2 - 1; i >= 0; i--) {
			if(visited[i]){
				calc(copiedOperand, copiedOperator, i);
			}
		}
		
		//우선순위가 없는 것 계산
		while(copiedOperator.size() > 0)
			calc(copiedOperand, copiedOperator, 0);
		
		return copiedOperand.get(0);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		operand = new ArrayList<Integer>(10);
		operator = new ArrayList<Character>(10);
		N = Integer.parseInt(br.readLine());
		
		String line = br.readLine();
		for (int i = 0; i < N; i++) {
			if(i % 2 == 0){
				operand.add(line.charAt(i) - '0');
			} else {
				operator.add(line.charAt(i));
			}
		}
		
		dfs(0, new boolean[N / 2]);
		
		bw.write(maxValue + "\n");
		
		br.close();
		bw.close();
	}
}
