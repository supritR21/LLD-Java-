import java.util.ArrayList;
import java.util.List;

abstract class RegularOrders {
    public abstract void printOrder();
}

class Meals extends RegularOrders {
    public String name = "Meals";
    public int price = 950;
    @Override 
    public void printOrder() {
        System.out.printf("%-15s %10s %n", name, price);
    }
}

class Beverages extends RegularOrders {
    public String name = "Beverages";
    public int price = 200;
    @Override 
    public void printOrder() {
        System.out.printf("%-15s %10s %n", name, price);
    }
}

class Desserts extends RegularOrders {
    public String name = "Desserts";
    public int price = 150;
    @Override 
    public void printOrder() {
        System.out.printf("%-15s %10s %n", name, price);
    }
}

class Salads extends RegularOrders {
    public String name = "Salads";
    public int price = 100;
    @Override 
    public void printOrder() {
        System.out.printf("%-15s %10s %n", name, price);
    }
}

abstract class Combos {
    protected List<RegularOrders> regularOrders = new ArrayList<>();
    public Combos() {
        comboDetails();
    }
    protected abstract void comboDetails();
    public void printOrder() {
        System.out.printf("%-15s %10s %n","Type", "Price");
        for(int i=0; i<regularOrders.size(); i++) {
            regularOrders.get(i).printOrder();
        }
        System.out.println("______________________ \n");
    }
}

class LiteCombo extends Combos {
    @Override 
    protected void comboDetails() {
        regularOrders.add(new Meals());
        regularOrders.add(new Beverages());
    }
}

class FamilyCombo extends Combos {
    @Override 
    protected void comboDetails() {
        regularOrders.add(new Meals());
        regularOrders.add(new Beverages());
        regularOrders.add(new Desserts());
    } 
}

class MegaCombo extends Combos {
    @Override 
    protected void comboDetails() {
        regularOrders.add(new Meals());
        regularOrders.add(new Beverages());
        regularOrders.add(new Desserts());
        regularOrders.add(new Salads());
    } 
}

class ComboCreator {
    public static Combos createCombos(ComboCode comboCode) {
        switch(comboCode) {
            case LITE:
                System.out.println("Selected Combo: LiteCombo \n");
                return new LiteCombo();
            case FAMILY:
                System.out.println("Selected Combo: FamilyCombo \n");
                return new FamilyCombo();
            case MEGA:
                System.out.println("Selected Combo: MegaCombo \n");
                return new MegaCombo();
            default:
                return null;
        }
    }
}

enum ComboCode {
    LITE,FAMILY,MEGA
}

public class FDP {
    public static void main(String[] args) {
        Combos combos1 = ComboCreator.createCombos(ComboCode.LITE);
        combos1.printOrder();
        Combos combos2 = ComboCreator.createCombos(ComboCode.FAMILY);
        combos2.printOrder();
        Combos combos3 = ComboCreator.createCombos(ComboCode.MEGA);
        combos3.printOrder();
    }
}
