package ajarara.io.app.db.contacts

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact(
    @PrimaryKey val id: Int,
    val name: String,
    val phoneNumber: String,
    val lastUpdated: Long)