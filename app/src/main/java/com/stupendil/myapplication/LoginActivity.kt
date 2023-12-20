package com.stupendil.myapplication

import android.annotation.SuppressLint
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
import com.github.kittinunf.result.Result
import com.google.firebase.auth.FirebaseAuth
import com.jakewharton.rxbinding2.widget.RxTextView
import com.stupendil.myapplication.databinding.ActivityLoginBinding


@SuppressLint("CheckResult")
class LoginActivity : AppCompatActivity(), View.OnKeyListener {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        //  Auth
        auth = FirebaseAuth.getInstance()

//  Validasi Email
        val emailValida = RxTextView.textChanges(binding.hintEmail)
            .skipInitialValue()
            .map { email ->
                !Patterns.EMAIL_ADDRESS.matcher(email).matches()
            }
        emailValida.subscribe{
            showEmailValidAlert(it)
        }

        val emailStream = RxTextView.textChanges(binding.hintEmail)
            .skipInitialValue()
            .map { email ->
                email.isEmpty()
            }
        emailStream.subscribe{
            showTextMinimalAlert(it, "Email")
        }

        //  Validasi Password
        val passwordStream = RxTextView.textChanges(binding.hintPassword)
            .skipInitialValue()
            .map { password ->
                password.isEmpty()
            }
        passwordStream.subscribe{
            showTextMinimalAlert(it, "Password")
        }

        //  Button Enable true or false
        val infalidFieldStream = Observable.combineLatest(
            emailStream,
            passwordStream,
            { emailInvalid: Boolean, passwordInvalid: Boolean ->
                !emailInvalid && !passwordInvalid
            })
        infalidFieldStream.subscribe { isValid ->
            if (isValid) {
                binding.loginBtnIn.isEnabled = true
                binding.loginBtnIn.backgroundTintList = ContextCompat.getColorStateList(this, R.color.primary)
            } else {
                binding.loginBtnIn.isEnabled = false
                binding.loginBtnIn.backgroundTintList = ContextCompat.getColorStateList(this, R.color.Grey)
            }
        }

        val bundle = intent.extras
        if (bundle != null){
            etEmail.setText(bundle.getString("Nickname"))
            etPassword.setText(bundle.getString("Password"))
        }

        binding.loginBtnIn.setOnClickListener{
            val email = binding.hintEmail.text.toString().trim()
            val password = binding.hintPassword.text.toString().trim()
            loginUser(email, password)
        }

        binding.forgotPW.setOnClickListener{
            startActivity(Intent(this,LupaPasswordActivity::class.java))
        }

        binding.moveToRegister.setOnClickListener{
            startActivity(Intent(this, RegistActivity::class.java))
        }

        main()
        showGIF()

    }

    private fun showEmailValidAlert(isNotValid: Boolean){
        binding.hintEmail.error = if (isNotValid) "Invalid Email" else null
    }

    private fun showTextMinimalAlert(isNotValid: Boolean, text: String){
        if (text == "Email")
            binding.hintEmail.error = if (isNotValid) "$text can not be empty" else null
        else (text == "Password")
            binding.hintPassword.error = if (isNotValid) "$text can not be empty" else null
    }

    private fun showGIF() {
        val imageView: ImageView = findViewById(R.id.imageView4)
        Glide.with(this).load(R.drawable.loginpict).into(imageView)
    }

    override fun onKey(view: View?, event: Int, keyEvent: KeyEvent?): Boolean {
        return false
    }

    private fun loginUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { login ->
                if (login.isSuccessful) {
                    Intent(this,MainActivity::class.java).also {
                        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(it)
                        Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, login.exception?.message, Toast.LENGTH_SHORT).show()
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