package Divide_and_conquer;

import java.util.Scanner;

public class B10830 {
    static int N;
    static int[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 행렬의 크기 N과 지수 B 입력 받기
        N = scanner.nextInt();
        long B = scanner.nextLong();

        matrix = new int[N][N];

        // 행렬 요소 입력 받기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = scanner.nextInt() % 1000; // 1000으로 먼저 나눠줌
            }
        }

        // 분할 정복으로 행렬 제곱 계산
        int[][] result = matrixPower(matrix, B);

        // 결과 출력
        for (int[] row : result) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

    // 행렬의 거듭제곱을 분할 정복으로 계산하는 함수
    public static int[][] matrixPower(int[][] base, long exp) {
        // 지수가 1인 경우, 원래 행렬을 반환
        if (exp == 1) {
            return base;
        }

        // 지수가 짝수인 경우
        if (exp % 2 == 0) {
            int[][] halfPower = matrixPower(base, exp / 2);
            return matrixMultiply(halfPower, halfPower);
        } else {
            // 지수가 홀수인 경우
            return matrixMultiply(matrixPower(base, exp - 1), base);
        }
    }

    // 두 행렬을 곱하고, 각 원소를 1000으로 나눈 나머지 값을 반환하는 함수
    public static int[][] matrixMultiply(int[][] a, int[][] b) {
        int[][] result = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    result[i][j] = (result[i][j] + a[i][k] * b[k][j]) % 1000;
                }
            }
        }

        return result;
    }
}
