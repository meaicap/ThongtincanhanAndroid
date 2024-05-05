package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Khai báo biến
        EditText edtHoTen, edtCCCD;
        Button btngui;
        RadioGroup idgroup;
        CheckBox chkdihoc, chkcongnhan, chkCEO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Ánh xạ code
        edtHoTen = findViewById(R.id.edtHoTen);
        edtCCCD = findViewById(R.id.edtCCCD);
        btngui = findViewById(R.id.btngui);
        idgroup = findViewById(R.id.idgroup);
        chkdihoc = findViewById(R.id.chkdihoc);
        chkcongnhan = findViewById(R.id.chkcongnhan);
        chkCEO = findViewById(R.id.chkCEO);
    //Xử lý click
        btngui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Lấy thông tin họ tên
                String hoten = edtHoTen.getText().toString();
                if (hoten.length() <3)
                {
                    Toast.makeText(MainActivity.this, "Họ Tên phải > 3 ký tự", Toast.LENGTH_LONG).show();
                    edtHoTen.requestFocus(); //đưa con trỏ trở về
                    edtHoTen.selectAll(); //bôi đen tất cả
                    return;
                }
                //Lấy thông tin CCCD
                String CCCD = edtCCCD.getText().toString();
                if (CCCD.length() !=12)
                {
                    Toast.makeText(MainActivity.this, "CCCD phải = 12 số", Toast.LENGTH_LONG).show();
                    edtCCCD.requestFocus(); //đưa con trỏ trở về
                    edtCCCD.selectAll(); //bôi đen tất cả
                    return;
                }
                //Lấy thông tin gia đình
                int idselect = idgroup.getCheckedRadioButtonId();
                RadioButton radselect = findViewById(idselect);
                String giadinh = radselect.getText().toString();
                //Láya thông tin công việc
                String congviec = "";
                if (chkdihoc.isChecked())
                    congviec += chkdihoc.getText().toString()+"-";
                if (chkcongnhan.isChecked())
                    congviec += chkcongnhan.getText().toString()+"-";
                if (chkCEO.isChecked())
                    congviec += chkCEO.getText().toString();
                //Lấy thông tin
                String tonghop  = hoten+"\n"+CCCD+"\n"+giadinh+"\n"+congviec+"\n";
                // Tạo dialog và gửi thông báo
                AlertDialog.Builder mydialog = new AlertDialog.Builder(MainActivity.this);
                mydialog.setTitle("Thông tin tổng hợp");

                mydialog.setMessage(tonghop);

               mydialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int which) {
                       dialogInterface.cancel();

                   }
               });
                mydialog.create().show();
            }
        });
    }
}