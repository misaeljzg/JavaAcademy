package mx.com.gm.challengearrays;

import java.util.Arrays;

public class ArraysHomework {
    public static void main(String[] args) {
        matrixToOnes(5);
        spiralMatrix(4);
    }
    
    private static void matrixToOnes(int size) {
        int size1 = size;
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || i == size -1 || j==i ) {
                    matrix[i][j] = 1;                    
                }
            }
            matrix[i][--size1] = 1;
        }
        printMatrix(matrix);
    }
    
     /*Note : Won't work with other sizes */
    private static void spiralMatrix(int size) {
        int[][] spiralMatrix = new int[size][size];
        int counter = 0;
        int row = 0, column = 0;
        while (column < size) { //go right            
            spiralMatrix[row][column++] = ++counter;                    
        }
        row++;
        column--;
        while (row < size) {  //go down
            spiralMatrix[row++][column] = ++counter;  
        }
        row--;
        column--;
        while (column >= 0) { //go left     
            spiralMatrix[row][column--] = ++counter;  
        }
        column++;
        row--;
        while (row > 0) { //go up      
            spiralMatrix[row--][column] = ++counter;   
        }
        row++;
        column++;
        while (column < size -1) { //go right            
            spiralMatrix[row][column++] = ++counter;   
        }
        row++;
        while (column >= size - column) { //go down        
            spiralMatrix[row][--column] = ++counter;   
        }
        printMatrix(spiralMatrix);
    }
    
    private static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print("\t" + (matrix[i][j]));
            }
            System.out.print("\n");
        }
    }
}
