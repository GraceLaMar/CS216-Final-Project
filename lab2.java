// lab2.java
// your name
// September 5, 2025
// calculates primes using Sieve of Eratosthenes
// demonstrates command line arguments and methods
// *** add answers to performance questions here ***

// The max prime number I could find was 997. 

// Printing effects preformance because it causes the program to run a lot slower. Without printing the program can run faster.

// Some of the factors that limit my program are the memory on my computer, the limit of language, and the limit of amount of time. 

public class lab2 {

	public static void main(String[] args) 
	{
		int N = 0;
		//add code to get num from command line argument
		if (args.length > 0)
        {
            
            N = Integer.parseInt( args[0] );
            System.out.println( "N = " + N);
        }
        else
        {
            N = 1000;
            System.out.println("Missing argument");
        }
        
        showPrimes( N );
    }

    //main
    public static void showPrimes(int N) {
        
        //array of booleans
        boolean[] array = new boolean[N+1];
        
        array[0] = false;
        array[1] = false;

        for (int i=2; i <= N;i++){
            array[i] = true;
        }
        
        //mark off values
        for (int i = 2; i <= Math.sqrt(N);i++){
            if (array[i]){
                for (int j = i * i; j <= N; j += i){
                    array[j] = false;
                }
            }
        }
        
        //display results
        for (int i = 2; i <= N; i++) {
            if (array[i] == true) {
                System.out.print( i );
            }
        }
		

    }
	
	
}//lab2
