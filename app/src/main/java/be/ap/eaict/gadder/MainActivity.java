package be.ap.eaict.gadder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import static be.ap.eaict.gadder.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(activity_main);
    }
}
