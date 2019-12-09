package com.ama.tourism_svg.CustomWidgets;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;

import com.ama.tourism_svg.R;

@SuppressLint("AppCompatCustomView")
public class HeaderTextView extends TextView {

    Typeface boldTypeface = ResourcesCompat.getFont(getContext(), R.font.roboto_bold);

    public HeaderTextView(Context context) {
        super(context);
        init();
    }

    public HeaderTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HeaderTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public HeaderTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        ViewGroup.MarginLayoutParams margins = ViewGroup.MarginLayoutParams.class.cast(getLayoutParams());
        int margin = (int) getResources().getDimension(R.dimen.view_margin_default);
        margins.leftMargin = margin;
        margins.topMargin = margin;

        setLayoutParams(margins);

    }

    private void init(){
        setTypeface(boldTypeface);
    }
}
