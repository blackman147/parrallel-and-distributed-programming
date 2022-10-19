package lab04;

public class Platform {
    public static void main(String[] args) {
        ViewingStand museum = new ViewingStand(20);

        int visitorsAmount = 30;
        Visitor[]  visitors = new Visitor[visitorsAmount];

        for (int i = 0; i < visitors.length; i++) {
            visitors[i] = new Visitor(museum, i);
        }
        for (int i = 0; i < visitors.length; i++) {
            visitors[i].start();

        }
    }
}
