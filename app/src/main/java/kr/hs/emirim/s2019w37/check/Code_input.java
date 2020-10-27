package kr.hs.emirim.s2019w37.check;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Code_input extends AppCompatActivity {
    private Button join;
    private Button cancel;
    private Button back2;
    private EditText ip_code;
    private EditText ip_classname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_code);

        ip_classname = (EditText)findViewById(R.id.text_classname);
        ip_code = (EditText)findViewById(R.id.text_classcord);

        //돌아가기 버튼을 누르면 메인화면으로 넘어감
        back2 = (Button)findViewById(R.id.back_button2);
        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainPage_teacherActivity.class);
                startActivity(intent);
            }
        });

        //최소하기 버튼을 누르면 수업 등록 취소를 하는 버튼
        cancel = (Button)findViewById(R.id.btn_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Toast.makeText( Code_input.this,"수업 등록을 취소하셨습니다.",Toast.LENGTH_LONG).show();
                }
            });

        //등록하기 버튼을 누르면 수업 등록을 함
        join = (Button)findViewById(R.id.btn_join);
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ip_classname.getText().toString();
                ip_code.getText().toString();

                if (ip_classname.toString().equals("") && ip_code.toString().equals("") ) { //둘 중에 하나가 공백일 경우
                    Toast.makeText( Code_input.this,"수업 등록을 취소하셨습니다.",Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(getBaseContext(), MainPage_teacherActivity.class);
                    startActivity(intent);
                    Toast.makeText( Code_input.this,"수업 등록이 됐습니다.",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
