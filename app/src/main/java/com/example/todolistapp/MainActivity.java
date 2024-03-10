package com.example.todolistapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button; //helps to implement button functionalities
import android.widget.EditText; //helps in Editing the text
import android.widget.LinearLayout; //helps in showing the linearlayout
import android.widget.TextView; //helps us to set the textview


public class MainActivity extends AppCompatActivity {
    Button add; //Button type variable add
    AlertDialog dialog; //Alert type variable Dialog
    LinearLayout layout; //linearlayout type variable linear
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//sets the content to activity_main xml file
        add=findViewById(R.id.add); //assigning id declared as add in xml file with the java add variable done using findviewbyid method
        layout=findViewById(R.id.container); //utilizing the container layout mentioned in xml file

        buildDialog();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });
            }
            public void buildDialog(){
               AlertDialog.Builder builder=new AlertDialog.Builder(this);//creating object to alert dialog
                View view=getLayoutInflater().inflate(R.layout.dialog,null);
                final EditText name=view.findViewById(R.id.nameEdit);
                builder.setView(view);
                builder.setTitle("Enter your Task")
                        .setPositiveButton("SAVE", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                addcard(name.getText().toString());
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {

                            }
                        });
                dialog= builder.create();

            }
            private void addcard(String name){
              final View view=getLayoutInflater().inflate(R.layout.card,null);
              TextView nameView=view.findViewById(R.id.name);
              Button delete=view.findViewById(R.id.delete);
              nameView.setText(name);
              delete.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      layout.removeView(view);
                  }
              });
              layout.addView(view);
            }
        }

