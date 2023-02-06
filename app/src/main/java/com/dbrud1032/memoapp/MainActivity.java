package com.dbrud1032.memoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dbrud1032.memoapp.adapter.MemoAdapter;
import com.dbrud1032.memoapp.model.Memo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;
    EditText editMemo;

    // 리사이클러뷰를 사용할 때!
    // RecyclerView, Adapter, ArrayList 를 쌍으로 적어라!
    RecyclerView recyclerView;
    MemoAdapter adapter;
    ArrayList<Memo> memoList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
        editMemo = findViewById(R.id.editMemo);

        // 리사이클러뷰를 화면에 연결하고,
        // 쌍으로 같이 다니는 코드도 작성.
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 1. 유저가 입력한 메모를 가져온다.
                String content = editMemo.getText().toString().trim();

                if (content.isEmpty()){
                    Toast.makeText(MainActivity.this, "메모를 작성해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // 2. 메모를 리스트에 저장한다.
                Memo memo = new Memo();
                memo.setContent(content);

//                memoList.add(memo);

                // 맨 앞에 저장하는 방법
                memoList.add(0, memo);

//                Collections.reverse(memoList);

                // 3. 리사이클러뷰를 갱신 (update)
                adapter.notifyDataSetChanged();

                // 4. 에디트텍스트를 초기화한다.
                editMemo.setText("");

            }
        });

        // 리사이클러뷰에 보이게 한다.
        // 어댑터를 만든다.
        adapter = new MemoAdapter(MainActivity.this, memoList);
        // 어댑터를 리사이클러뷰에 셋팅!
        recyclerView.setAdapter(adapter);


    }
}