package com.stupendil.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.stupendil.myapplication.databinding.FragmentScheduleBinding

class ScheduleFragment : Fragment() {

    private var mBinding: FragmentScheduleBinding? = null
    private val binding get() = mBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentScheduleBinding.inflate(inflater, container, false)

        binding?.btnNextTo5?.setOnClickListener {
            val intent = Intent(requireContext(), CreateScheduleActivity::class.java)
            startActivity(intent)
            Log.d("Schedule Fragment", "Button Clicked")
        }
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }
}
