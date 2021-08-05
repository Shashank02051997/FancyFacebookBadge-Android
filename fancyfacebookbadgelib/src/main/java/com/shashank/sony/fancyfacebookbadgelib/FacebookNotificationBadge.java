package com.shashank.sony.fancyfacebookbadgelib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class FacebookNotificationBadge extends FrameLayout {
    private static final int DEFAULT_TEXT_COLOR = Color.parseColor("#3F51B5");
    private static final int DEFAULT_TEXT_SIZE = 16;
    private static final boolean DEFAULT_ANIMATION_ENABLED = true;
    private static final int DEFAULT_ANIMATION_DURATION = 500;
    private static final int DEFAULT_MAX_TEXT_LENGTH = 2;
    private static final String DEFAULT_MAX_LENGTH_REACHED_TEXT = "...";

    private FrameLayout mContainer;
    private ImageView mIvBadgeBg;
    private TextView mTvBadgeText;
    private int mBadgeTextColor = DEFAULT_TEXT_COLOR;
    private float mBadgeTextSize = dpToPx(DEFAULT_TEXT_SIZE);
    private int mAnimationDuration = DEFAULT_ANIMATION_DURATION;
    private Animation mUpdate;
    private Animation mShow;
    private Animation mHide;
    private String mBadgeText;
    private boolean mIsBadgeShown;
    private boolean mAnimationEnabled = DEFAULT_ANIMATION_ENABLED;
    private int mMaxTextLength = DEFAULT_MAX_TEXT_LENGTH;
    private String mEllipsizeText = DEFAULT_MAX_LENGTH_REACHED_TEXT;

    public FacebookNotificationBadge(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.facebook_notification_badge, this, true);
        mContainer = (FrameLayout) findViewById(R.id.fl_container);
        mIvBadgeBg = (ImageView) findViewById(R.id.iv_badge_bg);
        mTvBadgeText = (TextView) findViewById(R.id.tv_badge_text);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs, R.styleable.NotificationBadge, 0, 0);
        try {
            mBadgeTextColor = a.getColor(R.styleable.NotificationBadge_nbTextColor, DEFAULT_TEXT_COLOR);
            mTvBadgeText.setTextColor(mBadgeTextColor);

            mBadgeTextSize = a.getDimensionPixelSize(R.styleable.NotificationBadge_nbTextSize, (int)dpToPx(DEFAULT_TEXT_SIZE));
            mTvBadgeText.setTextSize(TypedValue.COMPLEX_UNIT_PX, mBadgeTextSize);

            mAnimationEnabled = a.getBoolean(R.styleable.NotificationBadge_nbAnimationEnabled, DEFAULT_ANIMATION_ENABLED);

            mAnimationDuration = a.getInt(R.styleable.NotificationBadge_nbAnimationDuration, DEFAULT_ANIMATION_DURATION);

            mMaxTextLength = a.getInt(R.styleable.NotificationBadge_nbMaxTextLength, DEFAULT_MAX_TEXT_LENGTH);
            mEllipsizeText = a.getString(R.styleable.NotificationBadge_nbEllipsizeText);
            if (mEllipsizeText == null) {
                mEllipsizeText = DEFAULT_MAX_LENGTH_REACHED_TEXT;
            }
        } finally {
            a.recycle();
        }

        if (mAnimationEnabled) {
            initUpdateAnimation();
        }
    }

    public void clear() {
        if (mIsBadgeShown) {
            if (mAnimationEnabled) {
                mContainer.startAnimation(mHide);
            } else {
                mContainer.setVisibility(INVISIBLE);
            }
            mIsBadgeShown = false;
        }
    }

    public void show(String text) {
        mBadgeText = text;
        if (!mIsBadgeShown) {
            if (mAnimationEnabled) {
                mContainer.startAnimation(mShow);
            } else {
                mContainer.setVisibility(VISIBLE);
                mTvBadgeText.setText(text);
            }
            mIsBadgeShown = true;
        } else {
            mTvBadgeText.setText(text);
        }
    }

    public boolean isAnimationEnabled() {
        return mAnimationEnabled;
    }

    public void setAnimationEnabled(boolean animationEnabled) {
        mAnimationEnabled = animationEnabled;
        if (animationEnabled && (mUpdate == null || mShow == null || mHide == null)) {
            initUpdateAnimation();
        }
    }
    public void setEmoji(Emoji emoji){
        if(emoji==Emoji.ANGRY)
        mIvBadgeBg.setImageResource(R.drawable.angryimg);
        else if(emoji==Emoji.HAHA)
        mIvBadgeBg.setImageResource(R.drawable.hahaimg);
        else if(emoji==Emoji.LIKE)
        mIvBadgeBg.setImageResource(R.drawable.likeimg);
        else if(emoji==Emoji.LOVE)
        mIvBadgeBg.setImageResource(R.drawable.loveimg);
        else if(emoji==Emoji.SAD)
        mIvBadgeBg.setImageResource(R.drawable.sadimg);
        else if(emoji==Emoji.WOW)
        mIvBadgeBg.setImageResource(R.drawable.wowimg);
    }

    public void setMaxTextLength(int maxLength) {
        mMaxTextLength = maxLength;
    }

    public void setText(String text) {
        if (text != null && text.length() > mMaxTextLength) {
            mBadgeText = mEllipsizeText;
        } else {
            mBadgeText = text;
        }
        if (text == null || text.isEmpty()) {
            clear();
        } else {
            if (mIsBadgeShown) {
                if (mAnimationEnabled) {
                    mContainer.startAnimation(mUpdate);
                } else {
                    mTvBadgeText.setText(mBadgeText);
                }
            } else {
                show(mBadgeText);
            }
        }
    }

    public void setNumber(int number) {
        if (number == 0) {
            clear();
        } else {
            setText(String.valueOf(number));
        }
    }

    public int getTextColor() {
        return mBadgeTextColor;
    }

    public void setTextColor(int textColor) {
        mBadgeTextColor = textColor;
        mTvBadgeText.setTextColor(mBadgeTextColor);
    }


    private void initUpdateAnimation() {
        mUpdate = new ScaleAnimation(1, 0.8f, 1, 0.8f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        mUpdate.setDuration(mAnimationDuration / 2);
        mUpdate.setRepeatMode(Animation.REVERSE);
        mUpdate.setRepeatCount(1);
        mUpdate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                mTvBadgeText.setText(mBadgeText);
            }
            @Override
            public void onAnimationEnd(Animation animation) {}
            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        mShow = new ScaleAnimation(0, 1, 0, 1,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        mShow.setDuration(mAnimationDuration / 2);
        mShow.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                mContainer.setVisibility(VISIBLE);
                mTvBadgeText.setText(mBadgeText);
            }
            @Override
            public void onAnimationEnd(Animation animation) {}
            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        mHide = new ScaleAnimation(1, 0, 1, 0,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        mHide.setDuration(mAnimationDuration / 2);
        mHide.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}
            @Override
            public void onAnimationEnd(Animation animation) {
                mContainer.setVisibility(INVISIBLE);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {}
        });
    }

    private float dpToPx(float dp){
        return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
    }

}
