package algonquin.cst2335.kala0049.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
    }
}