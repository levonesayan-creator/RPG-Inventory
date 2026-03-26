import java.util.ArrayList;

abstract class Bag {

    String name;
    int capacity;
    boolean isOpen;
    ArrayList<Item> items = new ArrayList<>();

    public Bag(String n, int c) {
        name = n;
        capacity = c;
        isOpen = false;
    }

    public void openBag() {
        isOpen = true;
        System.out.println("open");
    }

    public void closeBag() {
        isOpen = false;
        System.out.println("close");
    }

    public void addItem(Item i) {
        if (isOpen && items.size() < capacity) {
            items.add(i);
            System.out.println("added " + i.name);
        } else {
            System.out.println("cant add");
        }
    }

    public void search(String n) {
        for (Item i : items) {
            if (i.name.equals(n)) {
                System.out.println("found");
                return;
            }
        }
        System.out.println("not found");
    }
}

class MainContainer extends Bag {
    public MainContainer() {
        super("main", 10);
    }
}

class SmallBag extends Bag {
    public SmallBag() {
        super("small", 5);
    }
}

class MediumBag extends Bag {
    public MediumBag() {
        super("medium", 8);
    }
}

class LargeBag extends Bag {
    public LargeBag() {
        super("large", 15);
    }
}