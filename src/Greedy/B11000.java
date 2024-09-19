package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num_class = Integer.parseInt(br.readLine());

        int[][] class_time = new int[num_class][2];

        for (int i=0; i<num_class; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            class_time[i][0] = Integer.parseInt(st.nextToken());
            class_time[i][1] = Integer.parseInt(st.nextToken());
        }



    }
}
