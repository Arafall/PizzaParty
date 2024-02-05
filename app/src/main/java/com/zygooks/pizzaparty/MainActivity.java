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
        //mHowHungryRadioGroup =
    }

    // calculateClick is called from a button component interaction and
    // passes the specific component that called it.
    public void calculateClick(View view) {
        // Take the text value from the saved text box component and
        // convert it to an integer for calculations.
        String numAttendStr = mNumAttendEditText.getText().toString();
        int numAttend = Integer.getInteger(numAttendStr);

        // Calculate how many total pizzas required based on number of people, pieces for each person,
        // and the constant for slices on each pizza.
        // Multiply number of people with how many slices each gets rounded
        // up to get total slices needed.
        // Now divided by the slice number of each pizza to get total pizzas required.
        int slicesPerPerson = 4;
        int totalPizzas = (int) Math.ceil(numAttend * slicesPerPerson / (double) SLICES_PER_PIZZA);
        // Set a text display asset to show the calculated number.
        // Calls setText method to change text output to the view;
        mNumPizzasTextView.setText("Total pizzas: " + totalPizzas);
    }
}