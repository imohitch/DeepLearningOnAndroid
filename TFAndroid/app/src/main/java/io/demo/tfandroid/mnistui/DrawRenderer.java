package io.demo.tfandroid.mnistui;

/**
 * Created by ai on 12/12/17.
 */

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class DrawRenderer {

    public static void renderModel(Canvas canvas, DrawModel model, Paint paint,
                                   int startLineIndex) {
        paint.setAntiAlias(true);

        int lineSize = model.getLineSize();
        for (int i = startLineIndex; i < lineSize; ++i) {
            DrawModel.Line line = model.getLine(i);
            paint.setColor(Color.BLACK);
            int elemSize = line.getElemSize();
            if (elemSize < 1) {
                continue;
            }
            DrawModel.LineElem elem = line.getElem(0);
            float lastX = elem.x;
            float lastY = elem.y;

            for (int j = 0; j < elemSize; ++j) {
                elem = line.getElem(j);
                float x = elem.x;
                float y = elem.y;
                canvas.drawLine(lastX, lastY, x, y, paint);
                lastX = x;
                lastY = y;
            }
        }
    }
}
