import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Callendar {
    private DataManager dm;

    public Callendar(){
        dm = new DataManager();
    }

    public synchronized String getSlot(int year, int month, int day, int from, int to, String name){
        String ret = reserve(new Date(year, month, day), name, from, to);
        if(ret.equals("done")){
            return "Reservation complete at " + day + "/" + month + "/" + year + " from " + from + " to " + to + " for " + name;
        }else{
            return "Failed to reserve slot at " + day + "/" + month + "/" + year + " from " + from + " to " + to + ". These are the slots that are already reserved: \n" + ret;
        }
    }

    public synchronized String reserve(Date date, String name, int from, int to){
        String[] data = dm.readData(date);
        int from_h = from / 100;
        int from_m = from % 100;
        int to_h = to / 100;
        int to_m = to % 100;
        int fromData = from_h * 4 + from_m / 15;
        int toData = to_h * 4 + to_m / 15;
        boolean a = true;
        for(int i = fromData; i < toData; i++){
            if(!data[i].equals("free")){
                a = false;
            }
        }
        if(a){  // if the required slot is free
            dm.writeData(name, from, to, date);
            return "done";
        }else{  // if the required slot is occupied
            ArrayList<String> file = dm.readFile(new Date(2020, 1, 1));
            String out = "";

            for(int i = 0; i < file.size(); i++){
                out = out + file.get(i) + "\n";
            }
            return out;
        }
    }


}

