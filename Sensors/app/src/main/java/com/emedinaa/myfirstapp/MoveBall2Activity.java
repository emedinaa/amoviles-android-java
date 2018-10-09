package com.emedinaa.myfirstapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;

public class MoveBall2Activity extends AppCompatActivity  {

        private float xPos;
        private float yPos;
        private float xMax, yMax;
        private Bitmap ball;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //setContentView(R.layout.activity_move_ball);
            final BallView ballView = new BallView(this);
            setContentView(ballView);

            Point size = new Point();
            Display display = getWindowManager().getDefaultDisplay();
            display.getSize(size);
            xMax = (float) size.x - ballView.getViewWidth();
            yMax = (float) size.y - ballView.getViewHeight();

            View.OnTouchListener onTouchListener = new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {

                    // Set drawBallView currX and currY value to user finger x y ordinate value..
                    xPos=motionEvent.getX();//+ballView.getViewWidth()/2.0f;
                    yPos=motionEvent.getY();//+ballView.getHeight()/2.0f;
                    ballView.invalidate();

                    return true;
                }
            };

            ballView.setOnTouchListener(onTouchListener);
        }

        private class BallView extends View {

            private int viewWidth=200;
            private int viewHeight=200;

            public BallView(Context context) {
                super(context);
                Bitmap ballSrc = BitmapFactory.decodeResource(getResources(), R.drawable.ball_red);
                final int dstWidth = viewWidth;
                final int dstHeight = viewHeight;
                ball = Bitmap.createScaledBitmap(ballSrc, dstWidth, dstHeight, true);
            }

            @Override
            protected void onDraw(Canvas canvas) {
                canvas.drawBitmap(ball, xPos, yPos, null);
                invalidate();
            }

            public int getViewWidth() {
                return viewWidth;
            }

            public int getViewHeight() {
                return viewHeight;
            }
        }
}
