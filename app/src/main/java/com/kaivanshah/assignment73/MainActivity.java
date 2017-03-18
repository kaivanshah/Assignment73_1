package com.kaivanshah.assignment73;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_NameValue;
    TextView tv_AgeValue;
    ImageView IMG_Photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper oDBHelper = new DBHelper(this);
        Employee oEmployee = oDBHelper.getEmployee(1);

        tv_NameValue = (TextView)(this.findViewById(R.id.tv_NameValue));
        tv_AgeValue = (TextView)(this.findViewById(R.id.tv_AgeValue));
        IMG_Photo = (ImageView)(this.findViewById(R.id.IMG_Photo));
        tv_NameValue.setText(oEmployee._name);
        tv_AgeValue.setText(String.valueOf(oEmployee._Age));
        IMG_Photo.setImageResource(R.drawable.android);
        //IMG_Photo.setImageResource(oEmployee._PhotoURL);

        BitmapDrawable drawable = (BitmapDrawable) IMG_Photo.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        int i = oDBHelper.UpdateEmployee(oEmployee._id, bitmap);



    }
}
