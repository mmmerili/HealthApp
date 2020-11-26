package com.example.healthapp_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class KyselyActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.project.MESSAGE";
    private ArrayList<String> kysymykset = new ArrayList<String>();
    private int kysymysNumero = 0;
    private int aktiviteetti1Pisteet = 0;
    private int aktiviteetti2Pisteet = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kysely);

        kysymykset.add("Kysymys1");
        kysymykset.add("Kysymys2");
        kysymykset.add("Kysymys3");
        kysymykset.add("Kysymys4");
        kysymykset.add("Kysymys5");

        TextView kysymys = findViewById(R.id.kysymys);
        kysymys.setText(kysymykset.get(0));
    }

    public void onButtonPress(View view) {
        TextView kysymys = findViewById(R.id.kysymys);

        if (view == findViewById(R.id.vastaus1)) {
            this.aktiviteetti1Pisteet++;
            if (kysymysNumero == kysymykset.size() - 1) {
                String vastaus = "Vastaus";
                if (aktiviteetti1Pisteet > aktiviteetti2Pisteet) {
                    vastaus = "Vastaus1";
                } else if (aktiviteetti2Pisteet > aktiviteetti1Pisteet) {
                    vastaus = "Vastaus2";
                }
                Intent intent = new Intent(this, VastausActivity.class);
                intent.putExtra(EXTRA_MESSAGE, vastaus);
                startActivity(intent);
            } else {
                kysymysNumero++;
                kysymys.setText(kysymykset.get(kysymysNumero));
            }
        } else if (view == findViewById(R.id.vastaus2)) {
            this.aktiviteetti2Pisteet++;
            if (kysymysNumero == kysymykset.size() - 1) {
                String vastaus = "Vastaus";
                if (aktiviteetti1Pisteet > aktiviteetti2Pisteet) {
                    vastaus = "Vastaus1";
                } else if (aktiviteetti2Pisteet > aktiviteetti1Pisteet) {
                    vastaus = "Vastaus2";
                }
                Intent intent = new Intent(this, VastausActivity.class);
                intent.putExtra(EXTRA_MESSAGE, vastaus);
                startActivity(intent);
            } else {
                kysymysNumero++;
                kysymys.setText(kysymykset.get(kysymysNumero));
            }
        }
    }
}