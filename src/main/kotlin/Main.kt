import config.AppConfig
import repositories.CochesRepositoryMemory
import services.storage.DataBaseManager

fun main(args: Array<String>) {
    val data = DataBaseManager
    val repo = CochesRepositoryMemory(data)
    println(repo.buscarTodos())
}