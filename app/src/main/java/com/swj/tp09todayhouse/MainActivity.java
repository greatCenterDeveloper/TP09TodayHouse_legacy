package com.swj.tp09todayhouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnSort, btnJugeoType, btnPyeong, btnArea;
    ArrayList<Item> itemArrayList = new ArrayList<>();
    TextView tvTotal;
    RecyclerView recyclerView;
    SearchView searchView;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemArrayList.add(
                new Item(R.drawable.room01,
                        "복잡하고 어두웠던 공간을 깔끔하게", "디자인홈즈")
        );

        itemArrayList.add(
                new Item(R.drawable.room02,
                        "큰 창문으로 개방감을 준 화이트 인테리어", "LX지인 HS디자인")
        );

        itemArrayList.add(
                new Item(R.drawable.room03,
                        "복층 침대로 내부 여유 공간을 크게", "예스디자인")
        );

        itemArrayList.add(
                new Item(R.drawable.room04,
                        "공부하기 좋은 화이트 인테리어", "대해건축디자인")
        );

        itemArrayList.add(
                new Item(R.drawable.room05,
                        "화이트/블루를 섞은 고품격 인테리어", "디자인홈즈")
        );

        itemArrayList.add(
                new Item(R.drawable.room06,
                        "고품격 벙커형 인테리어", "LX지인 HS디자인")
        );

        itemArrayList.add(
                new Item(R.drawable.room07,
                        "한옥 느낌 물씬나는 그리운 옛맛", "예스디자인")
        );

        itemArrayList.add(
                new Item(R.drawable.room08,
                        "유럽에 온 것처럼! 유럽식 호텔형 인테리어", "대해건축디자인")
        );

        tvTotal = findViewById(R.id.tv_total);
        tvTotal.setText("" + itemArrayList.size());
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new MyAdapter(this, itemArrayList);
        recyclerView.setAdapter(adapter);

        btnSort = findViewById(R.id.btn_sort);
        btnJugeoType = findViewById(R.id.btn_jugeo_type);
        btnPyeong = findViewById(R.id.btn_pyeong);
        btnArea = findViewById(R.id.btn_area);

        btnSort.setOnClickListener(view -> Toast.makeText(this, "정렬", Toast.LENGTH_SHORT).show());
        btnJugeoType.setOnClickListener(view -> Toast.makeText(this, "주거형태", Toast.LENGTH_SHORT).show());
        btnPyeong.setOnClickListener(view -> Toast.makeText(this, "평수", Toast.LENGTH_SHORT).show());
        btnArea.setOnClickListener(view -> Toast.makeText(this, "지역", Toast.LENGTH_SHORT).show());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option, menu);
        MenuItem menuItem = menu.findItem(R.id.menu_search);
        searchView = (SearchView) menuItem.getActionView();
//        searchView.setIconified(false);
        searchView.setQueryHint("오늘의집 통합검색");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String toastText = "query : " + query;
                Toast.makeText(MainActivity.this, toastText, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menu_jjim)
            Toast.makeText(this, "찜", Toast.LENGTH_SHORT).show();
        else if(item.getItemId() == R.id.menu_shopping_basket)
            Toast.makeText(this, "장바구니", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}