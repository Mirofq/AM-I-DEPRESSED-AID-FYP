package com.example.android.depressiontest;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

public class FragmentVoice extends AppCompatActivity {

    private Button recordButton;
    private TextView recordText;
    private TextView checkmic;
    private MediaRecorder mediaRecorder;
    private String fileName = null;
    private StorageReference storage;
    private ProgressDialog progressDialog;
    private File instanceRecord;

    FirebaseAuth fAuth;
    String userID;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_voice);
        recordButton = findViewById(R.id.record_button);
        recordText = findViewById(R.id.record_text);
        checkmic = findViewById(R.id.checkmic);
        storage = FirebaseStorage.getInstance().getReference();
        progressDialog = new ProgressDialog(this);

        fAuth = FirebaseAuth.getInstance();


        //check permissions and request Marshmallow permissions
        int MyVersion = Build.VERSION.SDK_INT;
        if (MyVersion > Build.VERSION_CODES.LOLLIPOP_MR1) {
            if (!checkIfAlreadyhavePermission()) {
                requestForSpecificPermission();
            }
        }

        fileName = Environment.getExternalStorageDirectory().getAbsolutePath() + "/AudioRecording.3gp";
        instanceRecord = new File(fileName);
        if(!instanceRecord.exists()){
            try {
                instanceRecord.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        recordButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, final MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    startRecording();
                    recordText.setText("Recording started ....");
                    checkmic.setVisibility(View.VISIBLE);

                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    recordText.setText("Recording stopped .....");
                    stopRecording();
                    checkmic.setVisibility(View.INVISIBLE);
                    Intent i=new Intent(getApplicationContext(), VoiceActivity.class);
                    startActivity(i);
                }

                return false;
            }
        });
    }

    private boolean checkIfAlreadyhavePermission() {
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int result2 = ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO);
        if (result == PackageManager.PERMISSION_GRANTED && result2 == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    private void requestForSpecificPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO}, 101);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 101:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //granted
                } else {
                    //not granted
                    Toast.makeText(FragmentVoice.this, "Permission denied ", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void startRecording() {

        Log.i("statuss","startRecording ");
        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        mediaRecorder.setOutputFile(fileName);

        try {
            mediaRecorder.prepare();
        } catch (IOException e) {
            Log.i("statuss", "prepare() failed ");

        }

        mediaRecorder.start();

    }

    private void stopRecording() {

        if (mediaRecorder != null) {
            try {
                mediaRecorder.stop();
            } catch(RuntimeException e) {
                instanceRecord.delete();  //you must delete the outputfile when the recorder stop failed.
            } finally {
                mediaRecorder.release();
                mediaRecorder = null;
                uploadAudio();
            }

        }


    }


    private void uploadAudio() {
        progressDialog.setMessage("Loading ..");
        progressDialog.show();

        userID = fAuth.getCurrentUser().getUid();
        Random random = new Random();

        //String path = "firememes/" + fAuth.getCurrentUser().getUid() + UUID.randomUUID() + ".png";
        String str = String.valueOf(random.nextInt(10000));

        //StorageReference firememeRef = storage.getReference("users/" + fAuth.getCurrentUser().getUid() + "/Face_Emotion.jpg");
        StorageReference filePath = storage.child("Audio Records ").child(fAuth.getCurrentUser().getUid()).child("new_audio"+str+".3gp");
        //StorageReference filePath = storage.child("users/" + fAuth.getCurrentUser().getUid()).child("new_audio"+str+".3gp");

        Uri uri = Uri.fromFile(new File(fileName));
        filePath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                progressDialog.dismiss();
                recordText.setText("All set !");

            }
        });

        filePath.putFile(uri).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                recordText.setText("Failed to detect voice");

            }
        });




    }
}
