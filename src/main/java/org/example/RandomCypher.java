package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class RandomCypher
{
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private final String cypher;

    public RandomCypher()
    {
        cypher = createRandomCypher();
    }

    public char swapChar(char _c)
    {
        return cypher.charAt(alphabet.indexOf(_c));
    }
    private String createRandomCypher()
    {
        ArrayList<Character> letters = new ArrayList<>();
        for(char c: alphabet.toCharArray())
        {
            letters.add(Character.valueOf(c));
        }
        Collections.shuffle(letters);

        return letters.toString();
    }
}
