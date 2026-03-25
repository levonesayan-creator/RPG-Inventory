import java.util.ArrayList;

abstract class Bag {
    String name;
    int capacity;
    boolean isOpen;
    ArrayList<Item> items = new ArrayList<>();

    public Bag(String n, int c) {
        name = n;
        capacity = c;
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
    public MainContainer() { super("main", 10); }
}

class SmallBag extends Bag {
    public SmallBag() { super("small", 5); }
}

class MediumBag extends Bag {
    public MediumBag() { super("medium", 8); }
}

class LargeBag extends Bag {
    public LargeBag() { super("large", 15); }
}

abstract class Item {
    String name;

    public Item(String n) {
        name = n;
    }

    public void drop() {
        System.out.println("drop " + name);
    }

    public abstract void use();
}

class Weapon extends Item {
    int damage;

    public Weapon(String n, int d) {
        super(n);
        damage = d;
    }

    public void use() {
        System.out.println("attack " + damage);
    }
}

class Consumable extends Item {
    int effect;

    public Consumable(String n, int e) {
        super(n);
        effect = e;
    }

    public void use() {
        System.out.println("heal " + effect);
    }
}

class Projectile extends Item {
    int qty;

    public Projectile(String n, int q) {
        super(n);
        qty = q;
    }

    public void use() {
        qty--;
        System.out.println("left " + qty);
    }
}

class KeyItem extends Item {
    public KeyItem(String n) {
        super(n);
    }

    public void use() {
        System.out.println("cant use");
    }
}

public class Main {
    public static void main(String[] args) {

        Bag bag = new MainContainer();

        Item sword = new Weapon("sword", 10);
        Item potion = new Consumable("potion", 5);

        bag.openBag();
        bag.addItem(sword);
        bag.addItem(potion);

        bag.search("sword");

        sword.use();
        potion.use();

        bag.closeBag();
    }
}