package com.example;

import java.awt.GraphicsEnvironment;

public class FontFamilyNames {
    private String allFontNames[];

    public String[] getFontName() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();  //获取关于系统字体的信息
        if(allFontNames==null)
            allFontNames = ge.getAvailableFontFamilyNames();
        return allFontNames;
    }
}