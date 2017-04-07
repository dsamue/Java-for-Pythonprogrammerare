import java.util.*;
import java.io.*;
import java.math.*;  

public class Dekompression {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner data;
        String kod;

        //File testData = new File("samples/decompress.2.in");

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

        String siffra = "0";
        Integer number = 1;
        String subString = "";

        //Kontrollera att strängen inte är tom. 
        if(kod.isEmpty()){
            return "";
        }

        //Hämta första tecknet
        Character i = kod.charAt(0);

        //Gör en variant där vi konvertera char till string för senare jämföresle
        String k = Character.toString(i);



        //Kolla om det är en siffra
        if (Character.isDigit(i)){
            Character j = kod.charAt(1);

            //Är även andra tecknet en siffra?
            if (Character.isDigit(j)){

                Integer int1 = Character.getNumericValue(i);
                Integer int2 = Character.getNumericValue(j);

                //Lägg ihop tecken och omvandla till integer
                String numberString = "" + int1 + int2;
                number = Integer.parseInt(numberString);

                //System.out.println(number);

                //Radera dom två första tecknen
                kod = kod.substring(2);

                //och sätt nytt tecken som första   ..bör ej behövas? Jo kanske beroende på hur jag ändrat. 
                i = kod.charAt(0);

            }

            //Om bara första tecknet är en siffra
            else{
                //System.out.println("yes");
                number = Character.getNumericValue(i);
                //System.out.println(number);

                //Radera första tecknet
                kod = kod.substring(1);

                //och sätt nytt tecken som första   .. bör ej behövas?
                i = kod.charAt(0);
            } 
            

            //Kolla om det finns nästa tecken är en parentes och dela upp strängen
            Integer position = kod.lastIndexOf(')');
            String kodEnd = "";
            String kodBegin = "";

            k = Character.toString(i);

            //Om parentes:
            if(Objects.equals(k, "(" )){

                kodEnd = kod.substring(position);
                //System.out.println("kodEnd = " + kodEnd);
                kodBegin = kod.substring(0, position);

            }


            //Om nästa inte är en parentes: dela upp efter första tecknet  
            else {
                //System.out.println(position);
                kodEnd = kod.substring(1);    
                kodBegin = kod.substring(0, 1); 
            } 

            // //Om det finns en parentes, dela upp där och skicka i varsitt anrop 
            // else{
            //     kodEnd = kod.substring(position);
            //     System.out.println("kodEnd = " + kodEnd);
            //     kodBegin = kod.substring(0, position);
            // }

            return new String(new char[number]).replace("\0", Dekomprimera(kodBegin)) + Dekomprimera(kodEnd);


            //return subString + Dekomprimera(kod));       
        }

            //Skriv ut rätt antal tecken
            //while char = bokstav... addera och gör till sträng (fast bara om i parentes).. skriv sen ut number * sträng) Fundera på hur jag löser det om det är en parentes typ 3(3a2(ab)).



        else if (Character.isLetter(i)){

            //Ta bort slutparentes --> funkar ej att ha denna här om man t.ex. har "ab" iom att det inte finns nån sista parentes. 
            //kod = kod.substring(1);

            //konvertera char till string .. Slutfall?
            subString = Character.toString(i);
            kod = kod.substring(1);

            return subString + Dekomprimera(kod);   //Här känns det ju iofs som att det blir samma grej med a + b? Ev. bara returnera substring utan nytt anrop? kanske i den bortkommenterade här under så vi får med alla tecken? 




            //Det här blir väl mitt slutfall? 
            // if (kod.isEmpty()){
            //     return subString;
            // }

            // else{
            //     return subString + Dekomprimera(kod);
            // }
        }


        //Kolla om startparentes
        else if (Objects.equals(k, "(" )){
            // System.out.println("funkar");
            // System.out.println("kod = " + kod);
            // System.out.println("räknas ( som bokstav? = " + Character.isLetter(i));

            //Ta bort parentes och byt första tecken
            kod = kod.substring(1);
            i = kod.charAt(0);

            //System.out.println("räknas ( som bokstav? = " + Character.isLetter(i));

            while (Character.isLetter(i) && !kod.isEmpty()){
                // System.out.println(i);
                // System.out.println(!kod.isEmpty());
                subString += i;

                kod = kod.substring(1);

                // System.out.println("kod tom = " + kod.isEmpty());
                // System.out.println("kod = " + kod);

                if (!kod.isEmpty()){
                    i = kod.charAt(0);
                }
                
            }

            return subString + Dekomprimera(kod);

        }

        //Kolla om slutparentes    ...Denna kanske blir överflödig om man alltid tar bort slutparentes i tidigare fall?
        else if (Objects.equals(k, ")" )){
            kod = kod.substring(1);
            //System.out.println(kod);
            return Dekomprimera(kod);
        }

        else{
            System.out.println("Error");
        }

        //System.out.println(number*100);    
        

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