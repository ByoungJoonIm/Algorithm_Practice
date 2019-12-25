package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q10158 {
	private static final int MODE_UR = 0;
	private static final int MODE_DR = 1;
	private static final int MODE_UL = 2;
	private static final int MODE_DL = 3;
	private static final int MODE_SIGN[][] = { { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };
	private static final int NEXT_MODE[][] = { { MODE_DL, MODE_DR, MODE_UL }, { MODE_UL, MODE_UR, MODE_DL },
			{ MODE_DR, MODE_DL, MODE_UR }, { MODE_UR, MODE_UL, MODE_DR } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());

		int curMode = MODE_UR;
		int curTime = 0;

		while (curTime < t) {
			int wxDist = 0;
			int hyDist = 0;
			
			switch(curMode){	//x and y dist
				case MODE_UR:
					wxDist = w - x;
					hyDist = h - y;
					break;
				case MODE_DR:
					wxDist = w - x;
					hyDist = y;
					break;
				case MODE_UL:
					wxDist = x;
					hyDist = h - y;
					break;
				case MODE_DL:
					wxDist = x;
					hyDist = y;
					break;
			}
			
			int dist = hyDist;
			int nextMode = curMode; // 무의미한 초기화

			if (wxDist == hyDist) // dist = wxDist 포함
				nextMode = NEXT_MODE[curMode][0];
			else if (wxDist > hyDist)
				nextMode = NEXT_MODE[curMode][1];
			else if (wxDist < hyDist) {
				dist = wxDist;
				nextMode = NEXT_MODE[curMode][2];
			}

			if (curTime + dist > t)
				dist = t - curTime;

			curTime += dist;
			x += (MODE_SIGN[curMode][0] * dist);
			y += (MODE_SIGN[curMode][1] * dist);
			curMode = nextMode;
		}
		
		bw.write(x + " " + y + "\n");

		br.close();
		bw.close();
	}
}
