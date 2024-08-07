package com.example.algorithm.프로그래머스.힙;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'getMaxBeauty' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static long getMaxBeauty(List<Integer> arr) {
        // Write your code here
        int[] psum = new int[arr.size()];
        for(int i = 1; i<= arr.size(); i++){
            int sum = 0;
            for(int j = i-1; j < i; j++){
                sum += arr.get(j);
            }
            psum[i-1] = sum;
        }
        long answer = 0;
        for(int i = 0; i < psum.length; i++){
            int num = psum[i];
            if(psum[i]%2 == 0){
                answer += num;
            } else {
                answer -= num;
            }
        }
        return answer;


    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        long result = Result.getMaxBeauty(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
