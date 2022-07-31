package com.greatlearning.main;

import java.io.OutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.BufferedInputStream;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Main {
	public static void main(String[] ARGS) {
		new Thread(null, new Runnable() {
			public void run() {
				new Main().solve();
			}
		}, "1", 1 << 26).start();
	}

	void solve() {
		InputStream IS = System.in;
		OutputStream OS = System.out;
		ScanReader in = new ScanReader(IS);
		PrintWriter out = new PrintWriter(OS);
		Skyscraper skyscraper = new Skyscraper();
		skyscraper.solve(1, in, out);
		out.close();
	}

	static class Skyscraper {
		public void solve(int testNumber, ScanReader in, PrintWriter out) {
			System.out.println("Enter the total number of floors in the building");
			int n = in.scanInt();
			int current_need = n;
			PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});
			for (int i = 0; i < n ; i++) {
				System.out.println("Enter the floor size given on day: " + (i+1));
				int x = in.scanInt();
				out.println("Day: " + (i+1));
				if (current_need == x) {
					out.print(x + " ");
					current_need--;

					while (!queue.isEmpty() && current_need == queue.peek()) {
						out.print(queue.poll() + " ");
						current_need--;
					}
				} else {

					queue.add(x);
				}
				out.println();

			}
			System.out.println("The order of construction is as follows:");
		}

	}

	static class ScanReader {
		private byte[] buf = new byte[4 * 1024];
		private int index;
		private BufferedInputStream in;
		private int Total_Char;

		public ScanReader(InputStream inputStream) {
			in = new BufferedInputStream(inputStream);
		}

		private int scan() {
			if (index >= Total_Char) {
				index = 0;
				try {
					Total_Char = in.read(buf);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (Total_Char <= 0)
					return -1;
			}
			return buf[index++];
		}

		public int scanInt() {
			int integer = 0;
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			int neg = 1;
			if (n == '-') {
				neg = -1;
				n = scan();
			}
			while (!isWhiteSpace(n)) {
				if (n >= '0' && n <= '9') {
					integer *= 10;
					integer += n - '0';
					n = scan();
				}
			}
			return neg * integer;
		}

		private boolean isWhiteSpace(int n) {
			if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1)
				return true;
			else
				return false;
		}

	}
}
