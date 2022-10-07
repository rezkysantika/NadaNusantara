package rezky.santika.mendel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PaketMedium extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paket_medium);

        CardView a = (CardView) findViewById(R.id.playA);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PlayA.class);
                view.getContext().startActivity(intent);
                finish();}
        });

        CardView b = (CardView) findViewById(R.id.playB);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PlayB.class);
                view.getContext().startActivity(intent);
                finish();}
        });

        CardView c = (CardView) findViewById(R.id.playC);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PlayC.class);
                view.getContext().startActivity(intent);
                finish();}
        });

        CardView d = (CardView) findViewById(R.id.playD);
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PlayD.class);
                view.getContext().startActivity(intent);
                finish();}
        });
    }
}
