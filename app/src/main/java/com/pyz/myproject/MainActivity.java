package com.pyz.myproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private static final String TAG = "MainActivity";
    private RadioButton btn1, btn2, btn3, btn4;
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    private Fragment4 fragment4;

    private Fragment mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup navigation = (RadioGroup) findViewById(R.id.navigation);
        if (navigation != null) {
            navigation.setOnCheckedChangeListener(this);
        }

        btn1 = (RadioButton) findViewById(R.id.fragment1);
        btn2 = (RadioButton) findViewById(R.id.fragment2);
        btn3 = (RadioButton) findViewById(R.id.fragment3);
        btn4 = (RadioButton) findViewById(R.id.fragment4);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();

        getSupportFragmentManager().beginTransaction().add(R.id.home_container, fragment1).commit();
        mContent = fragment1;


    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.fragment1:
                btn1.setChecked(true);
                btn2.setChecked(false);
                btn3.setChecked(false);
                btn4.setChecked(false);
                switchFragment(fragment1);
                break;
            case R.id.fragment2:
                btn1.setChecked(false);
                btn2.setChecked(true);
                btn3.setChecked(false);
                btn4.setChecked(false);
                switchFragment(fragment2);
                break;
            case R.id.fragment3:
                btn1.setChecked(false);
                btn2.setChecked(false);
                btn3.setChecked(true);
                btn4.setChecked(false);
                switchFragment(fragment3);
                break;
            case R.id.fragment4:
                btn1.setChecked(false);
                btn2.setChecked(false);
                btn3.setChecked(false);
                btn4.setChecked(true);
                switchFragment(fragment4);
                break;
        }
    }

    private void switchFragment(Fragment fragment) {
        if (mContent != fragment) {
            if (!fragment.isAdded()) {//判断fragment是否已经添加过
                //先把当前的fragment隐藏，把用到的fragment添加上去
                getSupportFragmentManager().beginTransaction().hide(mContent).add(R.id.home_container, fragment).commit();
            } else {
                //先把当前的fragment隐藏，把已经添加过的并需要用到的fragment显示出
                getSupportFragmentManager().beginTransaction().hide(mContent).show(fragment).commit();
            }
            mContent = fragment;
        }
    }
}
