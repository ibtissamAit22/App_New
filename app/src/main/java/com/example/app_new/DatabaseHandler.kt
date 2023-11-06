package com.example.app_new

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object DatabaseHandler {
    private const val DB_URL = "jdbc:postgresql://192.168.100.89:5432/DB_New"
    private const val DB_USER = "postgres"
    private const val DB_PASSWORD = "azerty"

    fun getConnection(): Connection? {
        return try {
            Class.forName("org.postgresql.Driver") // Load the PostgreSQL JDBC driver
            DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
            null
        } catch (e: SQLException) {
            e.printStackTrace()
            null
        }
    }

    fun insertLocation(latitude: Double, longitude: Double) {
        val insertQuery = "INSERT INTO saved_points (latitude, longitude) VALUES (?, ?"
        getConnection()?.use { connection ->
            connection.prepareStatement(insertQuery).use { preparedStatement ->
                preparedStatement.setDouble(1, latitude)
                preparedStatement.setDouble(2, longitude)
                preparedStatement.executeUpdate()
            }
        }
    }


    fun testDatabaseConnection(): Boolean {
        val dbUrl = "jdbc:postgresql://192.168.100.89:5432/DB_New"
        val dbUser = "postgres"
        val dbPassword = "azerty"

        var connection: Connection? = null
        var isConnected = false

        try {
            Class.forName("org.postgresql.Driver") // Load the PostgreSQL JDBC driver
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)

            if (connection != null && !connection.isClosed) {
                isConnected = true
            }
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        } catch (e: SQLException) {
            e.printStackTrace()
        } finally {
            try {
                connection?.close()
            } catch (e: SQLException) {
                e.printStackTrace()
            }
        }

        return isConnected
    }
}
