package com.example.englishlearnapp

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.englishlearnapp.ui.LaunchActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

const val TAG = "Login"
class SignInActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    private lateinit var mName: EditText
    private lateinit var mEmail: EditText
    private lateinit var mPassword: EditText
    private lateinit var mConfirmPassword: EditText
    private lateinit var btnSignIn: Button
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signin_activity)

        auth = FirebaseAuth.getInstance()
        mName = findViewById(R.id.etName)
        mEmail = findViewById(R.id.etEmail)
        mPassword = findViewById(R.id.etPassword)
        mConfirmPassword = findViewById(R.id.etConfirmPassword)
        btnLogin = findViewById(R.id.btnLogin)
        btnSignIn = findViewById(R.id.btnSignIn)



//        val user: FirebaseUser? = auth.currentUser
////        val userId:String = user!!.uid
//
//        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
//        databaseReference.child("$user").setValue(hashMap)



        btnSignIn.setOnClickListener {
            val name = mName.text.toString()
            val email = mEmail.text.toString()
            val password = mPassword.text.toString()
            val confirmPassword = mConfirmPassword.text.toString()

            if (TextUtils.isEmpty(name)) {
                Toast.makeText(applicationContext, "Name is required", Toast.LENGTH_SHORT).show()
            } else if (TextUtils.isEmpty(email)) {
                Toast.makeText(applicationContext, "Email is required", Toast.LENGTH_SHORT).show()
            } else if (TextUtils.isEmpty(password)) {
                Toast.makeText(applicationContext, "Password is required", Toast.LENGTH_SHORT).show()
            } else if (TextUtils.isEmpty(confirmPassword)) {
                Toast.makeText(applicationContext, "Confirm password is required", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Toast.makeText(applicationContext, "Password not match", Toast.LENGTH_SHORT).show()
            }else {
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this) {
                            if (it.isSuccessful) {
                                val user: FirebaseUser? = auth.currentUser
                                val userId:String = user!!.uid
                                Log.d(TAG, "registerUser: $userId ")

                                databaseReference = FirebaseDatabase.getInstance().getReference("Users").child("userId")

                                val hashMap: HashMap<String, String> = HashMap()
                                hashMap.put("userId", userId)
                                hashMap.put("name", name)
                                hashMap.put("email", email)
                                hashMap.put("password", password)
                                hashMap.put("profileImage", "")

                                databaseReference.setValue(hashMap).addOnCompleteListener(this) {
                                    if (it.isSuccessful) {
                                        Log.d("SignInActivity", "Completed")
                                        val intent = Intent(this@SignInActivity, LaunchActivity::class.java)
                                        startActivity(intent)
                                    }
                                }
                            }
                        }
            }
        }

    }

    private fun registerUser(name: String, email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) {
                    if (it.isSuccessful) {
                        val user: FirebaseUser? = auth.currentUser
                        val userId:String = user!!.uid
                        Log.d(TAG, "registerUser: $userId ")

                        databaseReference = FirebaseDatabase.getInstance().getReference("Users").child("$userId")

                        val hashMap: HashMap<String, String> = HashMap()
                        hashMap.put("userId", userId)
                        hashMap.put("name", name)
                        hashMap.put("email", email)
                        hashMap.put("password", password)
                        hashMap.put("profileImage", "")

                        databaseReference.setValue(hashMap).addOnCompleteListener(this) {
                            if (it.isSuccessful) {
                                Log.d("SignInActivity", "Completed")
                                val intent = Intent(this@SignInActivity, LaunchActivity::class.java)
                                startActivity(intent)
                            }
                        }
                    }
                }
    }
}