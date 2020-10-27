package kr.hs.emirim.s2019w37.check;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class JoinActivity extends AppCompatActivity {
    private Button join; //회원가입 버튼
    private Button login; //로그인 버튼
    private EditText edit_email, edit_password;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage_join);

        firebaseAuth = FirebaseAuth.getInstance(); //firebaseAuth의 인스턴스를 가져옴

        edit_email = (EditText) findViewById(R.id.join_email);
        edit_password = (EditText) findViewById(R.id.join_password);

        //회원가입창 연결
        login = (Button) findViewById(R.id.btn_fristlogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JoinActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        //로그인 창
        join = (Button) findViewById(R.id.btn_login);
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!edit_email.getText().toString().equals("") && !edit_password.getText().toString().equals("")){
                    loginUser(edit_email.getText().toString(),edit_password.getText().toString());
                }else{
                    Toast.makeText(JoinActivity.this,"계정과 비밀번호를 입력하세요.",Toast.LENGTH_LONG).show();
                }
            }
        });

        firebaseAuthListener = new FirebaseAuth.AuthStateListener() { //로그인 서버 넘기는곳
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(JoinActivity.this, ChooseActivity.class);
                    startActivity(intent);
                    finish();
                } else {
               }
            }
        };
    }

    public void loginUser(String email, String password) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) { //로그인 성공
                    Toast.makeText(JoinActivity.this, "로그인 성공", Toast.LENGTH_SHORT).show();
                    firebaseAuth.addAuthStateListener(firebaseAuthListener);

                } else {//로그인 실패
                    Toast.makeText(JoinActivity.this, "이메일 또는 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (firebaseAuthListener != null){
            firebaseAuth.removeAuthStateListener(firebaseAuthListener);
        }
    }
}


