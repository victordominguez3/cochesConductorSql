package services.storage

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import models.Coche
import utils.LocalDateAdapter
import java.io.File

@OptIn(ExperimentalStdlibApi::class)
object JsonService: CochesService {

    private val path = "${System.getProperty("user.dir")}${File.separator}data${File.separator}coches.json"
    val fichero = File(path)
    private val moshi = Moshi.Builder()
        .add(LocalDateAdapter())
        .addLast(KotlinJsonAdapterFactory())
        .build()
    private val jsonAdapter = moshi.adapter<List<Coche>>()

    override fun exportar(items: List<Coche>) {
        fichero.writeText(jsonAdapter.indent("  ").toJson(items))
    }

    override fun importar(): List<Coche> {
        return jsonAdapter.fromJson(fichero.readText()) ?: emptyList()
    }


}