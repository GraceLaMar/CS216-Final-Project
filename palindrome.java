/// palindrome.java 
//
// fall 2025
// lab4b assignment
//
//  Grace La Mar
//
// Use for paindrome.java

public class palindrome {
    
    public static void main(String[] args) {

        //single call to test
        System.out.println( palindrome("racecar") ); //true
        System.out.println( palindrome("sass") ); //false

        //uncomment to test additional words
        /*
        String words[] = { "a", "racecar", "noon", "hannah", "abcba", "abbca", "nope", "ab" };

        for (int i = 0; i < words.length; i++) {

            if (palindrome(words[i]) == true)
                System.out.println( words[i] + " IS a palindrome");
            else
                System.out.println( words[i] + " IS NOT a palindrome");
        }
        */
        
    }// main

    // *** use StackCharArray and QueueCharArray here to determine Palindrome
    private static boolean palindrome(String word) {

        //assume status is true
        boolean status = true;

		StackCharArray stack = new StackCharArray(word.length());
        QueueCharArray queue = new QueueCharArray(word.length());

        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            stack.push(c);
            queue.add(c);
        }

        for (int i = 0; i < word.length() && status; i++) {
            if (stack.top() != queue.front()) {
                status = false;
            } else {
                stack.pop();
                queue.remove();
            }
        }

        return status;
        
    }// palindrome method

}//class
