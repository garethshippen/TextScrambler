package org.example;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        File source = getFile("plaintext.txt");
        File sink = getFile("cyphertext1.txt");

        createCypherText(source, sink, 10);
        System.out.println("Finished.");
    }
    private static char swapChar(char _c, int offset)
    {
        final String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int index = alphabet.indexOf(_c);
        return alphabet.charAt((index + offset)%alphabet.length());
    }

    private static char swapChar(char _c)
    {
        return swapChar(_c, 13);
    }

    private static File getFile(String _fileName) throws URISyntaxException {
        ClassLoader classLoader = Main.class.getClassLoader();
        URL resource = classLoader.getResource(_fileName);
        if(resource == null)
        {
            throw new IllegalArgumentException("File not found. " + _fileName);
        }
        else
        {
            return new File(resource.toURI());
        }
    }

    private static void createCypherText(File _file, File _output)
    {
        createCypherText(_file, _output, 13);
    }
    private static void createCypherText(File _file, File _output, int _offset)
    {
        BufferedReader reader;
        BufferedWriter writer;
        try
        {
            reader = new BufferedReader(new FileReader(_file));
            writer = new BufferedWriter(new FileWriter(_output));
            int red;
            char character;
            while((red = reader.read()) != -1)
            {
                character = Character.toLowerCase((char) red);
                red = (int)character;
                //a = 97
                //z = 122
                if(red > 96 && red < 123) {
                    character = swapChar(character, _offset);
                }
                writer.write((int)character);

            }
            reader.close();
            writer.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}