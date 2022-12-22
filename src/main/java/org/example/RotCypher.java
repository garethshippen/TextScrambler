package org.example;

public class RotCypher
{
    private int offset;

    public RotCypher(int _offset)
    {
        offset = _offset;
    }
    public RotCypher()
    {
        this(13);
    }
    public char rotateChar(char _c)
    {
        final String alphabet = "abcdefghijklmnopqrstuvwxyz";
        final int length = alphabet.length();
        int index = alphabet.indexOf(_c);
        return alphabet.charAt((index + this.offset)%length);
    }
}
