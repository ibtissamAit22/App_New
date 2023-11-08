package com.example.app_new

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.app_new.DatabaseHandler.testDatabaseConnection
import com.example.app_new.ui.theme.App_NewTheme
import android.widget.TextView
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.appcompat.app.AppCompatActivity



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Add the code to set up the "Save Point" button click listener
        val savePointButton = findViewById<Button>(R.id.savePointButton)
        savePointButton.setOnClickListener {
            showSavePointDialog()
        }

        val isConnected = testDatabaseConnection()

        // Get a reference to the TextView
        val splashMessageTextView = findViewById<TextView>(R.id.splashText)

        if (isConnected) {
            // Database connection successful
            splashMessageTextView.text = "Database connected. Starting the app..."
        } else {
            // Database connection failed
            splashMessageTextView.text = "Unable to connect to the database. Please check your connection."
        }

    }
}

private fun showSavePointDialog() {
    val dialogFragment = SavePointDialogFragment()
    val activity = AppCompatActivity()
    dialogFragment.show(activity.supportFragmentManager, "SavePointDialog")
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    App_NewTheme {
        Greeting("Android")
    }


}