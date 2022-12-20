package org.example;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    final static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    public static void main(String[] args) throws URISyntaxException {
//        File source = getFile("plaintext.txt");
//        File sink = getFile("cyphertext1.txt");
//        createRotText(source, sink, 10);
//        System.out.println("Finished.");
//
        System.out.println(createRandomCypher());
    }
    private static char rotateChar(char _c, int offset)
    {
        final String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int index = alphabet.indexOf(_c);
        return alphabet.charAt((index + offset)%alphabet.length());
    }

    private static char rotateChar(char _c)
    {
        return rotateChar(_c, 13);
    }

    private static char swapChar(String _cypher, char c)
    {

        return 'c';
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

    private static void createRotText(File _file, File _output)
    {
        createRotText(_file, _output, 13);
    }
    private static void createRotText(File _file, File _output, int _offset)
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
                    character = rotateChar(character, _offset);
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
    private static void createRandomText()
    {

    }

}