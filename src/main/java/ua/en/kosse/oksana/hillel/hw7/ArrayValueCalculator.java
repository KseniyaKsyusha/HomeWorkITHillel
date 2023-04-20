package ua.en.kosse.oksana.hillel.hw7;

import org.apache.commons.lang3.RandomStringUtils;
import ua.en.kosse.oksana.hillel.hw7.exception.ArrayDataException;
import ua.en.kosse.oksana.hillel.hw7.exception.ArraySizeException;

import java.util.Arrays;

public class ArrayValueCalculator {

    public String[][] matrixInput(int matrixSize, int param) {
        String[][] matrix = new String[matrixSize][matrixSize];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                switch (param) {
                    case 1 -> // матриця букви та цифри randomAlphanumeric(1- число символів , наприклад "7",
                            // якщо 2 -> "к6", 3 ->"0р5" )
                            matrix[i][j] = RandomStringUtils.randomAlphanumeric(1);
                    case 2 -> // цифри randomNumeric(1, 3) від однозначних до тризначних цифр
                            matrix[i][j] = RandomStringUtils.randomNumeric(1, 3);
                }
            }
        }
        return matrix;
    }

    public int doCalc(String[][] matrix) throws ArrayDataException, ArraySizeException {
        int summaElem = 0;
        int elem;
        //for (String[] elemI : matrix) {
        //    for (String elemJ : elemI) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix.length != 4 || matrix[i].length != 4) //перевірка на кудлаті матриці
                    throw new ArraySizeException("The size of the matrix should be 4x4, and its size "
                            + matrix.length + "x" + matrix[i].length, matrix.length);
                try {
                    elem = Integer.parseInt(matrix[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("Incorrect data in the matrix["
                            + i + "][" + j + "] = " + matrix[i][j]);
                }

            /* try {
                    elem = Integer.parseInt(elemJ);
                } catch (NumberFormatException e) {
                    System.err.println("Wrong string format!");
                }*/
                summaElem += elem;
            }
        }
        return summaElem;
    }

    public void matrixOutput(String[][] matrix) {
        for (String[] strings : matrix) {
            System.out.println(Arrays.toString(strings));
        }
    }
}
