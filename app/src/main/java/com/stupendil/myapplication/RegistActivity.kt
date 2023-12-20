package com.stupendil.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import io.reactivex.Observable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.github.kittinunf.fuel.httpGet
import com.google.firebase.auth.FirebaseAuth
import com.jakewharton.rxbinding2.widget.RxTextView
import com.stupendil.myapplication.databinding.ActivityRegistBinding


@SuppressLint("CheckResult")
class RegistActivity : AppCompatActivity(), View.OnKeyListener {

    private lateinit var binding: ActivityRegistBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

//  Auth
        auth = FirebaseAuth.getInstance()

//  Email Validation
        val emailStream = RxTextView.textChanges(binding.emailHint)
            .skipInitialValue()
            .map { email ->
                !Patterns.EMAIL_ADDRESS.matcher(email).matches()
            }
        emailStream.subscribe{
            showEmailValidAlert(it)
        }

//  Password Validation
        val passwordStream = RxTextView.textChanges(binding.passwordHint)
            .skipInitialValue()
            .map { password ->
                password.length < 8
            }
        passwordStream.subscribe{
            showTextMinimalAlert(it, "Password")
        }

//  Confirm Password Validation
        val passwordConfirmStream = Observable.merge(
            RxTextView.textChanges(binding.passwordHint)
                .skipInitialValue()
                .map { password ->
                    password.toString() != binding.confirmPasswordHint.text.toString()
                },
            RxTextView.textChanges(binding.confirmPasswordHint)
                .skipInitialValue()
                .map { confirmPassword ->
                    confirmPassword.toString() != binding.passwordHint.text.toString()
                })
        passwordConfirmStream.subscribe{
            showPasswordConfirmAlert(it)
        }

//  Botton Enable True or False
        val invalidFieldStream = Observable.combineLatest(
            emailStream,
            passwordStream,
            passwordConfirmStream,
            {emailInvalid: Boolean, passwordInvalid: Boolean, passwordConfirmInvalid: Boolean ->
                !emailInvalid && !passwordInvalid && !passwordConfirmInvalid
            })
        invalidFieldStream.subscribe{ isValid ->
            if (isValid) {
                binding.registBtnIn.isEnabled = true
                binding.registBtnIn.backgroundTintList = ContextCompat.getColorStateList(this, R.color.primary)
            } else {
                binding.registBtnIn.isEnabled = false
                binding.registBtnIn.backgroundTintList = ContextCompat.getColorStateList(this, R.color.Grey)
            }
        }


        val bundle = intent.extras
        if (bundle != null){
            etEmail.setText(bundle.getString("Nickname"))
            etPassword.setText(bundle.getString("Password"))
            etConfirmPassword.setText((bundle.getString("Confirm Password")))
        }

        binding.registBtnIn.setOnClickListener{
            val email = binding.emailHint.text.toString().trim()
            val password = binding.passwordHint.text.toString().trim()
            registerUser(email, password)
        }

        binding.toLogin.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }

        showGIF()
        main()

    }

    private fun showGIF() {
        val imageView: ImageView = findViewById(R.id.iv_regist)
        Glide.with(this).load(R.drawable.registpict).into(imageView)
    }

    override fun onKey(v: View?, event: Int, keyEvent: KeyEvent?): Boolean {
        return false
    }


//    private fun showNameExistAlert(isNotValid: Boolean){
//        binding.emailHint.error = if (isNotValid) "Email cannot be empty" else null
//    }
    private fun showEmailValidAlert(isNotValid: Boolean){
        binding.emailHint.error = if (isNotValid) "Invalid Email" else null
    }

    private fun showTextMinimalAlert(isNotValid: Boolean, text: String){
        if (text == "Password")
            binding.passwordHint.error = if (isNotValid) "$text password must be 8 characters long" else null
    }

    private fun showPasswordConfirmAlert(isNotValid: Boolean){
        binding.confirmPasswordHint.error = if (isNotValid) "The password is not the same" else null
    }

    private fun registerUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    startActivity(Intent(this, OtpActivity::class.java))
                    Toast.makeText(this, "Register Success", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }
    }

    fun main() {
        val url = "http://localhost:8082/"

        val (_, _, result) = url.httpGet().responseString()
        when (result) {
            is com.github.kittinunf.result.Result.Success -> {
                val data = result.get()
                println("Data from server: $data")
            }
            is com.github.kittinunf.result.Result.Failure -> {
                val ex = result.getException()
                println("Failed to retrieve data: $ex")
            }
        }
    }

}