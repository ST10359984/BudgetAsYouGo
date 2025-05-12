package com.example.budgetasyougo

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object DatabaseConnection {
    private const val DB_URL = "jdbc:oracle:thin:@//10.0.2.2:1521/XEPDB1"
    private const val USER = "budget_as_you_go"
    private const val PASSWORD = "budget123"

    fun connect(): Connection? {
        return try {
            Class.forName("oracle.jdbc.driver.OracleDriver")
            val connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)
            println("Database connection successful.")
            connection
        } catch (e: SQLException) {
            e.printStackTrace()
            println("SQLException: ${e.message}")
            null
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
            println("ClassNotFoundException: ${e.message}")
            null
        }
    }
}

