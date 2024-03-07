package com.ptitsa_chebupitsa.onvector.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.ptitsa_chebupitsa.onvector.ConvectorApp
import com.ptitsa_chebupitsa.onvector.R
import com.ptitsa_chebupitsa.onvector.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

private lateinit var viewModel: MainViewModel
@Inject
lateinit var viewModelFactory: ViewModelFactory
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
        viewModel = ViewModelProvider(this,viewModelFactory)[MainViewModel::class.java]
        viewModel.currencyInfoList.observe(this){
            binding.textText.text = it.size.toString()
        }

    }

}


