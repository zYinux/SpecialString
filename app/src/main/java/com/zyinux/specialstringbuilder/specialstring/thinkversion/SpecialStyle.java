package com.zyinux.specialstringbuilder.specialstring.thinkversion;

import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;

import java.util.HashMap;


/**
 * author: zyinux
 * date: on 2018/8/29
 */
public class SpecialStyle {

    HashMap<Class,CharacterStyle> styles;


    public SpecialStyle() {
        styles = new HashMap<>();
    }

    public SpecialStyle setColor(int color){
        ForegroundColorSpan span=new ForegroundColorSpan(color);
        putStyle(span);
        return this;
    }

    public SpecialStyle setBackgroundColor(int color){
        BackgroundColorSpan span=new BackgroundColorSpan(color);
        putStyle(span);
        return this;
    }

    public SpecialStyle setFontSize(int size){
        AbsoluteSizeSpan span=new AbsoluteSizeSpan(size);
        putStyle(span);
        return this;
    }

    private void putStyle(CharacterStyle span){
        styles.put(span.getClass(),span);
    }

    private SpecialStyle removeStyle(Class clazz){
        styles.remove(clazz);
        return this;
    }


    public SpecialStyle clearColor(){

        return removeStyle(ForegroundColorSpan.class);
    }

    public SpecialStyle clearBackGroundColor(){
        return removeStyle(BackgroundColorSpan.class);
    }

    public HashMap<Class, CharacterStyle> getStyles() {
        return styles;
    }

    public SpecialStyle clearAllStyle(){
        styles.clear();
        return this;
    }

}
