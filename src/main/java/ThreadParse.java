import Objects.Bed;
import Objects.Furniture;
import Objects.Sofa;

import java.util.ArrayList;

public class ThreadParse implements Runnable{
    final Thread t;
    private ArrayList<Furniture> furnitureArrayList;
   // public static MyEventProducer eventProducer = new MyEventProducer();

    public ThreadParse(ArrayList<Furniture> furnitureArrayList) {
        this.furnitureArrayList = furnitureArrayList;
        t = new Thread(this, "Parse thread");
        System.out.println("Daughter thread created " + t);
        t.start();
    }

    public void showAll(){
        for(Furniture f: furnitureArrayList){
            System.out.println(f.toString());
        }
    }

    private synchronized void parse(String line){
        try {
            String[] furnitureData = line.split(";");
                Checker.checkString(furnitureData[0]);
                Checker.checkString(furnitureData[1]);
                Checker.checkString(furnitureData[4]);

                if (furnitureData[0].equals("Bed")) {
                    furnitureArrayList.add(new Bed(Integer.parseInt(furnitureData[2]), furnitureData[1],
                            Integer.parseInt(furnitureData[3]), furnitureData[4]));
                } else if (furnitureData[0].equals("Sofa")) {
                    furnitureArrayList.add(new Sofa(Integer.parseInt(furnitureData[2]), furnitureData[1],
                            Integer.parseInt(furnitureData[3]), furnitureData[4]));
                }
                System.out.println(furnitureArrayList.get(furnitureArrayList.size() - 1).toString());
            System.out.println(furnitureArrayList.size());
        } catch(Exception e){
           //e.printStackTrace();
        }
    }

    @Override
    public void run() {
//        eventProducer.addMyListener(new MyListener() {
//                @Override
//                public void myHappend(MyEvent myEvent) {
//                    String line = EntryQueue.getFirst();
//                    parse(line);
//                }
//            });


    }

}
