package repositories

interface CrudRepository<T, Long> {
    fun exportar(): List<T>
    fun importar(items: List<T>)
    fun buscarTodos(): List<T>
    fun buscarPorId(id: Long): T?
    fun eliminarPorId(id: Long): T?
    fun guardar(item: T): T?
//    fun actualizar(item: T): T?
}