package com.example.insurance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class one_year_goods extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    //setting spinners
    String[] zone = {"A","B","C"};
    private Spinner zone_spin;
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
    private TextView disscount;
    private TextView a_part;
    private TextView tp_value;
    private TextView cpa_value;
    private TextView b_part;
    private TextView a_and_b;
    private TextView gst;
    private  TextView total;
    private TextView imt;
    private TextView addl;
    private TextView wc;
    private TextView passenger;
    private TextView nfpf;
    private CheckBox cpa_box;
    private int cpa_int;
    private CheckBox imt_box;
    private double imt_int_value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_year_goods);

        //setting spinner in Activity
        zone_spin = (Spinner)findViewById(R.id.zone_spin);
        age_spin = (Spinner)findViewById(R.id.age_spin);
        ncb_spin = (Spinner)findViewById(R.id.ncb_spin);
        nil_spin = (Spinner)findViewById(R.id.nil_spin);
        zone_spin.setOnItemSelectedListener(this);
        age_spin.setOnItemSelectedListener(this);
        ncb_spin.setOnItemSelectedListener(this);
        nil_spin.setOnItemSelectedListener(this);

        ArrayAdapter<String> aa = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,zone);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        zone_spin.setAdapter(aa);

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
        disscount = findViewById(R.id.discount);
        a_part = findViewById(R.id.a_part);
        tp_value  =findViewById(R.id.tp);
        cpa_value = findViewById(R.id.cpa);
        b_part = findViewById(R.id.b_part);
        a_and_b = findViewById(R.id.a_and_b);
        gst = findViewById(R.id.gst);
        total = findViewById(R.id.total);
        premium = findViewById(R.id.premium);
        imt = findViewById(R.id.imt);
        addl = findViewById(R.id.addl_premium);
        wc = findViewById(R.id.wc);
        passenger = findViewById(R.id.passenger);
        nfpf = findViewById(R.id.nfpf);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateResult();
            }
        });
        cpa_box = findViewById(R.id.checkBox10);
        cpa_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cpa_box.isChecked()){
                    //cpa_int = 0;
                }else if(!cpa_box.isChecked()){
                    //cpa_int =0;
                }
            }
        });
        imt_box = findViewById(R.id.checkBox9);
        imt_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imt_box.isChecked()){
                    //imt_int_value=
                }else if(!imt_box.isChecked()){
                    //imt_int_value=
                }
            }
        });
    }

    private void updateResult() {
        String idv_string = idv.getText().toString();
        int idv_int = Integer.parseInt(idv_string);
        //setting zone spin
        String zone_string =zone_spin.getSelectedItem().toString();
        double zone_int=0;
        if(zone_string.equals("A")){
            zone_int = 1.66;
        }else if(zone_string.equals("B")){
            zone_int  = 1.66;
        }else if(zone_string.equals("C")){
            zone_int = 1.64;
        }
        //setting age spin
        String age_string = age_spin.getSelectedItem().toString();
        double age_int=0;
        if( zone_string.equals("A") && age_string.equals("5-7 YRS")){
            age_int = 0.04;
        }else if(zone_string.equals("A") && age_string.equals(">7 YRS")){
            age_int = 0.09;
        }else if( zone_string.equals("B") && age_string.equals("5-7 YRS")){
            age_int = 0.04;
        }else if(zone_string.equals("B") && age_string.equals(">7 YRS")){
            age_int = 0.08;
        }else if( zone_string.equals("C") && age_string.equals("5-7 YRS")){
            age_int = 0.04;
        }else if(zone_string.equals("C") && age_string.equals(">7 YRS")){
            age_int = 0.08;
        }
        double od_value;
        od_value = (idv_int*(zone_int+age_int))/100;
        od.setText("OWN DAMAGE: "+od_value);
       nil_dep_value.setText("NIL DEP: +"+0.00);
       imt.setText("IMT: -"+0.00);
       addl.setText("Addl Premium: +"+0);
       ncb_value.setText("NCB: -"+0.00);
        disscount.setText("DISCOUNT: -"+0.00);
       a_part.setText("A= "+od_value);
        tp_value.setText("TP: "+0.0);
        cpa_value.setText("CPA: +"+0);
        wc.setText("WC: +"+50);
        passenger.setText("Passenger: +"+0.00);
        nfpf.setText("NFPF: +"+0);
        b_part.setText("B= "+0.0);
        a_and_b.setText("A+B= "+0.00);
        gst.setText("GST@18%: "+0.00);
        total.setText("TOTAL = "+0.000);
        premium.setText("PREMIUM = "+0.00);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
