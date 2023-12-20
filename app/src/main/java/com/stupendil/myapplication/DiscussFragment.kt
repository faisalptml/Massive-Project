package com.stupendil.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.stupendil.myapplication.databinding.FragmentDiscussBinding

class DiscussFragment : Fragment() {
    private var mBinding: FragmentDiscussBinding? = null
    private val binding get() = mBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentDiscussBinding.inflate(inflater, container, false)

        binding?.btnBengkel?.setOnClickListener {
            val intent = Intent(requireContext(), ComunityDiscussActivity::class.java)
            startActivity(intent)
            Log.d("Discuss Fragment", "Button Clicked")
        }
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

}