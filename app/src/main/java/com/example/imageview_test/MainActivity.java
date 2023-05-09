package com.example.imageview_test;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


        public static final int Code_Req_for_CAMERA = 1;
        public static final int GALERI_PICTURE = 2;

    // public static final int CAMERA_REQUEST_CODE = 102;
//     public static final int CAMERA_PERM_CODE = 101;

    ImageView lihatfoto;
    Button btnkamera, btngaleri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lihatfoto = findViewById(R.id.lihatfoto);
        btnkamera = findViewById(R.id.btnkamera);
        btngaleri = findViewById(R.id.btngaleri);

        btnkamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Ambilgambar = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(Ambilgambar, Code_Req_for_CAMERA);
            }
        });

        btngaleri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Pilihgambar = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(Pilihgambar, GALERI_PICTURE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
      if (requestCode == GALERI_PICTURE) {
          Uri uri = data.getData();
          lihatfoto.setImageURI(uri);
      } else if (requestCode == Code_Req_for_CAMERA) {
          Bitmap img = (Bitmap) data.getExtras().get("data");
          lihatfoto.setImageBitmap(img);
      }
    }
}

//        btnkamera.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent Ambilgambar = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(Ambilgambar, Code_Req_for_CAMERA);
//            }
//        });
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//            if(requestCode==Code_Req_for_CAMERA){
//                Bitmap img = (Bitmap) data.getExtras().get("data");
//                lihatfoto.setImageBitmap(img);
//            }
//        }
//    }

//        btnkamera.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                kameraPermission();
//            }
//        });
//        btngaleri.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//    }
//
//    private void kameraPermission() {
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, CAMERA_PERM_CODE);
//        } else {
//            openCamera();
//        }
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == CAMERA_PERM_CODE) {
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                openCamera();
//            } else {
//                Toast.makeText(this, "Camera field open,use permision", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//
//    private void openCamera() {
//        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        startActivityForResult(camera, CAMERA_REQUEST_CODE);
//    }
//
//}

