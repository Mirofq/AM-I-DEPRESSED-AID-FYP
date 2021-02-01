package com.example.android.depressiontest;

import android.content.ComponentName;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

//import junit.framework.Test;

public class ResultActivity extends AppCompatActivity  {

    public static final String TAG = "TAG";
    TextView TestResult;
    TextView Disclaimer;
    Button viewRec;
    int nilaiInt;
    //ImageView ScoreRange;
    private static final String Name = "FullName";
    String VoiceEmo;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;
    String DocumentName;
    String depression;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);



        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        userID = fAuth.getCurrentUser().getUid();



        TestResult = (TextView) findViewById(R.id.TestResult);
        //Disclaimer = (TextView) findViewById(R.id.Disclaimer);
        //ScoreRange = (ImageView) findViewById(R.id.ScoreRange);

        //MainMenu = findViewById(R.id.ButtonMenu);

        //getName = getIntent().getStringExtra("nameofuser");
        nilaiInt = getIntent().getIntExtra("nilai", 0);
        VoiceEmo = getIntent().getStringExtra("voiceemotion");

        final DocumentReference documentReference = fStore.collection("users").document(userID);
        documentReference.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {
                            String FullName = documentSnapshot.getString(Name);

        //Neutrality
        if (nilaiInt <= 4 && "neutrality".equals(VoiceEmo)) {
            depression = "No Depression";
            TestResult.setText("Hi " + FullName + "\n\n\n Voice Emotion: " + VoiceEmo + "\n AID Questionnaire Score: " + nilaiInt +
                    "\n Total Result: No Depression"+
                    "\n\n Your result indicates you may not be suffering from depression." + "\n\n Still if you feel something isn’t quite right we recommend you contact AID recommended helplines to seek for help and emotional support."+
                    "\n\n We advise you to retest after one month in order to track improvements.");
        } else if (nilaiInt <= 9 && "neutrality".equals(VoiceEmo)) {
            depression = "No Depression";
            TestResult.setText("Hi " + FullName + "\n\n\n Voice Emotion: " + VoiceEmo + "\n AID Questionnaire Score: " + nilaiInt +
                    "\n Total Result: No Depression"+
                    "\n\n Your result indicates you may not be suffering from depression." + "\n\n Still if you feel something isn’t quite right we recommend you contact AID recommended helplines to seek for help and emotional support."+
                    "\n\n We advise you to retest after one month in order to track improvements.");
        } else if (nilaiInt <= 14 && "neutrality".equals(VoiceEmo)) {
            depression = "Mild Depression";
            TestResult.setText("Hi " + FullName + "\n\n\n Voice Emotion: " + VoiceEmo + "\n AID Questionnaire Score: " + nilaiInt +
                    "\n Total Result: Mild Depression"+
                    "\n\n Your result indicates you may be suffering from mild depression." + "\n\n Consider watchful waiting, and testing again normally within two weeks." +
                    "\n\n If you need help right away, check out AID recommended helplines for assistance and/or consider AID self treatment suggestions.");
        } else if (nilaiInt <= 19 && "neutrality".equals(VoiceEmo)) {
            depression = "Moderate Depression";
            TestResult.setText("Hi " + FullName + "\n\n\n Voice Emotion: " + VoiceEmo + "\n AID Questionnaire Score: " + nilaiInt +
                    "\n Total Result: Moderate Depression"+
                    "\n\n Your result indicates you may be suffering from moderate depression." + "\n\n Since this test is not meant to replace a professional diagnosis, you should refer to mental health specialist for an assessment or further treatment plan."+
                    "\n\n Please try AID self treatment suggestions and we advise you to retest weekly in order to track improvements.");
        } else if (nilaiInt > 19 && "neutrality".equals(VoiceEmo)) {
            depression = "Moderate Depression";
            TestResult.setText("Hi " + FullName + "\n\n\n Voice Emotion: " + VoiceEmo + "\n AID Questionnaire Score: " + nilaiInt +
                    "\n Total Result: Moderate Depression"+
                    "\n\n Your result indicates you may be suffering from moderate depression." + "\n\n Since this test is not meant to replace a professional diagnosis, you should refer to mental health specialist for an assessment or further treatment plan."+
                    "\n\n Please try AID self treatment suggestions and we advise you to retest weekly in order to track improvements.");
        }


        //Happiness
        if (nilaiInt <= 4 && "happiness".equals(VoiceEmo)) {
            depression = "No Depression";
            TestResult.setText("Hi " + FullName + "\n\n\n Voice Emotion: " + VoiceEmo + "\n AID Questionnaire Score: " + nilaiInt +
                    "\n Total Result: No Depression"+
                    "\n\n Your result indicates you may not be suffering from depression." + "\n\n Still if you feel something isn’t quite right we recommend you contact AID recommended helplines to seek for help and emotional support."+
                    "\n\n We advise you to retest after one month in order to track improvements.");
        } else if (nilaiInt <= 9 && "happiness".equals(VoiceEmo)) {
            depression = "No Depression";
            TestResult.setText("Hi " + FullName + "\n\n\n Voice Emotion: " + VoiceEmo + "\n AID Questionnaire Score: " + nilaiInt +
                    "\n Total Result: No Depression"+
                    "\n\n Your result indicates you may not be suffering from depression." + "\n\n Still if you feel something isn’t quite right we recommend you contact AID recommended helplines to seek for help and emotional support."+
                    "\n\n We advise you to retest after one month in order to track improvements.");
        } else if (nilaiInt <= 14 && "happiness".equals(VoiceEmo)) {
            depression = "Mild Depression";
            TestResult.setText("Hi " + FullName + "\n\n\n Voice Emotion: " + VoiceEmo + "\n AID Questionnaire Score: " + nilaiInt +
                    "\n Total Result: Mild Depression"+
                    "\n\n Your result indicates you may be suffering from mild depression." + "\n\n Consider watchful waiting, and testing again normally within two weeks." +
                    "\n\n If you need help right away, check out AID recommended helplines for assistance and/or consider AID self treatment suggestions.");
        } else if (nilaiInt <= 19 && "happiness".equals(VoiceEmo)) {
            depression = "Moderate Depression";
            TestResult.setText("Hi " + FullName + "\n\n\n Voice Emotion: " + VoiceEmo + "\n AID Questionnaire Score: " + nilaiInt +
                    "\n Total Result: Moderate Depression"+
                    "\n\n Your result indicates you may be suffering from moderate depression." + "\n\n Since this test is not meant to replace a professional diagnosis, you should refer to mental health specialist for an assessment or further treatment plan."+
                    "\n\n Please try AID self treatment suggestions and we advise you to retest weekly in order to track improvements.");
        } else if (nilaiInt > 19 && "happiness".equals(VoiceEmo)) {
            depression = "Moderate Depression";
            TestResult.setText("Hi " + FullName + "\n\n\n Voice Emotion: " + VoiceEmo + "\n AID Questionnaire Score: " + nilaiInt +
                    "\n Total Result: Moderate Depression"+
                    "\n\n Your result indicates you may be suffering from moderate depression." + "\n\n Since this test is not meant to replace a professional diagnosis, you should refer to mental health specialist for an assessment or further treatment plan."+
                    "\n\n Please try AID self treatment suggestions and we advise you to retest weekly in order to track improvements.");
        }


        //Sadness
        if (nilaiInt <= 4 && "sadness".equals(VoiceEmo)) {
            depression = "No Depression";
            TestResult.setText("Hi " + FullName + "\n\n\n Voice Emotion: " + VoiceEmo + "\n AID Questionnaire Score: " + nilaiInt +
                    "\n Total Result: No Depression"+
                    "\n\n Your result indicates you may not be suffering from depression." + "\n\n Still if you feel something isn’t quite right we recommend you contact AID recommended helplines to seek for help and emotional support."+
                    "\n\n We advise you to retest after one month in order to track improvements.");
        } else if (nilaiInt <= 9 && "sadness".equals(VoiceEmo)) {
            depression = "Mild Depression";
            TestResult.setText("Hi " + FullName + "\n\n\n Voice Emotion: " + VoiceEmo + "\n AID Questionnaire Score: " + nilaiInt +
                    "\n Total Result: Mild Depression"+
                    "\n\n Your result indicates you may be suffering from mild depression." + "\n\n Consider watchful waiting, and testing again normally within two weeks." +
                    "\n\n If you need help right away, check out AID recommended helplines for assistance and/or consider AID self treatment suggestions.");
        } else if (nilaiInt <= 14 && "sadness".equals(VoiceEmo)) {
            depression = "Moderate Depression";
            TestResult.setText("Hi " + FullName + "\n\n\n Voice Emotion: " + VoiceEmo + "\n AID Questionnaire Score: " + nilaiInt +
                    "\n Total Result: Moderate Depression"+
                    "\n\n Your result indicates you may be suffering from moderate depression." + "\n\n Since this test is not meant to replace a professional diagnosis, you should refer to mental health specialist for an assessment or further treatment plan."+
                    "\n\n Please try AID self treatment suggestions and we advise you to retest weekly in order to track improvements.");
        } else if (nilaiInt <= 19 && "sadness".equals(VoiceEmo)) {
            depression = "Moderately Severe Depression";
            TestResult.setText("Hi " + FullName + "\n\n\n Voice Emotion: " + VoiceEmo + "\n AID Questionnaire Score: " + nilaiInt +
                    "\n Total Result: Moderately Severe Depression"+
                    "\n\n Your result indicates you may be suffering from moderately severe depression." + "\n\n We additionally suggest it would be prudent to schedule an appointment with mental health specialist for active treatment with medication and/or therapy."+
                    "\n\n Please try AID self treatment suggestions and we advise you to retest weekly in order to track improvements.");
        } else if (nilaiInt > 19 && "sadness".equals(VoiceEmo)) {
            depression = "Severe Depression";
            TestResult.setText("Hi " + FullName + "\n\n\n Voice Emotion: " + VoiceEmo + "\n AID Questionnaire Score: " + nilaiInt +
                    "\n Total Result: Severe Depression"+
                    "\n\n Your result suggest you are suffering from severe depression." + "\n\n It is important that you schedule an appointment with mental health specialist now. If you need help finding a mental health professional, we suggest that you reach out to AID recommended helplines."+
                    "\n\n Please try AID self treatment suggestions and we advise you to retest daily in order to track improvements.");
        }

        //Anger
        if (nilaiInt <= 4 && "anger".equals(VoiceEmo)) {
            depression = "No Depression";
            TestResult.setText("Hi " + FullName + "\n\n\n Voice Emotion: " + VoiceEmo + "\n AID Questionnaire Score: " + nilaiInt +
                    "\n Total Result: No Depression"+
                    "\n\n Your result indicates you may not be suffering from depression." + "\n\n Still if you feel something isn’t quite right we recommend you contact AID recommended helplines to seek for help and emotional support."+
                    "\n\n We advise you to retest after one month in order to track improvements.");
        } else if (nilaiInt <= 9 && "anger".equals(VoiceEmo)) {
            depression = "Mild Depression";
            TestResult.setText("Hi " + FullName + "\n\n\n Voice Emotion: " + VoiceEmo + "\n AID Questionnaire Score: " + nilaiInt +
                    "\n Total Result: Mild Depression"+
                    "\n\n Your result indicates you may be suffering from mild depression." + "\n\n Consider watchful waiting, and testing again normally within two weeks." +
                    "\n\n If you need help right away, check out AID recommended helplines for assistance and/or consider AID self treatment suggestions.");
        } else if (nilaiInt <= 14 && "anger".equals(VoiceEmo)) {
            depression = "Moderate Depression";
            TestResult.setText("Hi " + FullName + "\n\n\n Voice Emotion: " + VoiceEmo + "\n AID Questionnaire Score: " + nilaiInt +
                    "\n Total Result: Moderate Depression"+
                    "\n\n Your result indicates you may be suffering from moderate depression." + "\n\n Since this test is not meant to replace a professional diagnosis, you should refer to mental health specialist for an assessment or further treatment plan."+
                    "\n\n Please try AID self treatment suggestions and we advise you to retest weekly in order to track improvements.");
        } else if (nilaiInt <= 19 && "anger".equals(VoiceEmo)) {
            depression = "Moderately Severe Depression";
            TestResult.setText("Hi " + FullName + "\n\n\n Voice Emotion: " + VoiceEmo + "\n AID Questionnaire Score: " + nilaiInt +
                    "\n Total Result: Moderately Severe Depression"+
                    "\n\n Your result indicates you may be suffering from moderately severe depression." + "\n\n We additionally suggest it would be prudent to schedule an appointment with mental health specialist for active treatment with medication and/or therapy."+
                    "\n\n Please try AID self treatment suggestions and we advise you to retest weekly in order to track improvements.");
        } else if (nilaiInt > 19 && "anger".equals(VoiceEmo)) {
            depression = "Severe Depression";
            TestResult.setText("Hi " + FullName + "\n\n\n Voice Emotion: " + VoiceEmo + "\n AID Questionnaire Score: " + nilaiInt +
                    "\n Total Result: Severe Depression"+
                    "\n\n Your result suggest you are suffering from severe depression." + "\n\n It is important that you schedule an appointment with mental health specialist now. If you need help finding a mental health professional, we suggest that you reach out to AID recommended helplines."+
                    "\n\n Please try AID self treatment suggestions and we advise you to retest daily in order to track improvements.");
        }

        //Fear
        if (nilaiInt <= 4 && "fear".equals(VoiceEmo)) {
            depression = "No Depression";
            TestResult.setText("Hi " + FullName + "\n\n\n Voice Emotion: " + VoiceEmo + "\n AID Questionnaire Score: " + nilaiInt +
                    "\n Total Result: No Depression"+
                    "\n\n Your result indicates you may not be suffering from depression." + "\n\n Still if you feel something isn’t quite right we recommend you contact AID recommended helplines to seek for help and emotional support."+
                    "\n\n We advise you to retest after one month in order to track improvements.");
        } else if (nilaiInt <= 9 && "fear".equals(VoiceEmo)) {
            depression = "Mild Depression";
            TestResult.setText("Hi " + FullName + "\n\n\n Voice Emotion: " + VoiceEmo + "\n AID Questionnaire Score: " + nilaiInt +
                    "\n Total Result: Mild Depression"+
                    "\n\n Your result indicates you may be suffering from mild depression." + "\n\n Consider watchful waiting, and testing again normally within two weeks." +
                    "\n\n If you need help right away, check out AID recommended helplines for assistance and/or consider AID self treatment suggestions.");
        } else if (nilaiInt <= 14 && "fear".equals(VoiceEmo)) {
            depression = "Moderate Depression";
            TestResult.setText("Hi " + FullName + "\n\n\n Voice Emotion: " + VoiceEmo + "\n AID Questionnaire Score: " + nilaiInt +
                    "\n Total Result: Moderate Depression"+
                    "\n\n Your result indicates you may be suffering from moderate depression." + "\n\n Since this test is not meant to replace a professional diagnosis, you should refer to mental health specialist for an assessment or further treatment plan."+
                    "\n\n Please try AID self treatment suggestions and we advise you to retest weekly in order to track improvements.");
        } else if (nilaiInt <= 19 && "fear".equals(VoiceEmo)) {
            depression = "Moderately Severe Depression";
            TestResult.setText("Hi " + FullName + "\n\n\n Voice Emotion: " + VoiceEmo + "\n AID Questionnaire Score: " + nilaiInt +
                    "\n Total Result: Moderately Severe Depression"+
                    "\n\n Your result indicates you may be suffering from moderately severe depression." + "\n\n We additionally suggest it would be prudent to schedule an appointment with mental health specialist for active treatment with medication and/or therapy."+
                    "\n\n Please try AID self treatment suggestions and we advise you to retest weekly in order to track improvements.");
        } else if (nilaiInt > 19 && "fear".equals(VoiceEmo)) {
            depression = "Severe Depression";
            TestResult.setText("Hi " + FullName + "\n\n\n Voice Emotion: " + VoiceEmo + "\n AID Questionnaire Score: " + nilaiInt +
                    "\n Total Result: Severe Depression"+
                    "\n\n Your result suggest you are suffering from severe depression." + "\n\n It is important that you schedule an appointment with mental health specialist now. If you need help finding a mental health professional, we suggest that you reach out to AID recommended helplines."+
                    "\n\n Please try AID self treatment suggestions and we advise you to retest daily in order to track improvements.");
        }

                        } else {
                            Toast.makeText( ResultActivity.this, "Document does not exist", Toast.LENGTH_SHORT).show();
                            //Log.d("tag", "onEvent: Document do not exists");
                        }


                        documentReference.get().addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText( ResultActivity.this, "Error", Toast.LENGTH_SHORT).show();
                                Log.d("tag", e.toString());

                            }
                        });

                    }
                });

        //Disclaimer.setText("\nPHQ-9, Patient Health Questionnaire 9:-" + "\nDeveloped by Drs Robert L Spitzer, Janet B.W. Williams, Kurt Kroenke and colleages, with an educational grant from Pfizer Inc."
        // + "\nNo permission required to reproduce, translate, display or contribute.");

        Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        int hour = c.get(Calendar.HOUR);
        int min = c.get(Calendar.MINUTE);
        int date = c.get(Calendar.DATE);
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);

        int AMPMint =c.get(Calendar.AM_PM);
        String AMPM="AM";
        if(AMPMint==1){
            AMPM="PM";

        }

        if(hour==0){
            hour=12;
        }



        if(min<=9){
            String o="0"+String.valueOf(min);
            min=Integer.valueOf(o);
        }



        final String Hour = String.valueOf(hour);
        final String Min = String.valueOf(min);
        final String Date = String.valueOf(date);
        final String Month = String.valueOf(month + 1);
        final String Year = String.valueOf(year);

        final String finalAMPM = AMPM;


        viewRec = (Button) findViewById(R.id.recList);
        viewRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userID = fAuth.getCurrentUser().getUid();
                //ScoreData = "Score - " + calndr.getTime();
                DocumentName = Date + "/" + Month + "/" + Year + ", " + Hour + ":" + Min+" "+ finalAMPM;

                {
                    DocumentReference documentReference = fStore.collection("users").document(userID).collection("Result").document("ScoreDataVoice");
                    Map<String, Object> user = new HashMap<>();
                    //user.put("date-" + DocumentName2, DocumentName);
                    user.put("result-" + DocumentName, depression);
                    //user.put("Gender",genderM);
                    //user.put("Gender",genderF);

                    //documentReference.child("date").setValue(Date + "/" + Month + "/" + Year + ", " + Hour + ":" + Min+" "+ finalAMPM);
                    //documentReference.child("result").setValue(depression);

                    documentReference.set(user, SetOptions.merge()).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Log.d(TAG, "onSuccess: Data has been saved " + userID);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d(TAG, "onFailure: " + e.toString());
                        }
                    });
                }

                DocumentReference documentReference2 = fStore.collection("users").document(userID).collection("Result").document("History");
                Map<String,Object> user2 = new HashMap<>();
                user2.put("newdate" ,DocumentName);
                user2.put("newresult" ,depression);
                //user.put("Gender",genderM);
                //user.put("Gender",genderF);

                //documentReference.child("date").setValue(Date + "/" + Month + "/" + Year + ", " + Hour + ":" + Min+" "+ finalAMPM);
                //documentReference.child("result").setValue(depression);

                documentReference2.set(user2,SetOptions.merge()).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "onSuccess: Data has been saved "+ userID);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d(TAG, "onFailure: " + e.toString());
                    }
                });

                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.setComponent(new ComponentName("com.microsoft.projectoxford.face.samples", "com.microsoft.projectoxford.face.samples.ui.TreatmentActivity"));
                startActivity(intent);
            }
        });

    }


}


