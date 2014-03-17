package com.example.hci2_demo.app;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ListView;

public class FastSearchListView extends ListView {

    private Context ctx;

    private static int indWidth = 20;
    private String[] sections;
    private float scaledWidth;
    private float sx;
    private int indexSize;
    private String section;

    public FastSearchListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        ctx = context;
        this.sections = new String[] {"A","B","C","D","E","F","G","H","I","J","K","L",
                            "M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    }

    public FastSearchListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        ctx = context;
        this.sections = new String[] {"A","B","C","D","E","F","G","H","I","J","K","L",
                "M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    }

    public FastSearchListView(Context context, String keyList) {
        super(context);
        ctx = context;
        this.sections = new String[] {"A","B","C","D","E","F","G","H","I","J","K","L",
                "M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        scaledWidth = indWidth * 3;
        sx = this.getWidth() - this.getPaddingRight() - scaledWidth;

        Paint p = new Paint();
        p.setColor(Color.WHITE);
        p.setAlpha(100);

        canvas.drawRect(sx, this.getPaddingTop(), sx + scaledWidth,
                this.getHeight() - this.getPaddingBottom(), p);

        indexSize = (this.getHeight() - this.getPaddingTop() - getPaddingBottom())
                / sections.length;

        Paint textPaint = new Paint();
        textPaint.setColor(Color.DKGRAY);
        textPaint.setTextSize(scaledWidth / 2);

        for (int i = 0; i < sections.length; i++)
            canvas.drawText(sections[i].toUpperCase(),
                    sx + textPaint.getTextSize() / 2, getPaddingTop()
                    + indexSize * (i + 1), textPaint);


    }
}