package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num_meeting = Integer.parseInt(br.readLine());

        int[][] meeting_time = new int[num_meeting][2];
        for (int i=0; i<num_meeting; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meeting_time[i][0] = Integer.parseInt(st.nextToken());
            meeting_time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meeting_time, (a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int count = 0;
        int lastEndTime = 0;

        for (int i = 0; i < num_meeting; i++) {
            if (meeting_time[i][0] >= lastEndTime) {
                lastEndTime = meeting_time[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
