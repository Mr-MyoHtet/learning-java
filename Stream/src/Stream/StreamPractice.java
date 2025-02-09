package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;

public class StreamPractice {
	
	public static void main(String[]args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario","Milan");
		Trader alan = new Trader("Alan","Cambridge");
		Trader brian = new Trader("Brian","Cambridge");
		List<Transaction> transactions = Arrays.asList(
				 new Transaction(brian, 2011, 300), 
				 new Transaction(raoul, 2011, 100),
				 new Transaction(raoul, 2012, 400),
				 new Transaction(mario, 2012, 710),
				 new Transaction(mario, 2012, 700),
				 new Transaction(alan, 2012, 950));
		//=========================================================================================
		//Eg1 Find all transactions in the year 2011 and sort them by value (small to high)

		List<Transaction> result1 = transactions.stream().filter(t -> t.getYear()==2011)
				.sorted(comparing(Transaction::getValue)).toList();
		
		//Eg2 Eg1 vs Eg2 is the same result 
		List<Transaction> result2 = transactions.stream().filter(t->t.getYear()==2011)
				.sorted((t1,t2)->Integer.compare(t1.getValue(), t2.getValue())).toList();
		
		System.out.println(result1);
		System.out.println(result2);
		//=========================================================================================
		
		//Eg3 What are all the unique cities where the traders work?
		List<String> result3 = transactions.stream().map(city -> city.getTrader().getCity()).distinct().toList();
		System.out.println(result3);
		//=========================================================================================
		
		//Eg4 Find all traders from Cambridge and sort them by name.
		List<Trader> result4 = transactions.stream().map(Transaction::getTrader)
				               .filter(city -> city.getCity().equals("Cambridge"))
				               .sorted(comparing(Trader::getName)).toList();
		System.out.println(result4);
		//=========================================================================================

		//Eg5 Return a string of all traders’ names sorted alphabetically.
		List<String> result5 = transactions.stream().map(transaction -> transaction.getTrader().getName())
				               .sorted().toList();
		System.out.println(result5);
		//=========================================================================================

		//Eg6 Are any traders based in Milan?
		boolean result6 = transactions.stream().anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
		System.out.println(result6);
		//=========================================================================================
		
		//Eg6 Print the values of all transactions from the traders living in Cambridge.
		 List<Integer> result7 = transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambridge"))
				                    .map(value -> value.getValue()).toList();
		 System.out.println(result7);
		//=========================================================================================

		 
		 //Eg7 What’s the highest value of all the transactions?
		 Optional<Integer> result8 = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
		 System.out.println(result8);
		//=========================================================================================

		 
		 //Eg8What’s the smallest value of all the transactions?
         Optional<Integer> result9 = transactions.stream().map(t -> t.getValue()).reduce(Integer::min);
         System.out.println(result9);
 		//=========================================================================================

         
         //Eg9 Find the transaction with the smallest value.
         Optional<Transaction> result10 = transactions.stream().min(comparing(Transaction::getValue));
         System.out.println(result10);
 		//=========================================================================================
         
       //Eg9 Find the transaction with the smallest value.
         Optional<Transaction> result11 = transactions.stream().max(comparing(Transaction::getValue));
         System.out.println(result11);
 		//=========================================================================================


		
	}
}
