package com.zyinux.specialstringbuilder.specialstring.thinkversion;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;

import java.util.HashMap;

/**
 * author: zyinux
 * date: on 2018/8/29
 */
public class SpecialStringBuilder {

    private SpannableStringBuilder sb;

    private int pos=0;

    public SpecialStringBuilder() {
        sb=new SpannableStringBuilder();
    }

    public SpecialStringBuilder append(String s,SpecialStyle style){

        return append(s,style,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    public SpecialStringBuilder append(String s,SpecialStyle style,int flags){
        sb.append(s);
        HashMap<Class, CharacterStyle> stylesMap = style.getStyles();
        int length=s.length();
        for (Class key : stylesMap.keySet()) {

            CharacterStyle characterStyle=style.getStyles().get(key);

            setSpan(characterStyle,pos,pos+length, flags);

            style.getStyles().put(key,handleCopyStyle(characterStyle));
        }
        pos+=length;
        return this;
    }


    /**
     * 和SpecialStringBuilder.setSpan()方法相同。
     * 考虑到这个类是为了简单的实现定制化文本样式的效果，关闭这个方法。
     * @param span
     * @param start
     * @param end
     * @param flags
     */
    private void setSpan(CharacterStyle span,int start,int end,int flags){
        sb.setSpan(span,start,end,flags);
    }

    public int getPos(){
        return pos;
    }

    public SpannableStringBuilder getCharSequence() {
        return sb;
    }

    public int getLength() {
        return sb.length();
    }

    private CharacterStyle handleCopyStyle(CharacterStyle style) {
        CharacterStyle span=null;
        if (style instanceof ForegroundColorSpan){

            span=new ForegroundColorSpan(((ForegroundColorSpan) style).getForegroundColor());

        }else if (style instanceof BackgroundColorSpan){

            span=new BackgroundColorSpan(((BackgroundColorSpan) style).getBackgroundColor());

        }else if (style instanceof AbsoluteSizeSpan){

            span=new AbsoluteSizeSpan(((AbsoluteSizeSpan) style).getSize());

        }else {
            span=style;
        }


        return span;
    }
}
