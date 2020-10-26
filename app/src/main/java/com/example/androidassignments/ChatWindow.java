package com.example.androidassignments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatWindow extends AppCompatActivity {
    Button buttn;
    EditText txtnmsg;
    ListView chtview;
    ArrayList<String> msgArry;
    ChatAdapter msgadpt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);
        buttn = findViewById(R.id.btnSendMessage);
        txtnmsg = findViewById(R.id.txtMessage);
        chtview = findViewById(R.id.chatView);

        msgArry = new ArrayList<>();

        msgadpt = new ChatAdapter(this);
        chtview.setAdapter(msgadpt);

        buttn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                msgArry.add(txtnmsg.getText().toString());
                msgadpt.notifyDataSetChanged();
                txtnmsg.setText("");
            }
        });





    }

    private class ChatAdapter extends ArrayAdapter<String>{

        public ChatAdapter(@NonNull Context context) {
            super(context, 0);
        }

        public int getCount(){

            return msgArry.size();
        }

        public String getItem(int position){
            return msgArry.get(position);
        }

        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = ChatWindow.this.getLayoutInflater();

            View result;

            if(position%2==0){
                result = inflater.inflate(R.layout.chat_row_incoming,null);
            }

            else{
                result = inflater.inflate(R.layout.chat_row_outgoing,null);
            }

            TextView message = result.findViewById(R.id.message_text);

            message.setText(getItem(position));
            return result;

        }

    }
}