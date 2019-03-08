package com.concordia.cejv669.recyclerviewclass6;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class BookAdpater extends RecyclerView.Adapter<BookAdpater.MyViewHolder> {
    List<Book> bookList;


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, pages, isbn;
        Button btLent;

        MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.TextViewBookName);
            pages = view.findViewById(R.id.TextViewPages);
            isbn = view.findViewById(R.id.TextViewISBN);
            btLent=view.findViewById(R.id.buttonLent);
        }
    }

    BookAdpater(List<Book> bookList) {
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.book_row,viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final BookAdpater.MyViewHolder viewHolder, int i){
        final Book book= bookList.get(i);
        viewHolder.name.setText(book.getName());
        viewHolder.pages.setText(book.getPages()+"");
        viewHolder.isbn.setText(book.getISBN()+"");
        viewHolder.btLent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lent = book.isLent()? "Not available" : "Available" ;
                Toast.makeText(v.getContext(),lent,Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.bookList.size();
    }
}
