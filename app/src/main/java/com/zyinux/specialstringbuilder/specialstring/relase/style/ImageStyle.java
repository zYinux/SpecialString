package com.zyinux.specialstringbuilder.specialstring.relase.style;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.style.ImageSpan;

/**
 * author: zyinux
 * date: on 2018/9/4
 */
public class ImageStyle extends StyleWrapper{

    ImageSpan imageSpan;

    public ImageStyle(ImageSpan imageSpan) {
        this.imageSpan = imageSpan;
    }

    public ImageSpan getImageSpan() {
        return imageSpan;
    }

    public void setImageSpan(ImageSpan imageSpan) {
        this.imageSpan = imageSpan;
    }
}
