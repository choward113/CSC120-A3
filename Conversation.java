import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;


class Conversation {
 
  public static void main(String[] arguments) {
    // You will start the conversation here.
    
    //choose number of rounds
    int currentRound = 1;
    Scanner userInput = new Scanner(System.in);
    System.out.println("How many rounds (int): ");
    int roundMax = userInput.nextInt();
    //Transcipt
    List<String> transcript = new ArrayList<String>();
    transcript.add("Hi! What's on your mind?"); //Introduction is constant 
    String previousInput;
    
    //canned response array
    String[] cannedResponses = new String[]{
      "Uh huh","How interesting","Really?","Hmm...", "Wow"
    };

    Scanner userIntro = new Scanner(System.in); 
    System.out.println("Hi! What's on your mind? "); //can intro, take in userresponse
    for (currentRound = 1; currentRound <= roundMax; currentRound++){
      String userResponse = userIntro.nextLine();
      transcript.add(userResponse);//add initial Userresponse to transcript 


      String output = "";
      //checks if response has a pronoun, and replaces it
        if (userResponse.contains("i ")) {
          output = userResponse.replaceAll("i ", "you ");
      } else if (userResponse.contains("me ")) {
          output = userResponse.replaceAll("me ", "you ");
      } else if (userResponse.contains("am ")) {
          output = userResponse.replaceAll("am ", "are ");
      } else if (userResponse.contains("you ")) {
          output = userResponse.replaceAll("you ", "I ");
      } else if (userResponse.contains("my ")) {
          output = userResponse.replaceAll("my ", "your ");
      } else if (userResponse.contains("your ")) {
          output = userResponse.replaceAll("your ", "my ");
          
      } else {
          //choose random response from list 
          int max = 4;
          int min = 0;
          Random rand = new Random();
          int randomNum = rand.nextInt((max - min) + 1) + min;
          String randomResponse = cannedResponses[randomNum];
          output = randomResponse;
          
          
      }
      //Responds after changing all pronouns
      System.out.println(output);
      previousInput = output;
      transcript.add(output); //add response to transcript
    }
    System.out.println("Goodbye!");
    transcript.add("Goodbye!");
    
    //print transcript
    System.out.println("\nTRANSCRIPT");
    for (String line : transcript) {
      System.out.println(line);
    }
    
  }
}