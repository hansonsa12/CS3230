import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FractionCalc {
    public static void main(String[] args) {
    	
        System.out.println("Enter a fraction expression:");
        
        Scanner scanner = new Scanner(System.in);
        
        String input = scanner.nextLine();
     
        if (input != null) {
            //the regex pattern that allows spaces/tabs/whitespace between each digit and operation
        	  String fractionPattern = "\\s*(-?\\d+)\\s*/\\s*(-?\\d+)\\s*([-+*/])\\s*(-?\\d+)\\s*/\\s*(-?\\d+)\\s*";
            //the matcher to the regex pattern
            Matcher x = Pattern.compile(fractionPattern).matcher(input);
            //if the input matches
            if (x.find()) {
                //store each group(digit or operation) in an array
                String[] groups = new String[x.groupCount()];
                for(int i = 0; i < x.groupCount() ;i++) {
                    groups[i]= x.group(i+1);
                }
                //build the fraction objects
               
                Fraction left = new Fraction(Integer.parseInt(groups[0]),Integer.parseInt(groups[1]));
                
                Fraction right = new Fraction(Integer.parseInt(groups[3]),Integer.parseInt(groups[4]));
                
             
                switch(groups[2]){
                    case "+":
                        System.out.println(left.add(right));
                        break;
                    case "-":
                        System.out.println(left.sub(right));
                        break;
                    case "*":
                        System.out.println(left.mult(right));
                        break;
                    case "/":
                        System.out.println(left.div(right));
                        break;
                }
            }
            else{
                System.out.println("Incorrect expression format.");
            }
        }
    }
}