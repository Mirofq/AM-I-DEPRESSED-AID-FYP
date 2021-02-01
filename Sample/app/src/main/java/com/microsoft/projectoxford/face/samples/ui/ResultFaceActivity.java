package com.microsoft.projectoxford.face.samples.ui;

import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
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
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.SetOptions;
import com.microsoft.projectoxford.face.samples.R;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.annotation.Nullable;


public class ResultFaceActivity extends AppCompatActivity  {

    public static final String TAG = "TAG";
    TextView TestResult;
    TextView Disclaimer;
    Button viewRec;
    int nilaiInt;
    //ImageView ScoreRange;
    private static final String Name = "FullName";
    String getEmo;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;
    String DocumentName;
    String depression;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navi_result);



        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        userID = fAuth.getCurrentUser().getUid();


        //DocumentReference documentReference = fStore.collection("users").document(userID);
        //documentReference.get()
        //.addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
        //@Override
        //public void onSuccess(DocumentSnapshot documentSnapshot) {
        //if (documentSnapshot.exists()) {
        //String FullName = documentSnapshot.getString(Name);



        TestResult = (TextView) findViewById(com.example.android.depressiontest.R.id.TestResult);
        //Disclaimer = (TextView) findViewById(com.example.android.depressiontest.R.id.Disclaimer);
        //ScoreRange = (ImageView) findViewById(com.example.android.depressiontest.R.id.ScoreRange);

        //MainMenu = findViewById(R.id.ButtonMenu);

        //getName = getIntent().getStringExtra("nameofuser");
        nilaiInt = getIntent().getIntExtra("nilai", 0);
        getEmo = getIntent().getStringExtra("voiceemotion");

        final DocumentReference documentReference = fStore.collection("users").document(userID);
        documentReference.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {
                            String FullName = documentSnapshot.getString(Name);

                            //Neutral
                            if (nilaiInt <= 4 && "Neutral".equals(getEmo)) {
                                depression = "No Depression";
                                TestResult.setText("\n Hi " + FullName + "\n\n\n Face Emotion: " + getEmo + "\n AID Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: No Depression"+
                                        "\n\n Your result indicates you may not be suffering from depression." + "\n\n Still if you feel something isn’t quite right we recommend you contact AID recommended helplines to seek for help and emotional support."+
                                        "\n\n We advise you to retest after one month in order to track improvements.");
                            } else if (nilaiInt <= 9 && "Neutral".equals(getEmo)) {
                                depression = "No Depression";
                                TestResult.setText("\n Hi " + FullName + "\n\n\n Face Emotion: " + getEmo + "\n AID Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: No Depression"+
                                        "\n\n Your result indicates you may not be suffering from depression." + "\n\n Still if you feel something isn’t quite right we recommend you contact AID recommended helplines to seek for help and emotional support."+
                                        "\n\n We advise you to retest after one month in order to track improvements.");
                            } else if (nilaiInt <= 14 && "Neutral".equals(getEmo)) {
                                depression = "Mild Depression";
                                TestResult.setText("\n Hi " + FullName + "\n\n\n Face Emotion: " + getEmo + "\n AID Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: Mild Depression"+
                                        "\n\n Your result indicates you may be suffering from mild depression." + "\n\n Consider watchful waiting, and testing again normally within two weeks." +
                                        "\n\n If you need help right away, check out AID recommended helplines for assistance and/or consider AID self treatment suggestions.");
                            } else if (nilaiInt <= 19 && "Neutral".equals(getEmo)) {
                                depression = "Moderate Depression";
                                TestResult.setText("\n Hi " + FullName + "\n\n\n Face Emotion: " + getEmo + "\n AID Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: Moderate Depression"+
                                        "\n\n Your result indicates you may be suffering from moderate depression." + "\n\n Since this test is not meant to replace a professional diagnosis, you should refer to mental health specialist for an assessment or further treatment plan."+
                                        "\n\n Please try AID self treatment suggestions and we advise you to retest weekly in order to track improvements.");
                            } else if (nilaiInt > 19 && "Neutral".equals(getEmo)) {
                                depression = "Moderate Depression";
                                TestResult.setText("\n Hi " + FullName + "\n\n\n Face Emotion: " + getEmo + "\n AID Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: Moderate Depression"+
                                        "\n\n Your result indicates you may be suffering from moderate depression." + "\n\n Since this test is not meant to replace a professional diagnosis, you should refer to mental health specialist for an assessment or further treatment plan."+
                                        "\n\n Please try AID self treatment suggestions and we advise you to retest weekly in order to track improvements.");
                            }

                            //Happiness
                            if (nilaiInt <= 4 && "Happiness".equals(getEmo)) {
                                depression = "No Depression";
                                TestResult.setText("\n Hi " + FullName + "\n\n\n Face Emotion: " + getEmo + "\n AID Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: No Depression"+
                                        "\n\n Your result indicates you may not be suffering from depression." + "\n\n Still if you feel something isn’t quite right we recommend you contact AID recommended helplines to seek for help and emotional support."+
                                        "\n\n We advise you to retest after one month in order to track improvements.");
                            } else if (nilaiInt <= 9 && "Happiness".equals(getEmo)) {
                                depression = "No Depression";
                                TestResult.setText("\n Hi " + FullName + "\n\n\n Face Emotion: " + getEmo + "\n AID Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: No Depression"+
                                        "\n\n Your result indicates you may not be suffering from depression." + "\n\n Still if you feel something isn’t quite right we recommend you contact AID recommended helplines to seek for help and emotional support."+
                                        "\n\n We advise you to retest after one month in order to track improvements.");
                            } else if (nilaiInt <= 14 && "Happiness".equals(getEmo)) {
                                depression = "Mild Depression";
                                TestResult.setText("\n Hi " + FullName + "\n\n\n Face Emotion: " + getEmo + "\n AID Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: Mild Depression"+
                                        "\n\n Your result indicates you may be suffering from mild depression." + "\n\n Consider watchful waiting, and testing again normally within two weeks." +
                                        "\n\n If you need help right away, check out AID recommended helplines for assistance and/or consider AID self treatment suggestions.");
                            } else if (nilaiInt <= 19 && "Happiness".equals(getEmo)) {
                                depression = "Moderate Depression";
                                TestResult.setText("\n Hi " + FullName + "\n\n\n Face Emotion: " + getEmo + "\n AID Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: Moderate Depression"+
                                        "\n\n Your result indicates you may be suffering from moderate depression." + "\n\n Since this test is not meant to replace a professional diagnosis, you should refer to mental health specialist for an assessment or further treatment plan."+
                                        "\n\n Please try AID self treatment suggestions and we advise you to retest weekly in order to track improvements.");
                            } else if (nilaiInt > 19 && "Happiness".equals(getEmo)) {
                                depression = "Moderate Depression";
                                TestResult.setText("\n Hi " + FullName + "\n\n\n Face Emotion: " + getEmo + "\n AID Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: Moderate Depression"+
                                        "\n\n Your result indicates you may be suffering from moderate depression." + "\n\n Since this test is not meant to replace a professional diagnosis, you should refer to mental health specialist for an assessment or further treatment plan."+
                                        "\n\n Please try AID self treatment suggestions and we advise you to retest weekly in order to track improvements.");
                            }


                            //Sadness
                            if (nilaiInt <= 4 && "Sadness".equals(getEmo)) {
                                depression = "No Depression";
                                TestResult.setText("\n Hi " + FullName + "\n\n\n Face Emotion: " + getEmo + "\n AID Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: No Depression"+
                                        "\n\n Your result indicates you may not be suffering from depression." + "\n\n Still if you feel something isn’t quite right we recommend you contact AID recommended helplines to seek for help and emotional support."+
                                        "\n\n We advise you to retest after one month in order to track improvements.");
                            } else if (nilaiInt <= 9 && "Sadness".equals(getEmo)) {
                                depression = "Mild Depression";
                                TestResult.setText("\n Hi " + FullName + "\n\n\n Face Emotion: " + getEmo + "\n AID Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: Mild Depression"+
                                        "\n\n Your result indicates you may be suffering from mild depression." + "\n\n Consider watchful waiting, and testing again normally within two weeks." +
                                        "\n\n If you need help right away, check out AID recommended helplines for assistance and/or consider AID self treatment suggestions.");
                            } else if (nilaiInt <= 14 && "Sadness".equals(getEmo)) {
                                depression = "Moderate Depression";
                                TestResult.setText("\n Hi " + FullName + "\n\n\n Face Emotion: " + getEmo + "\n AID Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: Moderate Depression"+
                                        "\n\n Your result indicates you may be suffering from moderate depression." + "\n\n Since this test is not meant to replace a professional diagnosis, you should refer to mental health specialist for an assessment or further treatment plan."+
                                        "\n\n Please try AID self treatment suggestions and we advise you to retest weekly in order to track improvements.");
                            } else if (nilaiInt <= 19 && "Sadness".equals(getEmo)) {
                                depression = "Moderately Severe Depression";
                                TestResult.setText("\n Hi " + FullName + "\n\n\n Face Emotion: " + getEmo + "\n AID Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: Moderately Severe Depression"+
                                        "\n\n Your result indicates you may be suffering from moderately severe depression." + "\n\n We additionally suggest it would be prudent to schedule an appointment with mental health specialist for active treatment with medication and/or therapy."+
                                        "\n\n Please try AID self treatment suggestions and we advise you to retest weekly in order to track improvements.");
                            } else if (nilaiInt > 19 && "Sadness".equals(getEmo)) {
                                depression = "Severe Depression";
                                TestResult.setText("\n Hi " + FullName + "\n\n\n Face Emotion: " + getEmo + "\n AID Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: Severe Depression"+
                                        "\n\n Your result suggest you are suffering from severe depression." + "\n\n It is important that you schedule an appointment with mental health specialist now. If you need help finding a mental health professional, we suggest that you reach out to AID recommended helplines."+
                                        "\n\n Please try AID self treatment suggestions and we advise you to retest daily in order to track improvements.");
                            }

                            //Anger
                            if (nilaiInt <= 4 && "Anger".equals(getEmo)) {
                                depression = "No Depression";
                                TestResult.setText("\n Hi " + FullName + "\n\n\n Face Emotion: " + getEmo + "\n AID Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: No Depression"+
                                        "\n\n Your result indicates you may not be suffering from depression." + "\n\n Still if you feel something isn’t quite right we recommend you contact AID recommended helplines to seek for help and emotional support."+
                                        "\n\n We advise you to retest after one month in order to track improvements.");
                            } else if (nilaiInt <= 9 && "Anger".equals(getEmo)) {
                                depression = "Mild Depression";
                                TestResult.setText("\n Hi " + FullName + "\n\n\n Face Emotion: " + getEmo + "\n AID Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: Mild Depression"+
                                        "\n\n Your result indicates you may be suffering from mild depression." + "\n\n Consider watchful waiting, and testing again normally within two weeks." +
                                        "\n\n If you need help right away, check out AID recommended helplines for assistance and/or consider AID self treatment suggestions.");
                            } else if (nilaiInt <= 14 && "Anger".equals(getEmo)) {
                                depression = "Moderate Depression";
                                TestResult.setText("\n Hi " + FullName + "\n\n\n Face Emotion: " + getEmo + "\n AID Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: Moderate Depression"+
                                        "\n\n Your result indicates you may be suffering from moderate depression." + "\n\n Since this test is not meant to replace a professional diagnosis, you should refer to mental health specialist for an assessment or further treatment plan."+
                                        "\n\n Please try AID self treatment suggestions and we advise you to retest weekly in order to track improvements.");
                            } else if (nilaiInt <= 19 && "Anger".equals(getEmo)) {
                                depression = "Moderately Severe Depression";
                                TestResult.setText("\n Hi " + FullName + "\n\n\n Face Emotion: " + getEmo + "\n AID Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: Moderately Severe Depression"+
                                        "\n\n Your result indicates you may be suffering from moderately severe depression." + "\n\n We additionally suggest it would be prudent to schedule an appointment with mental health specialist for active treatment with medication and/or therapy."+
                                        "\n\n Please try AID self treatment suggestions and we advise you to retest weekly in order to track improvements.");
                            } else if (nilaiInt > 19 && "Anger".equals(getEmo)) {
                                depression = "Severe Depression";
                                TestResult.setText("\n Hi " + FullName + "\n\n\n Face Emotion: " + getEmo + "\n AID Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: Severe Depression"+
                                        "\n\n Your result suggest you are suffering from severe depression." + "\n\n It is important that you schedule an appointment with mental health specialist now. If you need help finding a mental health professional, we suggest that you reach out to AID recommended helplines."+
                                        "\n\n Please try AID self treatment suggestions and we advise you to retest daily in order to track improvements.");
                            }

                            //Fear
                            if (nilaiInt <= 4 && "Fear".equals(getEmo)) {
                                depression = "No Depression";
                                TestResult.setText("\n Hi " + FullName + "\n\n\n Face Emotion: " + getEmo + "\n AID Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: No Depression"+
                                        "\n\n Your result indicates you may not be suffering from depression." + "\n\n Still if you feel something isn’t quite right we recommend you contact AID recommended helplines to seek for help and emotional support."+
                                        "\n\n We advise you to retest after one month in order to track improvements.");
                            } else if (nilaiInt <= 9 && "Fear".equals(getEmo)) {
                                depression = "Mild Depression";
                                TestResult.setText("\n Hi " + FullName + "\n\n\n Face Emotion: " + getEmo + "\n AID Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: Mild Depression"+
                                        "\n\n Your result indicates you may be suffering from mild depression." + "\n\n Consider watchful waiting, and testing again normally within two weeks." +
                                        "\n\n If you need help right away, check out AID recommended helplines for assistance and/or consider AID self treatment suggestions.");
                            } else if (nilaiInt <= 14 && "Fear".equals(getEmo)) {
                                depression = "Moderate Depression";
                                TestResult.setText("\n Hi " + FullName + "\n\n\n Face Emotion: " + getEmo + "\n AID Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: Moderate Depression"+
                                        "\n\n Your result indicates you may be suffering from moderate depression." + "\n\n Since this test is not meant to replace a professional diagnosis, you should refer to mental health specialist for an assessment or further treatment plan."+
                                        "\n\n Please try AID self treatment suggestions and we advise you to retest weekly in order to track improvements.");
                            } else if (nilaiInt <= 19 && "Fear".equals(getEmo)) {
                                depression = "Moderately Severe Depression";
                                TestResult.setText("\n Hi " + FullName + "\n\n\n Face Emotion: " + getEmo + "\n AID Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: Moderately Severe Depression"+
                                        "\n\n Your result indicates you may be suffering from moderately severe depression." + "\n\n We additionally suggest it would be prudent to schedule an appointment with mental health specialist for active treatment with medication and/or therapy."+
                                        "\n\n Please try AID self treatment suggestions and we advise you to retest weekly in order to track improvements.");
                            } else if (nilaiInt > 19 && "Fear".equals(getEmo)) {
                                depression = "Severe Depression";
                                TestResult.setText("\n Hi " + FullName + "\n\n\n Face Emotion: " + getEmo + "\n AID Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: Severe Depression"+
                                        "\n\n Your result suggest you are suffering from severe depression." + "\n\n It is important that you schedule an appointment with mental health specialist now. If you need help finding a mental health professional, we suggest that you reach out to AID recommended helplines."+
                                        "\n\n Please try AID self treatment suggestions and we advise you to retest daily in order to track improvements.");
                            }

                        } else {
                            Toast.makeText( ResultFaceActivity.this, "Document does not exist", Toast.LENGTH_SHORT).show();
                            //Log.d("tag", "onEvent: Document do not exists");
                        }


                        documentReference.get().addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText( ResultFaceActivity.this, "Error", Toast.LENGTH_SHORT).show();
                                Log.d("tag", e.toString());

                            }
                        });

                    }
                });

        //Disclaimer.setText("PHQ-9, Patient Health Questionnaire 9:-" + " Developed by Drs Robert L Spitzer, Janet B.W. Williams, Kurt Kroenke and colleages, with an educational grant from Pfizer Inc."
        //+ " No permission required to reproduce, translate, display or contribute.");

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

        String finalAMPM = AMPM;

        //Calendar calndr = Calendar.getInstance();
        //calndr.setTimeZone(TimeZone.getTimeZone("GMT+8"));



        viewRec = (Button) findViewById(com.example.android.depressiontest.R.id.recList);
        viewRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userID = fAuth.getCurrentUser().getUid();
                //ScoreData = "Score - " + calndr.getTime();
                DocumentName = Date + "/" + Month + "/" + Year + ", " + Hour + ":" + Min+" "+ finalAMPM;
                //DocumentName2 = Date + "." + Month + "." + Year + ", " + Hour + ":" + Min+" "+ finalAMPM;
                //timestamp = FirebaseFirestore.Timestamp.fromDate(new Date(("December 25, 1993")));

                {
                    DocumentReference documentReference = fStore.collection("users").document(userID).collection("Result").document("ScoreDataFace");
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
                user2.put("date" ,DocumentName);
                user2.put("result" ,depression);
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

                Intent r = new Intent(getApplicationContext(), TreatmentActivity.class);
                startActivity(r);
            }
        });

    }


}