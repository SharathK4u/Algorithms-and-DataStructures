package com.skdamoda.common;

import java.util.*;
import java.util.concurrent.*;

/**
 * 
 * @author Sharath
 * Symbol class to hold the value for symbol/price
 */
class Symbol{
	private String symbol;
	private double price;
	Symbol(String symbol,Double price){
		this.symbol=symbol;
		this.price=price;
	}
	
	public String getSymbol() {
		return symbol;
	}
	public double getPrice() {
		return price;
	}
}

public class Stats {
	public static class StatisticsAggregatorImpl implements StatisticsAggregator {
		
		HashMap<Symbol,Double> priceMap;
		
		/**
		 * Constructor to initialize the map
		 */
		StatisticsAggregatorImpl(){
			priceMap=new HashMap<Symbol,Double>();
		}
		
		/**
		 * Add the objects of Symbol to the map for storage.  
		 */
		@Override
		public void putNewPrice(String symbol, double price) {
			//synchronized to handle multiple threads
		    synchronized(this) {
		    	Symbol symbolObject = new Symbol(symbol,price);
		    	priceMap.put(symbolObject,price);
		    }
		}
		
		/**
		 * To get the average price of the given symbol
		 */
		@Override
		public double getAveragePrice(String symbol) {
			//Using streams to first filter based upon symbol and then get average of price.
			return priceMap.entrySet().stream().filter(s->s.getKey().getSymbol().equals(symbol)).mapToDouble(s->s.getValue()).average().orElse(Double.NaN);
		}
		
		/**
		 * To get the total count of the given symbol
		 */
		@Override
		public int getTickCount(String symbol) {
			//Using streams to first filter based upon symbol and then get the total count.
			return (int)priceMap.entrySet().stream().filter(s->s.getKey().getSymbol().equals(symbol)).count();
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