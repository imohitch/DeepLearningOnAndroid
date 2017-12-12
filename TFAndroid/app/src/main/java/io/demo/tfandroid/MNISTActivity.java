package io.demo.tfandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.graphics.PointF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import org.tensorflow.contrib.android.TensorFlowInferenceInterface;

import io.demo.tfandroid.mnistui.DrawModel;
import io.demo.tfandroid.mnistui.DrawView;

public class MNISTActivity extends AppCompatActivity implements View.OnTouchListener {

    private static final String TAG = "MNISTActivity";
    private static final int PIXEL_WIDTH = 28;
    private TextView mResultText;
    private float mLastX;
    private float mLastY;
    private DrawModel mModel;
    private DrawView mDrawView;
    private PointF mTmpPiont = new PointF();

    // Tensorflow related code
    private TensorFlowInferenceInterface inferenceInterface;
    private static final String MODEL_FILE = "file:///android_asset/_frozen_mnistTFonAndroid.pb";
    private static final String[] INPUT_NODES = {"modelInput"};
    private static final String[] OUTPUT_NODES = {"modelOutput"};
    private static final int[] INPUT_DIM = {1, PIXEL_WIDTH*PIXEL_WIDTH};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mnist);

        inferenceInterface = new TensorFlowInferenceInterface(getAssets(), MODEL_FILE);

        mModel = new DrawModel(PIXEL_WIDTH, PIXEL_WIDTH);
        mDrawView = (DrawView)findViewById(R.id.view_draw);
        mDrawView.setModel(mModel);
        mDrawView.setOnTouchListener(this);

        View detectButton = findViewById(R.id.button_detect);
        detectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDetectClicked();
            }
        });

        View clearButton = findViewById(R.id.button_clear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClearClicked();
            }
        });

        mResultText = (TextView)findViewById(R.id.text_result);
    }

    @Override
    protected void onResume() {
        mDrawView.onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        mDrawView.onPause();
        super.onPause();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction() & MotionEvent.ACTION_MASK;

        if (action == MotionEvent.ACTION_DOWN) {
            processTouchDown(event);
            return true;

        } else if (action == MotionEvent.ACTION_MOVE) {
            processTouchMove(event);
            return true;

        } else if (action == MotionEvent.ACTION_UP) {
            processTouchUp();
            return true;
        }
        return false;
    }

    private void processTouchDown(MotionEvent event) {
        mLastX = event.getX();
        mLastY = event.getY();
        mDrawView.calcPos(mLastX, mLastY, mTmpPiont);
        float lastConvX = mTmpPiont.x;
        float lastConvY = mTmpPiont.y;
        mModel.startLine(lastConvX, lastConvY);
    }

    private void processTouchMove(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        mDrawView.calcPos(x, y, mTmpPiont);
        float newConvX = mTmpPiont.x;
        float newConvY = mTmpPiont.y;
        mModel.addLineElem(newConvX, newConvY);

        mLastX = x;
        mLastY = y;
        mDrawView.invalidate();
    }

    private void processTouchUp() {
        mModel.endLine();
    }

    private void onDetectClicked() {

        float pixels[] = mDrawView.getPixelData();
        String[] labels = new String[]{"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        float[] modelOutput = new float[labels.length];

        // Feed in the values
        inferenceInterface.feed(INPUT_NODES[0],pixels,INPUT_DIM[0], INPUT_DIM[1]);

        // Run a session over the fed in data
        inferenceInterface.run(OUTPUT_NODES);

        // Fetch the result at output node
        inferenceInterface.fetch(OUTPUT_NODES[0], modelOutput);

        int index = 0;
        for (int i=0; i<10; i++){
            Log.i(TAG,""+modelOutput[i]);
            if (modelOutput[i] > modelOutput[index]){
                index=i;
            }
        }
        Log.i(TAG, "digit =" + index);
        mResultText.setText("Detected = " + labels[index]);
    }

    private void onClearClicked() {
        mModel.clear();
        mDrawView.reset();
        mDrawView.invalidate();
        mResultText.setText("");
    }
}
