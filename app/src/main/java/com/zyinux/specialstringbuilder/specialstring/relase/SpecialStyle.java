package com.zyinux.specialstringbuilder.specialstring.relase;

import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;

import com.zyinux.specialstringbuilder.specialstring.relase.style.AbsoluteSizeStyle;
import com.zyinux.specialstringbuilder.specialstring.relase.style.BackgroundColor;
import com.zyinux.specialstringbuilder.specialstring.relase.style.ClickableStyle;
import com.zyinux.specialstringbuilder.specialstring.relase.style.ForegroundColor;
import com.zyinux.specialstringbuilder.specialstring.relase.style.ImageStyle;
import com.zyinux.specialstringbuilder.specialstring.relase.style.StrikethroughStyle;
import com.zyinux.specialstringbuilder.specialstring.relase.style.StyleWrapper;
import com.zyinux.specialstringbuilder.specialstring.relase.style.UnderlineStyle;

import java.util.HashMap;

/**
 * author: zyinux
 * date: on 2018/9/1
 */
public class SpecialStyle {

    private HashMap<Class,StyleWrapper> styles;

    public SpecialStyle() {
        styles=new HashMap<>();
    }

    public HashMap<Class, StyleWrapper> getStyles() {
        return styles;
    }
    public SpecialStyle setColor(int color){
        return setColor(color,true);
    }

    public SpecialStyle setColor(int color,boolean save){
        ForegroundColor foregroundColor;
        if (styles.containsKey(ForegroundColor.class)){
             foregroundColor = (ForegroundColor) styles.get(ForegroundColor.class);
            foregroundColor.setColor(color);
            foregroundColor.setSave(save);
        }else {
            foregroundColor=new ForegroundColor(color);
            foregroundColor.setSave(save);
            putStyle(foregroundColor);
        }
        return this;
    }

    public SpecialStyle setBackgroundColor(int color){
        return setBackgroundColor(color,true);
    }

    public SpecialStyle setBackgroundColor(int color,boolean save){
        BackgroundColor backgroundColor;
        if (styles.containsKey(BackgroundColor.class)){
            backgroundColor=(BackgroundColor) styles.get(BackgroundColor.class);
            backgroundColor.setColor(color);
            backgroundColor.setSave(save);
        }else {
            backgroundColor=new BackgroundColor(color);
            backgroundColor.setSave(save);
            putStyle(backgroundColor);
        }
        return this;
    }

    public SpecialStyle setClickable(ClickableStyle.OnClick onClick){
        ClickableStyle style;
        if (styles.containsKey(ClickableStyle.class)){
            style= (ClickableStyle) styles.get(ClickableStyle.class);
            style.setOnClick(onClick);
            style.setSave(false);
        }else {
            style=new ClickableStyle(onClick);
            putStyle(style);
        }
        return this;
    }

    public SpecialStyle setImage(ImageSpan imageSpan){
        return setImage(imageSpan,false);
    }

    public SpecialStyle setImage(ImageSpan imageSpan,boolean save){
        ImageStyle style;
        if (styles.containsKey(ImageStyle.class)){
            style= (ImageStyle) styles.get(ImageStyle.class);
            style.setImageSpan(imageSpan);
            style.setSave(save);
        }else {
            style=new ImageStyle(imageSpan);
            style.setSave(save);
            putStyle(style);
        }

        return this;
    }
    public SpecialStyle setStrikethrough(){
        return setStrikethrough(true);
    }


    public SpecialStyle setStrikethrough(boolean save){
        if (styles.containsKey(StrikethroughStyle.class)) {
            StyleWrapper style=styles.get(StrikethroughStyle.class);
            style.setSave(save);
        }else {

            putStyle(new StrikethroughStyle(save));

        }
        return this;
    }
    public SpecialStyle setUnderLine(){
        return setUnderLine(true);
    }

    public SpecialStyle setUnderLine(boolean save){
        if (styles.containsKey(UnderlineStyle.class)) {
            StyleWrapper style=styles.get(UnderlineStyle.class);
            style.setSave(save);
        }else {
            putStyle(new UnderlineStyle(save));
        }
        return this;
    }

    public SpecialStyle clearStyles(){
        styles.clear();
        return this;
    }

    public SpecialStyle clearColor(){
        return clear(ForegroundColor.class);
    }

    public SpecialStyle clearBackgroudColor(){
        return clear(BackgroundColor.class);
    }

    public SpecialStyle clearFontSize(){
        return clear(AbsoluteSizeStyle.class);
    }

    public SpecialStyle clearImage(){
        return clear(ImageStyle.class);
    }

    public SpecialStyle clearStrikethrough(){
        return clear(StrikethroughStyle.class);
    }

    public SpecialStyle clearUnderLine(){
        return clear(UnderlineStyle.class);
    }

    private SpecialStyle clear(Class clazz){
        if (styles.containsKey(clazz)){
            styles.remove(clazz);
        }
        return this;
    }

    private void putStyle(StyleWrapper styleWrapper){
        styles.put(styleWrapper.getClass(),styleWrapper);
    }
}
