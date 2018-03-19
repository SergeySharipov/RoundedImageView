package ca.sharipov.sergey.roundedimageview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private CardView cardViewForImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ImageView roundedImageView = findViewById(R.id.rounded_image_view);
        cardViewForImage = findViewById(R.id.card_view_for_image);

        setupSeekBar();

        setupRadioGroup();
    }

    private void setupRadioGroup() {
        RadioGroup radioGroup = findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.radio_btn_no_rings:
                        cardViewForImage.setForeground(null);
                        break;
                    case R.id.radio_btn_one_ring:
                        cardViewForImage.setForeground(getResources().getDrawable(R.drawable.one_ring));
                        break;
                    case R.id.radio_btn_two_rings:
                        cardViewForImage.setForeground(getResources().getDrawable(R.drawable.two_rings));
                        break;
                }
            }
        });
    }

    private void setupSeekBar() {
        SeekBar seekBar = findViewById(R.id.seek_bar);

        seekBar.setMax(100);

        int progress = 50;
        seekBar.setProgress(progress);
        setRoundedImageViewSize(progress * 5);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                setRoundedImageViewSize(i * 5);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    void setRoundedImageViewSize(int size) {
        cardViewForImage.setRadius(size / 2);

        ViewGroup.LayoutParams params = cardViewForImage.getLayoutParams();
        params.width = size;
        params.height = size;
        cardViewForImage.setLayoutParams(params);
    }
}
