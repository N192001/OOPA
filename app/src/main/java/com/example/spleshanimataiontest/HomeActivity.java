package com.example.spleshanimataiontest;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeActivity extends Fragment {
    BottomNavigationView bottomNavigation;
    Unbinder unbinder;
    BottomNavigationView navigation;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View mView = inflater.inflate(R.layout.activity_home, container, false);
        unbinder = ButterKnife.bind(this, mView);
        navigation = mView.findViewById(R.id.nav_view);

        return mView;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("tag", "click  3 ");
        unbinder.unbind();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        loadFragment(new HomeActivity());
    }



    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_host_fragment, fragment);
        transaction.commit();
    }


}
