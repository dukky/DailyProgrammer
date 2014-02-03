/*******************************************************************************
 * Copyright 2014 Andreas Holley
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package intermediate140;

import java.util.Scanner;

/**
 * A class to solve /r/dailyprogrammer intermediate #140
 * http://www.reddit.com/r/dailyprogrammer/comments/1tiz4z/
 * 122313_challenge_140_intermediate_graph_radius/
 * 
 * Short description: Create a program to calculate the radius of a graph given
 * an adjacency matrix.
 * 
 * I used the Floyd-Warshall algorithm.
 * 
 * @author Andreas
 * 
 */
public class GraphRadius {
	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {

			System.out.println("Enter the dimensions of the matrix, followed by the matrix:");
			int dimension = s.nextInt();
			s.nextLine();

			int[][] matrix = new int[dimension][dimension];
			for (int i = 0; i < dimension; ++i) {
				for (int j = 0; j < dimension; ++j) {
					matrix[i][j] = s.nextInt();
				}
				s.nextLine();
			}
			floyd(dimension, matrix);
			int max = 0;
			for (int[] arr : matrix) {
				for (int i : arr) {
					if (i > max) {
						max = i;
					}
				}
			}
			System.out.println(max);
			new GraphRadius()
		}
	}

	private static void floyd(int n, int[][] matrix) {

		for (int s = 0; s < n; s++) {
			for (int z = 0; z < n; z++) {
				if (matrix[s][z] == 0 && s != z) {
					matrix[s][z] = Integer.MAX_VALUE / 2;
				}
			}
		}

		for (int u = 0; u < n; u++) {
			for (int s = 0; s < n; s++) {
				for (int z = 0; z < n; z++) {
					if (matrix[s][u] + matrix[u][z] < matrix[s][z]) {
						matrix[s][z] = matrix[s][u] + matrix[u][z];
					}
				}
			}
		}

	}
}
