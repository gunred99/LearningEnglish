package com.example.englishlearnapp.ui.login

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.englishlearnapp.R
import com.example.englishlearnapp.ui.main.MainActivity
import com.example.englishlearnapp.ui.signin.SignInActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

const val TAG = "Login"

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    private lateinit var mBtnLogin: Button
    private lateinit var mAddAccount: TextView
    private lateinit var mEmail: EditText
    private lateinit var mPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        auth = Firebase.auth

        mBtnLogin = findViewById(R.id.mBtnLogin)
        mAddAccount = findViewById(R.id.mAddAccount)
        mEmail = findViewById(R.id.mLabelEmail)
        mPassword = findViewById(R.id.mLabelPassword)

        mAddAccount.setOnClickListener {
            val i = Intent(this, SignInActivity::class.java)
            startActivity(i)
        }
        mBtnLogin.setOnClickListener {
            loginUser()
        }

    }

    public override fun onStart() {
        super.onStart()

    }
    private fun loginUser() {
        val email = mEmail.text.toString()
        val password = mPassword.text.toString()

        if (TextUtils.isEmpty(email) && (TextUtils.isEmpty(password))) {
            Toast.makeText(applicationContext, "Email or password are required", Toast.LENGTH_SHORT)
                .show()
        } else {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) {
                    if (it.isSuccessful) {
                        val user: FirebaseUser? = auth.currentUser
                        val userId: String = user!!.uid
                        Log.d(com.example.englishlearnapp.ui.signin.TAG, "registerUser: $userId ")

                        databaseReference =
                            FirebaseDatabase.getInstance().getReference("Users").child(userId)

                        val hashMap: HashMap<String, String> = HashMap()
                        hashMap.set("email", email)
                        hashMap.set("password", password)

                        databaseReference.setValue(hashMap).addOnSuccessListener(this) {
                                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                                startActivity(intent)
                        }

                    } else {
                        Toast.makeText(
                            applicationContext,
                            "Email or password invalid",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
    }
}