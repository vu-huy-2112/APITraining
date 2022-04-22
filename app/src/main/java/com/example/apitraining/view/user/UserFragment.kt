package com.example.apitraining.view.user

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apitraining.R
import com.example.apitraining.view.adapter.UserAdapter
import com.example.apitraining.view.data.user.UserModel
import kotlinx.android.synthetic.main.fragment_user.*

class UserFragment : Fragment() {

    private val viewModel:UserViewModel by viewModels()
    lateinit var adapterUser : UserAdapter

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

        viewModel.userLiveData.observe(viewLifecycleOwner){
            Log.d("TAG", "onViewCreated: "+it)
            getData(it)
        }
        viewModel.getUser()

    }

    private fun getData(it: List<UserModel>) {
        var listUser = it

        adapterUser = UserAdapter(activity,listUser)
        recycle_view_users.adapter = adapterUser
        recycle_view_users.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
    }


}