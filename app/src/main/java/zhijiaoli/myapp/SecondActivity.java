package zhijiaoli.com.app;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TimePicker;
import android.widget.Toast;

import static android.view.View.VISIBLE;

public class SecondActivity extends Activity {


    private RatingBar rbScore;
    private SeekBar  skbChina;
    private ImageButton ibDream;
    private ProgressBar pbTime;
    private DatePicker  dpDate;
    private TimePicker tpTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


           rbScore = (RatingBar) findViewById(R.id.rbScore);
           skbChina = (SeekBar)  findViewById(R.id.skbChina);
          ibDream =(ImageButton) findViewById(R.id.ibDream);
           pbTime = (ProgressBar) findViewById(R.id.pbTime);
          dpDate = (DatePicker) findViewById(R.id.dpDate);
          tpTime = (TimePicker) findViewById(R.id.tpTime);

        rbScore.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(SecondActivity.this,"你给自己的评分是"+v+"颗星",Toast.LENGTH_SHORT).show();
            }
        });

        skbChina.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
               // tvChina.setText("中华名族的伟大复兴的进度是："+i);
                Toast.makeText(SecondActivity.this,"中华名族的伟大复兴进度是："+i,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ibDream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Toast.makeText(SecondActivity.this,"很好",Toast.LENGTH_SHORT).show();
                pbTime.setVisibility(VISIBLE);
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();
            }
        });

        dpDate.init(2017, 5, 5, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                Toast.makeText(SecondActivity.this,"你选取的时间是"+i+"-"+(i1+1)+"-"+i2,Toast.LENGTH_SHORT).show();
            }
        });
        
       tpTime.setIs24HourView(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            tpTime.setHour(17);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            tpTime.setMinute(23);
        }
        tpTime.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                Toast.makeText(SecondActivity.this,"你选取的时间是"+i+":"+i1,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
