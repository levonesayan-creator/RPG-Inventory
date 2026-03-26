public class Main {
    public static void main(String[] args) {

        Bag bag = new MainContainer();

        Item sword = new Weapon("sword", true, 10);
        Item potion = new Consumable("potion", true, 5);

        bag.openBag();
        bag.addItem(sword);
        bag.addItem(potion);

        bag.search("sword");

        sword.use();
        potion.use();

        bag.closeBag();
    }
}