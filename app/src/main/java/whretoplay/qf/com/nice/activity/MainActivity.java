package whretoplay.qf.com.nice.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import whretoplay.qf.com.nice.R;
import whretoplay.qf.com.nice.adapter.ViewPagerAdapter;
import whretoplay.qf.com.nice.fragment.FragmentChat;
import whretoplay.qf.com.nice.fragment.FragmentDiscover;
import whretoplay.qf.com.nice.fragment.FragmentMain;
import whretoplay.qf.com.nice.fragment.FragmentMe;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    @BindView(R.id.main_viewpager)
    ViewPager viewPager;
    List<Fragment> list = new ArrayList<>();
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
    private boolean isFirst = true;
    private long t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(MainActivity.this);

        list.add(new FragmentMain());
        list.add(new FragmentDiscover());
        list.add(new FragmentChat());
        list.add(new FragmentMe());
        Log.e("---","-----");

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), list);
        viewPager.setOffscreenPageLimit(5);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(this);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_main:
                        viewPager.setCurrentItem(0, false);
//                        stopAnim();
                        radioButton_main.setChecked(true);
                        break;
                    case R.id.rb_discover:
                        viewPager.setCurrentItem(1, false);
//                        stopAnim();
                        radioButton_discover.setChecked(true);
                        break;
                    case R.id.rb_chat:
                        viewPager.setCurrentItem(2, false);
//                        stopAnim();
                        radioButton_chat.setChecked(true);
                        break;
                    case R.id.rb_me:
                        viewPager.setCurrentItem(3, false);
//                        stopAnim();
                        radioButton_me.setChecked(true);
                        break;
                }
            }
        });

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

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i <radioGroup.getChildCount() ; i++) {
            RadioButton childAt= (RadioButton) radioGroup.getChildAt(i);
            if (position==i){
                childAt.setChecked(true);
            }else{
                childAt.setChecked(false);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewPager.removeOnPageChangeListener(this);

    }
}
