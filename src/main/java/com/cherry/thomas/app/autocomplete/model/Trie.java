package com.cherry.thomas.app.autocomplete.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Trie extends HashMap<String,Object>
{
    public void populate(String key)
    {
        if (0<key.length())
        {
            String first = key.toLowerCase().substring(0,1);
            String remainder = null;
            Trie node = null;
            Object obj = this.get(first);

            if (1<key.length()){remainder = key.substring(1);}
            if (obj==null)
            {//add it
                node = new Trie();
                this.put(first, node);
            }
            else
            {//exists
                node = (Trie)obj;
            }
            if (remainder!=null && 0<remainder.length())
            {
                node.populate(remainder);
            }
        }
    }

    public List<String> find(String key){return this.find("", key);}

    protected List<String> find(String prefix, String key)
    {
        List<String> ret = new ArrayList<String>();

        if (key==null || key.isEmpty())
        {//return subs
            ret.addAll(this.dump(prefix));
        }
        else
        {
            String first = key.toLowerCase().substring(0,1);
            String remainder = null;
            Trie node = null;
            Object obj = this.get(first);

            if (1<key.length()){remainder = key.substring(1);}

            if (obj!=null)
            {
                node = (Trie)obj;
                ret.addAll(node.find(prefix + first, remainder));
            }
        }

        return ret;
    }

    public List<String> dump(String prefix){return dump(prefix, 10);}

    protected List<String> dump(String prefix, int limit)
    {
        List<String> ret = new ArrayList<String>();
        if (0<limit)
        {
            Set<String> set = this.keySet();
            Iterator<String> i = set.iterator();
            while (i.hasNext())
            {
                String key = i.next();
                Object obj = this.get(key);
                Trie node = null;

                if (obj!=null){node = (Trie)obj;}
                if (node!=null)
                {
                    if (0<node.size())
                    {
                        ret.addAll(node.dump(prefix + key, --limit));
                    }
                    else
                    {
                        ret.add(prefix+key);
                    }
                }
                else
                {//end of word
                    ret.add(prefix);
                }
            }
        }

        return ret;
    }
}
