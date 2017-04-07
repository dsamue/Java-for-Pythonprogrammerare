import java.util.*;
import java.io.*;
import java.math.*;  

public class Enigma {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner data;
        String kod;
        String ord;
        String positioner = "";

        //File testData = new File("samples/enigma.4.in");

        data = new Scanner(System.in);            //testData ovan för att köra testfallen. System.in Vid redovisning. 
        kod = data.next();
        ord = data.next();

        //Splitta strings till arrays
        String[] kodArray = kod.split("");
        String[] ordArray = ord.split("");

        //Kolla igenom positioner
        for (Integer i=0; i <= kodArray.length - ordArray.length; i++){
            //Kolla bokstäver i ordet
            ordLoop:
            for (Integer j=0;  j < ordArray.length ; j++){

                //System.out.println(ordArray[j].length() + kodArray[i+j].length());
                //System.out.println(ordArray[j] == kodArray[i+j]);

                if (Objects.equals(ordArray[j], kodArray[i+j])){
                    //System.out.println("Yes");
                    break ordLoop;
                }

                else if (Objects.equals (j, ordArray.length - 1)){
                    //Integer k = Integer.parseInt(i);         Ok, lyckas inte plussa 1 till i i output. Varför?. Annars snyggt! 
                    Integer k = i +1;
                    positioner = positioner + k + " ";
                    //System.out.println("hej");
                }

                else{
                    //System.out.println("hm");
                }


            }
        }

        if (Objects.equals(positioner, "")){
                    System.out.println(-1);
                    System.exit(0);
                }

        System.out.println(positioner);
        System.exit(0);

    }
}