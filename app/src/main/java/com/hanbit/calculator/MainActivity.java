package com.hanbit.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hanbit.calculator.domain.CalcDTO;
import com.hanbit.calculator.service.CalcService;
import com.hanbit.calculator.service.CalcServiceImpl;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etNum1,etNum2;
    Button btPlus,btMinus,btMulti,btDivde,btMod,btEqual;
    TextView tvResult;
    int result;
    CalcService service;
    CalcDTO cal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNum1= (EditText) findViewById(R.id.etNum1);
        etNum2= (EditText) findViewById(R.id.etNum2);
        btPlus= (Button) findViewById(R.id.btPlus);
        btMinus= (Button) findViewById(R.id.btMinus);
        btMulti= (Button) findViewById(R.id.btMulti);
        btDivde= (Button) findViewById(R.id.btDivde);
        btMod= (Button) findViewById(R.id.btMod);
        btEqual= (Button) findViewById(R.id.btEqual);
        tvResult= (TextView) findViewById(R.id.tvResult);
        btPlus.setOnClickListener(this);
        btMinus.setOnClickListener(this);
        btMulti.setOnClickListener(this);
        btDivde.setOnClickListener(this);
        btEqual.setOnClickListener(this);
        service = new CalcServiceImpl();
        cal = new CalcDTO();
    }

    @Override
    public void onClick(View v) {
        int num1 = Integer.parseInt(etNum1.getText().toString());
        int num2 = Integer.parseInt(etNum2.getText().toString());
        cal.setNum1(num1);
        cal.setNum2(num2);
        switch (v.getId()){
            case R.id.btPlus:
                result = service.plus(cal);
                break;
            case R.id.btMinus:
                result = num1 - num2;
                break;
            case R.id.btMulti:
                result = num1 * num2;
                break;
            case R.id.btDivde:
                result = num1 / num2;
                break;
            case R.id.btMod:
                result = num1 % num2;
                break;
            case R.id.btEqual:
                tvResult.setText("RESULT :"+result);
                break;
        }

    }
}
