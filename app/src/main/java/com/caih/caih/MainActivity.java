package com.caih.caih;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;

import com.caih.fragment.Chtk_Frag;
import com.caih.fragment.Grzx_Frag;
import com.caih.fragment.Kczx_frag;
import com.caih.fragment.Xxzx_Frag;

/**
 * Created by Administrator on 2016/5/27.
 */
public class MainActivity extends FragmentActivity  implements View.OnClickListener{

    FragmentManager manager;
    private RadioButton kczx;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.main_frag, new Kczx_frag());

        findId();

        transaction.commit();
    }

    private void findId() {
        kczx = (RadioButton) findViewById(R.id.kczx);
        RadioButton chtk = (RadioButton) findViewById(R.id.chtk);
        RadioButton xxzx = (RadioButton) findViewById(R.id.xxzx);
        RadioButton grzx = (RadioButton) findViewById(R.id.grzx);
        //监听
        kczx.setOnClickListener(this);
        chtk.setOnClickListener(this);
        xxzx.setOnClickListener(this);
        grzx.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.kczx://替换
                FragmentTransaction transaction1 = manager.beginTransaction();
                transaction1.replace(R.id.main_frag, new Kczx_frag()).commit();
                break;
            case R.id.chtk:
                FragmentTransaction transaction2 = manager.beginTransaction();
                transaction2.replace(R.id.main_frag, new Chtk_Frag()).commit();
                break;
            case R.id.xxzx:
                FragmentTransaction transaction3 = manager.beginTransaction();
                transaction3.replace(R.id.main_frag, new Xxzx_Frag()).commit();
                break;
            case R.id.grzx:
                FragmentTransaction transaction4 = manager.beginTransaction();
                transaction4.replace(R.id.main_frag, new Grzx_Frag()).commit();
                break;


        }
    }
}
