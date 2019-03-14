package com.concordia.cejv669.recyclerviewclass6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

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


        final EditText etAddSIN, etAddName, etAddPages;
        final ToggleButton tbLent;
        Button btAdd;
        etAddSIN=findViewById(R.id.editTextAddSIN);
        etAddName=findViewById(R.id.editTextAddName);
        etAddPages=findViewById(R.id.editTextAddPage);
        tbLent=findViewById(R.id.toggleButtonAddLent);
        btAdd=findViewById(R.id.buttonAdd);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int isbn=Integer.parseInt(etAddSIN.getText().toString());
                String name=etAddName.getText().toString();
                int pages=Integer.parseInt(etAddPages.getText().toString());
                boolean islent= tbLent.isChecked();
                Book addedBook=new Book(isbn,name,pages,islent);
                bookList.add(addedBook);
                ba.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(),"Record added successfully", Toast.LENGTH_LONG).show();
            }
        });

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
