package org.example;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        File source = getFile("plaintext.txt");
        File sink = getFile("cyphertext.txt");
        createRandomText(source, sink);
        System.out.println("Finished.");

        //TODO bug on first letter of line of plaintext not swapping. It's to do with the case

//        String test = "hello\nmy name is gareth";
//        String test1 = "";
//        for(int i = 0; i < test.length(); i++)
//        {
//            test1 = test1 + cypher.swapChar(test.charAt(i));
//        }
//        System.out.println(test);
//        System.out.println(test1);
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
                //a = 97
                //z = 122
                if(red > 96 && red < 123) {
                    character = rotateChar(character, _offset);
                }
                writer.write(character);

            }
            reader.close();
            writer.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    private static void createRandomText(File _file, File _output)
    {
        RandomCypher cypher = new RandomCypher();
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
                //a = 97
                //z = 122
                if((int)character > 96 && (int)character < 123) {
                    character = cypher.swapChar(character);
                }
                writer.write(character);
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