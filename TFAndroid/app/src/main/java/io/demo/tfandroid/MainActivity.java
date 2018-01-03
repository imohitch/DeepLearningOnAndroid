package io.demo.tfandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.tensorflow.contrib.android.TensorFlowInferenceInterface;

public class MainActivity extends AppCompatActivity {

    private static final String MODEL_FILE = "file:///android_asset/_basicTFonAndroid.pb";
    private static final String[] INPUT_NODES = {"modelInputA","modelInputB"};
    private static final String[] OUTPUT_NODES = {"modelOutputAB"};
    private static final int[] INPUT_DIM = {1};

    private TensorFlowInferenceInterface inferenceInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inferenceInterface = new TensorFlowInferenceInterface(getAssets(), MODEL_FILE);

        final Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final EditText etInputA = (EditText) findViewById(R.id.valA);
                final EditText etInputB = (EditText) findViewById(R.id.valB);

                float numA = Float.parseFloat(etInputA.getText().toString());
                float numB = Float.parseFloat(etInputB.getText().toString());

                float[] modelInputA = {numA};
                float[] modelInputB = {numB};

                inferenceInterface.feed(INPUT_NODES[0], modelInputA, INPUT_DIM[0]);
                inferenceInterface.feed(INPUT_NODES[1], modelInputB, INPUT_DIM[0]);

                inferenceInterface.run(OUTPUT_NODES);

                float[] modelOutputAB = new float[1];
                inferenceInterface.fetch(OUTPUT_NODES[0], modelOutputAB);

                final TextView textViewR = (TextView) findViewById(R.id.resultAB);
                textViewR.setText(Float.toString(modelOutputAB[0]) );
            }
        });
    }
}
