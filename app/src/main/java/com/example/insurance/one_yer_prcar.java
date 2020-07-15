package com.example.insurance;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

public class one_yer_prcar extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Spinner zone_spin;
    String[] zone = {"P1","P2","P3","P4"};
    private Spinner cc_spin;
    String[] cc = {"<1000","1000-1500",">1500"};
    String[] ncb = {"0","20","25","35","45","50","55","65"};
    private Spinner ncb_spin;

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
    private TextView unamed_value;
    private TextView b_part;
    private TextView a_and_b;
    private TextView gst;
    private  TextView total;
    private  TextView engine;
    private  TextView nc_protect;
    private TextView invoice;
    private TextView anti;
    private TextView wc;
    private TextView lpg;
    private CheckBox cpa_box;
    private CheckBox engine_box;
    private int cpa_int_value=0;
    private  double engine_int_value;
    private int idv_int;
    private CheckBox log_box;
    private int lpg_int_value;
    private int wc_int = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_yer_prcar);

        //Setting spinner in Activity
        zone_spin = (Spinner)findViewById(R.id.zone_spin);
        cc_spin  = (Spinner)findViewById(R.id.cc_spin);
        ncb_spin = (Spinner)findViewById(R.id.ncb_spin);
        zone_spin.setOnItemSelectedListener(this);
        cc_spin.setOnItemSelectedListener(this);
        ncb_spin.setOnItemSelectedListener(this);

        ArrayAdapter<String> aa = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,zone);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        zone_spin.setAdapter(aa);

        ArrayAdapter<String> CC = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,cc);
        CC.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cc_spin.setAdapter(CC);

        ArrayAdapter<String> bb = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,ncb);
        bb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ncb_spin.setAdapter(bb);

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
        b_part = findViewById(R.id.b_part);
        a_and_b = findViewById(R.id.a_and_b);
        gst = findViewById(R.id.gst);
        total = findViewById(R.id.total);
        premium = findViewById(R.id.premium);
        engine = findViewById(R.id.engine_protect);
        nc_protect = findViewById(R.id.ncb_protect);
        invoice = findViewById(R.id.invoice_protect);
        anti = findViewById(R.id.anti_theft);
        wc = findViewById(R.id.wc);
        lpg = findViewById(R.id.lpg);
        unamed_value = findViewById(R.id.unamed);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateResult();
            }
        });
        cpa_box = findViewById(R.id.checkBox4);
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
        engine_box = findViewById(R.id.checkBox6);
        engine_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(engine_box.isChecked()){
                    engine_int_value = (idv_int*0.09)/100;
                }else if(!engine_box.isChecked()) {
                    engine_int_value = 0;
                }
            }
        });
        log_box = findViewById(R.id.checkBox7);
        log_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(log_box.isChecked()){
                    lpg_int_value = 60;
                }else if(!log_box.isChecked()){
                    lpg_int_value = 0;
                }
            }
        });
    }

    private void updateResult() {
        String idv_string = idv.getText().toString();
        idv_int = Integer.parseInt(idv_string);
        double od_value =  0;
        //getting zone
        String zone_string = zone_spin.getSelectedItem().toString();
        if(zone_string.equals("P1")){
            od_value = (idv_int*2.50)/100;
        }else  if(zone_string.equals("P2")){
            od_value = (idv_int*2.20)/100;
        }else if(zone_string.equals("P3")){
            od_value = (idv_int*2.19)/100;
        }else if(zone_string.equals("P4")){
            od_value = (idv_int*2.07)/100;
        }


        double a_int_part = od_value+engine_int_value;
        int tp_int_value = 2072;
        double b_int_part = tp_int_value+cpa_int_value+wc_int+lpg_int_value;
        double total_value = a_int_part+b_int_part;
        double gst_value = (total_value*18)/100;
        double total_final = total_value+gst_value;
//        int tp_int = (int) 20272;
        od.setText("OWN DAMAGE: "+od_value);
        nil_dep_value.setText("NIL DEP: +"+0.00);
        engine.setText("Engine Protect: +"+engine_int_value);
        nc_protect.setText("NCB Protect: +"+0);
        invoice.setText("Invoice Protect: +"+0);
        anti.setText("Anti Theft: +"+0);
        ncb_value.setText("NCB: -"+0.00);
        disscount_value.setText("DISCOUNT: -"+0.00);
        a_part.setText("A= "+a_int_part);
        tp_value.setText("TP: "+0.0);
       cpa_value.setText("CPA: +"+cpa_int_value);
       wc.setText("WC: +"+wc_int);
       lpg.setText("LPG: +"+lpg_int_value);
      unamed_value.setText("UNAMED: +"+0);
      b_part.setText("B= "+b_int_part);
       a_and_b.setText("A+B= "+total_value);
       gst.setText("GST@18%: "+0.00);
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
