package com.example.travel.SignUp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.travel.R;

import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {
    EditText edt_id,edt_pw,edt_pwCheck,edt_nickName,edt_email,edt_emailNumber,edt_birth;
    TextView textV_idCheck,textV_pwCheck,textV_pwCheckCk;
    TextView btn_idCheck,btn_nickNameCheck,btn_emailCheck,btn_emailNumberCheck,btn_Signup;
    CheckBox checkMale,checkFemale;
    ImageView goBack;
    LinearLayout textV_idCheckL;

    String idTest = "^[^\\s][a-zA-Z0-9]{4,15}$";
    String pwTest = "^.*(?=^.{8,15}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$";
    String emailTest = "^\\w{3,11}@[a-z]{2,10}[\\.][a-z]{1,2}[\\.]?[a-z]{0,2}$";
    String nicknameTest = "^[가-힣a-zA-Z0-9]{2,10}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // 상단 x 버튼
        goBack = findViewById(R.id.goBack);

        // 입력칸
        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);
        edt_pwCheck = findViewById(R.id.edt_pwCheck);
        edt_nickName = findViewById(R.id.edt_nickName);
        edt_email = findViewById(R.id.edt_email);
        edt_emailNumber = findViewById(R.id.edt_emailNumber);
        edt_birth = findViewById(R.id.edt_birth);

        // 입력칸 아래 문구
        textV_idCheck = findViewById(R.id.textV_idCheck);
        textV_pwCheck = findViewById(R.id.textV_pwCheck);
        textV_pwCheckCk = findViewById(R.id.textV_pwCheckCk);
        textV_idCheckL = findViewById(R.id.textV_idCheckL);

        // 버튼
        btn_idCheck = findViewById(R.id.btn_idCheck);
        btn_nickNameCheck = findViewById(R.id.btn_nickNameCheck);
        btn_emailCheck = findViewById(R.id.btn_emailCheck);
        btn_emailNumberCheck = findViewById(R.id.btn_emailNumberCheck);
        btn_Signup = findViewById(R.id.btn_Signup);

        // 체크박스
        checkMale = findViewById(R.id.checkMale);
        checkFemale = findViewById(R.id.checkFemale);

        // 우측상단 x 버튼
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        // 아이디
        edt_id.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b){
                    if(!Pattern.matches(idTest,edt_id.getText().toString())){
                        textV_idCheckL.setVisibility(View.VISIBLE);
                        textV_idCheck.setTextColor(Color.parseColor("#FF0000"));
                        textV_idCheck.setText("영문,숫자를 조합하여 4 ~ 15자");
                    }else if(edt_id.getText().toString().length() == 0){
                        textV_idCheckL.setVisibility(View.VISIBLE);
                        textV_idCheck.setTextColor(Color.parseColor("#FF0000"));
                        textV_idCheck.setText("아이디를 입력하세요!");
                    }else{
                        textV_idCheckL.setVisibility(View.VISIBLE);
                        textV_idCheck.setTextColor(Color.parseColor("#27D358"));
                        textV_idCheck.setText("중복검사를 실시해주세요!");
                    }
                }

            }
        });






    }

    //뒤로가기
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}