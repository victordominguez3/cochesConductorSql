package services.storage

import config.AppConfig
import org.apache.ibatis.jdbc.ScriptRunner
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.SQLException
import java.util.Properties

object DataBaseManager {
    val connection get() = DriverManager.getConnection(AppConfig.APP_URL)
    val initSqlScript: String = "${System.getProperty("user.dir")}${File.separator}src${File.separator}main${File.separator}resources${File.separator}initSqlScript.sql"

    init {
        ejecutarSql(initSqlScript)
    }

    private fun ejecutarSql(sql: String) {
        val sr = ScriptRunner(connection)
        val script = BufferedReader(FileReader(sql))
        sr.runScript(script)
    }
}