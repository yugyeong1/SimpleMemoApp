package com.dbrud1032.memoapp.adapter;


// 1. RecyclerView.Adapter 를 상속받는다.

// 2. 상속받은 클래스가 abstract 이므로, unimplemented method 오버라이드!

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dbrud1032.memoapp.R;
import com.dbrud1032.memoapp.model.Memo;

import java.util.ArrayList;
import java.util.List;

// 6. RecyclerView.Adapter 의 데이터 타입을 적어주어야 한다.
//    우리가 만든 ViewHolder 로 적는다.


// 7. 빨간색 에러가 뜨면, 우리가 만든 ViewHolder 로
// onCreateViewHolder, onBindViewHolder 변경해준다.

public class MemoAdapter extends RecyclerView.Adapter<MemoAdapter.ViewHolder> {
    // 5. 어댑터 클래스의 멤버변수와 생성자를 만들어 준다.
    Context context;
    ArrayList<Memo> memoList;

    public MemoAdapter(Context context, ArrayList<Memo> memoList) {
        this.context = context;
        this.memoList = memoList;
    }

    // 8. 오버라이드 함수 3개를 전부 구현 해주면 끝!

    @NonNull
    @Override
    public MemoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // xml 파일을 연결하는 작업
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.memo_row, parent, false);
        return new MemoAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MemoAdapter.ViewHolder holder, int position) {

        Memo memo = memoList.get(position);
        holder.txtContent.setText( memo.getContent() );

    }

    @Override
    public int getItemCount() {

        return memoList.size();
    }

    // 3. ViewHolder 클래스를 만든다.
    //      이 클래스는 row.xml 화면에 있는 뷰를 연결시키는 클래스다.
    // RecyclerView.ViewHolder 상속받는다.

    // 4. 생성자를 만든다.
    //    생성자에서, 뷰를 연결시키는 코드를 작성하고,
    //    클릭 이벤트도 작성한다.
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtContent = itemView.findViewById(R.id.txtContent);

        }
    }

}