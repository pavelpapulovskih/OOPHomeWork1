// Интерфейс VendingMachine
interface VendingMachine {
    void getProduct(int name, int volume);
    void getProduct(int name, int volume, int temperature);
}

// Класс Горячих напитков
class HotDrink {
    private String name;
    private int volume;

    public HotDrink(String name, int volume) {
        this.name = name;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }
}

// Наследник класса Горячих напитков
class HotDrinkWithTemperature extends HotDrink {
    private int temperature;

    public HotDrinkWithTemperature(String name, int volume, int temperature) {
        super(name, volume);
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }
}

// Класс Автомат горячих напитков
class HotDrinksVendingMachine implements VendingMachine {
    private HotDrink[] hotDrinks;

    public HotDrinksVendingMachine(HotDrink[] hotDrinks) {
        this.hotDrinks = hotDrinks;
    }

    public void getProduct(String string, int volume) {
        for (HotDrink hotDrink : hotDrinks) {
            if (hotDrink.getName().equals(string) && hotDrink.getVolume() == volume) {
                System.out.println("Выдан продукт: " + 
                hotDrink.getName() + 
                ", объем: " + 
                hotDrink.getVolume() + "мл");
                return;
            }
        }
        System.out.println("Продукт не найден");
    }

    public void getProduct(int name, int volume, int temperature) {
        for (HotDrink hotDrink : hotDrinks) {
            if (hotDrink instanceof HotDrinkWithTemperature) {
                HotDrinkWithTemperature hotDrinkWithTemperature = (HotDrinkWithTemperature) hotDrink;
                if (hotDrinkWithTemperature.getName().equals(name) && hotDrinkWithTemperature.getVolume() == volume && hotDrinkWithTemperature.getTemperature() == temperature) {
                    System.out.println("Выдан продукт: " + hotDrinkWithTemperature.getName() + ", объем: " + hotDrinkWithTemperature.getVolume() + "мл, температура: " + hotDrinkWithTemperature.getTemperature() + "C");
                    return;
                }
            }
        }
        System.out.println("Продукт не найден");
    }

    @Override
    public void getProduct(int name, int volume) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProduct'");
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаем несколько Горячих напитков
        HotDrink hotDrink1 = new HotDrink("Чай", 200);
        HotDrink hotDrink2 = new HotDrinkWithTemperature("Кофе", 150, 80);
        HotDrink hotDrink3 = new HotDrinkWithTemperature("Какао", 300, 60);

        // Создаем Автомат горячих напитков
        HotDrink[] hotDrinks = {hotDrink1, hotDrink2, hotDrink3};
        HotDrinksVendingMachine vendingMachine = new HotDrinksVendingMachine(hotDrinks);

        // Логика методов
        vendingMachine.getProduct("Кофе", 150);
        vendingMachine.getProduct("Чай", 200);
        vendingMachine.getProduct("Какао", 300);
    }
}
