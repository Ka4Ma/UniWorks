import java.util.Scanner;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class Main {
 
  public static void main(String[] args) {
   Scanner Scanner = new Scanner(System.in);
   Finch finch = new Finch();
   FinchMove finchMove = new FinchMove();
   System.out.println("Welcome to the game");
    while (true) {
    
     System.out.println("Do you want to start the game?\n"
     + "1 - Yes\n"
     + "2 - No");
     int Action = Scanner.nextInt();
     switch (Action) {
      case 1:
        finchMove.FinchStart();
        finchMove.Record();
        finchMove.Execute();
        break;
      case 2:
       System.out.println("Thanks for passing by :)");
    
       finch.quit();
       return;
     }
  
   
 
 }
 }
 
}
