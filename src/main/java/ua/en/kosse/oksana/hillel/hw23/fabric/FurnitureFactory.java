package ua.en.kosse.oksana.hillel.hw23.fabric;

import ua.en.kosse.oksana.hillel.hw23.fabric.itemFurniture.ChairFurniture;
import ua.en.kosse.oksana.hillel.hw23.fabric.itemFurniture.Furniture;
import ua.en.kosse.oksana.hillel.hw23.fabric.itemFurniture.SofaFurniture;
import ua.en.kosse.oksana.hillel.hw23.fabric.itemFurniture.TableFurniture;

public class FurnitureFactory {
    public Furniture getDoughnut(FurnitureTypes type) {
        Furniture toReturn = null;
        switch (type) {
            case TABLE:
                toReturn = new TableFurniture();
                break;
            case CHAIR:
                toReturn = new ChairFurniture();
                break;
            case SOFA:
                toReturn = new SofaFurniture();
                break;
            default:
                throw new IllegalArgumentException("Wrong furniture type:" + type);
        }
        return toReturn;
    }
}
