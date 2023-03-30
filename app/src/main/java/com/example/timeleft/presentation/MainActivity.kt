package com.example.timeleft.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.timeleft.R
import com.example.timeleft.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ShowFragment {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (savedInstanceState == null)
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, TimeLeftFragment())
                .commit()
    }

    override fun show(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .add(R.id.container, SettingsFragment())
            .addToBackStack(SettingsFragment().javaClass.simpleName)
            .commit()
    }
}

interface ShowFragment {

    fun show(fragment: Fragment)

    class Empty: ShowFragment {
        override fun show(fragment: Fragment) = Unit
    }
}