package com.slashiq.slash.onerepmaxcalculator;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
/** import android.widget.NumberPicker; */
import android.widget.RadioButton;
import android.widget.TextView;
import android.content.Context;
import android.view.View.OnFocusChangeListener;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;


import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView mWeight;
    TextView mReps;
    TextView mResult;
    TextView mError;
    Button mCalculate;

    Calculator oCalculator;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    //  http://www.weightrainer.net/training/coefficients.html

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWeight = (TextView) findViewById(R.id.enterWeight);
        mReps = (TextView) findViewById(R.id.enterReps);
        mResult = (TextView) findViewById(R.id.textResult);
        mError = (TextView) findViewById(R.id.textError);
        mCalculate = (Button) findViewById(R.id.calculate);




        mCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Integer iWeight;
                Integer iReps;
                Long lResult;

                String sZero;

                sZero = "0";
                lResult = 0L;

                mError.setText("");
                mResult.setText("");

                hideKeyboard();

                iWeight = Integer.valueOf(sZero += mWeight.getText().toString());
                sZero = "0";
                iReps = Integer.valueOf(sZero += mReps.getText().toString());

                oCalculator = new Calculator(iWeight, iReps);

                lResult = oCalculator.Calculate();

                if (lResult > 0) {

                    String sResult;
                    sResult = Long.toString(lResult);
                    mResult.setText(sResult);
                } else {
                    mError.setText(oCalculator.mError);
                }


            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void hideKeyboard(){

        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
