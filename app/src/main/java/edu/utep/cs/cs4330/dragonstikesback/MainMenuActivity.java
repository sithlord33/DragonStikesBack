package edu.utep.cs.cs4330.dragonstikesback;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends AppCompatActivity {
    private Button start, options, quit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        start = findViewById(R.id.start);
        options = findViewById(R.id.options);
        quit = findViewById(R.id.quit);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder adb = new AlertDialog.Builder(MainMenuActivity.this);
                adb.setTitle("Quit?");
                adb.setMessage("Are you sure you want to QUIT?");
                adb.setNegativeButton("Cancel", null);
                adb.setPositiveButton("Ok", (dialog, which) -> {
                    finish();
                    System.exit(0);
                });
                adb.show();
            }
        });
    }
}
