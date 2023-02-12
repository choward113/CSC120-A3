import java.util.Scanner;
class Conversation {
 
  public static void convertString(String userResponse){  //function for converting i-> you etc.
    
    System.out.println(userResponse + "convertString is working!");
  }

  public static void main(String[] arguments) {
    // You will start the conversation here.
    
    //choose number of rounds
    int currentRound = 1;
    Scanner userInput = new Scanner(System.in);
    System.out.println("Enter how many rounds you would like (int): ");
    int roundMax = userInput.nextInt();
    
    for (currentRound = 1; currentRound <= roundMax; currentRound++){
      System.out.println(currentRound); // prints current round, delete when done
      Scanner userIntro = new Scanner(System.in); 
      System.out.println("Hi! What's on your mind? "); //can intro, take in userresponse
      String userResponse = userIntro.nextLine();
      //convert pronouns, i->you etc
      convertString(userResponse);  //response here
      
       
    }
    if (roundMax > 1){ //if more than 1 conversation round print "rounds" if exactly one print "round"
      System.out.println(roundMax + " converstation rounds completed.");
    }
    else{
      System.out.println("Conversation round completed.");
    }


    
   
    
  }
}
