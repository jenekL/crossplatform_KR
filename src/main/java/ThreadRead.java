import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ThreadRead implements Runnable{
    final Thread t;

    private String direction;

    private Scanner sc;

    private Sender sender;


    public ThreadRead(String direction) {
        this.direction = direction;

        sender = new Sender("localhost", 1050);

        t = new Thread(this, "Read thread");
        System.out.println("Daughter thread created " + t);
        try {
            sc = new Scanner(new File(direction));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        t.start();
    }

    @Override
    public void run() {
        assert sc != null;
        //synchronized (t) {
                while (sc.hasNext()) {
                    String line = sc.nextLine();
                    System.out.println(line);
                    sender.sendMessage(line);
                }
        //}
        System.out.println("read end " + direction);
    }
}
