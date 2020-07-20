package com.example.spleshanimataiontest.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spleshanimataiontest.R;
import com.example.spleshanimataiontest.datamodel.ListItem;

import java.util.List;

import butterknife.BindView;

public class HomeFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public List<ListItem> listItemList;
    private RecyclerView recyclerView;
    private HomeViewModel homeViewModel;
    @BindView(R.id.rvBookLeadlist)
    public RecyclerView rvBookLeadlist;
    GridLayoutManager gridLayoutManager;

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home_tab, container, false);

        try {
            gridLayoutManager = new GridLayoutManager(getActivity(), 3);
            rvBookLeadlist.setLayoutManager(gridLayoutManager);

            setdata();

            MyAdapter myadapterflag = new MyAdapter();
            Log.e("tag", "before generate flag");
//                    myadapterflag.generateCartFlag();
            Log.e("tag", "after generate flag");
            MyAdapter adapter = new MyAdapter(listItemList);
            Log.e("tag", "after  adapter call");
            recyclerView.setAdapter(adapter);
            Log.e("tag", "after  recycle call");
        } catch (Exception e) {
            Log.e("tejas","problem in myadapter : - "+e.getMessage());
        }

        return root;
    }

    public void setdata() {
        listItemList.add(new ListItem("jack", "food", "    23-5-2020", "    100", "    7:12", "    new", "    145", "    5"));
        listItemList.add(new ListItem("ram", "juce", "  23-5-2020", "    11", "    7:12", "    new", "    45", "    5"));
        listItemList.add(new ListItem("manish", "meal", "  23-5-2020", "    147", "    7:12", "    ongoing", "    545", "    5"));
        listItemList.add(new ListItem("tejas", "meet", "  23-5-2020", "    587", "    7:12", "    ongoing", "    445", "    5"));
        listItemList.add(new ListItem("dev", "gabage", "  23-5-2020", "    75", "    7:12", "    complete", "    450", "    5"));
        listItemList.add(new ListItem("nikunj", "full dish", "  23-5-2020", "    45", "    7:12", "    status", "    22", "    10"));


    }
}