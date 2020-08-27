import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class DataManager {

    public synchronized void writeData(String person, int from, int to, Date date){
        LinkedList<String> prevElements = new LinkedList<String>();
        String dataPath = "data\\" + date.getYear() + "\\" + date.getMonth() + "\\" + date.getDay() + ".txt";
        File file = new File(dataPath);
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNext()){
                prevElements.add(sc.next() + " " + sc.nextInt() + " " + sc.nextInt());
            }

            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(person + " " + from + " " + to);
            while(!prevElements.isEmpty()){
                pw.println(prevElements.poll());
            }
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public synchronized ArrayList<String> readFile(Date date){
        String dataPath = "data\\" + date.getYear() + "\\" + date.getMonth() + "\\" + date.getDay() + ".txt";
        File file = new File(dataPath);
        ArrayList<String> out = new ArrayList<String>();
        try {

            Scanner sc = new Scanner(file);
            while (sc.hasNext()){
                String add = sc.next()+ " " + sc.nextInt() + " " + sc.nextInt();
                out.add(add);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return out;
    }


    public synchronized String[] readData(Date date){

        String[] out = new String[96];
        for(int i = 0; i < out.length; i++){
            out[i] = "free";
        }

        String dataPath = "data\\" + date.getYear() + "\\" + date.getMonth() + "\\" + date.getDay() + ".txt";


        File file = new File(dataPath);
        try {
            Scanner sc = new Scanner(file);
            if(!sc.hasNext()){
                return out;
            }else{
                boolean a = true;
                while(a){
                    String person = sc.next();
                    int from = sc.nextInt();
                    int to = sc.nextInt();
                    int from_h = from / 100;
                    int from_m = from % 100;
                    int to_h = to / 100;
                    int to_m = to % 100;
                    int fromData = from_h * 4 + from_m / 15;
                    int toData = to_h * 4 + to_m / 15;
                    for(int i = fromData; i < toData; i++){
                        out[i] = person;
                    }
                    if(!sc.hasNext()){
                        a = false;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }




        return out;
    }
}
