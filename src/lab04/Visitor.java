package lab04;

public class Visitor extends Thread{
    private int number;
    private ViewingStand museum;

    public Visitor(ViewingStand museum, int number) {
        this.museum = museum;
        this.number = number;
    }


    public void run(){
        museum.findSeat(number);

        System.out.println("Visitor "+ number+" entered");
        try{
            int t = (int)(Math.random()*10000);
            Thread.sleep(t);
        }catch(InterruptedException e){}
        museum.leaveSeat(number);
        System.out.println("Visitor "+ number+" left");
    }


}

