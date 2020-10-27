package kr.hs.emirim.s2019w37.check;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Check_information extends AppCompatActivity {
    private EditText name;
    private EditText email;
    private EditText pwd;
    private Button btn_back3;
    private Button btn_save;
    private TextView textView;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference  = database.getReference("message");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_information);

        name = (EditText)findViewById(R.id.mod_name);
        email = (EditText)findViewById(R.id.mod_email);
        pwd = (EditText)findViewById(R.id.mod_password);
        textView = (TextView)findViewById(R.id.textView);

        //돌아가기 버튼을 누를 경우 선생님 메인화면으로 넘어감
        btn_back3 = (Button)findViewById(R.id.back_button);
        btn_back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Check_information.this, MainPage_teacherActivity.class);
                startActivity(intent);
            }
        });
        //저장된 파이어베이스 값을 불러옴
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue(String.class);

                reference.setValue(name.getText().toString());
                reference.setValue(email.getText().toString());
                reference.setValue(pwd.getText().toString());
            }
            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        //수정된 정보를 저장을 하는 버튼
        btn_save = (Button)findViewById(R.id.btn_modsave);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
}
