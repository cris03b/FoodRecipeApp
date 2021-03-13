package com.cris.usernameapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ImageView
import android.widget.Toast
import androidx.core.graphics.drawable.toDrawable
import kotlinx.android.synthetic.main.activity_forgot_password.*

class ForgotPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        editEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(text: Editable) {
                val enabledButtons = text.length > 10
                buttonYes.isEnabled = enabledButtons
                buttonNo.isEnabled = enabledButtons
            }

        })

        var count = 0
        val pictureList = arrayListOf<Int>()
        val context = imagePicture.context
        val id1 = context.resources.getIdentifier("picture1", "drawable", context.packageName)
        val id2 = context.resources.getIdentifier("picture2", "drawable", context.packageName)
        val id3 = context.resources.getIdentifier("picture3", "drawable", context.packageName)
        val id4 = context.resources.getIdentifier("picture4", "drawable", context.packageName)
        val id5 = context.resources.getIdentifier("picture5", "drawable", context.packageName)

        pictureList.addAll(listOf(id1, id2, id3, id4, id5))
        buttonNo.setOnClickListener {

            /* pictureList.addAll(
                 listOf(
                     R.drawable.picture1,
                     R.drawable.picture2,
                     R.drawable.picture3,
                     R.drawable.picture4,
                     R.drawable.picture5
                 )
             )*/

            if (count == pictureList.size) {
                count = 0
            }
            imagePicture.setImageResource(pictureList[count])
            count++

            //imagePicture.setImageResource(R.drawable.picture1)

        }


        buttonYes.setOnClickListener {
            val emailStr = editEmail.text.toString()

            if (emailStr == "cris03b@yahoo.com") {
                if (count == 0 && id3 != id4) {
                    Toast.makeText(this, "Ups... wrong picture. Try again!", Toast.LENGTH_SHORT).show()
                }
                else if (pictureList[count - 1] == id4) {
                    Toast.makeText(this, "All good!", Toast.LENGTH_SHORT).show()
                }
                else {
                    Toast.makeText(this, "Ups... wrong picture. Try again!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Ups... wrong email. Try again!", Toast.LENGTH_SHORT).show()
            }
        }

    }

}
