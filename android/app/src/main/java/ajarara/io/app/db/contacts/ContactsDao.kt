package ajarara.io.app.db.contacts

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ContactsDao {
    @Query("SELECT * FROM contact where id in (:contactIds)")
    fun getById(contactIds: IntArray): List<Contact>
}