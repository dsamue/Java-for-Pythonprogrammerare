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

        //Kanske är lättast att skicka in en lista ändå? Iom att det verkar lite osmidigt att ta tecken från sträng.

        //Kolla om vi är klara (listan tom) o returnera isf vadå? True? Tom sträng?
        //Kolla om nästa tecken är "(". Returnera isf det inom parantesen. (isEqual?)
        //Kolla om första är siffra, kolla isf om även nästa är siffra. Returnera new String(new char[n]).replace("\0", s); där n är talet och s är ett nytt anrop?
        String dekomprimeradKod = kod;
        return dekomprimeradKod;
    }
}

//data.useLocale(Locale.US);               //gör det möjligt att hitta floats i string-input.

// repeated = new String(new char[n]).replace("\0", s);
// Where n is the number of times you want to repeat the string and s is the string to repeat.

//Ok, en himla massa problem just nu. Vet inte om jag ska skicka in ett scanner objekt eller string
//Skulle först och främst vilja få koden att funka för grundexemplet 11ab, därefter bör det bara vara att lägga till rekursivitet. 