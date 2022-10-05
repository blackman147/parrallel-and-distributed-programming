import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter a message :");
        Scanner sc = new Scanner(System.in);
        MessagePrinter mp = new MessagePrinter(sc.next());
        Thread messagePrinterThread = new Thread(mp);
        messagePrinterThread.start();
        String readEnter = "";
       while (messagePrinterThread.isAlive()) {
           if (!readEnter.isEmpty()) {
               try {
                   messagePrinterThread.stop();
               } catch (Error e) {
                   System.out.println("Error Interrupted");
               }
           }else{
               readEnter = sc.nextLine();
               System.out.println("Write 1 to stop");
           }
       }
    }
}