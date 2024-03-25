package com.ptitsa_chebupitsa.onvector.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.ptitsa_chebupitsa.onvector.ConvectorApp
import com.ptitsa_chebupitsa.onvector.databinding.ActivityMainBinding
import com.ptitsa_chebupitsa.onvector.presentation.factory.ViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


private val binding by lazy {
ActivityMainBinding.inflate(layoutInflater)
}
    private val component by lazy {
        (application as ConvectorApp).component
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        }


    }




