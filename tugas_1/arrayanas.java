import java.util.Scanner;

public class arrayanas {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int[][] nomer = new int[3][3];

        for(int i = 0; i < nomer.length; i++){
            System.out.println("masukan elemen untuk bilangan ke-" + (i + 1) + ": ");
            for(int j = 0; j < nomer[i].length; j++){
                System.out.print("Elemen " + "[" + i + "]" + "[" + j + "]" + ": ");
                nomer[i][j] = input.nextInt();
            }
        }

        for(int i = 0; i < nomer.length; i++){
            for(int j = 0; j < nomer[i].length; j++){
                System.out.print(nomer[i][j] + " ");
            }
            System.out.println();
        }

        int[][] transpose = new int[3][3];

        System.out.println("matriks transposenya : ");
        for(int i = 0; i < transpose.length; i++){
            for(int j = 0; j < transpose[i].length; j++){
                transpose[i][j] = nomer[j][i];
            }
        }

        for(int i = 0; i < transpose.length; i++){
            for(int j = 0; j < transpose[i].length; j++){
                System.out.print(transpose[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("hasilnya penjumlahannya : ");
        int[][] tambah = new int[3][3];
        for(int i = 0; i < tambah.length; i++){
            for(int j = 0; j < tambah[i].length; j++){
                tambah[i][j] = transpose[i][j] + nomer[i][j];
                System.out.print(tambah[i][j] + " ");
            }
            System.out.println();
        }
    }
}
