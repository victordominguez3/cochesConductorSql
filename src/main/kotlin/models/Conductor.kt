package models

import java.time.LocalDate
import java.util.UUID

class Conductor(
    val id: UUID,
    val nombre: String,
    val fechaCarnet: LocalDate
) {
}