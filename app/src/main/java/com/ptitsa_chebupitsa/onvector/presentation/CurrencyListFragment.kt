package com.ptitsa_chebupitsa.onvector.presentation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.ptitsa_chebupitsa.onvector.ConvectorApp
import com.ptitsa_chebupitsa.onvector.R
import com.ptitsa_chebupitsa.onvector.databinding.FragmentCurrencyListBinding
import com.ptitsa_chebupitsa.onvector.presentation.adapter.CurrencyListAdapter
import com.ptitsa_chebupitsa.onvector.presentation.factory.ViewModelFactory
import java.lang.RuntimeException
import javax.inject.Inject

class CurrencyListFragment : Fragment() {
    private lateinit var viewModel: CurrencyListViewModel
    private var _binding: FragmentCurrencyListBinding? = null
    private val binding: FragmentCurrencyListBinding
        get() = _binding ?: throw RuntimeException("FragmentCurrencyListBinding is null")
    private lateinit var currencyListAdapter: CurrencyListAdapter

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
        _binding = FragmentCurrencyListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRV()
        viewModel = ViewModelProvider(this, viewModelFactory)[CurrencyListViewModel::class.java]
        viewModel.currencyInfoList.observe(viewLifecycleOwner) {
            currencyListAdapter.submitList(it)
        }
    }

    private fun setUpRV() {
        val rvCurrencyList = binding.rvCurrencyList
        with(rvCurrencyList) {
            currencyListAdapter = CurrencyListAdapter()
            adapter = currencyListAdapter
        }
        elementClickListener()//Todo сделать реализацию нажатия на элемент
    }

    private fun elementClickListener() {
        currencyListAdapter.onCurrencyItemClickListener = {

        }
    }
}