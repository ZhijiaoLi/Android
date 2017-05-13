package zhijiaoli.myapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btDecMoney;
    private Button btAddMoney;
    private TextView tvMoney;
    private EditText etGoalMoney;
    private int  num=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etGoalMoney =(EditText)findViewById(R.id.etGoalMoney);
        btAddMoney = (Button) findViewById(R.id.btAddMoney);
        btDecMoney = (Button) findViewById(R.id.btDecMoney);
        tvMoney = (TextView) findViewById(R.id.tvMoney);
       String strInputMoney = etGoalMoney.getText().toString().trim();
         final int iMoney = Integer.parseInt(strInputMoney);
        btAddMoney.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if (iMoney == num){
                    Toast.makeText(MainActivity.this,"你已经达到目标",Toast.LENGTH_SHORT).show();
                }else{
                    num++;
                    tvMoney.setText("你现在有"+num+"元");
                }
            }
        });
        btDecMoney.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if (num == 0){
                    Toast.makeText(MainActivity.this,"你已经破产了，别点了",Toast.LENGTH_SHORT).show();
                }else{
                    num--;
                    tvMoney.setText("你现在有"+num+"元");
                }
            }
        });



    }
}
