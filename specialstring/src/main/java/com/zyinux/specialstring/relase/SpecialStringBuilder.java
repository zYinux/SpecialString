package com.zyinux.specialstring.relase;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.UnderlineSpan;
import android.view.View;

import com.zyinux.specialstring.relase.style.StyleWrapper;
import com.zyinux.specialstring.relase.style.AbsoluteSizeStyle;
import com.zyinux.specialstring.relase.style.BackgroundColor;
import com.zyinux.specialstring.relase.style.ClickableStyle;
import com.zyinux.specialstring.relase.style.ForegroundColor;
import com.zyinux.specialstring.relase.style.ImageStyle;
import com.zyinux.specialstring.relase.style.StrikethroughStyle;
import com.zyinux.specialstring.relase.style.UnderlineStyle;

import java.util.HashMap;
import java.util.HashSet;


/**
 * author: zyinux
 * date: on 2018/9/1
 */
public class SpecialStringBuilder {

    private SpannableStringBuilder sb;

    private int pos=0;

    public SpecialStringBuilder() {
        sb=new SpannableStringBuilder();
    }

    public SpecialStringBuilder append(String s, SpecialStyle style){
        return append(s,style, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    private SpecialStringBuilder append(String s, SpecialStyle style, int flags) {
        sb.append(s);
        int length=s.length();
        HashMap<Class, StyleWrapper> styles = style.getStyles();

        HashSet<Class> notSave=new HashSet<>();

        for (Class key : styles.keySet()) {
            CharacterStyle span=handleStyle(styles.get(key));
            if (span!=null){
                setSpan(span,pos,pos+length, flags);
            }
            if (!styles.get(key).isSave()){
                notSave.add(key);
            }
        }

        for (Class key : notSave) {
            styles.remove(key);
        }

        pos+=length;
        return this;
    }

    private void setSpan(CharacterStyle style, int start, int end, int flags) {
        sb.setSpan(style,start,end,flags);
    }

    private CharacterStyle handleStyle(final StyleWrapper style){
        CharacterStyle span=null;
        if (style instanceof ForegroundColor){
            span=new ForegroundColorSpan(((ForegroundColor) style).getColor());
        }else if (style instanceof BackgroundColor){
            span=new BackgroundColorSpan(((BackgroundColor) style).getColor());
        }else if (style instanceof AbsoluteSizeStyle){
            span=new AbsoluteSizeSpan(((AbsoluteSizeStyle) style).getFontSize());
        }else if (style instanceof ClickableStyle){
            span=new ClickableSpan() {
                @Override
                public void onClick(View widget) {
                    ((ClickableStyle) style).getOnClick().onClick(widget);
                }
            };
        }else if (style instanceof ImageStyle){
            ImageSpan imageSpan=((ImageStyle) style).getImageSpan();
            span=new ImageSpan(imageSpan.getDrawable());
        }else if (style instanceof StrikethroughStyle){
            span=new StrikethroughSpan();
        }else if (style instanceof UnderlineStyle){
            span=new UnderlineSpan();
        }

        return span;
    }

    public SpannableStringBuilder getCharSequence() {
        return sb;
    }

    public int getPos() {
        return pos;
    }

    public int getLength(){
        return sb.length();
    }
}
