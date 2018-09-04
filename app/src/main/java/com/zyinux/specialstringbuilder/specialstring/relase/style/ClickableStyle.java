package com.zyinux.specialstringbuilder.specialstring.relase.style;

import android.text.style.ClickableSpan;
import android.view.View;

/**
 * author: zyinux
 * date: on 2018/9/1
 */
public class ClickableStyle extends StyleWrapper{

    OnClick onClick;

    public static interface OnClick{
        void onClick(View widget);
    }

    public ClickableStyle(OnClick onClick) {
        this.onClick=onClick;
        this.save=false;
    }

    public OnClick getOnClick() {
        return onClick;
    }

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }
}
