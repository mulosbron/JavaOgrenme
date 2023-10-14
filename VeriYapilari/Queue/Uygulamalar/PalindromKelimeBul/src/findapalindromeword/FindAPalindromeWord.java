package findapalindromeword;

import java.util.Scanner;

public class FindAPalindromeWord {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StackStructure ss = new StackStructure(100);
        QueueStructure qs = new QueueStructure(100);
        String word;
        System.out.print("Enter a word: ");
        word = input.nextLine();
        int wordLength = word.length();
        
        char[] letters = word.toCharArray();
        for(int i = 0; i < wordLength; i++){
            ss.push(letters[i]);
            qs.enQueue(letters[i]);
        }
        
        while(!ss.isEmpty()){
            if(ss.pop() != qs.deQueue()){
                System.out.println(word + " is not Palindrome.");
                break;
            }
            else{
                System.out.println(word + " is Palindrome.");
                break;
            }
        }
    }
}
