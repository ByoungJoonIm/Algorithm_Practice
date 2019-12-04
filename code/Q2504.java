package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Q2504 {
	private static final int OPEN_SMALL = 2000000000;
	private static final int OPEN_MIDDLE = 2000000001;
	private static final int CLOSE_SMALL = 2000000002;
	private static final int CLOSE_MIDDLE = 2000000003;

	private static BufferedReader br;
	private static BufferedWriter bw;

	private static int convert(char c) {
		switch (c) {
		case '(':
			return OPEN_SMALL;
		case '[':
			return OPEN_MIDDLE;
		case ')':
			return CLOSE_SMALL;
		case ']':
			return CLOSE_MIDDLE;
		}
		return -1;
	}

	private static int calc() throws IOException {
		String str = br.readLine();
		Stack<Integer> stack = new Stack<Integer>();

		char c = str.charAt(0);
		if (c == '(' || c == '[') {
			stack.push(convert(c));

			for (int i = 1; i < str.length(); i++) {
				c = str.charAt(i);
				if (c == '(' || c == '[')
					stack.push(convert(c));
				else {
					int w = (c == ')') ? 0 : 1; // ) -> 0, ] -> 1
					if (stack.isEmpty() || stack.peek() == (OPEN_MIDDLE - w))
						return 0;

					int temp = 1;

					if (stack.peek() < OPEN_SMALL)
						temp = stack.pop();

					if (!stack.isEmpty() && stack.peek() == (OPEN_SMALL + w)) {	//곱하기 or 숫자로 치환
						stack.pop();
						stack.push(temp * (2 + w));
					} else
						return 0;

					while (!stack.isEmpty() && stack.peek() < OPEN_SMALL) {	//더하기
						int tempN = stack.pop();
						if (stack.isEmpty() || stack.peek() >= OPEN_SMALL) {
							stack.push(tempN);
							break;
						}
						stack.push(stack.pop() + tempN);
					}
				}
			}
		} else {
			return 0;
		}

		int rs = stack.pop();
		if(rs < OPEN_SMALL && stack.isEmpty())
			return rs;
		return 0;
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write(calc() + "\n");

		br.close();
		bw.close();
	}
}
