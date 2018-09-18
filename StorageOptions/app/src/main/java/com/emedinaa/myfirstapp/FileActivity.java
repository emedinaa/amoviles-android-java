package com.emedinaa.myfirstapp;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.emedinaa.myfirstapp.storage.FileOperations;
import com.emedinaa.myfirstapp.ui.BaseActivity;

import java.io.File;
import java.io.FileOutputStream;

public class FileActivity extends BaseActivity {
    private static final int EXTERNAL_STORAGE_PERMISSION_CONSTANT = 100;
    private EditText fname,fcontent;
    private Button buttonSave,buttonRead;

    private String currentFile=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        requestPermissions();
        ui();
    }

    private void ui() {
        fname =findViewById(R.id.editTextName);
        fcontent = findViewById(R.id.editTextContent);
        buttonSave = findViewById(R.id.buttonSave);
        buttonRead = findViewById(R.id.buttonRead);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeFile();
            }
        });
        buttonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readFile();
            }
        });
    }

    private void readFile() {
        //if(currentFile==null) return;
        // TODO Auto-generated method stub
        currentFile="Demo";
        String readfilename = currentFile;
        FileOperations fop = new FileOperations();
        String text = fop.read(readfilename);
        if(text != null){
            Toast.makeText(this,text,Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "File not Found", Toast.LENGTH_SHORT).show();
        }

    }

    private void writeFile(){
        String filename = fname.getText().toString();
        String filecontent = fcontent.getText().toString();
        FileOperations fop = new FileOperations();
        fop.write(filename, filecontent);
        if(fop.write(filename, filecontent)){
            currentFile= filename;
            Toast.makeText(getApplicationContext(), filename+".txt created", Toast.LENGTH_SHORT).show();
        }else{
            currentFile=null;
            Toast.makeText(getApplicationContext(), "I/O error", Toast.LENGTH_SHORT).show();
        }
    }


    private void requestPermissions(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED) {

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Need Storage Permission");
                builder.setMessage("This app needs storage permission.");
                builder.setPositiveButton("Grant", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        ActivityCompat.requestPermissions(FileActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.READ_EXTERNAL_STORAGE}, EXTERNAL_STORAGE_PERMISSION_CONSTANT);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
                //ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                //Manifest.permission.READ_EXTERNAL_STORAGE}, EXTERNAL_STORAGE_PERMISSION_CONSTANT);
        }

    }
    //Internal Storage
    private void saveFile(String filename){
        File file = new File(getFilesDir(), filename);
    }

    private void saveAndWriteFile(String filename,String string){

        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //External Storage

    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

    //Delete
    private void removeFile(String fileName){
        deleteFile(fileName);
    }

}
