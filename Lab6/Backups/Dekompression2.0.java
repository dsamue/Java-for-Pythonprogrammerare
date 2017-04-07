import java.util.*;
import java.io.*;
import java.math.*;  

public class Dekompression {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner data;
        String kod;

        File testData = new File("samples/decompress.1.in");

        data = new Scanner(testData);            //testData ovan för att köra testfallen. System.in Vid redovisning. 
        data.useLocale(Locale.US);
        //kod = data.nextLine();

        //Anropa rekursiv fuktion för att dekomprimera
        String dekomprimeradKod = Dekomprimera(data);

        //Skriv  ut dekomprimerad kod
        System.out.println(dekomprimeradKod);
        System.exit(0);

    }

    //Dekomprimerar koden rekursivt
    public static String Dekomprimera(Scanner kod){

        Scanner test = kod;

        if (test.hasNextDouble()){
            Double i = test.nextDouble();
            String j = String.valueOf(i);
            System.out.println(j);
            System.out.println("yes");
        }

        String dekomprimeradKod = "hej";
        return dekomprimeradKod;
    }
}


 //data.useLocale(Locale.US);               //gör det möjligt att hitta floats i string-input.

// repeated = new String(new char[n]).replace("\0", s);
// Where n is the number of times you want to repeat the string and s is the string to repeat.

//Ok, en himla massa problem just nu. Vet inte om jag ska skicka in ett scanner objekt eller string
//Skulle först och främst vilja få koden att funka för grundexemplet 11ab, därefter bör det bara vara att lägga till rekursivitet. 