package com.zygooks.pizzaparty;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    public final int SLICES_PER_PIZZA = 8;
    private EditText mNumAttendEditText;
    private TextView mNumPizzasTextView;
    private RadioGroup mHowHungryRadioGroup;

    // onCreate method is called to allow the activity to interact with the UI.
    // savedInstanceState is the activity state before being destroyed and
    // passed to reinstate the activity state.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Must be called through the super class to reach the method definition in the Activity class.
        // An exception will occur if method is not called.
        super.onCreate(savedInstanceState);

        // The R class is dynamically generated that holds constants for resource values,
        // such as layout, id, string, style, and xml.
        // setContentView method is called to add all the top level views to the activity from a layout resource.
        setContentView(R.layout.activity_main);
        // Retrieve asset data
        mNumAttendEditText = findViewById(R.id.num_attend_edit_text);
        mNumPizzasTextView = findViewById(R.id.num_pizzas_text_view);
        //mHowHungryRadioGroup =
    }

    public void calculateClick(View view) {
        String numAttendStr = mNumAttendEditText.getText().toString();
        int numAttend = Integer.getInteger(numAttendStr);

        int slicesPerPerson = 4;
        int totalPizzas = (int) Math.ceil(numAttend * slicesPerPerson / (double) SLICES_PER_PIZZA);
        mNumPizzasTextView.setText("Total pizzas: " + totalPizzas);
    }
}