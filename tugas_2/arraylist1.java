import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


public class arraylist1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Input jumlah baris: ");
        int rows = input.nextInt();
        System.out.print("Input jumlah kolom: ");
        int cols = input.nextInt();

        // Membuat matriks asli
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        System.out.println("Input nilai matriks:");

        for (int i = 0; i < rows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                System.out.print("Input nilai " + (i+1) + "," + (j+1) + " = ");
                row.add(input.nextInt());
            }
            matrix.add(row);
        }

        // Menampilkan matriks asli
        System.out.println("Matriks asli:");
        printMatrix(matrix);

        // Menghitung transpose matriks
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for (int i = 0; i < cols; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < rows; j++) {
                row.add(matrix.get(j).get(i));
            }
            transpose.add(row);
        }

        // Menampilkan matriks transpose
        System.out.println("Matriks transpose:");
        printMatrix(transpose);

        // Menjumlahkan matriks asli dengan transpose-nya
        ArrayList<ArrayList<Integer>> sumMatrix = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add(matrix.get(i).get(j) + transpose.get(i).get(j));
            }
            sumMatrix.add(row);
        }

        // Menampilkan hasil penjumlahan
        System.out.println("Hasil penjumlahan matriks asli dengan transpose-nya:");
        printMatrix(sumMatrix);
    }

    // Fungsi untuk menampilkan matriks
    public static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (ArrayList<Integer> row : matrix) {
            for (Integer val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();

        }
    }
}
