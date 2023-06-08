package algonquin.cst2335.kala0049.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import algonquin.cst2335.kala0049.data.MainViewModel;
import algonquin.cst2335.kala0049.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding variableBinding;
    private MainViewModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new ViewModelProvider(this).get(MainViewModel.class);
        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());
        variableBinding.mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editString = variableBinding.editText.getText().toString();
                variableBinding.mytextview.setText( "Your edit text has: " + editString);
            }
        });
        variableBinding.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            model.isSelected.postValue(isChecked);
        });
        variableBinding.switch1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            model.isSelected.postValue(isChecked);
        });
        variableBinding.radioButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            model.isSelected.postValue(isChecked);
        });
        model.isSelected.observe(this, selected -> {
            variableBinding.checkBox.setChecked(selected);
            variableBinding.switch1.setChecked(selected);
            variableBinding.radioButton.setChecked(selected);
            Toast.makeText(getApplicationContext(),"the value is now: "+ selected, Toast.LENGTH_SHORT).show();
        });
        variableBinding.myimageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int width = variableBinding.imageView.getWidth();
                int height = variableBinding.imageView.getHeight();
                Toast.makeText(getApplicationContext(), "The width = " + width + " and height = " + height,Toast.LENGTH_SHORT).show();
            }
        });
    }
}