package com.elico.viewmodelandlivedata;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    Button btnIncrement, btnReset;
    TextView txtScore;

    int score = 0;

    MyViewModel myViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnIncrement = findViewById(R.id.btnIncrement);
        btnReset = findViewById(R.id.btnRest);
        txtScore = findViewById(R.id.txtScore);

        myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);

        myViewModel.getScore().observe(this, new Observer<Integer>()
        {
            @Override
            public void onChanged(@Nullable Integer integer)
            {
                txtScore.setText(String.valueOf(integer));
            }
        });

        btnIncrement.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                incrementScore();
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                resetScore();
            }
        });
    }

    private void incrementScore()
    {
        myViewModel.incrementScore();
    }

    private void resetScore()
    {
        myViewModel.resetScore();
    }


}
