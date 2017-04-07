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

        String siffra = "0";

        //Hämta första tecknet
        Character i = kod.charAt(0);

        //Kolla om det är en siffra
        if (Character.isDigit(i)){
            Character j = kod.charAt(1);

            //Är även andra tecknet en siffra?
            if (Character.isDigit(j)){

                Integer int1 = Character.getNumericValue(i);
                Integer int2 = Character.getNumericValue(j);

                //Lägg ihop tecken och omvandla till integer
                String numberString = "" + int1 + int2;
                Integer number = Integer.parseInt(numberString);


                System.out.println(number);
                //System.out.println(int2);
                //System.out.println(number);

            }

            else{
                //System.out.println("yes");
                Integer number = Character.getNumericValue(i);
                System.out.println(number);
            }     
        }

        //Skulle först och främst vilja få koden att funka för grundexemplet 11ab, därefter bör det bara vara att lägga till rekursivitet. 
        //Kanske är lättast att skicka in en lista ändå? Iom att det verkar lite osmidigt att ta tecken från sträng. Får jag inte det att funka kan Stringreader kanske vara nåt. 

        //Kolla om vi är klara (listan tom) o returnera isf vadå? True? Tom sträng?
        //Kolla om nästa tecken är "(". Returnera isf det inom parantesen. (isEqual?)
        //Kolla om första är siffra, kolla isf om även nästa är siffra. Returnera new String(new char[n]).replace("\0", s); där n är talet och s är ett nytt anrop?

        // if (kod.hasNextInt()){
        //     System.out.println("yes");
        //      siffra = Integer.toString(kod.nextInt());
        // }

        //String dekomprimeradKod = kod;
        //return dekomprimeradKod;
        return siffra;
    }
}

//data.useLocale(Locale.US);               //gör det möjligt att hitta floats i string-input.

// repeated = new String(new char[n]).replace("\0", s);
// Where n is the number of times you want to repeat the string and s is the string to repeat.