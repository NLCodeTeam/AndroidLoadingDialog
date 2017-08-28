package ru.nlcodeteam.loadingdialogsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        LoadingDialog dialog = new LoadingDialog(this);
        dialog.setContentText("Подождите...");
        dialog.setCancelable(false);
        dialog.setBackPressed(false);
        dialog.show();
    }
}
