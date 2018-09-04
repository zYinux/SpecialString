package com.zyinux.specialstring.relase.style;

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
