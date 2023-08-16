import java.lang.Math;
import java.util.*;
import java.io.*;
public class RandomNumber{
    public static void generateRandom(){
        int min=1;
        int max=100;
        int random=(int)(Math.random()*(max-min+1)+min);
        guess(random);
    }
    public static void guess(int random){
        System.out.println("Enter your guess for the generated number from 1 to 100:");
        Scanner sc=new Scanner(System.in);
        
        int userGuess=0;
        
        int tryCount=0;
        while(userGuess!=random){
            if(tryCount==5){
                System.out.println("Game Over!Number of attempts the user has to guess the number is over");
                break;
            }
            userGuess=sc.nextInt();
            tryCount++;
            if(userGuess==random){
                System.out.println("You guessed it right");

            }
            else{
                if(userGuess>random){
                    System.out.println("You guessed it wrong.Number entered is too large.");
                }
                else{
                    System.out.println("You guessed it wrong.Number entered is too small.");

                }
            }
            

        }
        if(tryCount<5){
            System.out.println("You won the game and your score is 100");
        }
        else{
            System.out.println("You loss the game and your score is 0");

        }
    }
    public static void main(String[] args){
        generateRandom();
        System.out.println("If you want to play again then press 1 for playing again");
        System.out.println("Press 0 for exit the game");
        int choice;
        Scanner sc1=new Scanner(System.in);
        choice =sc1.nextInt();
        
        while(choice==1){
            generateRandom();
            
            System.out.println("If you want to play again then press 1 for playing again");
        System.out.println("Press 0 for exit the game");
            choice =sc1.nextInt();
        }
        
         


    
        
        


      
        
       
        
        
        


    }
}
