package com.example.cryptomessage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    ImageView support_imageview,edit_imageView,generate_imageView;
    TextView support_textView;
    TextInputEditText input_text_Input_Edit_Text, output_text_Input_Edit_Text, key_text_input_Edit_Text;
    Button create_btn,read_btn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assigning frontend variables to backend variables


        //support_textView = findViewById(R.id.support_textView);
        input_text_Input_Edit_Text = findViewById(R.id.input_text_Input_Edit_Text);
        output_text_Input_Edit_Text = findViewById(R.id.output_text_Input_Edit_Text);
        key_text_input_Edit_Text = findViewById(R.id.key_text_input_Edit_text);
        create_btn = findViewById(R.id.create_btn);
        read_btn = findViewById(R.id.read_btn);
        support_imageview = findViewById(R.id.support_imageview);
        edit_imageView = findViewById(R.id.edit_imageView);
        generate_imageView = findViewById(R.id.generate_imageView);

        create_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = input_text_Input_Edit_Text.getText().toString();
                String key = key_text_input_Edit_Text.getText().toString();
                String new_Message = Utility.createMessage(message,key);
                output_text_Input_Edit_Text.setText(new_Message);
                input_text_Input_Edit_Text.setText("");
                key_text_input_Edit_Text.setText("");
            }
        });

        read_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = input_text_Input_Edit_Text.getText().toString();
                String key = key_text_input_Edit_Text.getText().toString();
                String new_Message = Utility.readMessage(message,key);
                output_text_Input_Edit_Text.setText(new_Message);
                input_text_Input_Edit_Text.setText("");
                key_text_input_Edit_Text.setText("");
            }
        });

        support_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Welcome",Toast.LENGTH_SHORT).show();
                // Calling Another Class or page
                Intent intent = new Intent(MainActivity.this,Support.class);
                startActivity(intent);
            }
        });
    }


    public void print(String line){
        Toast.makeText(MainActivity.this, line, Toast.LENGTH_LONG).show();
    }
}
