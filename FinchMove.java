import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
public class FinchMove {
 Finch finch = new Finch();
 Scanner scanner = new Scanner(System.in);
 boolean t = false;
 int Action;
 int blue;
 int green = 255;
 ArrayList<String> movements_list = new ArrayList<String>();
 
         
 int Velo = 200; //ThreadLocalRandom.current().nextInt(50, 254 + 1);
 
 
  
 
 public void FinchStart() {
  System.out.println("How long do you want to record the tilt(1s-20s)?");
  Action = scanner.nextInt();
  while (t = false) {
   if (Action > 0 && Action <= 20) {
    int red = 255;
   finch.setLED(red, green, blue);
   finch.playTone(262, 500);
   t = true;
   int Move = scanner.nextInt();
  }
  else {
   System.out.println("The value is not valid. \n"
     + "Please enter valid time. ");
   t = false;
   }
   
  }   
 }
 public void Record() {
  
  long startTime = System.currentTimeMillis();
  long diff = 0;
  
  while(diff < (Action*1000)){
 
   finch.setLED(255,0,0);
   
   if(finch.isBeakUp()) {
    
    movements_list.add("MoveForward");
//    Action = Action -1 ;
    
   }
   else if(finch.isBeakDown()) {
    movements_list.add("MoveBackwards");
//    Action = Action -1 ;
    
    
   }
   else if(finch.isRightWingDown()) {
    movements_list.add("TurnRight");
//    Action = Action -1 ;
    
    
   }
   else if(finch.isLeftWingDown()) {
    movements_list.add("TurnLeft");
//    Action = Action -1 ;
    
    
   }
   else if (finch.isFinchLevel()) {
    movements_list.add("Stop");
//    Action = Action -1 ;
    
    
   }
   
   diff = System.currentTimeMillis() - startTime;
   System.out.println(diff);
  }
  
  
  for(int i = 0; i<movements_list.size(); i++){
   
   System.out.println("In the movements_list " + movements_list.get(i));
  }
   
  
  
 }
 
 
  public void Execute() {
   
   movements_list.add("MoveForward");
   movements_list.add("TurnRight");
   movements_list.add("MoveForward");
   movements_list.add("MoveForward");
   movements_list.add("MoveForward");
   movements_list.add("TurnLeft");
   movements_list.add("MoveBackwards");
   movements_list.add("MoveBackwards");
   movements_list.add("MoveBackwards");
   
   
    while (movements_list.size() != 0) {
     for (int i = 0;i <movements_list.size();) {
      String Got = movements_list.get(i);
       switch (Got) {
       case "MoveForward":
         finch.setWheelVelocities(Velo, Velo, 500);
         finch.setLED(0,green,0);
         movements_list.remove(Got);
         break;
       case "MoveBackwards" :
        finch.setWheelVelocities(-Velo, -Velo, 500);
        finch.setLED(green,0,0);
        movements_list.remove(Got);
        
        break;
        
       case "TurnRight" :
        finch.setWheelVelocities(Velo, 0, 500);
        finch.setLED(green,0,0);
        movements_list.remove(Got);
       
       break;
       case "TurnLeft" :
        finch.setWheelVelocities(0, Velo, 500);
        finch.setLED(green,0,0);
        movements_list.remove(Got);
       
       break;
       case "Stop":
        finch.setWheelVelocities(Velo, Velo, 500);
        finch.setLED(green,0,0);
        movements_list.remove(Got);
       
       break;
       
       }
      }
    }
  }
}

