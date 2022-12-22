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
        char c = _c;
        if(alphabet.indexOf(_c) >= 0)
        {
            c = cypher.charAt(alphabet.indexOf(_c));
        }
        return c;
    }
    public String getCypher()
    {
        return cypher;
    }
    private String createRandomCypher()
    {
        ArrayList<Character> letters = new ArrayList<>();
        for(char c: alphabet.toCharArray())
        {
            letters.add(Character.valueOf(c));
        }
        Collections.shuffle(letters);

        StringBuilder random = new StringBuilder();
        int length = letters.size();
        for(int i = 0; i < length; i++)
        {
            random.append(letters.get(i));
        }
        return random.toString();
    }
}
