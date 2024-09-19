package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2285 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num_village = Integer.parseInt(br.readLine());

        int[][] town = new int[num_village+1][2];
        int totalPopulation = 0;

        for (int i = 1; i<num_village+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            town[i][0] = Integer.parseInt(st.nextToken());
            town[i][1] = Integer.parseInt(st.nextToken());
            totalPopulation += town[i][1];
        }

        long populationSum = 0;
        for (int i = 1; i<num_village+1; i++) {
            populationSum += town[i][1];
            if (populationSum >= (totalPopulation + 1)/2) {
                System.out.println(town[i][0]);
                break;
            }
        }

    }
}
