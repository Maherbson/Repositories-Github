package com.maherbson.repositoriesgithub.features.repositories.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.maherbson.repositoriesgithub.databinding.ActivityMainBinding

class RepositoriesActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}