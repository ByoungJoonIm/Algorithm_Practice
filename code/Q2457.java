package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2457 {
	private static class Date {
		static int lastDay[] = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
		int startSerial;
		int endSerial;
		
		public Date(int startMonth, int startDay, int endMonth, int endDay){
			startSerial = convertToSerial(startMonth, startDay);
			endSerial = convertToSerial(endMonth, endDay);
		}
		
		public static int convertToSerial(int month, int day){	//시작, 끝 날짜를 직렬화함
			return lastDay[month - 1] + day;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Date dates[] = new Date[366];
		int N = Integer.parseInt(br.readLine());
		int flowersCounter = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startMonth = Integer.parseInt(st.nextToken());
			int startDay = Integer.parseInt(st.nextToken());
			int endMonth = Integer.parseInt(st.nextToken());
			int endDay = Integer.parseInt(st.nextToken());
			
			int startSerial = Date.convertToSerial(startMonth, startDay);
			if(dates[startSerial] == null			// 꽃이 지는 날을 기준으로 더 긴것을 저장
					|| dates[startSerial].endSerial < Date.convertToSerial(endMonth, endDay))
				dates[startSerial] = new Date(startMonth, startDay, endMonth, endDay);
		}
		
		Date curDate = new Date(1,1,1,2);
		
		//1.1~3.1중 종료일이 가장 긴 노드를 찾음
		for (int i = Date.convertToSerial(1, 1); i <= Date.convertToSerial(3, 1); i++) {
			if(dates[i] != null){
				if(dates[i].endSerial > curDate.endSerial)
					curDate = dates[i];
			}
		}
		
		if(curDate != null){
			while(true){
				int startSerial = curDate.startSerial;
				int endSerial = curDate.endSerial;
				
				for (int i = startSerial; i <= endSerial; i++) {	//다음 노드 선택
					if(dates[i] != null){
						if(dates[i].endSerial > curDate.endSerial)
							curDate = dates[i];
					}
				}
				flowersCounter++;
				if(endSerial > Date.convertToSerial(11, 30))		//현재 노드의 종료일이 11월 30일이 지났으면 종료
					break;
				
				if(startSerial == curDate.startSerial){				//다음 노드를 선택하지 못했다면 실패
					flowersCounter = 0;
					break;
				}
			}	
		}
		
		bw.write(flowersCounter + "\n");
		
		br.close();
		bw.close();
	}
}
