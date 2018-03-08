package at.se2einzelphase;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText inputString;
    private Button btnCheckString;
    private TextView outputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputString = findViewById(R.id.editTextInput);
        btnCheckString = findViewById(R.id.btnCheckString);
        outputText = findViewById(R.id.textViewOutput);

        btnCheckString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = inputString.getText().toString();
                if(input == null || input.trim().length() == 0) {
                    outputText.setTextColor(Color.RED);
                    outputText.setText("Eingabe darf nicht leer sein!");
                    inputString.setText("");
                }else if(input.length() < 5) {
                    outputText.setTextColor(Color.RED);
                    outputText.setText("Eingabe muss mindestens 5 Zeichen lang sein!");
                }else {
                    boolean isPal = isPalindrome(input);
                    if(isPal) {
                        outputText.setTextColor(Color.GREEN);
                        outputText.setText("Eingabe ist ein Palindrom!");
                    }else {
                        outputText.setTextColor(Color.RED);
                        outputText.setText("Eingabe ist kein Palindrom!");
                    }
                }
            }
        });
    }

    public static boolean isPalindrome(String str)	{
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}
