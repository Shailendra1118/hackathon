package com.applied;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Stats {
	public static class StatisticsAggregatorImpl implements StatisticsAggregator {

        ConcurrentHashMap<String, List<Double>> map = new ConcurrentHashMap<>();
       
		@Override
		public void putNewPrice(String symbol, double price) {
			if(map.containsKey(symbol)){
				ArrayList<Double> list = (ArrayList<Double>) map.get(symbol);
				Double count = list.get(0);
				Double avg = ((list.get(1) * count)+price)/(count+1);
				count++;
				list.add(0, count);
				list.add(1, avg);
				map.put(symbol, list);
			}else{				
				ArrayList<Double> list = new ArrayList<Double>();
				list.add(new Double(1));
				list.add(price);
				map.put(symbol, list);
			}
		}

		@Override
		public double getAveragePrice(String symbol) {
			List<Double> list = map.get(symbol);
			return list.get(1);
		}

		@Override
		public int getTickCount(String symbol) {
			List<Double> list = map.get(symbol);
			return list.get(0).intValue();
		}
	}

	////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

	public interface StatisticsAggregator {
		// This is an input. Make note of this price.
		public void putNewPrice(String symbol, double price);

		// Get the average price
		public double getAveragePrice(String symbol);

		// Get the total number of prices recorded
		public int getTickCount(String symbol);
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			final StatisticsAggregator stats = new StatisticsAggregatorImpl();
			final Set<String> symbols = new TreeSet<>();

			String line = scanner.nextLine();
			String[] inputs = line.split(",");
			int threads = Integer.parseInt(inputs[0]);
			ExecutorService pool = Executors.newFixedThreadPool(threads);
			for (int i = 1; i < inputs.length; ++i) {
				String[] tokens = inputs[i].split(" ");
				final String symbol = tokens[0];
				symbols.add(symbol);
				final double price = Double.parseDouble(tokens[1]);
				pool.submit(new Runnable() {
					@Override
					public void run() {
						stats.putNewPrice(symbol, price);
					}
				});

			}
			pool.shutdown();
			try {
				pool.awaitTermination(5000, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for (String symbol : symbols) {
				System.out.println(String.format("%s %.4f %d", symbol,
						stats.getAveragePrice(symbol),
						stats.getTickCount(symbol)));
			}
		}
		scanner.close();

	}
}