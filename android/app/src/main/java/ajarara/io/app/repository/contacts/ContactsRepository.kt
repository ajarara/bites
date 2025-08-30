package ajarara.io.app.repository.contacts

import ajarara.io.app.db.contacts.Contact
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onSubscription
import kotlinx.coroutines.flow.scan
import kotlinx.coroutines.flow.withIndex
import kotlinx.coroutines.launch
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap

class ContactsRepository(
    private val coroutineScope: CoroutineScope
) {
    private val contacts: ConcurrentMap<Int, MutableSharedFlow<Contact>> = ConcurrentHashMap()

    fun listen(ids: Set<Int>): Flow<Map<Int, Contact>> {
        val contactFlows = ids.map { id ->
            contacts.getOrPut(id) {
                val out = MutableSharedFlow<Contact>()
                out.subscriptionCount
                    .map { count -> count > 0 }
                    .distinctUntilChanged()
                    // we launch this immediately, before we get any subscribers, so we
                    // ignore the first isActive = false emission we inevitably get
                    .drop(1)
                    .onEach { isActive ->
                        if (isActive) {
                            coroutineScope.launch {
                                out.emit(queryForIds(listOf(id)).single())
                            }
                        } else {
                            contacts.remove(id)
                        }
                    }
                    .launchIn(coroutineScope)
                out
            }
        }

        return contactFlows.merge()
            .scan(mapOf()) { map, contact ->
                map + (contact.id to contact)
            }
    }

    private suspend fun queryForIds(ids: List<Int>): List<Contact> {
        return listOf(Contact(1, "fake", "123456789", 15))
    }

}