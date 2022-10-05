public class MessagePrinter extends Thread{
    private String message;
    public MessagePrinter(String message){
        this.message = message;
    }

    @Override
    public void run() {
        while(true){
            try{
                sleep(1000);
                System.out.println(message);
            }catch (InterruptedException e){}
        }
    }
}
