package com.example.apitraining.view.user

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.apitraining.R
import kotlinx.android.synthetic.main.fragment_user.*

class UserFragment : Fragment() {

    private val viewModel:UserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        huy.setOnClickListener {
            findNavController().navigate(R.id.user_to_post)
        }
        viewModel.userLiveData.observe(viewLifecycleOwner){
            Log.d("TAG", "onViewCreated: "+it)
        }
        viewModel.getUser()
    }

}