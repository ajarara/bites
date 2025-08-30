package ajarara.io.app.db

import ajarara.io.app.db.contacts.Contact
import ajarara.io.app.db.contacts.ContactsDao
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contactsDao(): ContactsDao
}