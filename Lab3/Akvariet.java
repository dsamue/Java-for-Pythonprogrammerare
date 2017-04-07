import java.util.*;
import java.io.*;
import java.math.*;  

public class Akvariet {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner data = null;
        Integer antal;
        Double totalStracka = 0.0;
        Double delStracka = null;
        Double x1, x2, y1, y2, z1, z2;

        File testData = new File("samples/aquarium.2.in");

        data = new Scanner(System.in);            //testData ovan för att köra testfallen. System.in Vid redovisning. 
        data.useLocale(Locale.US);               //gör det möjligt att hitta floats i string-input.
        antal = Integer.parseInt(data.next());   //fyller egentligen ingen mer funktion än att ta bort första int:en. 


        //Startpunkt
        x1 = data.nextDouble();
        y1 = data.nextDouble();
        z1 = data.nextDouble();

        while(data.hasNextDouble()) {
            x2 = data.nextDouble();
            y2 = data.nextDouble();
            z2 = data.nextDouble();

            //Räkna ut delsträcka
            delStracka = Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2)+Math.pow(z1-z2, 2));

            //Addera delsträcka till total sträcka
            totalStracka = totalStracka + delStracka;

            //Byt startpunkt
            x1 = x2;
            y1 = y2;
            z1 = z2;
            
        }
        //Avrundar output till 2 decimaler
        System.out.format("%.2f%n", totalStracka);
        System.exit(0);
    }

}