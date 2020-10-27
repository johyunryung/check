package kr.hs.emirim.s2019w37.check;

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

public class LoginActivity extends AppCompatActivity {
    private EditText name;
    private EditText mail;
    private EditText password;
    private Button mLogin;
    private static final String TAG = "LoginActivite";
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hompage_login);

        firebaseAuth = FirebaseAuth.getInstance();

        name = (EditText) findViewById(R.id.login_name);
        mail = (EditText) findViewById(R.id.login_email);
        password = (EditText) findViewById(R.id.login_password);
        mLogin = (Button) findViewById(R.id.btn_login2);

        mLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                    //이메일 , 비밀번호가 공백이 아닌 경우
                if(!mail.getText().toString().equals("") && !password.getText().toString().equals("")){
                    createUser (mail.getText().toString(), password.getText().toString(), name.getText().toString());
                    //이메일 , 비밀번호가 공백일 경우
                }else{
                    Toast.makeText(LoginActivity.this,"계정과 비밀번호를 입력해주세요.",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void createUser(String email, String password, String name) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){ //회원가입 성공시
                   Toast.makeText(LoginActivity.this,"회원가입 성공입니다.",Toast.LENGTH_SHORT).show();
                   finish();

              }else{ //계정이 중복된 경우
                    Toast.makeText(LoginActivity.this,"이미 존재하는 계정입니다.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}



