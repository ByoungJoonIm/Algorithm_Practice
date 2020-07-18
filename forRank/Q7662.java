package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q7662 {
	private static final int DELETE_MAX = 1;
	private static final int DELETE_MIN = -1;

	private static class Data implements Comparable<Data> {
		int value;
		boolean deleted;

		public Data(int value) {
			this.value = value;
			this.deleted = false;
		}

		@Override
		public int compareTo(Data data) {
			long comparedValue = (long)this.value - data.value;
			
			if(comparedValue == 0)
				return 0;
			else if(comparedValue < 0)
				return -1;
			return 1;
		}
	}

	private static class DoublePriorityQueue {
		private PriorityQueue<Data> minHeap;
		private PriorityQueue<Data> maxHeap;

		public DoublePriorityQueue() {
			this.minHeap = new PriorityQueue<Data>();
			this.maxHeap = new PriorityQueue<Data>(new Comparator<Data>() {
				@Override
				public int compare(Data data1, Data data2) {
					long comparedValue = (long)data2.value - data1.value;
					
					if(comparedValue == 0)
						return 0;
					else if(comparedValue < 0)
						return -1;
					return 1;
				}
			});
		}

		public void add(int value) {
			Data data = new Data(value);
			minHeap.add(data);
			maxHeap.add(data);
		}

		private void delete(int option){
			PriorityQueue<Data> pq;
			
			if(option == DELETE_MAX)
				pq = maxHeap;
			else if(option == DELETE_MIN)
				pq = minHeap;
			else
				return;
			
			while(true){
				if(pq.isEmpty())
					return;
				if(pq.peek().deleted)
					pq.poll();
				else {
					Data data = pq.poll();
					data.deleted = true;
					return;
				}
			}
		}

		public String getResult() {
			while(true){
				if(minHeap.isEmpty())
					return "EMPTY";
				if(minHeap.peek().deleted)
					minHeap.poll();
				else{
					break;
				}
			}
			
			while(maxHeap.peek().deleted){
				maxHeap.poll();
			}
			
			return maxHeap.peek().value + " " + minHeap.peek().value;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			DoublePriorityQueue dpq = new DoublePriorityQueue();
			int k = Integer.parseInt(br.readLine());

			for (int j = 0; j < k; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				char cmd = st.nextToken().charAt(0);
				int cmdParameter = Integer.parseInt(st.nextToken());

				if (cmd == 'I') {
					dpq.add(cmdParameter);
				} else if (cmd == 'D') {
					dpq.delete(cmdParameter);
				}
			}

			bw.write(dpq.getResult() + "\n");
		}

		br.close();
		bw.close();
	}
}
