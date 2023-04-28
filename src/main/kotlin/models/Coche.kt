package models

import enums.TipoMotor
import java.util.UUID

class Coche(
    val id: Long,
    val idCond: UUID,
    val marca: String,
    val modelo: String,
    val precio: Double,
    val tipoMotor: TipoMotor
) {
}