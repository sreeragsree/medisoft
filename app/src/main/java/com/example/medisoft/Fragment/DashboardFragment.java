package com.example.medisoft.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.medisoft.Purchase.PurchaseOrderActivity;
import com.example.medisoft.R;
import com.example.medisoft.Utils.AppPreference;
import com.example.medisoft.Utils.MyApplication;
import com.example.medisoft.databinding.FragmentDashboardBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardFragment extends Fragment implements View.OnClickListener {

    FragmentDashboardBinding binding;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DashboardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DashboardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DashboardFragment newInstance(String param1, String param2) {
        DashboardFragment fragment = new DashboardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        initViews(binding);
        binding.purchaseLt.setOnClickListener(this);
        return binding.getRoot();
    }

    private void initViews(FragmentDashboardBinding binding) {
        if (AppPreference.getInstance(MyApplication.mContext).getString(AppPreference.CLIENTNAME).isEmpty()) {
            binding.tvClientname.setText("MEDISOFT");
            binding.tvClientType.setText("Account Type : Admin");
        } else {
            binding.tvClientId.setText("ClientID : " + AppPreference.getInstance(MyApplication.mContext).getString(AppPreference.CLIENTID));
            binding.tvClientname.setText(AppPreference.getInstance(MyApplication.mContext).getString(AppPreference.CLIENTNAME));
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.purchase_lt:

                startActivity(new Intent(getActivity(), PurchaseOrderActivity.class));
                getActivity().finish();

                break;
        }

    }
}