package com.radha.dca;
import java.util.*;
import java.util.stream.*;

public class MaxDistanceBetweenSameElements {
    /*
    -convertArrayToMap
		- for each element
			if the element not present in the map
				-add the element as key
				-add the Element as a value
			if present
				- update the value of endPosition as current position
	-findMaxDistance
		- set distanceSoFar = 0
		- for each entry
			if the distance of the current value is greater than distanceSoFar
				update distance
     */
    Map<Integer, Element> convertArrayToMap(int[] numbers) {
        Map<Integer, Element> numWithIndex = new HashMap<>();
        for(int i = 0; i < numbers.length; i++) {
            int curValue = numbers[i];
            if(numWithIndex.putIfAbsent(curValue, new Element(i, i))!= null) {
                numWithIndex.replace(curValue, numWithIndex.get(curValue).setEndPosition(i));
            }
        }
        return numWithIndex;
    }
    int findMaxDistanceBetweenSameElement(int[] numbers) {
        Map<Integer, Element> elementWithPosition = convertArrayToMap(numbers);
        List<Integer> sortedDistances = elementWithPosition.entrySet().stream()
                .sorted(Map.Entry.<Integer, Element>comparingByValue(Comparator.comparingInt(Element::getDistance))
                        .reversed())
                .mapToInt(o -> o.getValue().getDistance())
                .boxed()
                .collect(Collectors.toList());

        return sortedDistances.isEmpty() ? 0 : sortedDistances.get(0);


    }
}
