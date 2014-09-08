package com.cherry.thomas.app.autocomplete.model;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class TrieTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TrieTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TrieTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testTrie()
    {
        Trie tree = new Trie();
        String[] args = {"Thomas", "Cherry", "this"};

        for (String arg : args){tree.populate(arg);}

        //System.out.println("dump: " + tree);
        //System.out.println("find: " + tree.find("th"));

        String expected
            ="{t={h={o={m={a={s={}}}}, i={s={}}}}, c={h={e={r={r={y={}}}}}}}";

        assertTrue(tree.toString().equals(expected));
        assertTrue(tree.find("th").toString().equals("[thomas, this]"));
    }
}
