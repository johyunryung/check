package kr.hs.emirim.s2019w37.check;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ChooseActivity extends AppCompatActivity {
    private ImageButton btn_teacher, btn_student;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hompage_choose);

        btn_teacher = (ImageButton)findViewById(R.id.teacher); //선생님 main
        btn_student = (ImageButton)findViewById(R.id.student); //학생 main

        btn_teacher.setOnClickListener(new ImageButton.OnClickListener(){ //선생님 버튼을 눌렀을때
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseActivity.this, MainPage_teacherActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_student.setOnClickListener(new ImageButton.OnClickListener(){ //학생 버튼을 눌렀을때
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseActivity.this, MainPage_studentActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
