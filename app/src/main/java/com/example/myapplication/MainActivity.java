package com.example.myapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.nfc.cardemulation.CardEmulation;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(final View v) {
        final Intent activate = new Intent();
        activate.setAction(CardEmulation.ACTION_CHANGE_DEFAULT);
        activate.putExtra(CardEmulation.EXTRA_SERVICE_COMPONENT,
            new ComponentName(getApplicationContext(),
                HCEService.class.getCanonicalName()));
        activate.putExtra(CardEmulation.EXTRA_CATEGORY, CardEmulation.CATEGORY_PAYMENT);
        startActivity(activate);

    }
}
