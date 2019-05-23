package br.com.franklin.bestfuel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private TextView precoDaGasolinaTextView;
    private SeekBar precoDaGasolinaSeekBar;
    private TextView precoDoEtanolTextView;
    private SeekBar precoDoEtanolSeekBar;
    private ImageView melhorOpcaoImageView;
    private TextView  bestChoiceTextView;
    private double precoGasolina;
    private double precoEtanol;
    private double razao;

    private NumberFormat currencyFormat =
            NumberFormat.getCurrencyInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        precoDaGasolinaTextView =
                 findViewById(R.id.gasoline_price_textview);
        precoDaGasolinaSeekBar = findViewById(R.id.gasoline_price_seekbar);
        precoDoEtanolTextView =
                 findViewById(R.id.ethanol_price_textview);
        precoDoEtanolSeekBar = findViewById(R.id.ethanol_price_seekbar);        ;
        bestChoiceTextView = findViewById(R.id.best_choice_textview);
        melhorOpcaoImageView =
                 findViewById(R.id.best_choice_imagenview);

        precoGasolina = precoEtanol = 5;
        calcular();
        precoDaGasolinaSeekBar.setOnSeekBarChangeListener(observer);
        precoDoEtanolSeekBar.setOnSeekBarChangeListener(observer);

    }
    private void calcular(){
        razao = precoEtanol / precoGasolina;
        precoDaGasolinaTextView.setText(currencyFormat.format(precoGasolina));
        precoDoEtanolTextView.setText(currencyFormat.format(precoEtanol));
        if (razao >= 0.7){
            melhorOpcaoImageView.setImageResource(R.drawable.gasoline);
            bestChoiceTextView.setText(R.string.gasoline);
        }
        else{
            melhorOpcaoImageView.setImageResource(R.drawable.ethanol);
            bestChoiceTextView.setText(R.string.ethanol);
        }
    }

    private SeekBar.OnSeekBarChangeListener observer =
            new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                    if (seekBar.getId() == R.id.gasoline_price_seekbar){
                        precoGasolina = progress / 100.;
                    }
                    else{
                        precoEtanol = progress / 100.;
                    }
                    calcular();
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            };
}
