import java.util.*;
import java.io.*;
import java.math.*;  

public class Enigma {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner data;
        String kod;
        String ord;
        String positioner = "";

        //File testData = new File("samples/enigma.1.in");

        data = new Scanner(System.in);            //testData ovan för att köra testfallen. System.in Vid redovisning. 
        kod = data.next();
        ord = data.next();

        //Splitta strings till arrays
        String[] kodArray = kod.split("");
        String[] ordArray = ord.split("");

        //Gå igenom positioner i koden
        for (Integer i=0; i <= kodArray.length - ordArray.length; i++){

            //Gå igenom positioner i ordet
            ordLoop:
            for (Integer j=0;  j < ordArray.length ; j++){

                //Om bokstäverna matchar bryter vi för denna position
                if (Objects.equals(ordArray[j], kodArray[i+j])){                      //Detta var tvunget då == inte jämför värden utan ser det som två olika objekt
                    break ordLoop;
                }

                //Om hela ordet går igenom utan break så sparas positionen
                else if (Objects.equals (j, ordArray.length - 1)){
                    Integer k = i +1;                                                // Ok, lyckas inte plussa 1 till i i output. Varför?. 
                    positioner = positioner + k + " ";
                }
            }
        }

        //Skriv ut -1 om inga positioner fanns
        if (Objects.equals(positioner, "")){
                    System.out.println(-1);
                    System.exit(0);
                }

        //Skriv annars ut positioner
        System.out.println(positioner);
        System.exit(0);

    }
}