package com.cs4520.assignment3.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cs4520.assignment3.databinding.FragmentMvpBinding
import com.cs4520.assignment3.databinding.FragmentMvvmBinding
import com.cs4520.assignment3.mvp.CalculatorModel
import com.cs4520.assignment3.mvp.MVPPresenter

class MVVMFragment : Fragment() {
    private lateinit var binding: FragmentMvvmBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflates the view
        binding = FragmentMvvmBinding.inflate(inflater, container, false)
        return binding.root
    }
}