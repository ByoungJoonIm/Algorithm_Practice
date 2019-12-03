	package olympiad;
	
	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.OutputStreamWriter;
	import java.util.HashMap;
	import java.util.StringTokenizer;
	
	public class Q2503 {
		private static final int LENGTH = 3;
		private static class Baseball{
			int strike;
			int ball;
			HashMap<Integer, Integer> hm;
			
			public Baseball(int number, int strike, int ball){
				this.strike = strike;
				this.ball = ball;
				hm = new HashMap<Integer, Integer>();
				
				for (int i = 0; i < LENGTH; i++) {
					hm.put(number % 10, i);
					number /= 10;
				}
			}
			
			public boolean isCorrect(int number){
				int strike = 0;
				int ball = 0;
				
				for (int i = 0; i < LENGTH; i++) {
					int target = number % 10;
					if(hm.containsKey(target)){
						if (hm.get(target) == i)
							strike++;
						else ball++;
					}
					number /= 10;
				}
				
				if(strike == this.strike && ball == this.ball)
					return true;
				return false;
			}
		}

		//it works for only LENGTH = 3
		private static boolean isDuplication(int number){
			int a = number % 10;	
			int b = number / 10 % 10;	
			int c = number / 100 % 10;
			return a == b || b == c || c == a || a == 0 || b == 0 || c == 0;
		}
		
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st;
			int counter = 0;
			int N = Integer.parseInt(br.readLine());
			Baseball baseball[] = new Baseball[N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int number = Integer.parseInt(st.nextToken());
				int strike = Integer.parseInt(st.nextToken());
				int ball = Integer.parseInt(st.nextToken());
				baseball[i] = new Baseball(number, strike, ball);
			}
			
			for (int i = 123; i <= 987; i++) {
				if(isDuplication(i))
					continue;
				
				boolean isCorrect = true;
				for (int j = 0; j < N; j++) {
					isCorrect = baseball[j].isCorrect(i);
					if(!isCorrect)
						break;
				}
				if(isCorrect)
					counter++;
			}
			
			bw.write(counter + "\n");
			
			br.close();
			bw.close();
		}
	}
