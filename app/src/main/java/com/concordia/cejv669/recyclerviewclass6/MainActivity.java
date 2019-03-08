package com.concordia.cejv669.recyclerviewclass6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Book> bookList=new ArrayList<>();
    private BookAdpater ba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView=findViewById(R.id.recycler_view);
        ba=new BookAdpater(bookList);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(ba);
        bookList.addAll(generatedData());
    }
    protected ArrayList<Book> generatedData()
    {
        ArrayList<Book> alb=new ArrayList<>();
        Book b;
        b=new Book(123,"Dune",450,false);
        alb.add(b);
        b=new Book(456,"Star wars",789,false);
        alb.add(b);
        b=new Book(789,"Star trek",852,false);
        alb.add(b);
        return alb;
    }
}
