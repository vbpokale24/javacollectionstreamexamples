package Java8Streams2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumber {

	public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 20);
       // primeNumberRange();
    System.out.println(numbers.stream()
                             .filter(PrimeNumber::isPrime)
                             .collect(Collectors.toList()));
    }
	/*
	 * Check prime number by using stream.rangeClosed
	 */
	public static boolean isPrime(int number) {
	    return !IntStream.rangeClosed(2, number/2).anyMatch(i -> number%i == 0); 
	}
	/*
	 * It will print the prime numbers between range
	 */
	public static  void primeNumberRange() {
        IntStream.rangeClosed(2, 100)
            .filter(i -> IntStream.rangeClosed(2, (int)Math.sqrt(i))
                    .allMatch(j -> i%j != 0))
            .forEach(n -> {
                System.out.println(n);
            });
    }
	/*
	 * 
	 */
	public static boolean isPrime1(int num){
	    if ( num > 2 && num%2 == 0 ) {
	        System.out.println(num + " is not prime");
	        return false;
	    }
	    int top = (int)Math.sqrt(num) + 1;
	     for(int i = 3; i < top; i+=2){
	    	       if(num % i == 0){
	            System.out.println(num + " is not prime");
	            return false;
	        }
	    }
	    System.out.println(num + " is prime");
	    return true; 
	}
	
	
	public static void prime1() {
		int i,m=0,flag=0;      
		  int n=3;//it is the number to be checked    
		  m=n/2;      
		  if(n==0||n==1){  
		   System.out.println(n+" is not prime number");      
		  }else{  
		   for(i=2;i<=m;i++){      
		    if(n%i==0){      
		     System.out.println(n+" is not prime number");      
		     flag=1;      
		     break;      
		    }      
		   }      
		   if(flag==0)  { System.out.println(n+" is prime number"); }  
		  }//end of else  
		
	}
}
