public class MeetingTime implements Comparable {
    
    String Time;
    int Votes;
    //Ok, dessa var jag tvungen att lägga till (även på MeetingTime-objekt i denna klass) för att få sorteringen att funka. 
    int EmpID;
    static int i;
 
 
    public MeetingTime(String time, int votes) {
        EmpID = i++;
        Time = time;
        Votes = votes;
    }
 
    public String toString() {
        return Time + " " + Votes;
    }

    public void addVote(){
        Votes = Votes + 1;
    }
 
    public int compareTo(Object o1) {
        if (this.Votes == ((MeetingTime) o1).Votes)
            return 0;
        else if ((this.Votes) < ((MeetingTime) o1).Votes)
            return 1;
        else
            return -1;
    }
}