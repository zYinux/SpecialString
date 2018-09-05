# SpecialString
# SpecialString 这是一个SpannableStringBuilder的辅助工具
    适合新手或者老鸟简单的需求使用。非常复杂特殊化的样式需求请使用SpannableStringBuilder。
## 写安卓的很多时候都会遇到这样子的界面需求
![GitHub](http://pdy1qf1ru.bkt.clouddn.com/1536110360.jpg )

一般遇到这种情况，有几个选择。
- 写三个TextView，来设置三个不同的文字和背景颜色。
- 写一个TextView 用SpannableStringBuilder来为不同部分文字设置不同样式。
- 写一个TextView，然后用构建Html的文本来设置不同样式，最后用Html.formHtml()方法来将其设置到TextView中。

> 第一个方法直观上最简便，因为TextView大家都会用，不就是多写两个吗，轻而易举。

>而第二个方法其实可以说是最好的一个方法（为什么？等下再说），但是对很多新手而言可能SpannableStringBuilder听都没听过，而且里面复杂的flag让人一脸懵逼。

> 至于第三个方法嘛，当初我写这个库的时候第一时间考虑的其实也是这种方法，后面发现用html来设置样式的时候有着无法为文本设定不同的大小等缺陷。而且研究Html.formHtml()的源码后发现，该方法并没有什么魔法，只是将html解析之后用SpannableStringBuilder来设置样式，所以有种脱了裤子放啥的感觉。（这也是为什么我觉得第二种方法比第一种好的原因）

## 使用方法
1. 引入库
```java
//在module下的dependencies 中加入
'com.zyinux:specialstring:1.0.2'
```
2.使用
```java
//构建SpecialStyle 用来设置样式的核心类
        SpecialStyle style=new SpecialStyle();
        SpecialStringBuilder sb=new SpecialStringBuilder();

        //设置文本颜色为黑色。第二个参数save的意思是代表该样式是否应用到下一段文字，如果不传则为true
        style.setColor(Color.BLACK,false);
        //为文字设置样式
        sb.append("售价:",style);

        style.setColor(Color.RED,false);
        sb.append("¥99.99  ",style);

        //设置颜色背景和点击事件样式
        //点击事件默认为不应用于下一段文字
        style.setColor(Color.GREEN,false)
             .setBackgroundColor(Color.rgb(200,200,200),false)
                .setClickable(new ClickableStyle.OnClick() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(MainActivity.this,"开始抢购",Toast.LENGTH_SHORT).show();
            }
        });
        sb.append("立即抢购",style);

        //为TextView设置刚刚构建的文本
        tv.setText(sb.getCharSequence());
        //如果为文字添加了点击事件，请添加这一句，否则点击事件不生效
        tv.setMovementMethod(LinkMovementMethod.getInstance());
```
3.方法说明
```java
//SpecialStyle的方法
setColor(int color);//设置文本颜色
setBackgroundColor(int color);//设置背景颜色
setClickable(ClickableStyle.OnClick onClick);//设置点击事件
setImage(ImageSpan imageSpan);//设置图片
setStrikethrough();//设置删除线
setUnderLine();//设置下划线
clearStyles();//清除SpecialStyle中所有设置的样式，获得一个新的Style
clear*();//清除SpecialStyle中的一个样式

//SpecialStringBuilder的方法
append(String s, SpecialStyle style);//添加文字并设置样式
```

## 第一次写辅助类库，只是一个很简单的功能。欢迎大家给star加关注，遇到问题欢迎大家提出。
同样欢迎大家加群闲聊：589184413
