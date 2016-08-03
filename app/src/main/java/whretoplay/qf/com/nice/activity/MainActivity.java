package whretoplay.qf.com.nice.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import whretoplay.qf.com.nice.R;
import whretoplay.qf.com.nice.fragment.FragmentChat;
import whretoplay.qf.com.nice.fragment.FragmentDiscover;
import whretoplay.qf.com.nice.fragment.FragmentMain;
import whretoplay.qf.com.nice.fragment.FragmentMe;

public class MainActivity extends AppCompatActivity{


    List<Fragment> fragmentList=new ArrayList<>();
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    @BindView(R.id.rb_main)
    RadioButton radioButton_main;
    @BindView(R.id.rb_discover)
    RadioButton radioButton_discover;
    @BindView(R.id.rb_chat)
    RadioButton radioButton_chat;
    @BindView(R.id.rb_me)
    RadioButton radioButton_me;
    @BindView(R.id.rb_photo)
    RadioButton radioButton_photo;
    private boolean isFirst = true;
    private long t1;

    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(MainActivity.this);

      initfragment();


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_main:
                       selectFragment(0);
                        radioButton_main.setChecked(true);
                        break;
                    case R.id.rb_discover:
                        selectFragment(1);
                        radioButton_discover.setChecked(true);
                        break;
                    case R.id.rb_chat:
                        selectFragment(2);
                        radioButton_chat.setChecked(true);
                        break;
                    case R.id.rb_me:
                        selectFragment(3);
                        radioButton_me.setChecked(true);
                        break;
                    case R.id.rb_photo:
                        Intent intent=new Intent(MainActivity.this,CameraActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });

    }

    private void initfragment() {
        fragmentList.add(new FragmentMain());
        fragmentList.add(new FragmentDiscover());
        fragmentList.add(new FragmentChat());
        fragmentList.add(new FragmentMe());
        manager=getSupportFragmentManager();
        FragmentTransaction ft=manager.beginTransaction();
        ft.add(R.id.main_fragment_container,fragmentList.get(3));
        ft.add(R.id.main_fragment_container,fragmentList.get(1));
        ft.add(R.id.main_fragment_container,fragmentList.get(2));
        ft.add(R.id.main_fragment_container,fragmentList.get(0));
        ft.commit();
    }

    private void selectFragment(int num){
        FragmentTransaction ft=manager.beginTransaction();
        for (int i=0;i<fragmentList.size();i++){
            if (i==num){
                ft.show(fragmentList.get(i));
            }else {
                ft.hide(fragmentList.get(i));
            }
        }
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        if (isFirst) {
            t1 = System.currentTimeMillis();
            Toast.makeText(this, "再一次点击退出", Toast.LENGTH_SHORT).show();
            isFirst = false;
        } else if (!isFirst) {
            long t2 = System.currentTimeMillis();
            if ((t2 - t1) > 2000) {
                isFirst = true;
            } else {
                super.onBackPressed();
            }
        }
    }


}
