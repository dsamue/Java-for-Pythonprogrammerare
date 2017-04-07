import java.util.*;
import java.io.*;
import java.math.*;  

public class Dekompression {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner data;
        String kod;

        File testData = new File("samples/decompress.3.in");

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

        //String siffra = "0";
        Integer number = 1;
        String subString = "";

        //Kontrollera att strängen inte är tom. 
        if(kod.isEmpty()){
            return "";
        }

        //Hämta första tecknet
        Character i = kod.charAt(0);

        //Konvertera tecknet till string för senare jämföresle
        String k = Character.toString(i);



        //Om första tecknet är en siffra:
        if (Character.isDigit(i)){
            Character j = kod.charAt(1);

            //Är även andra tecknet en siffra?
            if (Character.isDigit(j)){

                Integer int1 = Character.getNumericValue(i);
                Integer int2 = Character.getNumericValue(j);

                //Lägg ihop tecken och omvandla till integer
                String numberString = "" + int1 + int2;
                number = Integer.parseInt(numberString);

                //Radera dom två första tecknen
                kod = kod.substring(2);

                //och sätt nytt tecken som första 
                i = kod.charAt(0);

            }

            //Om bara första tecknet är en siffra:
            else{
                number = Character.getNumericValue(i);

                //Radera första tecknet
                kod = kod.substring(1);

                //och sätt nytt tecken som första
                i = kod.charAt(0);
            } 
            

            //Kolla om nästa tecken är en parentes och dela upp strängen
            Integer endPosition = kod.lastIndexOf(')');
            String kodEnd = "";
            String kodBegin = "";

            k = Character.toString(i);

            //Om nästa tecken är en parentes: Dela upp efter slutparentes
            if(Objects.equals(k, "(" )){

                kodEnd = kod.substring(endPosition);
                kodBegin = kod.substring(0, endPosition);

            }

            //Om nästa inte är en parentes: dela upp efter första tecknet  
            else {
                kodEnd = kod.substring(1);    
                kodBegin = kod.substring(0, 1); 
            } 

            //Repetera ensamt tecken alternativt innehåller i parentesen och addera därefter anropet på sista delen av koden. (Anar att denna del blir onödigt klumpig iom att jag delar upp stängen)
            return new String(new char[number]).replace("\0", Dekomprimera(kodBegin)) + Dekomprimera(kodEnd); 
        }



        //Om tecknet är en bokstav
        else if (Character.isLetter(i)){

            //konvertera char till string
            subString = Character.toString(i);
            kod = kod.substring(1);

            return subString + Dekomprimera(kod);  
        }



        //Om tecknet är en startparentes
        else if (Objects.equals(k, "(" )){

            //Ta bort parentes och byt första tecken
            kod = kod.substring(1);
            i = kod.charAt(0);

            //Plocka ut alla bokstäver
            while (Character.isLetter(i) && !kod.isEmpty()){
                
                subString += i;
                kod = kod.substring(1);

                if (!kod.isEmpty()){
                    i = kod.charAt(0);
                }
            }
            return subString + Dekomprimera(kod);
        }



        //Om tecknet är en slutparentes
        else if (Objects.equals(k, ")" )){
            
            //Ta bort slutparentes och gör nytt anrop
            kod = kod.substring(1);
            return Dekomprimera(kod);
        }


        else{
            System.out.println("Error");
        }
    return "";
    }
}