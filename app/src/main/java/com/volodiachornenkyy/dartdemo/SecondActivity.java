package com.volodiachornenkyy.dartdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.f2prateek.dart.Dart;
import com.f2prateek.dart.InjectExtra;
import com.volodiachornenkyy.dartdemo.model.ExampleModel;

import org.parceler.Parcels;

public class SecondActivity extends AppCompatActivity {

    private static final String EXTRA_KEY = "extra_key_string_representation";

    @Nullable
    @InjectExtra(EXTRA_KEY)
    ExampleModel extraObject = new ExampleModel();

    public static void startWithParcel(Context context) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(EXTRA_KEY, Parcels.wrap(getExampleData()));

        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtras(bundle);

        context.startActivity(intent);
    }

    public static void startByHenson(Context context) {
        Intent intent = Henson.with(context)
                .gotoSecondActivity()
                .extra_key_string_representation(getExampleData())
                .build();

        context.startActivity(intent);
    }

    private static ExampleModel getExampleData() {
        ExampleModel exampleModel = new ExampleModel();
        exampleModel.setAge(21);
        exampleModel.setName("Volodia");
        return exampleModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Dart.inject(this);

        TextView textView = ((TextView) findViewById(R.id.text));
        if (extraObject != null) {
            textView.setText(extraObject.toString());
        }
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.start(view.getContext());
            }
        });
    }
}
