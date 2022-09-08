package org.techtown.tple.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.techtown.tple.MainActivity
import org.techtown.tple.R
import org.techtown.tple.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val btn = findViewById<Button>(R.id.loginBtn)

//        if(TpleSharedPreferences.getUserId(this).isNullOrBlank()     // 저장된 로그인 값이 없을 때
//            || TpleSharedPreferences.getUserPw(this).isNullOrBlank()) {
//            Login()
//        }
//        else {                  // 저장된 로그인 값이 있을 때 --> loginActivity 종료
//            finish()
//        }
        //서버 통신하면 살릴거
        btn.setOnClickListener(){
            finish()
        }
        //서버 통신하면 지울거 로그인 버튼 누르면 무조건 넘어가짐~

        binding.signUp.setOnClickListener() {
            val sign_up = Intent(this, SignUpActivity::class.java)
            startActivity(sign_up)
        }
    }
    fun Login() {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        binding.loginBtn.setOnClickListener(){
            var userID = binding.textID.text.toString()
            var userPW = binding.textPW.text.toString()
            val loginInfo = LoginInfo(userID, userPW)
            postLogin(loginInfo)
        }
    }

    fun postLogin(loginInfo: LoginInfo) {
//        val gson = GsonBuilder().create()
//        val str = gson.toJson(loginInfo)
//        val okHttpClient = OkHttpClient()
//        val requestBody = str.toRequestBody("application/json".toMediaTypeOrNull())
//        val request = Request.Builder()
//            .method("POST", requestBody)
//            .url("주소")
//            .build()
//        okHttpClient.newCall(request).enqueue(object : Callback {
//            override fun onFailure(call: Call, e: IOException) {
//                CoroutineScope(Dispatchers.Main).launch{
//                    Toast.makeText(applicationContext,"로그인 실패",Toast.LENGTH_SHORT).show()
//                }
//                Log.e("fail to login",e.message.toString())
//                Log.e("fail to login",e.toString())
//            }
//            override fun onResponse(call: Call, response: Response) {
//                if(response.isSuccessful) {
//                    val tmpname = response.body.string()
//                    val username = gson.fromJson(tmpname, String::class.java)
//                    TpleSharedPreferences.setUserId(applicationContext, textID.text.toString())
//                    TpleSharedPreferences.setUserPw(applicationContext, textPW.text.toString())
//                    TpleSharedPreferences.setUserName(applicationContext, username)
//
//                    Log.i("Success", response.message)
//                    Log.i("Success", response.toString())
//                    val intent = Intent(applicationContext, MainActivity::class.java)
//                    startActivity(intent)
//                    finish()
//                }
//                else{
//                    Log.e("connection error",response.body.toString())
//                }
//            }
//        })
        //서버 생기면 살릴거
    }


    var backPressedTime : Long = 0
    override fun onBackPressed() {              // 뒤로가기 버튼
        if (System.currentTimeMillis()-backPressedTime <= 2000) {
            finishAffinity()
        }
        else {
            backPressedTime = System.currentTimeMillis()
            Toast.makeText(applicationContext, "뒤로가기를 한번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show()
        }
    }

}
data class LoginInfo(val userId: String, var password: String) {
}