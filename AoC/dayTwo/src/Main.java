import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[]args)throws FileNotFoundException{
        // reading file
        File file=new File("~/day2/src/input");
        Scanner sc=new Scanner(file);

        List<String> input=new ArrayList<String>();

        while(sc.hasNext()){
            input.add(sc.nextLine());
        }
        sc.close();

        int validPasswordsSled=0;
        int validPasswordsToboggan=0;
        int lowerNumber=0;
        int upperNumber=0;
        char character;

        for(String line:input){
            int hits=0;
            String[]inputArray=line.split(" ");
            String[]limits=inputArray[0].split("-");
            lowerNumber=Integer.parseInt(limits[0]);
            System.out.println(lowerNumber);
            upperNumber=Integer.parseInt(limits[1]);
            System.out.println(upperNumber);
            String password=inputArray[2];
            System.out.println(password);
            character=inputArray[1].charAt(0);
            System.out.println(character);
            if((lowerNumber<=charAmount(password,character))&&(charAmount(password,character)<=upperNumber)){
                validPasswordsSled++;
                System.out.println("Char Amount = " + charAmount(password,character));
                System.out.println(lowerNumber + " - " + upperNumber + " :" + character + " = " + password);
            }

            if(password.charAt(lowerNumber-1)==character){
                hits++;
                System.out.println(password.charAt(lowerNumber-1) + " first equals " + character);
            }

            if(password.charAt(upperNumber-1)==character){
                hits++;
                System.out.println(password.charAt(upperNumber-1) + " second equals " + character);

            }

            if(hits==1){
                validPasswordsToboggan++;
            }
        }

        System.out.println("There are "+validPasswordsSled+" valid passwords according to the Official Sled Corporate Authentication System");

        System.out.println("There are "+validPasswordsToboggan+" valid passwords according to the Official Toboggan Corporate Authentication System");


    }

    public static int charAmount(String string,char character){
        int amount=0;

        for(int i=0;i<string.length();i++){
            if(string.charAt(i)==character){
                amount++;
            }
        }

        return amount;
    }

}
