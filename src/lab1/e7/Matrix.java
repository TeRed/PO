package lab1.e7;

import java.util.Scanner;

public class Matrix {
    public Matrix(int a, int b) {
        this.a = a;
        this.b = b;

        matrix = new int[a][b];

        System.out.println("No Podaj!");
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < a; i++)
            for(int j = 0; j < b; j++){
                matrix[i][j] = s.nextInt();
            }
    }
    public Matrix(int a, int b, int fill) {
        this.a = a;
        this.b = b;

        matrix = new int[a][b];

        for (int i = 0; i < a; i++)
            for(int j = 0; j < b; j++){
                matrix[i][j] = fill;
            }
    }

    public Matrix add(Matrix m) {
        if(m.a == this.a && m.b == this.b);
        Matrix result = new Matrix(this.a, this.b, 0);

        for (int i = 0; i < a; i++)
            for(int j = 0; j < b; j++){
                result.matrix[i][j] = matrix[i][j] + m.matrix[i][j];
            }
        return result;
    }

    public Matrix sub(Matrix m) {
        if(m.a == this.a && m.b == this.b);
        Matrix result = new Matrix(this.a, this.b, 0);

        for (int i = 0; i < a; i++)
            for(int j = 0; j < b; j++){
                result.matrix[i][j] = matrix[i][j] - m.matrix[i][j];
            }
        return result;
    }

    public Matrix mul(Matrix m) {
        if(m.a == this.b);
        Matrix result = new Matrix(this.a, m.b, 0);

        for (int i = 0; i < a; i++)
            for(int j = 0; j < m.b; j++)
                for(int k = 0; k < this.b; k++) {
                    result.matrix[i][j] += matrix[i][k]*m.matrix[k][j];
                }

        return result;
    }

    @Override
    public String toString() {
        String Array = new String();
        for(int i = 0; i < a; i++)
            for(int j = 0; j < b; j++){
                Array += "( " + matrix[i][j] + " )";
            }
        return "Matrix{" +
                "a=" + a +
                ", b=" + b +
                ", e7=" + Array +
                '}';
    }

    private int a, b;
    private int [][] matrix;



}
