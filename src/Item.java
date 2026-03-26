abstract class Item {

    String name;
    boolean usable;

    public Item(String n, boolean u) {
        name = n;
        usable = u;
    }

    public void displayStats() {
        System.out.println(name);
    }

    public void drop() {
        System.out.println("drop " + name);
    }

    public abstract void use();
}

class Weapon extends Item {
    int damage;

    public Weapon(String n, boolean u, int d) {
        super(n, u);
        damage = d;
    }

    public void use() {
        System.out.println("attack " + damage);
    }
}

class Consumable extends Item {
    int effect;

    public Consumable(String n, boolean u, int e) {
        super(n, u);
        effect = e;
    }

    public void use() {
        System.out.println("heal " + effect);
    }
}

class Projectile extends Item {
    int qty;

    public Projectile(String n, boolean u, int q) {
        super(n, u);
        qty = q;
    }

    public void use() {
        if (qty > 0) {
            qty--;
            System.out.println("left " + qty);
        }
    }
}

class KeyItem extends Item {
    public KeyItem(String n, boolean u) {
        super(n, u);
    }

    public void use() {
        System.out.println("cant use");
    }
}