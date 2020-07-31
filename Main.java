/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Cdll list = new Cdll();
        list.addNode(750);
        list.addNode(40);
        list.addNode(900);
        list.addNode(240);
        list.addNode(107);

        list.sort();

        list.printList();

        System.out.println();
        
        list.printreverse();

        
    }
}