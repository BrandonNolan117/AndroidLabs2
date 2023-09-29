package com.example.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_linear);

        TextView textView = findViewById(R.id.textview);
        Switch switch1 = findViewById(R.id.switch1);
        Button button = findViewById(R.id.button1);
        CheckBox cb;
        cb = findViewById(R.id.checkbox);
        EditText edit;
        edit = findViewById(R.id.edit);

        button.setOnClickListener( (click) -> {
            textView.setText(edit.getText().toString());
            Toast.makeText(MainActivity.this, getString(R.string.toastMessage) ,Toast.LENGTH_LONG).show();
            } );
        cb.setOnCheckedChangeListener(  (compoundButton, b) -> {
            if(b){
            Snackbar.make(edit, getString(R.string.snackbarMessage) + " " + getString(R.string.cbOn) , Snackbar.LENGTH_LONG).setAction("Undo", click -> cb.setChecked(!b)).show();
            }else{
                Snackbar.make(edit, getString(R.string.snackbarMessage) + " " + getString(R.string.cbOff), Snackbar.LENGTH_LONG).setAction("Undo", click -> cb.setChecked(!b)).show();
            }
        }   );

    }
}