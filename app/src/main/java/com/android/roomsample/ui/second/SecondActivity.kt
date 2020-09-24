package com.android.roomsample.ui.second

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.roomsample.R
import com.android.roomsample.data.local.User
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {


    private lateinit var factory: SecondViewModelFactory
    private lateinit var viewModel: SecondViewModel

    private var usersAdapter: UsersAdapter? = null

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        factory = SecondViewModelFactory(application)
        viewModel = ViewModelProvider(this, factory).get(SecondViewModel::class.java)


        viewModel.allUsers.observe(this) { users ->
            initUsersList(users)

            supportActionBar?.title = getString(R.string.saved_users_n, users.size)

            if (users.isNullOrEmpty()) {

                tvMessage.apply {

                    setText(R.string.no_users)
                    visibility = View.VISIBLE

                }//apply

            } else {
                tvMessage.visibility = View.GONE
            }

        }

    }//onCreate()

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    private fun initUsersList(users: List<User>) {

        usersAdapter = UsersAdapter(users)

        usersRecyclerView.apply {

            layoutManager = LinearLayoutManager(this@SecondActivity)
            adapter = usersAdapter

        }//apply

    }//initUsersList()

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {

            android.R.id.home -> {
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }

    }//onOptionsItemSelected()

}