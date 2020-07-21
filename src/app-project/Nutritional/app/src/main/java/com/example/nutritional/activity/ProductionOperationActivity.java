package com.example.nutritional.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.nutritional.R;
import com.example.nutritional.bean.food.AddCookBook;
import com.example.nutritional.bean.safety.AddProductionBaseInfo;
import com.example.nutritional.util.ConstantsUtils;
import com.example.nutritional.util.HttpUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @author 69182
 */
public class ProductionOperationActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView baseInfo3Img;
    private Button baseInfo3Select;
    private EditText baseInfo3Name;
    private EditText baseInfo3Category;
    private EditText baseInfo3ResponsibleName;
    private EditText baseInfo3Tel;
    private Button baseInfo3Btn;
    ExecutorService service;
    AddProductionBaseInfo addProductionBaseInfo;
    private Uri imageUri;
    public static final int TAKE_PHOTO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_production_operation);
        initView();
    }

    private void initView() {
        service = newFixedThreadPool(1);
        baseInfo3Img = findViewById(R.id.base_info3_img);
        baseInfo3Name = findViewById(R.id.base_info3_name);
        baseInfo3Category = findViewById(R.id.base_info3_category);
        baseInfo3ResponsibleName = findViewById(R.id.base_info3_responsibleName);
        baseInfo3Tel = findViewById(R.id.base_info3_tel);
        baseInfo3Select = findViewById(R.id.base_info3_select);
        baseInfo3Btn = findViewById(R.id.base_info3_btn);

        baseInfo3Select.setOnClickListener(this);
        baseInfo3Btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.base_info3_btn:
                addCookBookData();
                break;
            case R.id.base_info3_select:
                takePhoto();
                break;
            default:
        }
    }

    private void takePhoto() {
        // 创建一个File对象，用于保存摄像头拍下的图片，这里把图片命名为output_image.jpg
        // 并将它存放在手机SD卡的应用关联缓存目录下
        File outputImage = new File(getExternalCacheDir(), "output_image.jpg");

        // 对照片的更换设置
        try {
            // 如果上一次的照片存在，就删除
            if (outputImage.exists()) {
                outputImage.delete();
            }
            // 创建一个新的文件
            outputImage.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 如果Android版本大于等于7.0
        if (Build.VERSION.SDK_INT >= 24) {
            // 将File对象转换成一个封装过的Uri对象
            imageUri = FileProvider.getUriForFile(ProductionOperationActivity.this, "com.example.nutritional.fileProvider", outputImage);
        } else {
            // 将File对象转换为Uri对象，这个Uri标识着output_image.jpg这张图片的本地真实路径
            imageUri = Uri.fromFile(outputImage);
        }

        // 动态申请权限
        if (ContextCompat.checkSelfPermission(ProductionOperationActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) ProductionOperationActivity.this, new String[]{Manifest.permission.CAMERA}, 100);
        } else {
            // 启动相机程序
            startCamera();
        }

    }

    private void startCamera() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        // 指定图片的输出地址为imageUri
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);

        startActivityForResult(intent, TAKE_PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case TAKE_PHOTO:
                if (resultCode == RESULT_OK) {
                    try {
                        // 将图片解析成Bitmap对象
                        InputStream is = getContentResolver().openInputStream(imageUri);
                        Bitmap bitmap = BitmapFactory.decodeStream(is);
                        // 将图片显示出来
                        baseInfo3Img.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            default:
                break;
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void addCookBookData() {
        service.execute(new Runnable() {
            @Override
            public void run() {
                String proname = baseInfo3Category.getText().toString();
                String category = baseInfo3Name.getText().toString();
                String responsiblename = baseInfo3ResponsibleName.getText().toString();
                String tel = baseInfo3Tel.getText().toString();

                try {
//                    file = new File(getPAth(imageUri));
                    Bitmap bitmap = ((BitmapDrawable) baseInfo3Img.getDrawable()).getBitmap();
                    File outputImage = new File(getExternalCacheDir(), "output_image.jpg");
                    if (outputImage.exists()) {
                        outputImage.delete();
                    }
                    outputImage.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(outputImage);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 50, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), outputImage);//表单类型

                    //1.创建MultipartBody.Builder对象
                    MultipartBody body = new MultipartBody.Builder()
                            .setType(MultipartBody.FORM)
                            .addFormDataPart("file", "" + 111+".jpg", requestBody)
                            .build();

                    addProductionBaseInfo = HttpUtils.okHttpPost1(ConstantsUtils.SERVER_URL_SAFETY + ConstantsUtils.Address_AddProductionBaseInfo
                            + "?proname=" + proname + "&category=" + category + "&responsiblename=" + responsiblename + "&tel=" + tel, body, AddProductionBaseInfo.class);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(ProductionOperationActivity.this, addProductionBaseInfo.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 100:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 启动相机程序
                    startCamera();
                } else {
                    Toast.makeText(ProductionOperationActivity.this, "没有权限", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }
}