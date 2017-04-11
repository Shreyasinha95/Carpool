package com.team43.carpool;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MyProfile extends AppCompatActivity {

    Toolbar toolbar;
    private static int RESULT_LOAD_IMAGE = 1;
    Button uploadAC;
    Button uploadDL;
     int flag =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        try {

            setSupportActionBar(toolbar);
            setTitle("My Profile");


        } catch (Throwable t) {

            // WTF
        }
        uploadAC = (Button)findViewById(R.id.ac);
        uploadAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
               // uploadAC.setText("Uploaded AC!");
                //Toast.makeText(MyProfile.this, "Uploaded",
                        //Toast.LENGTH_LONG).show();
                flag=1;
            }
        });

        uploadDL = (Button)findViewById(R.id.uploadDl);
        uploadDL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
               // uploadDL.setText("Uploaded DL!");
                //Toast.makeText(MyProfile.this, "Uploaded",
                        //Toast.LENGTH_LONG).show();
                flag =2;
            }
        });

        Button verify = (Button)findViewById(R.id.verify);
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent2 = new Intent(MyProfile.this,MainActivity.class);
                startActivity(intent2);
            }
        });

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /*if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContentResolver().query(selectedImage,filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            ImageView imageView = (ImageView) findViewById(R.id.imgView);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));


        }*/
        if(flag==1) {
            uploadAC.setVisibility(View.INVISIBLE);
            TextView showac = (TextView) findViewById(R.id.showac);
            showac.setText("Uploaded AC!");
        }
        if(flag==2){
            uploadDL.setVisibility(View.INVISIBLE);
        TextView showdl =(TextView)findViewById(R.id.showdl);
        showdl.setText("Uploaded DL!");}
    }
}
