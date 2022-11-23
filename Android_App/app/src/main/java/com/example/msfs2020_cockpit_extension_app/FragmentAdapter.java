package com.example.msfs2020_cockpit_extension_app;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class FragmentAdapter extends FragmentStateAdapter {

    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new ElectricalFragment();
            case 2:
                return new MonitorFragment();
            case 3:
                return new AutopilotFragment();
            case 4:
                return new CJ4_FMC_Fragment();
            default:
                return new Inibuilds_A310_Fragment();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}