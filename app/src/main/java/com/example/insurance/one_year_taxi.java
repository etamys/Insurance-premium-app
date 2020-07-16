package com.example.insurance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class one_year_taxi extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    //setting spinner in Activity
    private Button main_menu;
    String[] zone = {"A","B"};
    private Spinner zone_spin;
    String[] cc = {"<1000","1000-1500",">1500"};
    private Spinner cc_spin;
    String[] seating_cap = {"3+1","4+1","5+1","6+1"};
    private Spinner seating_spin;
    String[] age = {"up to 5 YRS","5-7 YRS",">7 YRS"};
    private Spinner age_spin;
    String[] ncb = {"0","20","25","35","45","50"};
    private Spinner ncb_spin;
    String[] nil = {"NO","1st YR","2nd YR","3rd YR","4th YR","5th YR"};
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
    private TextView wc;
    private TextView passenger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_year_taxi);

        //setting spinner in Activity
        zone_spin = (Spinner)findViewById(R.id.zone_spin);
        cc_spin = (Spinner)findViewById(R.id.cc_spin); 
        seating_spin  = (Spinner)findViewById(R.id.seating_spin);
        age_spin = (Spinner)findViewById(R.id.age_spin);
        ncb_spin = (Spinner)findViewById(R.id.ncb_spin);
        nil_spin = (Spinner)findViewById(R.id.nil_spin);
        zone_spin.setOnItemSelectedListener(this);
        seating_spin.setOnItemSelectedListener(this);
        age_spin.setOnItemSelectedListener(this);
        ncb_spin.setOnItemSelectedListener(this);
        nil_spin.setOnItemSelectedListener(this);
        ArrayAdapter<String> aa = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,zone);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        zone_spin.setAdapter(aa);

        ArrayAdapter<String> c_c = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,cc);
        c_c.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cc_spin.setAdapter(c_c);

        ArrayAdapter<String> CC = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,seating_cap);
        CC.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        seating_spin.setAdapter(CC);

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
        wc = findViewById(R.id.wc);
        passenger = findViewById(R.id.passenger);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateResult();
            }
        });
    }

    private void updateResult() {
        String idv_string = idv.getText().toString();
        int idv_int = Integer.parseInt(idv_string);

        //getting zones;
        String zone_string = zone_spin.getSelectedItem().toString();
        double zone_int=0;
        if(zone_string.equals("A")){
            zone_int = 3.28;
        }else if(zone_string.equals("B")) {
            zone_int = 3.19;
        }
        //getting cc;
        String cc_string = cc_spin.getSelectedItem().toString();
        double cc_int;
        if (zone_string.equals("A") && cc_string.equals("1000-1500")){
            cc_int = 0.21;
        }else if (zone_string.equals("A") && cc_string.equals(">1500")){
            cc_int = 0.33;
        }else if (zone_string.equals("B") && cc_string.equals("1000-1500")){
            cc_int = 0.16;
        }else if (zone_string.equals("B") && cc_string.equals(">1500")){
            cc_int =0.32;
        }

        //getting age;
        String age_string = age_spin.getSelectedItem().toString();
        double age_int=0;
        if(age_string.equals("5-7 YRS") && zone_string.equals("A") && cc_string.equals("1000-1500")){
            age_int = 0.25;
        }else if(age_string.equals("5-7 YRS") && zone_string.equals("A") && cc_string.equals("<1000")) {
            age_int = 0.09;
        }else if(age_string.equals(">7 YRS") && zone_string.equals("A") && cc_string.equals("<1000")){
            age_int = 0.17;
        } else if(age_string.equals("5-7 YRS") && zone_string.equals("A") && cc_string.equals(">1500")){
            age_int = 0.42;
        }else if(age_string.equals(">7 YRS") && zone_string.equals("A") && cc_string.equals(">1500")){
            age_int =0.51;
        }else if(age_string.equals(">7 YRS") && zone_string.equals("A") && cc_string.equals("1000-1500")){
            age_int = 0.34;
        }else if(age_string.equals("5-7 YRS") && zone_string.equals("B") && cc_string.equals("1000-1500")){
            age_int = 0.19;
        }else if(age_string.equals("5-7 YRS") && zone_string.equals("B") && cc_string.equals(">1500")){
            age_int = 0.41;
        }else if(age_string.equals(">7 YRS") && zone_string.equals("B") && cc_string.equals(">1500")){
            age_int = 0.50;
        }else if(age_string.equals(">7 YRS") && zone_string.equals("B") && cc_string.equals("1000-1500")){
            age_int = 0.33;
        }else if(age_string.equals("5-7 YRS") && zone_string.equals("B") && cc_string.equals("<1000")) {
            age_int = 0.0830;
        }else if(age_string.equals(">7 YRS") && zone_string.equals("B") && cc_string.equals("<1000")) {
            age_int = 0.16;
        }

        double od_value = (idv_int*(zone_int+age_int))/100;

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


        int cpa_int_value = 295;
        int pasenger_int = 3723;
        int wc_int_value = 50;
        double a_int_part = od_value - ncb_int_value;
        int tp_int_value = 5769;
        double b_int_part = tp_int_value+cpa_int_value+wc_int_value+pasenger_int;
        double total_value = a_int_part+b_int_part;
        double gst_value = (total_value*18)/100;
        double total_final = total_value+gst_value;

        od.setText("OWN DAMAGE: "+od_value);
        nil_dep_value.setText("NIL DEP: +"+0.00);
        ncb_value.setText("NCB: -"+ncb_int_value);
        disscount_value.setText("DISCOUNT: -"+0.0);
        a_part.setText("A= "+a_int_part);
        tp_value.setText("TP: "+tp_int_value);
        cpa_value.setText("CPA: +"+cpa_int_value);
        wc.setText("WC: +"+wc_int_value);
        passenger.setText("Passenger: +"+pasenger_int);
        b_part.setText("B= "+b_int_part);
        a_and_b.setText("A+B= "+total_value);
        gst.setText("GST@18%: "+gst_value);
        total.setText("TOTAL = "+Math.round(total_final));
        premium.setText("PREMIUM = "+Math.round(total_final));

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
