package com.zyinux.specialstringbuilder.specialstring.relase.style;

/**
 * author: zyinux
 * date: on 2018/9/1
 */
public class StyleWrapper {

    //该style是否保存到下一个地方使用,默认为保存。
    protected boolean save=true;

    public boolean isSave() {
        return save;
    }

    public void setSave(boolean save) {
        this.save = save;
    }
}
