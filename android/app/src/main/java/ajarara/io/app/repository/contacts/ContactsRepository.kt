package ajarara.io.app.repository.contacts

import ajarara.io.app.db.contacts.Contact
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.scan
import kotlinx.coroutines.launch
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap


class ContactsRepository(
    private val coroutineScope: CoroutineScope,
) {
    private val activeFlows = ConcurrentHashMap<Int, MutableSharedFlow<Contact>>()

    fun listen(ids: Set<Int>): Flow<Map<Int, Contact>> {
        val contactFlows = ids.map { id ->
            flowForId(id)
        }

        return contactFlows.merge()
            // consider a debounce here
            // ideally for large queries we don't construct n maps
            // we could reduce then emit an immutable copy through debounce
            .scan(mapOf()) { map, contact ->
                map + (contact.id to contact)
            }
    }

    fun handleContactsTableChangeNotification() {
        coroutineScope.launch {
            queryForIds(activeFlows.keys).forEach { contact ->
                activeFlows[contact.id]?.tryEmit(contact)
            }
        }
    }

    private fun flowForId(id: Int): MutableSharedFlow<Contact> =
        activeFlows.getOrPut(id) {
            val out = MutableSharedFlow<Contact>(replay = 1)

            // FIXME: LEAK
            // firing off a coroutine that waits for subscribers means in lock
            // contention scenarios this may be evaluated and never actually
            // subscribed to
            // probably the right approach is to shareIn from the upstream flow
            val job = coroutineScope.launch {
                out.subscriptionCount
                    .map { count -> count > 0 }
                    .distinctUntilChanged()
                    .collect { isActive ->
                        if (isActive) {
                            out.emit(queryForIds(listOf(id)).single())
                        } else {
                            cancel()
                        }
                    }
            }
            job.invokeOnCompletion { activeFlows.remove(id, out) }
            out
        }

    private suspend fun queryForIds(ids: Collection<Int>): List<Contact> {
        return listOf(Contact(1, "fake", "123456789", 15))
    }
}