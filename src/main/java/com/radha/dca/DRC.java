package com.radha.dca;
import java.util.*;

public class DRC {
    public static void main(String[] args) {
        DRC drc = new DRC();
        drc.printSmallestIntegerValueB(150);
//        drc.printSmallestIntegerValueB(10);
//        drc.printSmallestIntegerValueB(56);
    }
    public void printSmallestIntegerValueB(int a) {
        if(findFirstFactor(a) == 1) { //check for prime number
            System.out.println("Not possible");
            return;
        }
        List<Integer> resultSoFar = new ArrayList<>();
        resultSoFar = getSmallestIntegerValues(a, resultSoFar);
        Collections.sort(resultSoFar);
        resultSoFar.forEach(System.out :: print);
    }

     List<Integer> getSmallestIntegerValues(int a, List<Integer> resultSoFar) {
        int firstFactor = findFirstFactor(a);
        if(firstFactor == -1) {//prime number
            resultSoFar.add(a);
            return resultSoFar;
        }
        int nonPrimeFactor = getNonPrimeFactor(a);
        if(nonPrimeFactor == -1) { //no non prime factor
            resultSoFar.add(firstFactor);
            resultSoFar = getSmallestIntegerValues(a/firstFactor, resultSoFar);
        } else {
            resultSoFar.add(nonPrimeFactor);
            resultSoFar = getSmallestIntegerValues(a/nonPrimeFactor,resultSoFar);
        }
        return resultSoFar;
    }

     int getNonPrimeFactor(int a) {
        if(a % 9 == 0) {
            return 9;
        }
        if(a % 8 == 0) {
            return 8;
        }
        if(a % 6 == 0) {
            return 6;
        }
        if(a % 4 == 0) {
            return 4;
        }

        return -1;
    }

     int findFirstFactor(int a) {
        for(int i = 2; i <= a/2; i++) {
            if(a % i == 0) {
                return i;
            }
        }
        return -1;
    }
}
