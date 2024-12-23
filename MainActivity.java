package com.example.a3aaaa;

import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private GraphView graphView;
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Убедитесь, что используете правильный ID
        graphView = findViewById(R.id.graphView);  // Правильный ID из XML

        handler = new Handler();

        // Обновляем график каждую секунду
        runnable = new Runnable() {
            @Override
            public void run() {
                graphView.updateData();
                handler.postDelayed(this, 1000); // обновление данных каждую секунду
            }
        };
        handler.post(runnable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable); // Останавливаем обновление при выходе из активности
    }
}

