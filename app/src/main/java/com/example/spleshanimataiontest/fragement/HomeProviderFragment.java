package com.example.spleshanimataiontest.fragement;

import androidx.fragment.app.Fragment;

public class HomeProviderFragment extends Fragment {

    /*MainActivity mainActivity;
    Context mContext;

    Unbinder unbinder;
    BottomNavigationView navigation;

//    @BindView(R.id.fab_provider)
//    FloatingActionButton fabProvider;

    *//*public void CategoryFragment(MainActivity mainActivity, Context mContext) {
        this.mainActivity = mainActivity;
        this.mContext = mContext;

        Log.i("tag", "click  1 ");
    }*//*

    public void BookingLeadListFragment(MainActivity mainActivity, Context mContext) {
        this.mainActivity = mainActivity;
        this.mContext = mContext;
        Log.i("tag", "click  1 ");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View mView = inflater.inflate(R.layout.fragment_home_provider, container, false);
        unbinder = ButterKnife.bind(this, mView);
        navigation = mView.findViewById(R.id.navigation);

        return mView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("tag", "click  3 ");
        unbinder.unbind();
    }

    public void init() {
        Log.i("tag", "in init function 1 ");
        Context context = null;
        context = getContext();
        //mPager = (ViewPager) findViewById(R.id.pager);
        //mPager.setAdapter(new SlidingImage_Adapter(context, urls));
        Log.i("tag", "in init function  after set  adaptor 2 ");
//        CirclePageIndicator indicator = (CirclePageIndicator) findViewById(R.id.indicator);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(new BookingLeadListFragment());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_my_lead:
                    fragment = new BookingLeadListFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_pending:
                    fragment = new PendingLeadFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_order:
                    fragment = new OrderFragment();
                    loadFragment(fragment);
                    return true;
               *//* case R.id.navigation_earn:
                    fragment = new EarningFragment();
                    loadFragment(fragment);
                    return true;*//*
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }*/
}
