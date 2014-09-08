#!/bin/bash

input='/Users/thomas/Desktop/books/novel/Hobbit\,\ The.txt'
output="words.txt"
echomode=""

usage()
{
    printf "%s\n" "usage: cmd -h -f <input> -o <output>"
    printf "%10s : %s\n" "-e", "echo mode"
    printf "%10s : %s\n" "-h", "help message"
    printf "%10s : %s\n" "-i", "input file"
    printf "%10s : %s\n" "-o", "output file"
    exit 1
}

while getopts ehi:o: opt ; do
    case "$opt" in
        e)
            echomode="echo"
            ;;
        h)
            usage
            ;;
        i)
            input="$OPTARG"
            ;;
        o)
            output="$OPTARG"
            ;;
        *)
            usage
            ;;
    esac
done

cat "${input}" \
    | tr -s "[[:punct:][:space:]]" "\n" \
    | sort \
    | uniq -c \
    | sort -nr \
    > ${output}
