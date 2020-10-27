package kr.hs.emirim.s2019w37.check;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainPage_teacherActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private Button btn_add;
    private Button btn_back1;
    private Button btn_calender;
    private Button btn_list;
    private Button btn_information;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_home_teacher);

        //추가하기 버튼을 누르면 코드 입력 할 수 있는 창으로 넘어감
        btn_add = (Button)findViewById(R.id.add_button);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPage_teacherActivity.this, Code_input.class);
                startActivity(intent);
            }
        });

        //돌아가기 버튼을 누르면 선생님이랑 학생 버전을 고를 수 있는 창으로 넘어감
        btn_back1 = (Button)findViewById(R.id.back_button2);
        btn_back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChooseActivity.class);
                startActivity(intent);
            }
        });

        //calender 버튼을 누르면 스케줄 등록 할 수 있는 창으로 넘어감
        btn_calender = (Button)findViewById(R.id.calender);
        btn_calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPage_teacherActivity.this, Check_calender.class);
                startActivity(intent);
            }
        });

        // list 버튼을 누르면 학생들의 출결 상황을 알 수 있는 창으로 넘어감
        btn_list = (Button)findViewById(R.id.list);
        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPage_teacherActivity.this, Check_attendance.class);
                startActivity(intent);
            }
        });

        //information 버튼을 누르면 내가 입력 했던 개인정보를 수정 할 수 있는 창으로 넘어감
        btn_information = (Button)findViewById(R.id.information);
        btn_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPage_teacherActivity.this, Check_information.class);
                startActivity(intent);
            }
        });
    }
}