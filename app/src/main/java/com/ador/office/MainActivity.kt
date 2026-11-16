package com.ador.office

import android.os.Bundle
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val blue = Color.rgb(21, 101, 192)
    private val dark = Color.rgb(25, 35, 55)
    private val background = Color.rgb(245, 247, 250)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        createHomeScreen()
    }

    private fun createHomeScreen() {

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(background)
            setPadding(20, 35, 20, 20)
        }

        val scroll = android.widget.ScrollView(this)

        val content = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
        }

        val title = TextView(this).apply {
            text = "Ador Office"
            textSize = 30f
            setTextColor(blue)
            typeface = Typeface.DEFAULT_BOLD
        }

        content.addView(title)

        val subtitle = TextView(this).apply {
            text = "Your All-in-One Document Manager"
            textSize = 14f
            setTextColor(Color.DKGRAY)
            setPadding(0, 5, 0, 25)
        }

        content.addView(subtitle)

        addSection(content, "Document Tools")

        addButton(content, "📝  Create Word Document") {
            showMessage("Document Creator coming soon")
        }

        addButton(content, "📘  Word to PDF") {
            showMessage("Word to PDF coming soon")
        }

        addButton(content, "📕  PDF to Word") {
            showMessage("PDF to Word coming soon")
        }

        addSection(content, "PDF Tools")

        addButton(content, "✏️  Edit PDF") {
            showMessage("PDF Editor coming soon")
        }

        addButton(content, "🔗  Merge PDF") {
            showMessage("Merge PDF coming soon")
        }

        addButton(content, "✂️  Split PDF") {
            showMessage("Split PDF coming soon")
        }

        addButton(content, "📂  My Documents") {
            showMessage("Document Manager coming soon")
        }

        val footer = TextView(this).apply {
            text = "ADor Office • Version 1.0"
            textSize = 12f
            gravity = Gravity.CENTER
            setTextColor(Color.GRAY)
            setPadding(0, 30, 0, 15)
        }

        content.addView(footer)

        scroll.addView(content)
        root.addView(
            scroll,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
        )

        setContentView(root)
    }

    private fun addSection(
        parent: LinearLayout,
        text: String
    ) {

        val heading = TextView(this).apply {
            this.text = text
            textSize = 19f
            setTextColor(dark)
            typeface = Typeface.DEFAULT_BOLD
            setPadding(0, 12, 0, 12)
        }

        parent.addView(heading)
    }

    private fun addButton(
        parent: LinearLayout,
        text: String,
        action: () -> Unit
    ) {

        val button = com.google.android.material.button.MaterialButton(this).apply {
            this.text = text
            textSize = 15f
            isAllCaps = false
            cornerRadius = 18
            setBackgroundColor(blue)
            setTextColor(Color.WHITE)
            setPadding(12, 18, 12, 18)
            setOnClickListener {
                action()
            }
        }

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        params.setMargins(0, 5, 0, 10)

        parent.addView(button, params)
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
