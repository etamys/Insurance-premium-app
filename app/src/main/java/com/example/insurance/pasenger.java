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

public class pasenger extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
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
    private TextView disscount_value;
    private TextView a_part;
    private TextView tp_value;
    private TextView cpa_value;
    private TextView b_part;
    private TextView a_and_b;
    private TextView gst;
    private  TextView total;
    private TextView wc;
    private TextView passenger;
    private TextView imt;
    private CheckBox cpa_box;
    private int cpa_int_value;
    private CheckBox imt_box;
    private double imt_int;
    private EditText driver;
    private EditText no_of_passenger;
    private double od_value;
    private double imt_final;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasenger);
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
        disscount_value = findViewById(R.id.discount);
        a_part = findViewById(R.id.a_part);
        tp_value  =findViewById(R.id.tp);
        cpa_value = findViewById(R.id.cpa);
        b_part = findViewById(R.id.b_part);
        a_and_b = findViewById(R.id.a_and_b);
        gst = findViewById(R.id.gst);
        total = findViewById(R.id.total);
        premium = findViewById(R.id.premium);
        wc = findViewById(R.id.wc);
        passenger = findViewById(R.id.passenger);
        driver = findViewById(R.id.editText3);
        no_of_passenger = findViewById(R.id.editText4);
        imt = findViewById(R.id.imt);
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
                if(cpa_box.isChecked()){
                    cpa_int_value=295;
                }else if(!cpa_box.isChecked()){
                    cpa_int_value=0;
                }
            }
        });
        imt_box = findViewById(R.id.checkBox9);





    }

    private void updateResult() {
        String idv_string = idv.getText().toString();
        int idv_int = Integer.parseInt(idv_string);

        //check box values
        imt_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imt_box.isChecked()){
                    imt_int = (od_value*0.25)/100;
                    imt_final= Math.ceil(52.50+imt_int);
                }else if(!imt_box.isChecked()){
                    imt_final = 0;
                }
            }
        });
        //setting zone spin
        String zone_string = zone_spin.getSelectedItem().toString();
        double zone_int = 0;
        if (zone_string.equals("A")) {
            zone_int = 1.66;
        } else if (zone_string.equals("B")) {
            zone_int = 1.65;
        } else if (zone_string.equals("C")) {
            zone_int = 1.64;
        }
        //setting age spin
        String age_string = age_spin.getSelectedItem().toString();
        double age_int = 0;
        if (zone_string.equals("A") && age_string.equals("5-7 YRS")) {
            age_int = 0.04;
        } else if (zone_string.equals("A") && age_string.equals(">7 YRS")) {
            age_int = 0.08;
        } else if (zone_string.equals("B") && age_string.equals("5-7 YRS")) {
            age_int = 0.04;
        } else if (zone_string.equals("B") && age_string.equals(">7 YRS")) {
            age_int = 0.09;
        } else if (zone_string.equals("C") && age_string.equals("5-7 YRS")) {
            age_int = 0.04;
        } else if (zone_string.equals("C") && age_string.equals(">7 YRS")) {
            age_int = 0.08;
        }

        od_value = Math.ceil(350.02+((idv_int * (zone_int + age_int)) / 100));
        //getting ncb spin
        String ncb_string = ncb_spin.getSelectedItem().toString();
        double ncb_int_value = 0;
        if (ncb_string.equals("20")) {
            ncb_int_value = (od_value * 20) / 100;
        } else if (ncb_string.equals("25")) {
            ncb_int_value = (od_value * 25) / 100;
        } else if (ncb_string.equals("35")) {
            ncb_int_value = (od_value * 35) / 100;
        } else if (ncb_string.equals("45")) {
            ncb_int_value = (od_value * 45) / 100;
        } else if (ncb_string.equals("50")) {
            ncb_int_value = (od_value * 50) / 100;
        }
        //getting nil values from activity
        String nil_string = nil_spin.getSelectedItem().toString();
        double nil_int_value=0;
        if(nil_string.equals("1st YR")){
            nil_int_value =  (idv_int*0.29)/100;
        }else if(nil_string.equals("2nd YR")){
            nil_int_value =  (idv_int*0.31)/100;
        }else if(nil_string.equals("3rd YR")){
            nil_int_value =  (idv_int*0.36)/100;
        }else if(nil_string.equals("4th YR")){
            nil_int_value =  (idv_int*0.43)/100;
        }else if(nil_string.equals("5th YR")){
            nil_int_value =  (idv_int*0.53)/100;
        }

        //getting passenger values form activity
        String pass_string = no_of_passenger.getText().toString();
        int pass_int = Integer.parseInt(pass_string);
        int pass_sum = 886;
        for(int i=1;i<pass_int;i++){
            pass_sum+=886;
        }
        //getting driver from activity
        String driver_string = driver.getText().toString();
        int driver_int = Integer.parseInt(driver_string);
        int wc_int_value = 50;
        for(int i = 1;i<driver_int;i++)
        {
            wc_int_value+=50;
        }


        double a_int_part = od_value - ncb_int_value+nil_int_value+imt_final;
        int tp_int_value = 14494;
        double b_int_part = tp_int_value+cpa_int_value+wc_int_value+pass_sum;
        double total_value = a_int_part+b_int_part;
        double gst_value = (total_value*18)/100;
        double total_final = total_value+gst_value;



        od.setText("OWN DAMAGE: "+od_value);
        nil_dep_value.setText("NIL DEP: +"+nil_int_value);
        ncb_value.setText("NCB: -"+ncb_int_value);
        imt.setText("IMT 23: +"+imt_final);
        disscount_value.setText("DISCOUNT: -"+0.00);
        a_part.setText("A= "+a_int_part);
        tp_value.setText("TP: "+tp_int_value);
        cpa_value.setText("CPA: +"+cpa_int_value);
        wc.setText("WC: +"+wc_int_value);
        passenger.setText("Passenger: +"+pass_sum);
        b_part.setText("B= "+b_int_part);
        a_and_b.setText("A+B= "+total_value);
        gst.setText("GST@18%: "+Math.ceil(gst_value));
        total.setText("TOTAL = "+Math.ceil(total_final));
        premium.setText("PREMIUM = "+Math.round(total_final));

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
