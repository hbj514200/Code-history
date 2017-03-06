package com.example;

import java.io.*;
import java.util.*;

public class WordStatistic {
    private Vector<String> allWord, noSameWord;
    private File file = new File("d:/english.txt");
    private Scanner sc = null;
    private String regex;

    WordStatistic() {
        allWord = new Vector<String>();
        noSameWord = new Vector<String>();   //regex 是由空格、数字和符号(!"#$%&'()*+,-./:;<=>?@[\]^_`{|}~)组成的正则表达式
        regex = "[\\s\\d\\p{Punct}]+";
        try {
            sc = new Scanner(file);
            sc.useDelimiter(regex);
        } catch (IOException exp) {
            System.out.println(exp.toString());
        }
    }

    void setFileName(String name) {
        file = new File(name);
        try {
            sc = new Scanner(file);
            sc.useDelimiter(regex);
        } catch (IOException exp) {
            System.out.println(exp.toString());
        }

    }

    public void wordStatistic() {
        try {
            while (sc.hasNext()) {
                String word = sc.next();
                allWord.add(word);
                if (!noSameWord.contains(word)) noSameWord.add(word);
            }
        } catch (Exception ignored) { }
    }

    public Vector<String> getAllWord() {
        return allWord;
    }
    public Vector<String> getNoSameWord() {
        return noSameWord;
    }
}