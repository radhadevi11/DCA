package com.radha.dca;
import java.util.*;
import java.util.stream.*;

public class NumberWithFrequency {
    /*
    convert array to map with its frequency
    sort based on frequency
    then sort based on value
    print the value frequency times
     */

    public HashMap<Integer, Integer> convertToMap(int[] arr) {
        HashMap<Integer, Integer> numberWithFrequency = new HashMap<>();
        for (int num : arr) {
            if(numberWithFrequency.putIfAbsent(num,1) != null) {
                numberWithFrequency.replace(num, numberWithFrequency.get(num)+1);
            }
        }
        return numberWithFrequency;
    }
public void printNumberWithHighestFrequency(int[] arr) {

    Map<Integer, Integer> collect = convertToMap(arr);

    List<Map.Entry<Integer,Integer>> entries= new ArrayList<>(collect.entrySet());
            entries.sort(Map.Entry.<Integer, Integer>comparingByValue(Comparator.reverseOrder())
                    .thenComparingInt(Map.Entry::getKey));

    for( Map.Entry<Integer, Integer> set: entries) {
        for(int i = 0; i < set.getValue(); i++) {
            System.out.print(set.getKey()+" ");
        }
    }
}
}
