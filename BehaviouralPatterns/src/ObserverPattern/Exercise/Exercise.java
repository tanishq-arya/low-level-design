// The Exercise class simulates stock price updates, registers investors, and removes an observer after the 4th update.

package ObserverPattern.Exercise;

import java.util.Scanner;

public class Exercise {
    
    // Do not modify the run method. It is designed to handle user input, manage stock price updates, and control the observer notification process.
    public void run() {
        
        Scanner sc = new Scanner(System.in);
        
        double priceChangeThreshold = sc.nextDouble();
        StockMarketAlert stockMarket = new StockMarketAlert(priceChangeThreshold);

        InvestorA investorA = new InvestorA();
        InvestorB investorB = new InvestorB();
        
        // TODO: Register Investor A as an observer to receive stock updates.
        stockMarket.registerObserver(investorA);
        
        // TODO: Register Investor B as an observer to receive stock updates.
        stockMarket.registerObserver(investorB);

        int updates = sc.nextInt();
        
        for (int i = 1; i <= updates; i++) {
            
            if(i == 5) {
                // TODO: Remove Investor B from receiving notifications after the 4th update.
                stockMarket.removeObserver(investorB);
            }
            
            String stockSymbol = sc.next();
            double newPrice = sc.nextDouble();
            double oldPrice = sc.nextDouble();
            
            // TODO: Update the stock price and notify observers.
            stockMarket.setStockPrice(stockSymbol, newPrice, oldPrice);
        }
        sc.close();
    }
}