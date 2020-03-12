package com.example.tanvir.rotatetext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText tinput, toutput;
    Button rotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tinput = (EditText) findViewById(R.id.tinput);
        toutput = (EditText) findViewById(R.id.toutput);
        rotate = (Button) findViewById(R.id.rotate);

        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String oldText = tinput.getText().toString();
                String newText = rotateString(oldText);
                toutput.setText(newText);
            }
        });
    }

    private String rotateString(String input){
        String normal = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ?!.,\"'&";
        String split = "0ƖᄅƐㄣϛ9ㄥ86ɐqɔpǝɟƃɥᴉɾʞlɯuodbɹsʇnʌʍxʎz∀qƆpƎℲפHIſʞ˥WNOԀQɹS┴∩ΛMX⅄Z¿¡˙',,,⅋";

        String output = "";
        char letter;
        for(int i = 0; i<input.length();i++)
        {
            letter = input.charAt(i);
            int a = normal.indexOf(letter);
            output += (a != -1) ? split.charAt(a):letter;
        }
        return new StringBuilder(output).reverse().toString();
    }
}
