package com.example.nutritional.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.nutritional.R;
import com.example.nutritional.bean.food.AddCookBook;
import com.example.nutritional.util.ConstantsUtils;
import com.example.nutritional.util.HttpUtils;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @author 69182
 */
public class CookOperationActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText cookOperationName;
    private EditText cookOperationFlavour;
    private EditText cookOperationMaterial;
    private EditText cookOperationNutrition;
    private Button cookOperationBtn;
    ExecutorService service;
    AddCookBook addCookBook;
    private Bitmap bitmapSmall, myBitmapImage = null;
    ImageView imageView;
    private Button cookSelect;
    File file;
    private Uri imageUri;
    public static final int TAKE_PHOTO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook_operation);
        initView();
    }

    private void initView() {
        service = newFixedThreadPool(1);

        cookOperationName = (EditText) findViewById(R.id.cook_operation_name);
        cookOperationFlavour = (EditText) findViewById(R.id.cook_operation_flavour);
        cookOperationMaterial = (EditText) findViewById(R.id.cook_operation_material);
        cookOperationNutrition = (EditText) findViewById(R.id.cook_operation_nutrition);
        cookOperationBtn = (Button) findViewById(R.id.cook_operation_btn);
        imageView = findViewById(R.id.cook_operation_img);
        cookSelect = (Button) findViewById(R.id.cook_select);

        cookOperationBtn.setOnClickListener(this);
        cookSelect.setOnClickListener(this);
    }


    public String getPAth(Uri uri) {
        String path = null;
        if (!TextUtils.isEmpty(uri.getAuthority())) {
            Cursor cursor = getContentResolver().query(uri,
                    new String[]{MediaStore.Images.Media.DATA}, null, null, null);
            if (null == cursor) {
                Toast.makeText(this, "图片没找到", Toast.LENGTH_SHORT).show();
                return null;
            }
            cursor.moveToFirst();
            path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            cursor.close();
        } else {
            path = uri.getPath();
            Log.d("ppp", "getPAth: " + path);
        }
        return path;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cook_operation_btn:
                submit();
                break;
            case R.id.cook_select:
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
            imageUri = FileProvider.getUriForFile(CookOperationActivity.this, "com.example.nutritional.fileProvider", outputImage);
        } else {
            // 将File对象转换为Uri对象，这个Uri标识着output_image.jpg这张图片的本地真实路径
            imageUri = Uri.fromFile(outputImage);
        }

        // 动态申请权限
        if (ContextCompat.checkSelfPermission(CookOperationActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) CookOperationActivity.this, new String[]{Manifest.permission.CAMERA}, 100);
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
                        imageView.setImageBitmap(bitmap);
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


    private void submit() {
        addCookBookData();
    }

    private void addCookBookData() {
        service.execute(new Runnable() {
            @Override
            public void run() {
                String name = cookOperationName.getText().toString();
                String flavour = cookOperationFlavour.getText().toString();
                String material = cookOperationMaterial.getText().toString();
                String nutrition = cookOperationNutrition.getText().toString();

                try {
//                    file = new File(getPAth(imageUri));
                    Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                    File outputImage = new File(getExternalCacheDir(), "output_image.jpg");
                    if (outputImage.exists()){
                        outputImage.delete();
                    }
                    outputImage.createNewFile();
                    FileOutputStream fileOutputStream=new FileOutputStream(outputImage);
                    bitmap.compress(Bitmap.CompressFormat.JPEG,50,fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), outputImage);//表单类型

                    //1.创建MultipartBody.Builder对象
                    MultipartBody body = new MultipartBody.Builder()
                            .setType(MultipartBody.FORM)
                            .addFormDataPart("files",""+111+".jpg", requestBody)
                            .build();

                    addCookBook = HttpUtils.okHttpPost1(ConstantsUtils.SERVER_URL_FOOD + ConstantsUtils.Address_AddCookBook
                            + "?cookBookname=" + name + "&flavour=" + flavour + "&material=" + material + "&nutritionalingredient=" + nutrition, body, AddCookBook.class);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(CookOperationActivity.this, addCookBook.getMessage(), Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(CookOperationActivity.this, "没有权限", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }

}