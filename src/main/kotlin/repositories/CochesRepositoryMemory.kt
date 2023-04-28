package repositories

import enums.TipoMotor
import models.Coche
import models.Conductor
import services.storage.DataBaseManager
import java.util.*

class CochesRepositoryMemory(
    val database: DataBaseManager = DataBaseManager
): CrudRepository<Coche, Long> {

    private var coches = mutableListOf<Coche>()

    override fun exportar(): List<Coche> {
        return coches
    }

    override fun importar(items: List<Coche>) {
        coches.clear()
        coches = items.toMutableList()
    }

    override fun buscarTodos(): List<Coche> {
        val sqlScript = "SELECT * FROM TCoches"
        database.connection.prepareStatement(sqlScript).use {stm ->
            val result = stm.executeQuery()
            while (result.next()) {
                coches.add(
                    Coche(
                        result.getLong("id"),
                        UUID.fromString(result.getString("idCond")),
                        result.getString("marca"),
                        result.getString("modelo"),
                        result.getDouble("precio"),
                        TipoMotor.valueOf(result.getString("tipoMotor"))
                    )
                )
            }
        }
        return coches
    }

//    override fun actualizar(item: Coche): Coche? {
//
//    }

    override fun guardar(item: Coche): Coche? {
        TODO("Not yet implemented")
    }

    override fun eliminarPorId(id: Long): Coche? {
        TODO("Not yet implemented")
    }

    override fun buscarPorId(id: Long): Coche? {
        TODO("Not yet implemented")
    }


}