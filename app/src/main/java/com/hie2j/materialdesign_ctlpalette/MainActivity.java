package com.hie2j.materialdesign_ctlpalette;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private CollapsingToolbarLayout mCTL;
    private ImageView iv_header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCTL = findViewById(R.id.ctl_toolbar);
        iv_header = findViewById(R.id.iv_header);

        BitmapDrawable bitmapDrawable = (BitmapDrawable) iv_header.getDrawable();
        Bitmap bitmap = bitmapDrawable.getBitmap();

        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {
                int color = palette.getDarkMutedColor(Color.BLUE);
                mCTL.setContentScrimColor(color);
            }
        });
    }
}
