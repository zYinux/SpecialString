package com.zyinux.specialstringbuilder;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zyinux.specialstring.relase.SpecialStringBuilder;
import com.zyinux.specialstring.relase.SpecialStyle;
import com.zyinux.specialstring.relase.style.ClickableStyle;


public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv=findViewById(R.id.tv);
        SpecialStyle style=new SpecialStyle();
        SpecialStringBuilder sb=new SpecialStringBuilder();
        style.setColor(Color.WHITE);
        style.setBackgroundColor(Color.RED);

        sb.append("红底白字",style);

        style.clearColor();

        sb.append("红底正常文字",style);

        style.setColor(Color.WHITE);
        style.setClickable(new ClickableStyle.OnClick() {
            @Override
            public void onClick(View widget) {

                Toast.makeText(MainActivity.this,"点击了",Toast.LENGTH_SHORT).show();
            }
        });

        style.setBackgroundColor(Color.BLUE);
        sb.append("可以点击事件的蓝底文字",style);

        style.clearStyles()
                .setImage(new ImageSpan(this,R.mipmap.ic_launcher),false);
        sb.append("变成图片的文字",style);

        style.setUnderLine(false);
        sb.append("下划线的文字",style);

        style.setStrikethrough(false);
        sb.append("删除线的文字",style);

        style.clearStyles();
        sb.append("普通的文字",style);

        tv.setText(sb.getCharSequence());
        tv.setMovementMethod(LinkMovementMethod.getInstance());


    }


}
