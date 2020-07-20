package com.example.spleshanimataiontest.adapter;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spleshanimataiontest.fragement.Fragment_Completed_Order;
import com.example.spleshanimataiontest.fragement.Fragment_New_Order;
import com.example.spleshanimataiontest.fragement.Fragment_Ongoing_Order;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
        {
            fragment = new Fragment_New_Order();
        }
        else if (position == 1)
        {
            fragment = new Fragment_Ongoing_Order();
        }
        else if (position == 2)
        {
            fragment = new Fragment_Completed_Order();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "New Order" +"("+")";
        }
        else if (position == 1)
        {
            title = "Ongoing Order";
        }
        else if (position == 2)
        {
            title = "Completed Order";
        }
        return title;
    }
}
