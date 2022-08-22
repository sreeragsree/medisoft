package com.example.medisoft.Purchase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.medisoft.BaseActivity;
import com.example.medisoft.MainActivity;
import com.example.medisoft.R;
import com.example.medisoft.Utils.AppUtils;
import com.example.medisoft.databinding.ActivityPurchaseOrderBinding;

public class PurchaseOrderActivity extends BaseActivity implements View.OnClickListener {

    ActivityPurchaseOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPurchaseOrderBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        AppUtils.setSystemBarColor(this, R.color.white);
        AppUtils.setSystemBarLight(this);
        initViews(binding);
    }

    private void initViews(ActivityPurchaseOrderBinding binding) {
        binding.tbCommon.ivLogout.setVisibility(View.GONE);
        binding.tbCommon.tbHead.setText("Purchase Order Activity");
        binding.tbCommon.ivMenu.setBackgroundResource(R.drawable.ic_baseline_arrow_back_24);
        binding.tbCommon.ivMenu.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.iv_menu:
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
        }

    }
}