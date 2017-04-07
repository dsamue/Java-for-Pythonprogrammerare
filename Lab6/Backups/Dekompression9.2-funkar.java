import java.util.*;
import java.io.*;
import java.math.*;  

public class Dekompression {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner data;
        String kod;

        //File testData = new File("samples/decompress.1.in");

        data = new Scanner(System.in);            //testData ovan för att köra testfallen. System.in Vid redovisning. 
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
            //System.out.println("tom sträng ger: " + "");
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
            

            //Kolla om det finns parenteser
            Integer endPosition = 0;
            String kodEnd = "";
            String kodBegin = "";

            //För jämförelse
            k = Character.toString(i);

            //Om nästa tecken är en parentes: Dela upp efter slutparentes
            if(Objects.equals(k, "(" )){

                Integer kodLength = kod.length();
                Integer antalParenteser = 0;
                Integer antalSlutParenteser = 0;

                //Räkna antal startparenteser innan motsvarande slutparentes dyker upp
                //Boolean done = false;

                loop:
                for(int m = 0; m < kodLength; m++){
                    String tecken = kod.substring(m, m+1);
                    //System.out.println("tecken = " + tecken);

                    if(Objects.equals(tecken, "(")){
                        antalParenteser += 1;
                    } 

                    if(Objects.equals(tecken, ")")){
                        antalSlutParenteser += 1;

                        if(antalParenteser == antalSlutParenteser){
                            endPosition = m;
                            break loop;
                        }    
                    } 
                }

                // for(int m = 0; i < kodLength; m++ ){
                //     String tecken = kod.substring(m, m+1);

                //     if(Objects.equals(tecken, ")")){
                //         antalSlutParenteser += 1;
                //         if(antalParenteser == antalSlutParenteser){
                //             endPosition = m;
                //         }
                //     } 
                // } 

                kodEnd = kod.substring(endPosition + 1);
                kodBegin = kod.substring(0, endPosition + 1);

            }

            //Om nästa inte är en parentes: dela upp efter första tecknet  
            else {
                kodEnd = kod.substring(1);    
                kodBegin = kod.substring(0, 1); 
            } 

            //Repetera ensamt tecken alternativt innehåller i parentesen och addera därefter anropet på sista delen av koden. (Anar att denna del blir onödigt klumpig iom att jag delar upp stängen)
            //System.out.println("siffra returnerar : " + number + " * " + kodBegin + " + ger " + kodEnd + " som nytt anrop");
            return new String(new char[number]).replace("\0", Dekomprimera(kodBegin)) + Dekomprimera(kodEnd); 
        }



        //Om tecknet är en bokstav
        else if (Character.isLetter(i)){

            //konvertera char till string
            subString = Character.toString(i);
            kod = kod.substring(1);

            //System.out.println("bokstav ger: " + subString);
            return subString + Dekomprimera(kod);  
        }



        //Om tecknet är en startparentes
        else if (Objects.equals(k, "(" )){

            //Ta bort parentes och byt första tecken
            kod = kod.substring(1);
            i = kod.charAt(0);

            //För jämförelse
            //k = Character.toString(i);

            //Plocka ut alla tecken
            while (!kod.isEmpty()){
                
                subString += i;
                kod = kod.substring(1);

                if (!kod.isEmpty()){
                    i = kod.charAt(0);

                    //Om sista tecknet är en parentes tar vi bort den
                    k = Character.toString(i);

                    if (kod.length() < 2 && Objects.equals(k, ")" )){
                        kod = kod.substring(1);
                    }
                }
            }
            //System.out.println("startparentes ger: " + subString);
            return Dekomprimera(subString);
        }



        //Om tecknet är en slutparentes
        else if (Objects.equals(k, ")" )){
            
            //Ta bort slutparentes och gör nytt anrop
            kod = kod.substring(1);
            System.out.println("slutparentes ger: " + kod);

            return Dekomprimera(kod);
        }


        // else{
        //     System.out.println("Error");
        // }
    //System.out.println("Hela vägen till slutet ger: " + "");
    return "";
    }
}