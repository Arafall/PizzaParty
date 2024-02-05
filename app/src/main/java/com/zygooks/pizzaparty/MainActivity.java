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
        // findViewById is called to get a reference to an asset in the activity.
        // This will link a value to the actual component and allow changes to the asset.
        // The id is grabbed from the R class which stores the xml id index as a constant.
        mNumAttendEditText = findViewById(R.id.num_attend_edit_text);
        mNumPizzasTextView = findViewById(R.id.num_pizzas_text_view);
        mHowHungryRadioGroup = findViewById(R.id.hungry_radio_group);
    }

    // calculateClick is called from a button component interaction and
    // passes the specific component that called it.
    public void calculateClick(View view) {
        // Take the text value from the saved text box component and
        // convert it to an integer for calculations.
        String numAttendStr = mNumAttendEditText.getText().toString();
        int numAttend = Integer.parseInt(numAttendStr);

        int slicesPerPerson = 0;
        // Get the index of what radio button was selected and change
        // how many slices are set for each individual.
        int checkedId = mHowHungryRadioGroup.getCheckedRadioButtonId();
        if (checkedId == R.id.light_radio_button) {
            slicesPerPerson = 2;
        }
        else if (checkedId == R.id.medium_radio_button) {
            slicesPerPerson = 3;
        }
        else if (checkedId == R.id.ravenous_radio_button) {
            slicesPerPerson = 4;
        }

        // Calculate how many total pizzas required based on number of people, pieces for each person,
        // and the constant for slices on each pizza.
        // Multiply number of people with how many slices each gets rounded
        // up to get total slices needed, then divide by slices per pizza for total pizzas.
        int totalPizzas = (int) Math.ceil(numAttend * slicesPerPerson / (double) SLICES_PER_PIZZA);
        // Set a text display asset to show the calculated number.
        // Calls setText method to change text output to the view;
        mNumPizzasTextView.setText("Total pizzas: " + totalPizzas);
    }
}