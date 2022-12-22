package org.example;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws URISyntaxException
    {
        File source = getFile("plaintext.txt");
        File sink = getFile("cyphertext.txt");
        createRotText(source, sink);
        System.out.println("Finished.");
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

    private static void createRotText(File _file, File _output, int _offset)
    {
        RotCypher rotCypher = new RotCypher(_offset);
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
                    //character = rotateChar(character, _offset);
                    character = rotCypher.rotateChar(character);
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
    private static void createRotText(File _file, File _output)
    {
        createRotText(_file, _output, 13);
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