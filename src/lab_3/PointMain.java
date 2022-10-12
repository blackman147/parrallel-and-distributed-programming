package lab_3;

public class PointMain {
    public static void main(String[] args) {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(4, 5);
        Point p3 = new Point(3, 6);
        Point p4 = new Point(5, 9);

        CollectionPoint cp = new CollectionPoint();
        cp.add(p1);
        cp.add(p2);
        cp.add(p3);
        cp.add(p4);



       Thread thread1 = new Thread() {
           public void run() {
               cp.add(new Point(10, 11));
               System.out.println(cp + " " + getName());
           }
       };

       Thread thread2 = new Thread() {
           public void run() {
               cp.replace(p1, p2);
               System.out.println(cp + " " + getName());
           }
       };

       Thread thread3 = new Thread() {
           public void run() {
               cp.search(p1);
               System.out.println(cp + " " + getName());
           }
       };

       thread1.start();
       thread2.start();
       thread3.start();
    }
}
