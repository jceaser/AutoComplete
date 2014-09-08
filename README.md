# Auto Complete #
An example project that implements a Trie class.

## Overview ##
A very simple attempt at creating a [Trie](http://en.wikipedia.org/wiki/Trie) class based on the most superficial reading of a description of said class on Wikipedia.

## Usage ##
Project is managed by [Apache-Maven](http://http://maven.apache.org). Build with the `package` command then run the App class as such:

    >mvm package
	>java -cp target/AutoComplete-1.0-SNAPSHOT.jar \
	    com.cherry.thomas.app.autocomplete.App -f words.txt
	Loaded 6805 words in 223ms.
	enter 'exit()' to quit.
	Find> elf
	result: [] - 0ms.
	Find> elv 
	result: [elves, elvenking, elvish] - 0ms.
	Find> qu
	result: [queer, questioned, questions, quesstion, quench, quaff, quarters, quarreled, quarrels, quays, quoits, quivering, quieter, quite] - 1ms.
	Find> exit()
	
While in the "Find>" loop enter words to query. You will be returned a list of results and a duration.