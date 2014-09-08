package com.cherry.thomas.app.autocomplete;

import com.cherry.thomas.app.autocomplete.model.Trie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        Trie tree = new Trie();

        if (args.length<1)
        {
            System.out.printf("usage: cmd -f <file>");
            System.exit(1);
        }

        File dataFile = null;
        BufferedReader in = null;

        for (int i = 0; i<args.length; i++)
        {
            String arg = args[i];
            if (arg.equals("-f"))
            {
                dataFile = new File(args[i+1]);
                try
                {
                    FileReader fr = new FileReader(dataFile);
                    in = new BufferedReader(fr);
                }
                catch (java.io.FileNotFoundException fnfe)
                {
                    fnfe.printStackTrace();
                }
            }
        }

        if (in!=null)
        {
            long words = 0;
            long loadStart = System.currentTimeMillis();
            try
            {
                String line = in.readLine();
                while (line!=null)
                {
                    String[] parts = line.trim().split(" ");
                    String word = null;
                    if (parts.length==2){word = parts[1];}
                    if (word!=null && !word.isEmpty())
                    {
                        tree.populate(word);
                        words++;
                    }
                    line = in.readLine();
                }
            }
            catch (java.io.IOException ioe){ioe.printStackTrace();}
            long loadStop = System.currentTimeMillis();
            long durration = loadStop-loadStart;
            System.out.printf("Loaded %d words in %dms.\n", words, durration);
        }

        System.out.println("enter 'exit()' to quit.");
        System.out.print("Find> ");

        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine())
        {
            String line = scan.nextLine().trim();
            if (line.equals("exit()")){break;}
            long findStart = System.currentTimeMillis();
            String results = tree.find(line).toString();
            long findStop = System.currentTimeMillis();
            long durration = findStop-findStart;
            System.out.printf("result: %s - %dms.\n", results, durration);
            System.out.print("Find> ");
        }

    }
}
