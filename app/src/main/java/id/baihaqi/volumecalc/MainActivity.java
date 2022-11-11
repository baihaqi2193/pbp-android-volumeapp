package id.baihaqi.volumecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtWidth;
    private EditText edtLength;
    private EditText edtHeight;
    private Button btnCalculate;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtHeight = findViewById(R.id.text_fieldTinggi);
        edtLength = findViewById(R.id.text_fieldPanjang);
        edtWidth = findViewById(R.id.text_fieldLebar);
        btnCalculate = findViewById(R.id.button_calculateVolume);
        tvResult = findViewById(R.id.text_displayHasil);

        btnCalculate.setOnClickListener(this);
        tvResult.setText("0");

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.button_calculateVolume) {
            String inputLength = edtLength.getText().toString().trim();
            String inputWidth = edtWidth.getText().toString().trim();
            String inputHeight = edtHeight.getText().toString().trim();
            String errorText = "Field ini harus diisi!";

            boolean isInvalid = false;

            if(inputLength.isEmpty()) {
                isInvalid = true;
                edtLength.setError(errorText);
            }
            if(inputHeight.isEmpty()) {
                isInvalid = true;
                edtHeight.setError(errorText);
            }if(inputWidth.isEmpty()) {
                isInvalid = true;
                edtWidth.setError(errorText);
            }

            if (!isInvalid) {
                Integer volume = Integer.valueOf(inputHeight) * Integer.valueOf(inputLength) * Integer.valueOf(inputWidth);
                tvResult.setText(String.valueOf(volume) + "m^3");
            }


        }
    }
}