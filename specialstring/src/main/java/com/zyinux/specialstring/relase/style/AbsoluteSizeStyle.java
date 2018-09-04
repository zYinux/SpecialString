package com.zyinux.specialstring.relase.style;

/**
 * author: zyinux
 * date: on 2018/9/1
 */
public class AbsoluteSizeStyle extends StyleWrapper {

    int fontSize=40;

    public AbsoluteSizeStyle(int fontSize) {
        this.fontSize = fontSize;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }
}
