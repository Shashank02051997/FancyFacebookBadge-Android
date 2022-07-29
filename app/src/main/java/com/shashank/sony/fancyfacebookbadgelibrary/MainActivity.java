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
        final FacebookNotificationBadge mBadge = findViewById(R.id.badge);
        mBadge.setEmoji(Emoji.HAHA);
        Button increase = findViewById(R.id.button);
        increase.setOnClickListener(view -> mBadge.setNumber(++mCount));
        Button clear = findViewById(R.id.button2);
        clear.setOnClickListener(view -> {
            mCount = 0;
            mBadge.setNumber(mCount);
        });

    }
}
