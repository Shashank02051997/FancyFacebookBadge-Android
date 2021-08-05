package com.shashank.sony.fancyfacebookbadgelibrary;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.shashank.sony.fancyfacebookbadgelib.Emoji;
import com.shashank.sony.fancyfacebookbadgelib.FacebookNotificationBadge;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final FacebookNotificationBadge mBadge = (FacebookNotificationBadge) findViewById(R.id.badge);
        mBadge.setEmoji(Emoji.HAHA);
        Button increase = (Button) findViewById(R.id.button);
        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBadge.setNumber(++mCount);
            }
        });
        Button clear = (Button) findViewById(R.id.button2);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCount = 0;
                mBadge.setNumber(mCount);
            }
        });

    }
}
