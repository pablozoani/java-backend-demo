package com.pablozoani.designpattern.z_trash.models.store;

public class Main {

    private static final Store store = new Store();

    public static void main(String[] args) {

        Product roastBeef = ProductImpl
            .builder()
            .stock(10)
            .description("A dish of roasted beef")
            .price(4.8)
            .build();

        Shelf meat = new Shelf();

        meat.add(roastBeef);

        Product tomato = ProductImpl
            .builder()
            .stock(5)
            .description("Common garden tomatoes")
            .price(0.5)
            .build();

        Product onion = ProductImpl
            .builder()
            .stock(23)
            .description("Common garden onions")
            .price(0.4)
            .build();

        Shelf veggie = new Shelf();

        veggie.add(tomato);

        veggie.add(onion);

        Product spaghetti = ProductImpl
            .builder()
            .stock(30)
            .description("Traditional spaghetti")
            .price(1.3)
            .build();

        Shelf pasta = new Shelf();

        pasta.add(spaghetti);

        Aisle food = new Aisle();

        food.put("meat", meat);

        food.put("veggie", veggie);

        food.put("pasta", pasta);

        Product elegantShoes = ProductImpl
            .builder()
            .stock(6)
            .description("High quality shoes")
            .price(10)
            .build();

        Shelf shoes = new Shelf();

        shoes.add(elegantShoes);

        Product workPants = ProductImpl
            .builder()
            .stock(3)
            .description("Strong worker pants")
            .price(4.3)
            .build();

        Shelf pants = new Shelf();

        pants.add(workPants);

        Aisle cloth = new Aisle();

        cloth.put("shoes", shoes);

        cloth.put("pants", pants);

        Product indoorBroom = ProductImpl
            .builder()
            .stock(14)
            .description("Ideal for all types of floor")
            .price(1.1)
            .build();

        Shelf broom = new Shelf();

        broom.add(indoorBroom);

        Product concentratedBleach = ProductImpl
            .builder()
            .stock(53)
            .description("Highly concentrated bleach")
            .price(2.6)
            .build();

        Shelf bleach = new Shelf();

        bleach.add(concentratedBleach);

        Aisle cleaning = new Aisle();

        cleaning.put("broom", broom);

        cleaning.put("bleach", bleach);

        store.put("food", food);

        store.put("cloth", cloth);

        store.put("cleaning", cleaning);

        System.out.println(store);

        if (!tomato.addStock(10))
            throw new IllegalArgumentException("Stock mus't be a positive integer!");

        if (!indoorBroom.addStock(5))
            throw new IllegalArgumentException("Stock mus't be a positive integer!");

        if (!roastBeef.sell())
            System.out.println("Not enough stock!");

        if (!concentratedBleach.sell(20))
            System.out.println("Not enough stock!");

        if (!elegantShoes.sell(7))
            System.out.println("Not enough stock!");
    }
}
