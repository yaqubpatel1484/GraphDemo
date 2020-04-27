package com.example.examquation2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class GraphView extends View {

    int count =0;
    ArrayList<Integer> valueList;
    int parts;

    public GraphView(Context context, ArrayList<Integer> ValueList, int Part ) {
        super(context);

        valueList = ValueList;
        parts = Part;
      //  Toast.makeText(context, "In Graph View"+valueList.get(1), Toast.LENGTH_SHORT).show();
        Toast.makeText(context, "Total Value  ="+valueList.size(), Toast.LENGTH_SHORT).show();
    }



  /*  @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.GREEN);

         for (int i= 1;i<((2*parts)+1);i=i+1){

             canvas.drawRect((i*(getRight()/parts)),(getBottom()-valueList.get(count)),((i+1)*(getRight()/parts)),getBottom(),paint);

                   count ++;
         }

    }
*/

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.RED);


        for (int i = 1 ; i < ((2 * parts) + 1); i = i + 2) {
            if (count<(valueList.size())) {
       //         Toast.makeText(getContext(), "Rectangle Draw"+count, Toast.LENGTH_SHORT).show();
                canvas.drawRect(i * (getRight() / parts), ((getBottom()) - (valueList.get(count))), ((i + 1) * (getRight() / parts)), getBottom(), paint);

                count++;
            }
        }
    }








}
