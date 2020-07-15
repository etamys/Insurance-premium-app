package com.example.insurance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class one_year extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Button main_menu;
    String[] zone = {"A","B"};
    private Spinner zone_spin;
    String[] cc = {"75","150","350",">350"};
    private Spinner cc_spin;
    String[] age = {"up to 5","5 to 10","Above 10"};
    private Spinner age_spin;
    String[] ncb = {"0","20","25","35","45","50"};
    private Spinner ncb_spin;
    String[] nil = {"NEW","1 YR","2YR","3 YR","4 YR"};
    private Spinner nil_spin;
    //getting and setting value in screen
    private EditText idv;
    private TextView od;
    private TextView premium;
    private Button calc;
    private TextView nil_dep_value;
    private TextView ncb_value;
    private TextView disscount_value;
    private TextView a_part;
    private TextView tp_value;
    private TextView cpa_value;
    private TextView unamed;
    private TextView b_part;
    private TextView a_and_b;
    private TextView gst;
    private  TextView total;
    private CheckBox cpa_box;
    private CheckBox unamed_box;
//    private final float idv_cons = (float) 0.0134;

    private int cpa_int_value=0;
    private TextView un_hide;
    private TextView un_edit_hide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_year);

        main_menu = findViewById(R.id.main_menu);
        main_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Updateui();
            }
        });

        zone_spin = (Spinner)findViewById(R.id.zone_spin);
        cc_spin  = (Spinner)findViewById(R.id.cc_spin);
        age_spin = (Spinner)findViewById(R.id.age_spin);
        ncb_spin = (Spinner)findViewById(R.id.ncb_spin);
        nil_spin = (Spinner)findViewById(R.id.nil_spin);
        zone_spin.setOnItemSelectedListener(this);
        cc_spin.setOnItemSelectedListener(this);
        age_spin.setOnItemSelectedListener(this);
        ncb_spin.setOnItemSelectedListener(this);
        nil_spin.setOnItemSelectedListener(this);

        ArrayAdapter<String> aa = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,zone);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        zone_spin.setAdapter(aa);

        ArrayAdapter<String> CC = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,cc);
        CC.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cc_spin.setAdapter(CC);

        ArrayAdapter<String> bb = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,age);
        bb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        age_spin.setAdapter(bb);

        ArrayAdapter<String> dd = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,ncb);
        dd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ncb_spin.setAdapter(dd);

        ArrayAdapter<String> nn = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,nil);
        nn.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nil_spin.setAdapter(nn);

        //getting and setting value in screen
        idv = (EditText)findViewById(R.id.editText);
        calc =(Button)findViewById(R.id.button14);
        od  = findViewById(R.id.od);
        nil_dep_value = findViewById(R.id.nil_dep);
        ncb_value = findViewById(R.id.ncb);
        disscount_value = findViewById(R.id.disscount);
        a_part = findViewById(R.id.a_part);
        tp_value  =findViewById(R.id.tp);
        cpa_value = findViewById(R.id.cpa);
        unamed = findViewById(R.id.unamed);
        b_part = findViewById(R.id.b_part);
        a_and_b = findViewById(R.id.a_and_b);
        gst = findViewById(R.id.gst);
        total = findViewById(R.id.total);
        premium = findViewById(R.id.premium);
        cpa_box  =findViewById(R.id.checkBox2);
        unamed_box = findViewById(R.id.checkBox4);
        un_hide = findViewById(R.id.textView19);
        un_edit_hide = findViewById(R.id.editText6);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateResult();
            }
        });
        cpa_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cpa_box.isChecked()){
                    cpa_int_value = 295;
                }
                else if(!cpa_box.isChecked()){
                    cpa_int_value = 0;
                }
            }
        });
        unamed_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(unamed_box.isChecked()){
                    un_hide.setVisibility(v.VISIBLE);
                    un_edit_hide.setVisibility(v.VISIBLE);
                    String unamed_hide_string = un_edit_hide.getText().toString();
                    int unamed_int = Integer.parseInt(unamed_hide_string);
                }
                else{
                    un_hide.setVisibility(v.GONE);
                    un_edit_hide.setVisibility(v.GONE);
                }
            }
        });

    }

    private void updateResult() {
        String  idv_string = idv.getText().toString();
        int idv_int = Integer.parseInt(idv_string);
        double od_value =  0;

        //getting CC
        String cc_string = cc_spin.getSelectedItem().toString();
        double cc_value_int = 0;
        if(cc_string.equals("75")){
            cc_value_int = 0;

        }else if(cc_string.equals("150")){
            cc_value_int = 0;
        }else if(cc_string.equals("350")){
            cc_value_int = 0.06;

        }else if(cc_string.equals(">350")){
            cc_value_int =  0.13;
        }

        //getting age
        String age_string = age_spin.getSelectedItem().toString();
        double age_int = 0;
        if(cc_string.equals("75") && age_string.equals("5 to 10")){
            age_int = 0.06;
        }else if(cc_string.equals("75") && age_string.equals("Above 10")){
            age_int = 0.10;

        }else if(cc_string.equals("150") && age_string.equals("5 to 10")){
            age_int = 0.06;
        }else if(cc_string.equals("150") && age_string.equals("Above 10")){
            age_int = 0.10;
        }else if(cc_string.equals("350") && age_string.equals("5 to 10")) {
            age_int = 0.08;
        }else if(cc_string.equals("350") && age_string.equals("Above 10")) {
            age_int = 0.11;
        }else if(cc_string.equals(">350") && age_string.equals("5 to 10")) {
            age_int = 0.08;
        }else if(cc_string.equals(">350") && age_string.equals("Above 10")) {
            age_int = 0.12;
        }

        //getting Zones
        String zone_string  = zone_spin.getSelectedItem().toString();
        if(zone_string.equals("A")){
         od_value = (idv_int*(1.37+cc_value_int+age_int))/100;
        }
        else if(zone_string.equals("B")) {
            od_value = (idv_int*(1.34+cc_value_int+age_int))/100;
        }

        //getting ncb spin
        String ncb_string = ncb_spin.getSelectedItem().toString();
        double ncb_int_value=0;
        if(ncb_string.equals("20")){
            ncb_int_value =  (od_value/100)*20;
        }else if(ncb_string.equals("25")){
            ncb_int_value =  (od_value/100)*25;
        }else if(ncb_string.equals("35")){
            ncb_int_value =  (od_value/100)*35;
        }else if(ncb_string.equals("45")){
            ncb_int_value =  (od_value/100)*45;
        }else if(ncb_string.equals("50")){
            ncb_int_value =  (od_value/100)*50;
        }
        double a_int_part = od_value - ncb_int_value;
        int tp_int_value = 752;
        double b_int_part = 752+cpa_int_value;
        double total_value = a_int_part+b_int_part;
        double gst_value = (total_value*18)/100;
        double total_final = total_value+gst_value;

        od.setText("OWN DAMAGE: "+od_value);
        nil_dep_value.setText("NIL DEP: +"+0.00);
        ncb_value.setText("NCB: -"+ncb_int_value);
        disscount_value.setText("DISCOUNT: -"+0.00);
        a_part.setText("A= "+a_int_part);
        tp_value.setText("TP: "+tp_int_value);
        cpa_value.setText("CPA: +"+cpa_int_value);
        unamed.setText("UNAMED: +"+0);
        b_part.setText("B= "+b_int_part);
        a_and_b.setText("A+B= "+total_value);
        gst.setText("GST@18%: "+Math.ceil(gst_value));
        total.setText("TOTAL = "+Math.ceil(total_final));
        premium.setText("PREMIUM = "+Math.round(total_final));



    }

    private void Updateui() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
     //
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //
    }
}
