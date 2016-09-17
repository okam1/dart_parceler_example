package com.volodiachornenkyy.dartdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.f2prateek.dart.HensonNavigable;

@HensonNavigable
public class MainActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent intent = Henson.with(context)
                .gotoMainActivity()
                .build();

        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondActivity.startByHenson(view.getContext());
            }
        });
    }
}
