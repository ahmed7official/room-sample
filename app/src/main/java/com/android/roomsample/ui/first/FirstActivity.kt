package com.android.roomsample.ui.first

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.android.roomsample.R
import com.android.roomsample.data.local.User
import com.android.roomsample.ui.second.SecondActivity
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {

    private lateinit var factory: FirstViewModelFactory
    private lateinit var viewModel: FirstViewModel

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        supportActionBar?.title = getString(R.string.add_new_user)

        factory = FirstViewModelFactory(application)
        viewModel = ViewModelProvider(this, factory).get(FirstViewModel::class.java)


        btnAdd.setOnClickListener(btnAddClickListener)

        btnShowSaved.setOnClickListener {

            startActivity(Intent(this, SecondActivity::class.java))

        }

    }//onCreate()

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    private val btnAddClickListener = View.OnClickListener {

        if (validateInputs()) {

            val user = User(
                name = inputName.text.toString().trim(),
                age = inputAge.text.toString().trim(),
                job = inputJobTitle.text.toString().trim(),
                gender = inputGender.text.toString().trim(),
            )


            viewModel.insert(user)
            Toast.makeText(this, "User added successfully", Toast.LENGTH_SHORT).show()


            inputName.setText("")
            inputAge.setText("")
            inputJobTitle.setText("")
            inputGender.setText("")

        }//if

    }//btnAddClickListener

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    private fun validateInputs(): Boolean {

        if (inputName.text.isNullOrBlank()) {
            Toast.makeText(this, "Name Required", Toast.LENGTH_SHORT).show()
            return false
        }


        if (inputAge.text.isNullOrBlank()) {
            Toast.makeText(this, "Age Required", Toast.LENGTH_SHORT).show()
            return false
        }



        if (inputJobTitle.text.isNullOrBlank()) {
            Toast.makeText(this, "Job Title Required", Toast.LENGTH_SHORT).show()
            return false
        }




        if (inputGender.text.isNullOrBlank()) {
            Toast.makeText(this, "Gender Required", Toast.LENGTH_SHORT).show()
            return false
        }


        return true
    }//validateInputs()

}