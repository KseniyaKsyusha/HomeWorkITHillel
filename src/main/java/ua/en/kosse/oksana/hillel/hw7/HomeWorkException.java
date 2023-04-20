package ua.en.kosse.oksana.hillel.hw7;

import ua.en.kosse.oksana.hillel.hw5.color.RandomNumber;
import ua.en.kosse.oksana.hillel.hw7.exception.ArrayDataException;
import ua.en.kosse.oksana.hillel.hw7.exception.ArraySizeException;

public class HomeWorkException {
    public static void main(String[] args) throws ArrayDataException, ArraySizeException {
        final int matrixSize = new RandomNumber().getRandomNumberInt(2, 5);

//      2. Створити метод doCalc. На вхід до методу подається двомірний рядковий масив розміром 4х4.
//      3. При передачі масиву іншого розміру в метод doCalc необхідно викинути виняток ArraySizeException.

        // цифрова матриця 4x4
        String[][] matrixNum = new ArrayValueCalculator().matrixInput(4, 2);
        new ArrayValueCalculator().matrixOutput(matrixNum);
        try {
            System.out.printf("Sum of all matrix elements summaElem = %s\n", new ArrayValueCalculator().doCalc(matrixNum));
        } catch (ArraySizeException | ArrayDataException ex) {
            System.out.println(ex.getMessage());
        }

        // рандомний розмір цифрової матриці
        String[][] matrixNum1 = new ArrayValueCalculator().matrixInput(matrixSize, 2);
        new ArrayValueCalculator().matrixOutput(matrixNum1);
        System.out.printf("Sum of all matrix elements summaElem = %s\n", new ArrayValueCalculator().doCalc(matrixNum1));



        // рандомний розмір символьної матриці
        String[][] matrixAlfNum1 = new ArrayValueCalculator().matrixInput(matrixSize, 1);
        new ArrayValueCalculator().matrixOutput(matrixAlfNum1);
        System.out.printf("Summa of all matrix elements summaElem = %s\n", new ArrayValueCalculator().doCalc(matrixAlfNum1));

        // символьна матриця  4x4
        String[][] matrixAlfNum = new ArrayValueCalculator().matrixInput(4, 1);
        new ArrayValueCalculator().matrixOutput(matrixAlfNum);
        try {
            System.out.printf("Summa of all matrix elements summaElem = %s\n", new ArrayValueCalculator().doCalc(matrixAlfNum));
        }catch (ArraySizeException | ArrayDataException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
