package com.rasis.myloginmvvm2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rasis.myloginmvvm2.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        viewModel.btnstate.observe(this, Observer {
            binding.loginBtnSubmit.isEnabled=it
        })
        binding.apply {
            loginEtPassword.doAfterTextChanged {
                viewModel.checkUserPass(loginEtUsername.text.toString(),loginEtPassword.text.toString())
            }
            loginEtUsername.doAfterTextChanged {
                viewModel.checkUserPass(loginEtUsername.text.toString(),loginEtPassword.text.toString())
            }

        }
    }
}