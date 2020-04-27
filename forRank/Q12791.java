package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q12791 {
	private static String[][] db = {
			{"1967", "DavidBowie"},
			{"1969", "SpaceOddity"},
			{"1970", "TheManWhoSoldTheWorld"},
			{"1971", "HunkyDory"}, 
			{"1972", "TheRiseAndFallOfZiggyStardustAndTheSpidersFromMars"}, 
			{"1973", "AladdinSane"}, 
			{"1973", "PinUps"}, 
			{"1974", "DiamondDogs"}, 
			{"1975", "YoungAmericans"}, 
			{"1976", "StationToStation"}, 
			{"1977", "Low"}, 
			{"1977", "Heroes"}, 
			{"1979", "Lodger"}, 
			{"1980", "ScaryMonstersAndSuperCreeps"}, 
			{"1983", "LetsDance"}, 
			{"1984", "Tonight"}, 
			{"1987", "NeverLetMeDown"}, 
			{"1993", "BlackTieWhiteNoise"}, 
			{"1995", "1.Outside"}, 
			{"1997", "Earthling"}, 
			{"1999", "Hours"}, 
			{"2002", "Heathen"}, 
			{"2003", "Reality"}, 
			{"2013", "TheNextDay"}, 
			{"2016", "BlackStar"} 
	};
	
	private static ArrayList<String[]> getData(int start, int end){
		ArrayList<String[]> result = new ArrayList<String[]>();
		
		for (int i = 0; i < db.length; i++) {
			int year = Integer.parseInt(db[i][0]);
			
			if(start <= year && year <= end)
				result.add(db[i]);
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			ArrayList<String[]> result = getData(start, end);
			
			bw.write(result.size() + "\n");
			for (int j = 0; j < result.size(); j++)
				bw.write(result.get(j)[0] + " " + result.get(j)[1] + "\n");
		}
		
		br.close();
		bw.close();
	}
}
