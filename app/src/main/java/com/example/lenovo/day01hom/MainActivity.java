package com.example.lenovo.day01hom;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.lenovo.day01hom.Fragment.Fragmentgan3;
import com.example.lenovo.day01hom.Fragment.Fragmentxitu4;
import com.example.lenovo.day01hom.Fragment.WeiXingFragment2;
import com.example.lenovo.day01hom.Fragment.ZhuihuFragment1;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar tb;
    private NavigationView nv;
    private DrawerLayout dl;
    private FrameLayout fl;
    private ArrayList<Fragment> fragments;
    private FragmentManager sf;
    private FragmentTransaction transaction;


    //姓名：刘楠，班级：H1809A.。。。。。
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        fragments = new ArrayList<>();
        fragments.add(new ZhuihuFragment1());
        fragments.add(new WeiXingFragment2());
        fragments.add(new Fragmentgan3());
        fragments.add(new Fragmentxitu4());

    }

    private void initFM(int position) {

    }

    private void initView() {
        tb = (Toolbar) findViewById(R.id.tb);
        nv = (NavigationView) findViewById(R.id.nv);
        dl = (DrawerLayout) findViewById(R.id.dl);
        fl = (FrameLayout) findViewById(R.id.fl);
        tb.setTitle("");
        setSupportActionBar(tb);
        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, dl, tb, R.string.app_name, R.string.app_name);
        toggle.syncState();
        nv.setItemIconTintList(null);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.n1) {
                    Fragment fragment = fragments.get(0);
                    sf = getSupportFragmentManager();
                    transaction = sf.beginTransaction();
                    transaction.replace(R.id.fl,fragment);
                    transaction.commit();
                    tb.setTitle("知乎");
                    dl.closeDrawer(Gravity.LEFT);
                }
                if (item.getItemId() == R.id.n2) {
                    Fragment fragment1 = fragments.get(1);
                    FragmentManager sf1 = getSupportFragmentManager();
                    FragmentTransaction transaction1 = sf1.beginTransaction();
                    transaction1.replace(R.id.fl,fragment1);
                    transaction1.commit();
                    tb.setTitle("微信精选");
                    dl.closeDrawer(Gravity.LEFT);
                }
                if (item.getItemId() == R.id.n3) {
                    Fragment fragment2 = fragments.get(2);
                    FragmentManager sf2 = getSupportFragmentManager();
                    FragmentTransaction transaction2 = sf2.beginTransaction();
                    transaction2.replace(R.id.fl,fragment2);
                    transaction2.commit();
                    tb.setTitle("干活集中营");
                    dl.closeDrawer(Gravity.LEFT);
                }
                if (item.getItemId() == R.id.n4) {
                    Fragment fragment3 = fragments.get(3);
                    FragmentManager sf3 = getSupportFragmentManager();
                    FragmentTransaction transaction3 = sf3.beginTransaction();
                    transaction3.replace(R.id.fl,fragment3);
                    transaction3.commit();
                    tb.setTitle("稀土掘金");
                    dl.closeDrawer(Gravity.LEFT);
                }

                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
getMenuInflater().inflate(R.menu.menu_item,menu);
        return super.onCreateOptionsMenu(menu);
    }


}
