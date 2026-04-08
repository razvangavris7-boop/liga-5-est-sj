package com.example.liga_5_est_sj

import android.content.Context
import android.widget.Toast
import java.util.regex.Pattern


object AccountHelper {

    fun checkPasswordMatch(newPassword: String, confirmPassword: String) : Boolean {
        return if (newPassword !=confirmPassword) {
            false
        } else true
    }

    fun validatePass(context: Context?, password: String) : Boolean {
        // check for pattern

        val uppercase: Pattern = Pattern.compile("[A-Z]")
        val lowercase: Pattern = Pattern.compile("[a-z]")
        val digit: Pattern = Pattern.compile("[0-9]")


        // if lowercase character is not present
        return if (!lowercase.matcher(password).find()) {
            Toast.makeText(context, R.string.lowercase_character, Toast.LENGTH_SHORT).show()
            false
        }
        // if uppercase character is not present
        else if (!uppercase.matcher(password).find()) {
            Toast.makeText(context, R.string.uppercase_character, Toast.LENGTH_SHORT).show()
            false
        }
        // if digit is not present
        else if (!digit.matcher(password).find()) {
            Toast.makeText(context, R.string.digit_character, Toast.LENGTH_SHORT).show()
            false
        }
        // if password length is less than 8
        else if (password.length < 8) {
            Toast.makeText(context, R.string.password_length, Toast.LENGTH_SHORT).show()
            false
        } else true
    }
}