package com.zyinux.specialstring.relase.style;

/**
 * author: zyinux
 * date: on 2018/9/1
 */
public class BackgroundColor extends StyleWrapper {

    private int color;

    public BackgroundColor(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
