package com.example;

import java.io.*;

public class AnalysisResult {
    public static void main(String args[]) {
        File fRead = new File("d:/score.txt");
        File fWrite = new File("d:/socreAnalysis.txt");
        try {
            Writer out = new FileWriter(fWrite);
            BufferedWriter bufferWrite = new BufferedWriter(out);
            Reader in = new FileReader(fRead);
            BufferedReader bufferRead = new BufferedReader(in);
            String str = null;
            while ((str = bufferRead.readLine()) != null) {
                double totalScore = Fenxi.getTotalScore(str);
                str = str + "总成绩:" + totalScore;
                System.out.println(str);
                bufferWrite.write(str);
                bufferWrite.newLine();
            }
            bufferRead.close();
            bufferWrite.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}