package com.example.budgetasyougo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.SQLException

class RegisterActivity : AppCompatActivity() {
    private lateinit var edtFirstName: EditText
    private lateinit var edtLastName: EditText
    private lateinit var edtUsername: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        edtFirstName = findViewById(R.id.edtFirstName)
        edtLastName = findViewById(R.id.edtLastName)
        edtUsername = findViewById(R.id.edtUsername)
        edtPassword = findViewById(R.id.edtPassword)
        btnRegister = findViewById(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val firstName = edtFirstName.text.toString().trim()
            val lastName = edtLastName.text.toString().trim()
            val username = edtUsername.text.toString().trim()
            val password = edtPassword.text.toString().trim()

            if (firstName.isEmpty() || lastName.isEmpty() || username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
            } else {
                registerUser(firstName, lastName, username, password)
            }
        }
    }

    private fun registerUser(firstName: String, lastName: String, username: String, password: String) {
        CoroutineScope(Dispatchers.IO).launch {
            var connection: Connection? = null
            var preparedStatement: PreparedStatement? = null

            try {
                connection = DatabaseConnection.connect()

                if (connection != null) {
                    val sql = "INSERT INTO users (username, first_name, last_name, password) VALUES (?, ?, ?, ?)"
                    preparedStatement = connection.prepareStatement(sql)
                    preparedStatement.setString(1, username)
                    preparedStatement.setString(2, firstName)
                    preparedStatement.setString(3, lastName)
                    preparedStatement.setString(4, password)

                    val rowsInserted = preparedStatement.executeUpdate()

                    runOnUiThread {
                        if (rowsInserted > 0) {
                            Toast.makeText(this@RegisterActivity, "Registration Successful!", Toast.LENGTH_SHORT).show()
                            finish()
                        } else {
                            Toast.makeText(this@RegisterActivity, "Failed to register. Try again.", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    runOnUiThread {
                        Toast.makeText(this@RegisterActivity, "Database connection failed!", Toast.LENGTH_LONG).show()
                    }
                }
            } catch (e: SQLException) {
                e.printStackTrace()
                runOnUiThread {
                    Toast.makeText(this@RegisterActivity, "SQLException: ${e.message}", Toast.LENGTH_LONG).show()
                }
            } catch (e: Exception) {
                e.printStackTrace()
                runOnUiThread {
                    Toast.makeText(this@RegisterActivity, "Unexpected error: ${e.message}", Toast.LENGTH_LONG).show()
                }
            } finally {
                try {
                    preparedStatement?.close()
                    connection?.close()
                } catch (e: SQLException) {
                    e.printStackTrace()
                }
            }
        }
    }
}
