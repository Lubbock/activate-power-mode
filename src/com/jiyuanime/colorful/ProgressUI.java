package com.jiyuanime.colorful;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JProgressBar;
import javax.swing.plaf.basic.BasicProgressBarUI;

public class ProgressUI extends BasicProgressBarUI {

    private JProgressBar jProgressBar;
    private int progressvalue;
    private Color forecolor;

    public ProgressUI(JProgressBar jProgressBar,Color forecolor) {
        this.jProgressBar = jProgressBar;
        this.forecolor=forecolor;
    }

    @Override
    protected void paintDeterminate(Graphics g, JComponent c) {
        progressvalue=this.jProgressBar.getValue();
        this.jProgressBar.setForeground(ColorFactory.gen());
        this.jProgressBar.setSize(200, 50);
        super.paintDeterminate(g, c);
    }

}
