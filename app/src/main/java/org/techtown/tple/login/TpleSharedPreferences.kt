package org.techtown.tple.login

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

object TpleSharedPreferences{
    private val myAccount : String = "account"

    fun setUserId(context: Context, input: String ) {
        val prefs : SharedPreferences = context.getSharedPreferences(myAccount, MODE_PRIVATE)
        val editors : SharedPreferences.Editor = prefs.edit()
        editors.putString("my_Id", input)
        editors.commit()
    }
    fun getUserId(context: Context) : String {
        val prefs : SharedPreferences = context.getSharedPreferences(myAccount, MODE_PRIVATE)
        return prefs.getString("my_Id","").toString()
    }
    fun setUserPw(context: Context, input: String) {
        val prefs : SharedPreferences = context.getSharedPreferences(myAccount, MODE_PRIVATE)
        val editors : SharedPreferences.Editor = prefs.edit()
        editors.putString("my_Pw", input)
        editors.commit()
    }
    fun getUserPw(context: Context) : String {
        val prefs : SharedPreferences = context.getSharedPreferences(myAccount, MODE_PRIVATE)
        return prefs.getString("my_Pw","").toString()
    }
    fun setUserName(context: Context, input: String ) {
        val prefs : SharedPreferences = context.getSharedPreferences(myAccount, MODE_PRIVATE)
        val editors : SharedPreferences.Editor = prefs.edit()
        editors.putString("my_Name", input)
        editors.commit()
    }
    fun getUserName(context: Context) : String {
        val prefs : SharedPreferences = context.getSharedPreferences(myAccount, MODE_PRIVATE)
        return prefs.getString("my_Name","").toString()
    }
    fun clearInfo(context: Context){
        val pref : SharedPreferences = context.getSharedPreferences(myAccount, MODE_PRIVATE)
        val editor : SharedPreferences.Editor = pref.edit()
        editor.remove("my_Id")
        editor.remove("my_Pw")
        editor.commit()
    }
}
class Manager(val context: Context){
    companion object{
        lateinit var information : Information
        fun a(context: Context){
            information = Information(TpleSharedPreferences.getUserId(context),TpleSharedPreferences.getUserPw(context),
                TpleSharedPreferences.getUserName(context),null)

        }
    }
}
