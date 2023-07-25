package ua.en.kosse.oksana.hillel.hw23.fabric;

import ua.en.kosse.oksana.hillel.hw23.fabric.itemFurniture.Furniture;

import java.util.Random;

public class HomeWorkFabric {
    public static void main(String[] args) {
        FurnitureFactory factory = new FurnitureFactory();

        Furniture table = factory.getFurniture(FurnitureTypes.TABLE);
        Furniture chair = factory.getFurniture(FurnitureTypes.CHAIR);
        Furniture sofa  = factory.getFurniture(FurnitureTypes.SOFA);

        table.doFurniture();
        chair.doFurniture();
        sofa.doFurniture();

        for(int i = 0; i < 10; i++) {
            doRandomFurniture(factory);
        }



    }
    public static void doRandomFurniture(FurnitureFactory factory) {
        Furniture randomFurniture = getRandomFurniture(factory);
        System.out.printf("What a surprise! ");
        randomFurniture.doFurniture();
    }

    public static Furniture getRandomFurniture(FurnitureFactory factory){
        Random random = new Random();
        FurnitureTypes type = FurnitureTypes.values()[random.nextInt(FurnitureTypes.values().length)];

        return(factory.getFurniture(type));
    }
}
