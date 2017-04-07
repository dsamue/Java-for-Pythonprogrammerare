import java.util.Scanner;
import java.io.*;

public class LaggIhopOrd {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner data = null;
        Integer antal;
        String ord;
        String sammansatt = "";

        //File testData = new File("ord.1.in");

        data = new Scanner(System.in);  //testData ovan för att köra testfallen
        antal = Integer.parseInt(data.next());   //fyller egentligen ingen mer funktion än att ta bort första int:en. 

        while(data.hasNext()) {
            ord = data.next();
            sammansatt = sammansatt + ord;
            
        }

        System.out.println(sammansatt); 
        System.exit(0);
    }

}
