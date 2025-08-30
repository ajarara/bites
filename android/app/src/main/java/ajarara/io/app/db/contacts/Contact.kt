package ajarara.io.app.db.contacts

data class Contact(
    val id: Int,
    val name: String,
    val phoneNumber: String,
    val lastUpdated: Long)