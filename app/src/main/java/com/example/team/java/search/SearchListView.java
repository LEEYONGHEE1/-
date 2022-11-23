package com.example.team.java.search;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.team.R;

public class SearchListView extends AppCompatActivity {

    ListView listview = null ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        ListViewAdapter adapter;

        // Adapter 생성
        adapter = new ListViewAdapter() ;

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.image01),
                "신구 오락실", "최신게임\r\n100대 오락기계\r\n") ;

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.image03),
                "서현 노래방", "서현역 근처 노래방\r\n최신곡 업데이트") ;

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.image04),
                "야탑 보드게임카페", "다양한 종류의 게임 구비\r\n깨끗한 시설") ;

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.image05),
                "히어로 보드게임카페", "소문난 보드게임카페\r\n365일 운영") ;

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.image02),
                "신구 당구장", "신구대 근처 당구장\r\n단체 손님 환영") ;

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.image07),
                "서현 방탈출카페", "다양한 종류의 패키지\r\n최신시설") ;

        EditText editTextFilter = (EditText)findViewById(R.id.editTextFilter) ;

        editTextFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable edit) {
                String filterText = edit.toString() ;
//                if (filterText.length() > 0) {
//                    listview.setFilterText(filterText) ;
//                } else {
//                    listview.clearTextFilter() ;
//                }
                ((ListViewAdapter)listview.getAdapter()).getFilter().filter(filterText) ;
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        }) ;
    }
}