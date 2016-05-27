package com.example.lhries.sinaleira;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


public class SinaleiraView extends View {
    public static final int VERDE = 1;
    public static final int AMARELO = 2;
    public static final int VERMELHO = 3;

    private int corAtual;


    public SinaleiraView(Context context){
        this(context,null);
    }

    public SinaleiraView(Context context, AttributeSet attrs){
        super(context, attrs);
        corAtual=1;
        this.setBackgroundColor(Color.BLACK);

    }


    public void setCorAtual(int cor){
        this.corAtual = cor;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint pincelVerde = new Paint();
        Paint pincelVermelho = new Paint();
        Paint pincelAmarelo = new Paint();

        switch(corAtual)
        {
            case VERDE:
                pincelVerde.setColor(Color.GREEN);
                pincelAmarelo.setColor(Color.YELLOW);
                pincelVermelho.setColor(Color.RED);
                break;
            case AMARELO:
                pincelVerde.setColor(Color.GRAY);
                pincelAmarelo.setColor(Color.YELLOW);
                pincelVermelho.setColor(Color.GRAY);
                break;
            case VERMELHO:
                pincelVerde.setColor(Color.GRAY);
                pincelAmarelo.setColor(Color.GRAY);
                pincelVermelho.setColor(Color.RED);
                break;


        }


        canvas.drawCircle(getWidth()/2,800,100,pincelVerde);
        canvas.drawCircle(getWidth()/2,500,100,pincelAmarelo);
        canvas.drawCircle(getWidth()/2,200,100,pincelVermelho);

    }
}
