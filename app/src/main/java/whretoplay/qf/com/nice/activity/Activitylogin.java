package whretoplay.qf.com.nice.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import whretoplay.qf.com.nice.R;

public class Activitylogin extends AppCompatActivity {
    @BindView(R.id.login_viewpager)
    ViewPager viewPager;
    @BindView(R.id.registered)
    Button registered;
    @BindView(R.id.anotherway)
    Button anotherway;
    @BindView(R.id.haveaccount)
    Button haveaccount;
    Intent intent;
    boolean first=true;
    private SharedPreferences sharedPreferences;
    private final String FILENAME="loglo.db";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitylogin);
        ButterKnife.bind(this);
         intent=new Intent();

        sharedPreferences=getSharedPreferences(FILENAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
       if (sharedPreferences.getBoolean("first",true)){

        editor.putBoolean("first",false);
           editor.commit();
       }else{
           finish();
       }

    }

        @OnClick(R.id.registered)
         public void clickBtn1(View view){
            intent.setClass(this,ActivityWeChat.class);
            startActivity(intent);
        }
    @OnClick(R.id.anotherway)
    public void clickBtn2(View view){

    }
    @OnClick(R.id.haveaccount)
    public void clickBtn3(View view){

    }
}
