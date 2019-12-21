package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private SeekBar seekBar;
    private ListView list_view_numbers;
    private ArrayList<Integer> numbers;
    private ArrayAdapter<Integer> arrayAdapter;
    private int max = 20;
    private int min = 1;
    private int count = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAndBuildViews();
    }

    private void initAndBuildViews() {
        seekBar = findViewById(R.id.seekBar);
        list_view_numbers = findViewById(R.id.list_view_numbers);
        numbers = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,numbers);
        list_view_numbers.setAdapter(arrayAdapter);
        seekBar.setMax(max);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                numbers.clear();
                if (progress<min){
                    seekBar.setProgress(min);
                }
                for (int i = min; i<count; i++){
                    numbers.add(seekBar.getProgress()  * i);
                }
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar.setProgress(10);
    }
}
