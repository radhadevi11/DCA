package com.radha.dca;
import java.util.*;

public class LongestSubstringOfDistinctCharacter {
    /*

    32)idea
    step 1: take a character
    step 2: if the character has not already noted
            2.1: add it
    step 3: otherwise
        3.1: count all noted character
        3.2: compare the count and update maximum
        3.3: remove all the noted characted
        3.4: start from current character character
        3.5: go to step2

Algorithm:
	Declare character set
        maxCountSoFar = 0
	for each character
		if set does not contain curChar
			add it to set
		otherwise
			size = get set size
			if size > maxCountSoFar
				update maxCountSoFar
			removeAll element from set
			add curChar to set
     */
    int getCountOfLongestSubstringWithDistinctCharacter(String word) {
        Set<Character> characterSet = new HashSet<>();
        int maxSizeSoFar = 0;
        int size = 0;
        for (int i = 0; i < word.length();i++) {
            char curChar = word.charAt(i);
            if(!characterSet.contains(curChar)) {
                characterSet.add(curChar);
            } else {
                characterSet.removeAll(Collections.singletonList(curChar));
                characterSet.add(curChar);

            }
            size = characterSet.size();
            if(size > maxSizeSoFar) {
                maxSizeSoFar = size;
            }



        }
        return maxSizeSoFar;
    }
}
