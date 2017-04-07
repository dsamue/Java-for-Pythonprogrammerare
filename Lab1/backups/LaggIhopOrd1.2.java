import java.util.Scanner;
import java.io.*;

public class LaggIhopOrd {

    public static void main(String[] args) {

    	Scanner data = null;
    	Integer antal;
    	String ord;
    	String sammansatt = "";

    
	    antal = Integer.parseInt(new Scanner(System.in));

        //antal = Integer.parseInt(data.next());


        for (int i = 0; i < antal; i++) {
            ord = new Scanner(System.in);
            sammansatt = sammansatt + ord;
            
        }

        System.out.println(sammansatt);     //Ok, funkar alltså fint att skriva ut från while-loopen men inte utanför den. Annars snyggt jobbat!

        System.exit(0);
    }

}