package com.maherbson.repositoriesgithub.features.repositories.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.maherbson.repositoriesgithub.databinding.ActivityRepositoriesBinding

class RepositoriesActivity : AppCompatActivity() {

    private val binding: ActivityRepositoriesBinding by lazy {
        ActivityRepositoriesBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}