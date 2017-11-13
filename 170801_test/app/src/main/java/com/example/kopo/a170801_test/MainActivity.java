package com.example.kopo.a170801_test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText = null;
    EditText idText = null;
    EditText passText = null;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.gridlayout);
        //버튼 1
       /* Button firstButton;
        firstButton = (Button) findViewById(R.id.button1);
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "하이!",
                        Toast.LENGTH_SHORT).show();
            }
        });
        //버튼 2
        Button firstButton2;
        firstButton2 = (Button) findViewById(R.id.button2);
        firstButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "hello!",
                        Toast.LENGTH_SHORT).show();
            }
        });
        //입력 값을 받고 특정 단어를 띄어주기
        editText = (EditText)findViewById(R.id.editText);
        idText = (EditText)findViewById(R.id.idText);
        passText = (EditText)findViewById(R.id.passText);

        login = (Button)findViewById(R.id.login);
        editText.setOnKeyListener(new View.OnKeyListener() {
                                      @Override
                                      public boolean onKey(View v, int keyCode, KeyEvent event) {
                                          String kg = editText.getText().toString();
                                          if (kg.equals("POLY")) {
                                              Toast.makeText(getApplicationContext(), "반갑습니다", Toast.LENGTH_SHORT).show();
                                          } else if (kg.equals("name")) {  //이 부분에서 특정단어 입력되면 사라지게 하는거 구현해보기
                                              Toast.makeText(getApplicationContext(), " ", Toast.LENGTH_SHORT).show();
                                          }
                                          return false;
                                      }
                                  });
        //아이디 , 비번 입력받기


        login.setOnClickListener(new View.OnClickListener(){
                @Override
                        public void onClick(View v){
                    String id = idText.getText().toString();
                    String pass = passText.getText().toString();
                    if(id.equals("a") && pass.equals("b")){
                        Toast.makeText(getApplicationContext(), "어서오세요", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getApplicationContext(), "아이디 혹은 비밀번호 오류", Toast.LENGTH_SHORT).show();
                    }


                }
            });*/
    }
}
