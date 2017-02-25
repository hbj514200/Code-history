package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.JTextField;

public class WordPolice implements ActionListener {
    private JTextField showText;
    private HashMap<String, String> hashtable;

    WordPolice() {
        hashtable = new HashMap<String, String>();
        try {
            File file = new File("C:/MyApplication/lib/src/main/java/com/example/word.txt");
            System.out.println(System.getProperty("user.dir") + "/word.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String englishWord = sc.next();
                String chineseWord = sc.next();
                hashtable.put(englishWord, chineseWord);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setJTextField(JTextField showText) {
        this.showText = showText;
    }

    public void actionPerformed(ActionEvent e) {
        String englishWord = e.getActionCommand();
        if (hashtable.containsKey(englishWord)) {
            String chineseWord = hashtable.get(englishWord);
            showText.setText(chineseWord);
        } else {
            showText.setText("没有此单词");
        }
    }
}