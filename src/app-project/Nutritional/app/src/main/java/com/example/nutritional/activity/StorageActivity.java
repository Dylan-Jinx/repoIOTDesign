package com.example.nutritional.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nutritional.R;
import com.example.nutritional.fragment.storage.StorageFragment1;
import com.example.nutritional.fragment.storage.StorageFragment2;
import com.example.nutritional.util.FragmentUtils;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author 69182
 */
public class StorageActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText storageProductinfo;
    private Button storageBtn;
    private Button storageAddUpdate;
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
        initView();
    }

    private void initView() {
        storageProductinfo = (EditText) findViewById(R.id.storage_id);
        storageBtn = (Button) findViewById(R.id.storage_btn);
        FragmentUtils.ReplaceFragment(getSupportFragmentManager(), R.id.storage_frame, new StorageFragment1());
        storageBtn.setOnClickListener(this);
        storageAddUpdate = (Button) findViewById(R.id.storage_add_update);
        storageAddUpdate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.storage_btn:
                submit();
                break;
            default:
            case R.id.storage_add_update:
                startActivity(new Intent(StorageActivity.this,StorageOperationActivity.class));
                break;
        }
    }

    private void submit() {
        // validate
        String productinfo = storageProductinfo.getText().toString().trim();
        if (TextUtils.isEmpty(productinfo)) {
            Toast.makeText(this, "productinfo不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        flag++;
        FragmentUtils.ReplaceFragment(getSupportFragmentManager(), R.id.storage_frame, new StorageFragment2());

    }

    @Override
    public void onBackPressed() {
        if (flag==0){
            finish();
        }else {
            FragmentUtils.ReplaceFragment(getSupportFragmentManager(), R.id.storage_frame, new StorageFragment1());
            flag=0;
        }
    }
}