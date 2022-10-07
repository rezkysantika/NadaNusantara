package rezky.santika.mendel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2_Level extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    public static final String mypreference = "mypref";
    public static final String Score = "score";
//    String score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2__level);

        TextView tv = (TextView) findViewById(R.id.score);
        sharedpreferences = getSharedPreferences("mypref", Context.MODE_PRIVATE);
        int score = sharedpreferences.getInt("SCORE",0);
        tv.setText("Poin anda: " + score);

//        int mScore = getIntent().getIntExtra("score", 0);

        CardView cv1 = (CardView) findViewById(R.id.easy);
        cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PaketEasy.class);
                view.getContext().startActivity(intent);
                finish();
            }
        });

        if (score >= 15) {
            TextView tv2 = (TextView) findViewById(R.id.text_med);
            tv2.setTextColor(Color.BLACK);
            CardView cv2 = (CardView) findViewById(R.id.medium);
            cv2.setCardBackgroundColor(Color.WHITE);
            cv2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), PaketMedium.class);
                    view.getContext().startActivity(intent);
                    finish();
                }
            });
        } else {
            CardView cv2 = (CardView) findViewById(R.id.medium);
            cv2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(Main2_Level.this, "Dapatkan 15 poin untuk membuka tingkatan Sedang", Toast.LENGTH_SHORT).show();
                }
            });

        }

        if (score >= 30) {

            TextView tv3 = (TextView) findViewById(R.id.text_hard);
            tv3.setTextColor(Color.BLACK);
            CardView cv3 = (CardView) findViewById(R.id.hard);
            cv3.setCardBackgroundColor(Color.WHITE);
            cv3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), PaketHard.class);
                    view.getContext().startActivity(intent);
                    finish();
                }
            });
        } else {
            CardView cv3 = (CardView) findViewById(R.id.hard);
            cv3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(Main2_Level.this, "Dapatkan 30 poin untuk membuka tingkatan Sulit", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    public void mediumReached() {
    }

    public void hardReached() {
    }
}