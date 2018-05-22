package com.example.prachu.thanos;

import android.graphics.Color;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public Button b1,b2;
    TextView tv1,tv2,tv3;
    String tv22;
    public int n;
    public int a[]={0,0,0,0,0,0};
    String stones="list of stones obtained :",obb=" ";
    RelativeLayout rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     b1=(Button)findViewById(R.id.button1);
     b2=(Button)findViewById(R.id.button2);

     tv1=(TextView)findViewById(R.id.textView);
     tv2=(TextView)findViewById(R.id.textView2);
     tv3=(TextView)findViewById(R.id.textView3);


     rl=(RelativeLayout)findViewById(R.id.relativeLayout);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    for(int j=1;j>0;j++)
                    {
                        Random r= new Random();
                        n= r.nextInt(6);
                        if(a[0]==1 && a[1]==1 && a[2]==1 && a[3]==1 && a[4]==1 && a[5]==1 ) {
                            tv1.setText("! hurray you have collected all stones !");
                            break;
                        }
                        if(a[n]==0)
                        {
                           switch(n)
                           {
                               case 0: { obb="Power stone ";
                                   rl.setBackgroundColor(Color.parseColor("#1D3AC9"));
                               break; }
                               case 1: { obb="space stone ";
                               rl.setBackgroundColor(Color.parseColor("#7EE1F5"));
                               break; }
                               case 2: { obb="Time stone ";
                               rl.setBackgroundColor(Color.parseColor("#34F61D"));
                               break; }
                               case 3: { obb="Reality stone ";
                               rl.setBackgroundColor(Color.parseColor("#E62630"));
                               break;  }
                               case 4:{  obb="soul stone ";
                               rl.setBackgroundColor(Color.parseColor("#FB4925"));
                               break; }
                               case 5: { obb="Mind stone";
                               rl.setBackgroundColor(Color.parseColor("#F8ED23"));
                               break;  }
                           }
                           a[n]=1;
                            if(a[0]==1 && a[1]==1 && a[2]==1 && a[3]==1 && a[4]==1 && a[5]==1 ) {
                                tv1.setText("! hurray you have collected all stones !");
                                stones= stones+"\n" + obb;
                                break;
                            }
                           stones= stones+"\n" + obb;
                           break;
                        }
                    }
                    tv2.setText(" "+ stones);
                    tv3.setText("You Have got the "+ obb);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText(" ");
                tv2.setText(" list of stones obtained : ");
                tv3.setText("stone obtained now is : ");
                rl.setBackgroundColor(Color.parseColor("#f8e0a9"));
                a[0]=0;a[1]=0;a[2]=0;a[3]=0;a[4]=0;a[5]=0;
                stones="List of stones obtained : ";
            }
        });
    }


    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        tv22 = tv3.getText().toString();

        outState.putString("textview2",stones);
        outState.putString("textview3",tv22);
        outState.putInt("array0",a[0]);
        outState.putInt("array1",a[1]);
        outState.putInt("array2",a[2]);
        outState.putInt("array3",a[3]);
        outState.putInt("array4",a[4]);
        outState.putInt("array5",a[5]);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);

       stones = savedInstanceState.getString("textview2");
       tv2.setText(stones);

        tv3.setText(savedInstanceState.getString("textview3"));
       a[0]= savedInstanceState.getInt("array0");
        a[1]= savedInstanceState.getInt("array1");
        a[2]= savedInstanceState.getInt("array2");
        a[3]= savedInstanceState.getInt("array3");
        a[4]= savedInstanceState.getInt("array4");
        a[5]= savedInstanceState.getInt("array5");

    }
}
