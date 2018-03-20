package ca.sharipov.sergey.roundedimageview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    private static final int MIN_RADIUS = 2;

    private CardView cardViewForImage;
    private SeekBar seekBarSize;

    private float radius = MIN_RADIUS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ImageView roundedImageView = findViewById(R.id.rounded_image_view);
        cardViewForImage = findViewById(R.id.card_view_for_image);

        setupSeekBarSize();
        setupSeekBarRadius();

        setupRadioGroup();
    }

    private void setupRadioGroup() {
        RadioGroup radioGroup = findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (radioGroup.getCheckedRadioButtonId()) {
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

    private void setupSeekBarSize() {
        seekBarSize = findViewById(R.id.seek_bar_size);

        seekBarSize.setMax(100);

        int progress = 50;
        seekBarSize.setProgress(progress);
        setRoundedImageViewSize(progress * 5);

        seekBarSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
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
        cardViewForImage.setRadius(size / radius);

        ViewGroup.LayoutParams params = cardViewForImage.getLayoutParams();
        params.width = size;
        params.height = size;
        cardViewForImage.setLayoutParams(params);
    }

    private void setupSeekBarRadius() {
        SeekBar seekBarRadius = findViewById(R.id.seek_bar_radius);

        seekBarRadius.setMax(20);

        seekBarRadius.setProgress(0);

        seekBarRadius.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                radius = (float) (i / 2) + MIN_RADIUS;
                setRoundedImageViewSize(seekBarSize.getProgress() * 5);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
}
