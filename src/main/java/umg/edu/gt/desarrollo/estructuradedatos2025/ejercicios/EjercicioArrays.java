package umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios;

import java.util.Arrays;

public class EjercicioArrays {

	// Ejercicio 1: Encuentra la riqueza del cliente más rico
	public static int RiquezaMaxima(int[][] cuentas) {
		int maxRiqueza = 0;
		for (int[] cliente : cuentas) {
			int RiquezaCliente = Arrays.stream(cliente).sum();
			maxRiqueza = Math.max(maxRiqueza, RiquezaCliente);
		}
		return maxRiqueza;
	}

	// Ejercicio 2: Ordenar diagonales de la matriz
	public static int[][] OrdenarDiagonales(int[][] mat) {
		int m = mat.length, n = mat[0].length;

		// Ordenar diagonales que empiezan en la primera columna
		for (int i = 0; i < m; i++) {
			OrdenarDiagonal(mat, i, 0);
		}
		// Ordenar diagonales que empiezan en la primera fila (excepto la primera columna)
		for (int j = 1; j < n; j++) {
			OrdenarDiagonal(mat, 0, j);
		}

		return mat;
	}

	private static void OrdenarDiagonal(int[][] mat, int row, int col) {
		int m = mat.length, n = mat[0].length;
		int i = row, j = col;
		int[] diagonal = new int[Math.min(m - row, n - col)];
		int index = 0;

		// Extraer valores de la diagonal
		while (i < m && j < n) {
			diagonal[index++] = mat[i++][j++];
		}
		Arrays.sort(diagonal);

		// Insertar valores ordenados
		i = row;
		j = col;
		index = 0;
		while (i < m && j < n) {
			mat[i++][j++] = diagonal[index++];
		}
	}

	// Ejercicio 3: Sumar todos los elementos de una matriz
	public static int SumarMatrizes(int[][] mat) {
		return Arrays.stream(mat).flatMapToInt(Arrays::stream).sum();
	}
}
