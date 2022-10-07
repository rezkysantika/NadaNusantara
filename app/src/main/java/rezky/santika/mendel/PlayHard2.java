package rezky.santika.mendel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class PlayHard2 extends AppCompatActivity {

    SharedPreferences sharedpreferences;

    ImageView iv_11, iv_12, iv_13,
            iv_21, iv_22, iv_23,
            iv_31, iv_32, iv_33,
            iv_41, iv_42, iv_43;

    FloatingActionButton b_play;

    Random r;
    CountDownTimer timer;
    TextView time, score;

    MediaPlayer mp;
    AudioManager audioManager;
    int currentIndex = 0;
    private int mScore = 0;

    int rockLocationRow1, rockLocationRow2, rockLocationRow3, rockLocationRow4;
    int frameImage, pawInFrameImage, tap2Image, tap3Image, emptyImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_hard2);

        sharedpreferences = getSharedPreferences("mypref", Context.MODE_PRIVATE);
        r = new Random();
        loadImages();

        iv_11 = findViewById(R.id.iv_11a);
        iv_12 = findViewById(R.id.iv_12a);
        iv_13 = findViewById(R.id.iv_13a);

        iv_21 = findViewById(R.id.iv_21a);
        iv_22 = findViewById(R.id.iv_22a);
        iv_23 = findViewById(R.id.iv_23a);

        iv_31 = findViewById(R.id.iv_31a);
        iv_32 = findViewById(R.id.iv_32a);
        iv_33 = findViewById(R.id.iv_33a);

        iv_41 = findViewById(R.id.iv_41a);
        iv_42 = findViewById(R.id.iv_42a);
        iv_43 = findViewById(R.id.iv_43a);

        score = findViewById(R.id.score);
        score.setText("Score " + mScore);

        time = findViewById(R.id.tv_time);
        time.setText("Sisa waktu: " + millisToTime(10000) + " detik");

        timer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time.setText("Sisa waktu: " + millisToTime(millisUntilFinished) + " detik");
            }

            @Override
            public void onFinish() {
                time.setText("Sisa waktu: " + millisToTime(0) + " detik");

                iv_41.setEnabled(false);
                iv_42.setEnabled(false);
                iv_43.setEnabled(false);
                b_play.setVisibility(View.INVISIBLE);

                iv_11.setImageResource(emptyImage);
                iv_12.setImageResource(emptyImage);
                iv_13.setImageResource(emptyImage);

                iv_21.setImageResource(emptyImage);
                iv_22.setImageResource(emptyImage);
                iv_23.setImageResource(emptyImage);

                iv_31.setImageResource(emptyImage);
                iv_32.setImageResource(emptyImage);
                iv_33.setImageResource(emptyImage);

                iv_41.setImageResource(emptyImage);
                iv_42.setImageResource(emptyImage);
                iv_43.setImageResource(emptyImage);

                //Disini menebak
                if (mScore == 0) {
                    dialogGuess1();
                } if (mScore == 1) {
                    deleteCache(getApplicationContext());
                    dialogGuess2();
                } if (mScore == 2) {
                    deleteCache(getApplicationContext());
                    dialogGuess3();
                } if (mScore == 3) {
                    deleteCache(getApplicationContext());
                    dialogGuess4();
                } if (mScore == 4) {
                    deleteCache(getApplicationContext());
                    dialogGuess5();
                }
//                Toast.makeText(PlayHard2.this, "Waktu Habis!", Toast.LENGTH_SHORT).show();

            }
        };

        b_play = findViewById(R.id.b_play);

        iv_41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rockLocationRow4 == 1) {
                    if (mScore == 0) {
                        continueGame();
                    } if (mScore == 1) {
                        continueGame2();
                    } if (mScore == 2) {
                        continueGame3();
                    } if (mScore == 3) {
                        continueGame4();
                    } if (mScore == 4) {
                        continueGame5();
                    }
                } else {
                    endGame();
                }
            }
        });

        iv_42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rockLocationRow4 == 2) {
                    if (mScore == 0) {
                        continueGame();
                    } if (mScore == 1) {
                        continueGame2();
                    } if (mScore == 2) {
                        continueGame3();
                    } if (mScore == 3) {
                        continueGame4();
                    } if (mScore == 4) {
                        continueGame5();
                    }
                } else {
                    endGame();
                }
            }
        });

        iv_43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rockLocationRow4 == 3) {
                    if (mScore == 0) {
                        continueGame();
                    } if (mScore == 1) {
                        continueGame2();
                    } if (mScore == 2) {
                        continueGame3();
                    } if (mScore == 3) {
                        continueGame4();
                    } if (mScore == 4) {
                        continueGame5();
                    }
                } else {
                    endGame();
                }
            }
        });

        b_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initGame();
            }
        });

    }

    private void continueGame() {
        //soleram
        ArrayList<Integer> lagu1 = new ArrayList<>();
        lagu1.add(0, R.raw.c4);
        lagu1.add(1, R.raw.c4);
        lagu1.add(2, R.raw.d4);
        lagu1.add(3, R.raw.e4);
        lagu1.add(4, R.raw.f4);
        lagu1.add(5, R.raw.g4);
        lagu1.add(6, R.raw.f4);
        lagu1.add(7, R.raw.e4);
        lagu1.add(8, R.raw.d4);
        lagu1.add(9, R.raw.e4);
        lagu1.add(10, R.raw.f4);
        lagu1.add(11, R.raw.g4);
        lagu1.add(12, R.raw.a4);
        lagu1.add(13, R.raw.g4);
        lagu1.add(14, R.raw.f4);
        lagu1.add(15, R.raw.a4);
        lagu1.add(16, R.raw.g4);
        lagu1.add(17, R.raw.g4);
        lagu1.add(18, R.raw.a4);
        lagu1.add(19, R.raw.b4);
        lagu1.add(20, R.raw.c5);
        lagu1.add(21, R.raw.b4);
        lagu1.add(22, R.raw.a4);
        lagu1.add(23, R.raw.g4);
        lagu1.add(24, R.raw.f4);
        lagu1.add(25, R.raw.g4);
        lagu1.add(26, R.raw.e4);
        lagu1.add(27, R.raw.d4);
        lagu1.add(28, R.raw.c4);
        lagu1.add(29, R.raw.g4);
        lagu1.add(30, R.raw.g4);
        lagu1.add(31, R.raw.g4);
        lagu1.add(32, R.raw.a4);
        lagu1.add(33, R.raw.f4);
        lagu1.add(34, R.raw.f4);
        lagu1.add(35, R.raw.d4);
        lagu1.add(36, R.raw.b3);
        lagu1.add(37, R.raw.c4);
        lagu1.add(38, R.raw.e4);
        lagu1.add(39, R.raw.d4);
        lagu1.add(40, R.raw.c4);

        if (currentIndex < lagu1.size() - 1) {
            currentIndex++;
        } else {
            currentIndex = 0;
        }
        mp = MediaPlayer.create(getApplicationContext(), lagu1.get(currentIndex));
        mp.start();

        rockLocationRow4 = rockLocationRow3;
        setRockLocation(rockLocationRow4, 4);

        rockLocationRow3 = rockLocationRow2;
        setRockLocation(rockLocationRow3, 3);

        rockLocationRow2 = rockLocationRow1;
        setRockLocation(rockLocationRow2, 2);

        rockLocationRow1 = r.nextInt(3) + 1;
        setRockLocation(rockLocationRow1, 1);

    }

    private void continueGame2() {
        //potong bebek angsa
        ArrayList<Integer> lagu2 = new ArrayList<>();
        lagu2.add(0, R.raw.g3);
        lagu2.add(1, R.raw.g3);
        lagu2.add(2, R.raw.g3);
        lagu2.add(3, R.raw.c4);
        lagu2.add(4, R.raw.c4);
        lagu2.add(5, R.raw.c4);
        lagu2.add(6, R.raw.c4);
        lagu2.add(7, R.raw.b3);
        lagu2.add(8, R.raw.c4);
        lagu2.add(9, R.raw.d4);
        lagu2.add(10, R.raw.b3);
        lagu2.add(11, R.raw.c4);
        lagu2.add(12, R.raw.c4);
        lagu2.add(13, R.raw.g3);
        lagu2.add(14, R.raw.g3);
        lagu2.add(15, R.raw.c4);
        lagu2.add(16, R.raw.d4);
        lagu2.add(17, R.raw.e4);
        lagu2.add(18, R.raw.e4);
        lagu2.add(19, R.raw.d4);
        lagu2.add(20, R.raw.e4);
        lagu2.add(21, R.raw.f4);
        lagu2.add(22, R.raw.d4);
        lagu2.add(23, R.raw.e4);
        lagu2.add(24, R.raw.e4);
        lagu2.add(25, R.raw.f4);
        lagu2.add(26, R.raw.d4);
        lagu2.add(27, R.raw.f4);
        lagu2.add(28, R.raw.d4);
        lagu2.add(29, R.raw.f4);
        lagu2.add(30, R.raw.e4);
        lagu2.add(31, R.raw.g4);
        lagu2.add(32, R.raw.e4);
        lagu2.add(33, R.raw.c4);//
        lagu2.add(34, R.raw.e4);
        lagu2.add(35, R.raw.d4);
        lagu2.add(36, R.raw.e4);
        lagu2.add(37, R.raw.f4);
        lagu2.add(38, R.raw.d4);
        lagu2.add(39, R.raw.b3);
        lagu2.add(40, R.raw.g3);
        lagu2.add(41, R.raw.a3);
        lagu2.add(42, R.raw.b3);
        lagu2.add(43, R.raw.c4);

        if (currentIndex < lagu2.size() - 1) {
            currentIndex++;
        } else {
            currentIndex = 0;
        }
        mp = MediaPlayer.create(getApplicationContext(), lagu2.get(currentIndex));
        mp.start();
        rockLocationRow4 = rockLocationRow3;
        setRockLocation(rockLocationRow4, 4);

        rockLocationRow3 = rockLocationRow2;
        setRockLocation(rockLocationRow3, 3);

        rockLocationRow2 = rockLocationRow1;
        setRockLocation(rockLocationRow2, 2);

        rockLocationRow1 = r.nextInt(3) + 1;
        setRockLocation(rockLocationRow1, 1);
    }

    private void continueGame3() {
        //gundul pacul
        ArrayList<Integer> lagu3 = new ArrayList<>();
        lagu3.add(0, R.raw.c4);
        lagu3.add(1, R.raw.c4);
        lagu3.add(2, R.raw.e4);
        lagu3.add(3, R.raw.c4);
        lagu3.add(4, R.raw.e4);
        lagu3.add(5, R.raw.f4);
        lagu3.add(6, R.raw.g4);
        lagu3.add(7, R.raw.g4);
        lagu3.add(8, R.raw.b4);
        lagu3.add(9, R.raw.c5);
        lagu3.add(10, R.raw.b4);
        lagu3.add(11, R.raw.c5);
        lagu3.add(12, R.raw.b4);
        lagu3.add(13, R.raw.g4);
        lagu3.add(14, R.raw.c4);
        lagu3.add(15, R.raw.e4);
        lagu3.add(16, R.raw.c4);
        lagu3.add(17, R.raw.e4);
        lagu3.add(18, R.raw.f4);
        lagu3.add(19, R.raw.g4);
        lagu3.add(20, R.raw.g4);
        lagu3.add(21, R.raw.b4);
        lagu3.add(22, R.raw.c5);
        lagu3.add(23, R.raw.b4);
        lagu3.add(24, R.raw.c5);
        lagu3.add(25, R.raw.b4);
        lagu3.add(26, R.raw.g4);
        lagu3.add(27, R.raw.c4);
        lagu3.add(28, R.raw.e4);
        lagu3.add(29, R.raw.g4);
        lagu3.add(30, R.raw.f4);
        lagu3.add(31, R.raw.f4);
        lagu3.add(32, R.raw.g4);
        lagu3.add(33, R.raw.f4);
        lagu3.add(34, R.raw.e4);
        lagu3.add(35, R.raw.c4);
        lagu3.add(36, R.raw.f4);
        lagu3.add(37, R.raw.e4);
        lagu3.add(38, R.raw.c4);

        if (currentIndex < lagu3.size() - 1) {
            currentIndex++;
        } else {
            currentIndex = 0;
        }
        mp = MediaPlayer.create(getApplicationContext(), lagu3.get(currentIndex));
        mp.start();

        rockLocationRow4 = rockLocationRow3;
        setRockLocation(rockLocationRow4, 4);

        rockLocationRow3 = rockLocationRow2;
        setRockLocation(rockLocationRow3, 3);

        rockLocationRow2 = rockLocationRow1;
        setRockLocation(rockLocationRow2, 2);

        rockLocationRow1 = r.nextInt(3) + 1;
        setRockLocation(rockLocationRow1, 1);

    }

    private void continueGame4() {
        //yo miak
        ArrayList<Integer> lagu4 = new ArrayList<>();
        lagu4.add(0, R.raw.a3);
        lagu4.add(1, R.raw.a3);
        lagu4.add(2, R.raw.b3);
        lagu4.add(3, R.raw.c4);
        lagu4.add(4, R.raw.b3);
        lagu4.add(5, R.raw.c4);
        lagu4.add(6, R.raw.a3);
        lagu4.add(7, R.raw.b3);
        lagu4.add(8, R.raw.c4);
        lagu4.add(9, R.raw.b3);
        lagu4.add(10, R.raw.c4);
        lagu4.add(11, R.raw.d4);
        lagu4.add(12, R.raw.e4);
        lagu4.add(13, R.raw.a4);
        lagu4.add(14, R.raw.g4);
        lagu4.add(15, R.raw.f4);
        lagu4.add(16, R.raw.e4);
        lagu4.add(17, R.raw.d4);
        lagu4.add(18, R.raw.c4);
        lagu4.add(19, R.raw.d4);
        lagu4.add(20, R.raw.e4);
        lagu4.add(21, R.raw.f4);
        lagu4.add(22, R.raw.a4);
        lagu4.add(23, R.raw.g_4);
        lagu4.add(24, R.raw.a4);
        lagu4.add(25, R.raw.g_4);
        lagu4.add(26, R.raw.f4);
        lagu4.add(27, R.raw.e4);
        lagu4.add(28, R.raw.f4);
        lagu4.add(29, R.raw.e4);
        lagu4.add(30, R.raw.d4);
        lagu4.add(31, R.raw.c4);
        lagu4.add(32, R.raw.d4);
        lagu4.add(33, R.raw.b3);
        lagu4.add(34, R.raw.b3);
        lagu4.add(35, R.raw.b3);
        lagu4.add(36, R.raw.c4);
        lagu4.add(37, R.raw.d4);
        lagu4.add(38, R.raw.e4);
        lagu4.add(39, R.raw.d4);
        lagu4.add(40, R.raw.c4);
        lagu4.add(41, R.raw.b3);
        lagu4.add(42, R.raw.c4);
        lagu4.add(43, R.raw.a3);

        if (currentIndex < lagu4.size() - 1) {
            currentIndex++;
        } else {
            currentIndex = 0;
        }
        mp = MediaPlayer.create(getApplicationContext(), lagu4.get(currentIndex));
        mp.start();

        rockLocationRow4 = rockLocationRow3;
        setRockLocation(rockLocationRow4, 4);

        rockLocationRow3 = rockLocationRow2;
        setRockLocation(rockLocationRow3, 3);

        rockLocationRow2 = rockLocationRow1;
        setRockLocation(rockLocationRow2, 2);

        rockLocationRow1 = r.nextInt(3) + 1;
        setRockLocation(rockLocationRow1, 1);

    }

    private void continueGame5() {
        //lalan balek
        ArrayList<Integer> lagu5 = new ArrayList<>();
        lagu5.add(0, R.raw.c4);
        lagu5.add(1, R.raw.c4);
        lagu5.add(2, R.raw.d4);
        lagu5.add(3, R.raw.d4);
        lagu5.add(4, R.raw.c4);
        lagu5.add(5, R.raw.d4);
        lagu5.add(6, R.raw.f4);
        lagu5.add(7, R.raw.a4);
        lagu5.add(8, R.raw.a4);
        lagu5.add(9, R.raw.a4);
        lagu5.add(10, R.raw.g4);
        lagu5.add(11, R.raw.a4);
        lagu5.add(13, R.raw.g4);
        lagu5.add(14, R.raw.f4);
        lagu5.add(15, R.raw.d4);
        lagu5.add(16, R.raw.d4);
        lagu5.add(17, R.raw.g4);
        lagu5.add(18, R.raw.d4);
        lagu5.add(19, R.raw.c4);
        lagu5.add(20, R.raw.c4);
        lagu5.add(21, R.raw.g4);
        lagu5.add(22, R.raw.g4);
        lagu5.add(23, R.raw.c5);
        lagu5.add(24, R.raw.c5);
        lagu5.add(25, R.raw.c5);
        lagu5.add(26, R.raw.c5);
        lagu5.add(27, R.raw.c5);
        lagu5.add(28, R.raw.c5);
        lagu5.add(29, R.raw.d5);
        lagu5.add(30, R.raw.c5);
        lagu5.add(31, R.raw.c5);
        lagu5.add(32, R.raw.a4);
        lagu5.add(33, R.raw.g4);
        lagu5.add(34, R.raw.g4);
        lagu5.add(35, R.raw.e4);
        lagu5.add(36, R.raw.e4);
        lagu5.add(37, R.raw.g4);
        lagu5.add(38, R.raw.g4);

        if (currentIndex < lagu5.size() - 1) {
            currentIndex++;
        } else {
            currentIndex = 0;
        }
        mp = MediaPlayer.create(getApplicationContext(), lagu5.get(currentIndex));
        mp.start();

        rockLocationRow4 = rockLocationRow3;
        setRockLocation(rockLocationRow4, 4);

        rockLocationRow3 = rockLocationRow2;
        setRockLocation(rockLocationRow3, 3);

        rockLocationRow2 = rockLocationRow1;
        setRockLocation(rockLocationRow2, 2);

        rockLocationRow1 = r.nextInt(3) + 1;
        setRockLocation(rockLocationRow1, 1);

    }

    private void initGame() {
        iv_41.setEnabled(true);
        iv_42.setEnabled(true);
        iv_43.setEnabled(true);
        b_play.setVisibility(View.INVISIBLE);

        timer.start();

        rockLocationRow4 = 2;
        iv_42.setImageResource(pawInFrameImage);

        rockLocationRow3 = 2;
        iv_32.setImageResource(tap2Image);

        rockLocationRow2 = r.nextInt(3) + 1;
        setRockLocation(rockLocationRow2, 2);

        rockLocationRow1 = r.nextInt(3) + 1;
        setRockLocation(rockLocationRow1, 1);

    }

    private void endGame() {

        iv_41.setEnabled(false);
        iv_42.setEnabled(false);
        iv_43.setEnabled(false);
        b_play.setVisibility(View.INVISIBLE);

        iv_11.setImageResource(emptyImage);
        iv_12.setImageResource(emptyImage);
        iv_13.setImageResource(emptyImage);

        iv_21.setImageResource(emptyImage);
        iv_22.setImageResource(emptyImage);
        iv_23.setImageResource(emptyImage);

        iv_31.setImageResource(emptyImage);
        iv_32.setImageResource(emptyImage);
        iv_33.setImageResource(emptyImage);

        iv_41.setImageResource(emptyImage);
        iv_42.setImageResource(emptyImage);
        iv_43.setImageResource(emptyImage);

        //nanti ganti jadi panggil dialog
        timer.cancel();
        dialogTryAgain();
//        Toast.makeText(PlayHard2.this, "Failed!", Toast.LENGTH_SHORT).show();

    }

    public void dialogGuess1() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.m_dialog_guess);

        final Button opsi1 = dialog.findViewById(R.id.opsi1);
        opsi1.setText("Rek Ayo Rek");
        opsi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PlayHard2.this, "Jawaban salah, ulangi lagi", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        final Button opsi2 = dialog.findViewById(R.id.opsi2);
        opsi2.setText("Naik-Naik ke Puncak Gunung");
        opsi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PlayHard2.this, "Jawaban salah, ulangi lagi", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        final Button opsi3 = dialog.findViewById(R.id.opsi3);
        opsi3.setText("Tanduk Majeng");
        opsi3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PlayHard2.this, "Jawaban salah, ulangi lagi", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        final Button opsi4 = dialog.findViewById(R.id.opsi4);
        opsi4.setText("Soleram");
        opsi4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mScore++;
                dialogCorrect1();
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
    }

    public void dialogGuess2() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.m_dialog_guess);

        final Button opsi1 = dialog.findViewById(R.id.opsi1);
        opsi1.setText("Rasa Sayange");
        opsi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PlayHard2.this, "Jawaban salah, ulangi lagi", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        final Button opsi2 = dialog.findViewById(R.id.opsi2);
        opsi2.setText("Pitik Tukung");
        opsi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PlayHard2.this, "Jawaban salah, ulangi lagi", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        final Button opsi3 = dialog.findViewById(R.id.opsi3);
        opsi3.setText("Potong Bebek Angsa");
        opsi3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mScore++;
                dialogCorrect2();
                dialog.dismiss();
            }
        });

        final Button opsi4 = dialog.findViewById(R.id.opsi4);
        opsi4.setText("Anging Mamiri");
        opsi4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PlayHard2.this, "Jawaban salah, ulangi lagi", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
    }

    public void dialogGuess3() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.m_dialog_guess);

        final Button opsi1 = dialog.findViewById(R.id.opsi1);
        opsi1.setText("Bungong Jeumpa");
        opsi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PlayHard2.this, "Jawaban salah, ulangi lagi", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        final Button opsi2 = dialog.findViewById(R.id.opsi2);
        opsi2.setText("Gundul Pacul");
        opsi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mScore++;
                dialogCorrect3();
                dialog.dismiss();
            }
        });

        final Button opsi3 = dialog.findViewById(R.id.opsi3);
        opsi3.setText("Tebe Ona Na");
        opsi3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PlayHard2.this, "Jawaban salah, ulangi lagi", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        final Button opsi4 = dialog.findViewById(R.id.opsi4);
        opsi4.setText("O Ina Ni Keke");
        opsi4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PlayHard2.this, "Jawaban salah, ulangi lagi", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
    }

    public void dialogGuess4() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.m_dialog_guess);

        final Button opsi1 = dialog.findViewById(R.id.opsi1);
        opsi1.setText("Yo Miak");
        opsi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mScore++;
                dialogCorrect4();
                dialog.dismiss();
            }
        });

        final Button opsi2 = dialog.findViewById(R.id.opsi2);
        opsi2.setText("Pitik Tukung");
        opsi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PlayHard2.this, "Jawaban salah, ulangi lagi", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        final Button opsi3 = dialog.findViewById(R.id.opsi3);
        opsi3.setText("Surilang");
        opsi3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PlayHard2.this, "Jawaban salah, ulangi lagi", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        final Button opsi4 = dialog.findViewById(R.id.opsi4);
        opsi4.setText("Dodoi si Dodoi");
        opsi4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PlayHard2.this, "Jawaban salah, ulangi lagi", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
    }

    public void dialogGuess5() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.m_dialog_guess);

        final Button opsi1 = dialog.findViewById(R.id.opsi1);
        opsi1.setText("Lalan Belek");
        opsi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mScore++;
                dialogCorrect5();
                dialog.dismiss();
            }
        });

        final Button opsi2 = dialog.findViewById(R.id.opsi2);
        opsi2.setText("Suwe Ora Jamu");
        opsi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PlayHard2.this, "Jawaban salah, ulangi lagi", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        final Button opsi3 = dialog.findViewById(R.id.opsi3);
        opsi3.setText("Injit-Injit Semut");
        opsi3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PlayHard2.this, "Jawaban salah, ulangi lagi", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        final Button opsi4 = dialog.findViewById(R.id.opsi4);
        opsi4.setText("Ayam Den Lapeh");
        opsi4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PlayHard2.this, "Jawaban salah, ulangi lagi", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
    }
    //----------------------------------------
    public void dialogCorrect1() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.m_dialog_correct);

        final TextView title = dialog.findViewById(R.id.title);
        title.setText("Judul Lagu: Soleram");

        final TextView from = dialog.findViewById(R.id.from);
        from.setText("Provinsi: Kepulauan Riau");

        final TextView songlyrics = dialog.findViewById(R.id.lyrics);
        String lyrics = getResources().getString(R.string.lyrics_soleram);
        songlyrics.setText(lyrics);

        final CardView cardView = dialog.findViewById(R.id.playSong);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.lagu_soleram_comp);
        cardView.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                mp.start();
            }
        });

        final Button btn = dialog.findViewById(R.id.ok);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.release();
                dialog.dismiss();
                b_play.setVisibility(View.VISIBLE);
            }
        });

        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
    }

    public void dialogCorrect2() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.m_dialog_correct);

        final TextView title = dialog.findViewById(R.id.title);
        title.setText("Judul Lagu: Potong Bebek Angsa");

        final TextView from = dialog.findViewById(R.id.from);
        from.setText("Provinsi: Nusa Tenggara Barat");

        final TextView songlyrics = dialog.findViewById(R.id.lyrics);
        String lyrics = getResources().getString(R.string.lirik_potong_bebek);
        songlyrics.setText(lyrics);

        final CardView cardView = dialog.findViewById(R.id.playSong);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.lagu_potong_comp);
        cardView.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                mp.start();
            }
        });

        final Button btn = dialog.findViewById(R.id.ok);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.release();
                dialog.dismiss();
                b_play.setVisibility(View.VISIBLE);
            }
        });

        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
    }

    public void dialogCorrect3() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.m_dialog_correct);

        final TextView title = dialog.findViewById(R.id.title);
        title.setText("Judul Lagu: Gundul Pacul");

        final TextView from = dialog.findViewById(R.id.from);
        from.setText("Provinsi: Jawa Tengah");

        final TextView songlyrics = dialog.findViewById(R.id.lyrics);
        String lyrics = getResources().getString(R.string.lirik_gundul_pacul);
        songlyrics.setText(lyrics);

        final CardView cardView = dialog.findViewById(R.id.playSong);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.lagu_gundulpacul_comp);
        cardView.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                mp.start();
            }
        });

        final Button btn = dialog.findViewById(R.id.ok);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.release();
                dialog.dismiss();
                b_play.setVisibility(View.VISIBLE);
            }
        });

        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
    }

    public void dialogCorrect4() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.m_dialog_correct);

        final TextView title = dialog.findViewById(R.id.title);
        title.setText("Judul Lagu: Yok Miak");

        final TextView from = dialog.findViewById(R.id.from);
        from.setText("Provinsi: Bangka Belitung");

        final TextView songlyrics = dialog.findViewById(R.id.lyrics);
        String lyrics = getResources().getString(R.string.lirik_yomiak);
        songlyrics.setText(lyrics);

        final CardView cardView = dialog.findViewById(R.id.playSong);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.lagu_yokmiak_comp);
        cardView.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                mp.start();
            }
        });

        final Button btn = dialog.findViewById(R.id.ok);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.release();
                dialog.dismiss();
                b_play.setVisibility(View.VISIBLE);
            }
        });

        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
    }

    public void dialogCorrect5() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.m_dialog_correct);

        final TextView title = dialog.findViewById(R.id.title);
        title.setText("Judul Lagu: Lalan Belek");

        final TextView from = dialog.findViewById(R.id.from);
        from.setText("Provinsi: Bengkulu");

        final TextView songlyrics = dialog.findViewById(R.id.lyrics);
        String lyrics = getResources().getString(R.string.lirik_lalanbalek);
        songlyrics.setText(lyrics);

        final CardView cardView = dialog.findViewById(R.id.playSong);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.lagu_lalanbelek_comp);
        cardView.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                mp.start();
            }
        });

        final Button btn = dialog.findViewById(R.id.ok);
        btn.setText("Sesi Selesai");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.release();
                dialog.dismiss();
                Intent intent = new Intent(view.getContext(), Main2_Level.class);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putInt("SCORE", sharedpreferences.getInt("SCORE",0)+5);
                editor.apply();
                view.getContext().startActivity(intent);
                finish();
            }
        });

        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
    }

    public static void deleteCache(Context context) {
        try {
            File dir = context.getCacheDir();
            deleteDir(dir);
        } catch (Exception e) { e.printStackTrace();}
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
            return dir.delete();
        } else if(dir!= null && dir.isFile()) {
            return dir.delete();
        } else {
            return false;
        }
    }

    public void dialogTryAgain() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.m_dialog_wrongtile);

        Button retry = dialog.findViewById(R.id.retry);
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        Button quit = dialog.findViewById(R.id.quit);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
    }

    private void setRockLocation(int place, int row) {
        if (row == 1) {
            iv_11.setImageResource(emptyImage);
            iv_12.setImageResource(emptyImage);
            iv_13.setImageResource(emptyImage);

            switch (place) {
                case 1:
                    iv_11.setImageResource(tap3Image);
                    break;
                case 2:
                    iv_12.setImageResource(tap3Image);
                    break;
                case 3:
                    iv_13.setImageResource(tap3Image);
                    break;
            }
        }

        if (row == 2) {
            iv_21.setImageResource(emptyImage);
            iv_22.setImageResource(emptyImage);
            iv_23.setImageResource(emptyImage);

            switch (place) {
                case 1:
                    iv_21.setImageResource(frameImage);
                    break;
                case 2:
                    iv_22.setImageResource(frameImage);
                    break;
                case 3:
                    iv_23.setImageResource(frameImage);
                    break;
            }
        }

        if (row == 3) {
            iv_31.setImageResource(emptyImage);
            iv_32.setImageResource(emptyImage);
            iv_33.setImageResource(emptyImage);

            switch (place) {
                case 1:
                    iv_31.setImageResource(tap2Image);
                    break;
                case 2:
                    iv_32.setImageResource(tap2Image);
                    break;
                case 3:
                    iv_33.setImageResource(tap2Image);
                    break;
            }
        }

        if (row == 4) {
            iv_41.setImageResource(emptyImage);
            iv_42.setImageResource(emptyImage);
            iv_43.setImageResource(emptyImage);

            switch (place) {
                case 1:
                    iv_41.setImageResource(pawInFrameImage);
                    break;
                case 2:
                    iv_42.setImageResource(pawInFrameImage);
                    break;
                case 3:
                    iv_43.setImageResource(pawInFrameImage);
                    break;
            }
        }
    }

    private int millisToTime (long millis) {
        return (int) millis / 1000;
    }

    private void loadImages() {
        frameImage = R.drawable.tile3;
        pawInFrameImage = R.drawable.tapped;
        emptyImage = R.drawable.air;
        tap2Image = R.drawable.tile4;
        tap3Image = R.drawable.tile5;
    }

}