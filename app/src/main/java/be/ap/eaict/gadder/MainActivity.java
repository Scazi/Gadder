package be.ap.eaict.gadder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import be.ap.eaict.gadder.DOM.DummyRepository;

import static be.ap.eaict.gadder.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(activity_main);


    }

    public void onClick(View view){
        MyAdapter myAdapter = new MyAdapter(this, DummyRepository.getInstance().getEvents());
        openActivity();
    }

    public void openActivity(){
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}
