package com.example.medisoft.Purchase;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.medisoft.BaseActivity;
import com.example.medisoft.MainActivity;
import com.example.medisoft.Model.Example;
import com.example.medisoft.Model.SupplierByClient;
import com.example.medisoft.R;
import com.example.medisoft.Retrofit.APIClient;
import com.example.medisoft.Retrofit.GetResult;
import com.example.medisoft.Utils.AppPreference;
import com.example.medisoft.Utils.AppUtils;
import com.example.medisoft.Utils.MyApplication;
import com.example.medisoft.databinding.ActivityPurchaseOrderBinding;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class PurchaseOrderActivity extends BaseActivity implements View.OnClickListener, GetResult.MyListener {

    ActivityPurchaseOrderBinding binding;
    ArrayList<String> ar = new ArrayList<String>();
    List<SupplierByClient> supplier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPurchaseOrderBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getAllSupplierbyClient();
        AppUtils.setSystemBarColor(this, R.color.white);
        AppUtils.setSystemBarLight(this);
        initViews(binding);
    }

    private void initViews(ActivityPurchaseOrderBinding binding) {

        binding.autoCompleteTextView.setTextColor(Color.RED);
        binding.tbCommon.ivLogout.setVisibility(View.GONE);
        binding.tbCommon.tbHead.setText("Purchase Order Activity");
        binding.tbCommon.ivMenu.setBackgroundResource(R.drawable.ic_baseline_arrow_back_24);
        binding.tbCommon.ivMenu.setOnClickListener(this);

    }

    private void getAllSupplierbyClient() {
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("ClientID", AppPreference.getInstance(MyApplication.mContext).getString(AppPreference.CLIENTID));
            JsonParser jsonParser = new JsonParser();
            Call<JsonObject> call = APIClient.getInterface().getAllSupplierbyClient((JsonObject) jsonParser.parse(jsonObject.toString()));
            GetResult getResult = new GetResult();
            getResult.setMyListener(this);
            getResult.onNCHandle(call, "login");
        } catch (JSONException e) {
            e.printStackTrace();
        }
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

    @Override
    public void callback(JsonObject result, String callNo) {
        Gson gson = new Gson();
        Example example = gson.fromJson(result.toString(), Example.class);
        supplier = new ArrayList<>();
        if (example.getResultData().getSuppliern() != null) {
            supplier = example.getResultData().getSuppliern();
            for (SupplierByClient sn : supplier) {
                ar.add(sn.getSupplierName());
                Log.d("==",sn.getSupplierName());

            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>
                    (this, android.R.layout.select_dialog_item, ar);
            binding.autoCompleteTextView.setThreshold(1);//will start working from first character
            binding.autoCompleteTextView.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView

        }

    }
}