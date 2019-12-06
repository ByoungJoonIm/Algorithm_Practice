package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2477 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int times = Integer.parseInt(br.readLine());
		int lines[] = new int[6];
		int height = 0;
		int heightIndex = 0;
		int width = 0;
		int widthIndex = 0;
		
		for (int i = 0; i < 6; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			Integer.parseInt(st.nextToken());
			lines[i] = Integer.parseInt(st.nextToken());
			
			if(i % 2 == 0){
				if(height < lines[i]){
					height = lines[i];
					heightIndex = i;
				}
			} else {
				if(width < lines[i]){
					width = lines[i];
					widthIndex = i;
				}
			}
		}

		int bigSquare = height * width;
		int smallSquare = lines[(heightIndex + 3) % 6] * lines[(widthIndex + 3) % 6];
		
		bw.write(((bigSquare - smallSquare) * times) + "\n");
		
		br.close();
		bw.close();
	}
}
