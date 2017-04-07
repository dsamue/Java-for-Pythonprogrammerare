import java.util.*;
import java.io.*;
import java.math.*;  

@SuppressWarnings("unchecked") //För att slippa varningar vid kompliering
 
public class TidsBokning{
 
    public static void main(String[] args) throws FileNotFoundException {

        Scanner data;
        Integer tidID;
        String tid;
        Integer antalTider;
        Integer antalPersoner;
        

        //File testData = new File("samples/tidbokning.1.in");
        data = new Scanner(System.in);            //testData ovan för att köra testfallen. System.in Vid redovisning. 

        antalTider = Integer.parseInt(data.next());
        antalPersoner = Integer.parseInt(data.next());
        String resenAvRaden = data.nextLine();   //Känns lite sådär

        //Skapa lista av tidsobjekt
        List<MeetingTime> tidsLista = new ArrayList<MeetingTime>();
        
        //Läs in tider
        for (Integer i=0; i < antalTider; i++){
            String rad;
            rad = data.nextLine();
            tidsLista.add(new MeetingTime(rad, 0));
        }

        //Läs in röster
        for (Integer i=0; i < antalPersoner; i++){
            Scanner rad = new Scanner(data.nextLine());
            String namn = rad.next();

            //Lägg röster
            while (rad.hasNextInt()){
                tidID = rad.nextInt();
                tidsLista.get(tidID).addVote();
            }
        }

        //Sortera
        Collections.sort(tidsLista);
        Iterator itr = tidsLista.iterator();
 
        //Printa
        while(itr.hasNext()){
            Object element = itr.next();
            System.out.println(element + "\n");            
        }
    }
}