package com.example.msfs2020_cockpit_extension_app;

import android.os.Bundle;
import android.view.WindowManager;

import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity {

    private static final int[] TAB_TITLES = new int[]{
            R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3, R.string.tab_text_4, R.string.tab_text_5};
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    FragmentAdapter fragmentAdapter;
    private SimVarViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager2 = findViewById(R.id.view_pager2);

        FragmentManager fm = getSupportFragmentManager();
        fragmentAdapter = new FragmentAdapter(fm, getLifecycle());
        viewPager2.setAdapter(fragmentAdapter);

        // Add the tabs
        tabLayout.addTab(tabLayout.newTab().setText(TAB_TITLES[4]));
        tabLayout.addTab(tabLayout.newTab().setText(TAB_TITLES[0]));
        tabLayout.addTab(tabLayout.newTab().setText(TAB_TITLES[1]));
        tabLayout.addTab(tabLayout.newTab().setText(TAB_TITLES[2]));
        tabLayout.addTab(tabLayout.newTab().setText(TAB_TITLES[3]));

        // Tab selected listener
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(@NonNull TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        // Swipe page callback
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

        viewPager2.setUserInputEnabled(false);          // Disable the swiping feature

    }
}