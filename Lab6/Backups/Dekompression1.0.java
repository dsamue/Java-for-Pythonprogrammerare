import java.util.*;
import java.io.*;
import java.math.*;  

public class Dekompression {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner data;
        String kod;

        File testData = new File("samples/decompress.1.in");

        data = new Scanner(testData);            //testData ovan för att köra testfallen. System.in Vid redovisning. 
        kod = data.nextLine();

        //Anropa rekursiv fuktion för att dekomprimera
        String dekomprimeradKod = Dekomprimera(kod);

        //Skriv  ut dekomprimerad kod
        System.out.println(dekomprimeradKod);
        System.exit(0);

    }

    //Dekomprimerar koden rekursivt
    public static String Dekomprimera(String kod){
        String dekomprimeradKod = kod;
        return dekomprimeradKod;
    }
}