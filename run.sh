#!/bin/bash

class=com.cherry.thomas.app.autocomplete.App

function usage
{
    printf "%5s : %s\n" "Usage" "cmd -h -c <class name>"
    printf "%5s : %s\n" "-c" "class name to run"
    printf "%5s : %s\n" "-h" "this help message"
    exit 1
}

while getopts c:hm opt ; do
    case "${opt}" in
        c) class=${OPTARG} ;;
        h) usage ;;
        m) mvn package ;;
        *) usage ;;
    esac
done

shift $((OPTIND-1))

java -cp target/AutoComplete-1.0-SNAPSHOT.jar \
    ${class} $1 $2 $3
