package com.example.thibanglaixe.fragment

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.thibanglaixe.activity.MainActivity
import com.example.thibanglaixe.databinding.FragmentLoginBinding
import com.example.thibanglaixe.storage.MySharedPreference


class FragmentLogin: Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var mySharedPreference: MySharedPreference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        mySharedPreference = MySharedPreference(requireContext())

        binding.toolbarBack.setOnClickListener {
            (activity as MainActivity).onBackPressed()
        }

        checkLoginOrSignUp()
        loginOrSignUp()
        forgetPassword()
        checkPassword()

        return view
    }

    override fun onResume() {
        super.onResume()

        binding.editUsername.setText("")
        binding.editPassword.setText("")
        binding.checkboxShowPassword.isChecked = false
    }

    private fun checkPassword(){
        binding.checkboxShowPassword.setOnClickListener {
            if(binding.checkboxShowPassword.isChecked){
                binding.editPassword.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD;

            } else {
                binding.editPassword.inputType = InputType.TYPE_CLASS_TEXT or
                        InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
        }
    }

    private fun checkLoginOrSignUp(){
        binding.textSignUp.setOnClickListener {
            if(binding.textLogin.text == "Đăng nhập"){
                binding.textLogin.text = "Đăng ký"
                binding.textForget.visibility = View.GONE
                binding.buttonLogin.text = "Đăng ký"
                binding.textSignUp.text = "Bạn đã có tài khoản? Đăng nhập"
            } else {
                binding.textLogin.text = "Đăng nhập"
                binding.textForget.visibility = View.VISIBLE
                binding.buttonLogin.text = "Đăng nhập"
                binding.textSignUp.text = "Không có tài khoản? Đăng ký"
            }
        }
    }

    private fun forgetPassword(){
        binding.textForget.setOnClickListener {
            val userName = binding.editUsername.text.toString().trim()
            if(mySharedPreference.findKey(userName) == null){
                Toast.makeText(requireContext(), "Người dùng không tồn tại", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), mySharedPreference.getStringValue(userName), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loginOrSignUp(){
        binding.buttonLogin.setOnClickListener {
            val userName = binding.editUsername.text.toString().trim()
            val password = binding.editPassword.text.toString().trim()

            if(binding.textLogin.text == "Đăng ký"){
                if (binding.editUsername.text.toString().contains(" ")) {
                    Toast.makeText(requireContext(), "Tên đăng nhập không được chứa khoảng trống!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                if(mySharedPreference.findKey(userName) == null){
                    mySharedPreference.putStringValue(userName, password)
                    Toast.makeText(requireContext(), "Tạo tài khoản thành công!", Toast.LENGTH_SHORT).show()
                    (activity as MainActivity).onBackPressed()
                } else {
                    Toast.makeText(requireContext(), "Tên đăng nhập đã có người sử dụng.\nXin mời tạo lại!", Toast.LENGTH_SHORT).show()
                }
            } else {
                if(mySharedPreference.getStringValue(userName) != password){
                    Toast.makeText(requireContext(), "Tên đăng nhập hoặc mật khẩu không chính xác!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show()
                    (activity as MainActivity).onBackPressed()
                }
            }
        }
    }

}