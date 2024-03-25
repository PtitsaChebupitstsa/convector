package com.ptitsa_chebupitsa.onvector.presentation

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.ptitsa_chebupitsa.onvector.ConvectorApp
import com.ptitsa_chebupitsa.onvector.R
import com.ptitsa_chebupitsa.onvector.databinding.FragmentCurrencyConvectTestBinding
import com.ptitsa_chebupitsa.onvector.presentation.adapter.ConvectAdapter
import com.ptitsa_chebupitsa.onvector.presentation.factory.ViewModelFactory
import java.lang.RuntimeException
import javax.inject.Inject

class CurrencyConvectTest : Fragment() {
    private lateinit var viewModel: CurrencyConvectViewModel
    private var _binding: FragmentCurrencyConvectTestBinding? = null
    private val binding: FragmentCurrencyConvectTestBinding
        get() = _binding ?: throw RuntimeException("FragmentCurrencyConvectTestBinding is null")
    private lateinit var convectAdapter: ConvectAdapter
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val component by lazy {
        (requireActivity().application as ConvectorApp).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCurrencyConvectTestBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRv()
        inputValueListener()
        viewModel = ViewModelProvider(this, viewModelFactory).get(CurrencyConvectViewModel::class.java)
        viewModel.currencyList.observe(viewLifecycleOwner) { convectedCurrencies ->
            convectAdapter.submitList(convectedCurrencies)
        }
    }


    private fun setUpRv(){
        val rvConvectCurrency = binding.rvConvectTest
        with(rvConvectCurrency){
            convectAdapter = ConvectAdapter()
            adapter = convectAdapter
        }

    }
    private fun inputValueListener(){
        binding.tvAmount.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Ничего не делаем
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Ничего не делаем
            }

            override fun afterTextChanged(s: Editable?) {
                try {
                    val value = s?.toString()?.takeIf { it.isNotBlank() }?.toDoubleOrNull() ?: 0.0
                    viewModel.convect(value)
                } catch (e: NumberFormatException) {
                    // Обработка ошибки преобразования строки в число
                    // Например, вы можете показать пользователю сообщение об ошибке
                }
            }
        })
    }
}