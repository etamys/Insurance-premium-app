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

public class misc extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
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
    private TextView overturning;
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
    private TextView imt_value_output;
    private CheckBox imt_box;
    private CheckBox overturning_box;
    private CheckBox cpa_box;
    private  double imt_int;
    private  double overturning_int;
    private EditText driver;
    private EditText no_of_passenger;
    private TextView discount_value;
    private int cpa_int_value;
    private int idv_int;
    private double ncb_check = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_misc);

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
        overturning = findViewById(R.id.overturning);
        a_part = findViewById(R.id.a_part);
        tp_value  =findViewById(R.id.tp);
        cpa_value = findViewById(R.id.cpa);
        discount_value = findViewById(R.id.discount);
        b_part = findViewById(R.id.b_part);
        a_and_b = findViewById(R.id.a_and_b);
        gst = findViewById(R.id.gst);
        total = findViewById(R.id.total);
        premium = findViewById(R.id.premium);
        premium = findViewById(R.id.premium);
        wc = findViewById(R.id.wc);
        passenger = findViewById(R.id.passenger);
        imt_value_output = findViewById(R.id.imt);
        driver = findViewById(R.id.editText3);
        no_of_passenger = findViewById(R.id.editText4);
        imt_box = findViewById(R.id.checkBox9);
        overturning_box = findViewById(R.id.checkBox11);
        cpa_box = findViewById(R.id.checkBox10);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateResult();
            }
        });

    }

    /**
     * Update the UI when user click on the Calculate button
     */
    private void updateResult() {
        String idv_string = idv.getText().toString();
        idv_int = Integer.parseInt(idv_string);

        //checkBox values
        cpa_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cpa_box.isChecked()){
                    cpa_int_value = 295;
                }else if(!cpa_box.isChecked()){
                    cpa_int_value = 0;
                }
            }
        });

        //value for ncb when ncb is checked

        overturning_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(overturning_box.isChecked()){
                    overturning_int = 100;
                    ncb_check = 20.0;
                }else if(!overturning_box.isChecked()){
                    overturning_int = 0;
                }
            }
        });
        imt_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imt_box.isChecked()){
                    imt_int = (idv_int*0.18)/100;
                }else if(!imt_box.isChecked()){
                    imt_int = 0;
                }
            }
        });

        //setting zone spin
        String zone_string =zone_spin.getSelectedItem().toString();
        double zone_int=0;
        if(zone_string.equals("A")){
            zone_int = 1.21;
        }else if(zone_string.equals("B")){
            zone_int  = 1.20;
        }else if(zone_string.equals("C")){
            zone_int = 1.19;
        }
        //setting age spin
        String age_string = age_spin.getSelectedItem().toString();
        double age_int=0;
        if( zone_string.equals("A") && age_string.equals("5-7 YRS")){
            age_int = 0.03;
        }else if(zone_string.equals("A") && age_string.equals(">7 YRS")){
            age_int = 0.06;
        }else if( zone_string.equals("B") && age_string.equals("5-7 YRS")){
            age_int = 0.03;
        }else if(zone_string.equals("B") && age_string.equals(">7 YRS")){
            age_int = 0.06;
        }else if( zone_string.equals("C") && age_string.equals("5-7 YRS")){
            age_int = 0.03;
        }else if(zone_string.equals("C") && age_string.equals(">7 YRS")){
            age_int = 0.06;
        }
        double od_value;
        od_value = (idv_int*(zone_int+age_int))/100;
        //getting ncb spin

        String ncb_string = ncb_spin.getSelectedItem().toString();
        double ncb_int_value=0;
        if(ncb_string.equals("20")){
            ncb_int_value =  (idv_int*0.24)/100;
            ncb_int_value+=ncb_check;
        }else if(ncb_string.equals("25")){
            ncb_int_value =  (idv_int*0.30)/100;
            ncb_int_value+=ncb_check;
        }else if(ncb_string.equals("35")){
            ncb_int_value =  (idv_int*.42)/100;
            ncb_int_value+=ncb_check;
        }else if(ncb_string.equals("45")){
            ncb_int_value =  (idv_int*0.54)/100;
            ncb_int_value+=ncb_check;
        }else if(ncb_string.equals("50")){
            ncb_int_value =  (idv_int*0.59)/100;
            ncb_int_value+=ncb_check;
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
        }else if(nil_string.equals("5 Yr")){
            nil_int_value =  (idv_int*0.53)/100;
        }
        //getting passenger values form activity
        String pass_string = no_of_passenger.getText().toString();
        int pass_int = Integer.parseInt(pass_string);
        int pass_sum = 0;
        for(int i=0;i<pass_int;i++){
            pass_sum+=60;
        }
        //getting driver from activity
        String driver_string = driver.getText().toString();
        int driver_int = Integer.parseInt(driver_string);
        int wc_int_value = 50;
        for(int i = 1;i<driver_int;i++)
        {
            wc_int_value+=50;
        }



        double a_int_part = od_value+imt_int+overturning_int-nil_int_value;
        int tp_int_value = 6847;

        double b_int_part = tp_int_value+ cpa_int_value +wc_int_value+pass_sum ;
        double total_value = a_int_part+b_int_part;
        double gst_value = (total_value*18)/100;
        double total_final = total_value+gst_value;



        od.setText("OWN DAMAGE: "+od_value);
        nil_dep_value.setText("NIL DEP: +"+nil_int_value);
        imt_value_output.setText("IMT 23: +"+imt_int);
        ncb_value.setText("NCB: -"+ncb_int_value);
        overturning.setText("Overturning: +"+overturning_int);
        a_part.setText("A= "+a_int_part);
        tp_value.setText("TP: "+tp_int_value);
        cpa_value.setText("CPA: +"+ cpa_int_value);
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
