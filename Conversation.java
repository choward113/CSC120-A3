import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

/**
 * The Conversation class holds a chatbot. 
 */
class Conversation {
 /**
  * Chatbot that responds by mirroring the user input or by choosing a random response.
  * @param arguments
  */
  public static void main(String[] arguments) {
    // You will start the conversation here.
    int currentRound = 1;
    Scanner userInput = new Scanner(System.in);
    System.out.println("How many rounds (int): ");
    int roundMax = userInput.nextInt();

    List<String> transcript = new ArrayList<String>();
    transcript.add("Hi! What's on your mind?"); //Introduction is constant 
    
    List<String> mirrorPronouns = new ArrayList<String>();
    mirrorPronouns.add("you ");
    mirrorPronouns.add("i ");
    mirrorPronouns.add("me");
   
    List<String> mirrorPossessivePrns = new ArrayList<String>();
    mirrorPossessivePrns.add("my");//BROKEN
    mirrorPossessivePrns.add("your");//BROKEN

    List<String> mirrorVerbs = new ArrayList<String>();
    mirrorVerbs.add("are ");
    mirrorVerbs.add("am ");
    mirrorVerbs.add("is ");

    String[] cannedResponses = new String[]{
      "Uh huh","How interesting","Really?","Hmm...", "Wow"
    };

    Scanner userIntro = new Scanner(System.in); 
    System.out.println("Hi! What's on your mind? "); //can intro, take in userresponse

    for (currentRound = 1; currentRound <= roundMax; currentRound++){
      String userResponse = userIntro.nextLine();
      transcript.add(userResponse);//add initial Userresponse to transcript 
      userResponse = userResponse.toLowerCase(); 
      boolean change = false;
      String output = "";
      
      /**
       * Checks if response has a pronoun, and replaces it if it exists.
       */
      for (int i = 0; i < mirrorPronouns.size(); i++) {
        String pronoun = mirrorPronouns.get(i);
        pronoun = pronoun.toLowerCase();
        if (userResponse.contains(pronoun) || userResponse.contains("I ")) {
          String mirrorPronoun = mirrorPronouns.get((i + 2) % 3);
          userResponse = userResponse.replaceAll(pronoun, mirrorPronoun);
          change = true;
          break;
        }
      }

      /**
       * Checks if response has a possessive pronoun, and replaces it if it exists.
       */
      for (int i = 0; i < mirrorPossessivePrns.size(); i++) {
        String possessivePrn = mirrorPossessivePrns.get(i);
        possessivePrn = possessivePrn.toLowerCase();
        if (userResponse.contains(possessivePrn)) {
          String mirrorPossessivePrn = mirrorPossessivePrns.get((i + 1) % 2);
          userResponse = userResponse.replaceAll(possessivePrn, mirrorPossessivePrn);
          change = true;
          break;
        }
      }
      
      /**
       * Checks if respons has a mirrorable verb, and replaces it **WORKS*
      */
      for (int i = 0; i < mirrorVerbs.size(); i++) {
        String verb = mirrorVerbs.get(i);
        if (userResponse.contains(verb)) {
          String mirrorVerb = mirrorVerbs.get((i + 2) % 3);
          userResponse = userResponse.replaceAll(verb, mirrorVerb);
          change = true;
          break;
        }
      }

      if (change == true) {
        //Convert lower case to regular sentence capitalization
        String str1 = userResponse.substring(0, 1).toUpperCase();  
        String str2 = userResponse.substring(1, userResponse.length()); 
        output = str1.substring(0,1).toUpperCase() + str2.substring(0);
      } else {
        //Choose random response from list 
        int max = 4;
        int min = 0;
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        output = cannedResponses[randomNum];
      }

    
      if (change == true) {
        //Convert lower case to regular sentence capitalization
        String str1 = output.substring(0, 1).toUpperCase();  
        String str2 = output.substring(1, output.length()); 
        output = str1.substring(0,1).toUpperCase() + str2.substring(0);
        System.out.println(output + "?");
        transcript.add(output); 
      } else {
        System.out.println(output);
        transcript.add(output); 
      }
      
    }
    System.out.println("Goodbye!");
    transcript.add("Goodbye!");
    
    //Prints transcript
    System.out.println("\nTRANSCRIPT");
    for (String line : transcript) {
      System.out.println(line);
    }
    
  }
}