package ajarara.io.app.repository.contacts

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.test.TestScope
import org.junit.Test
import kotlinx.coroutines.test.runTest

class ContactsRepositoryTest {
    private val testScope = TestScope()
    private val contactsRepository = ContactsRepository(testScope)

    @Test
    fun subscriptionGetsValues() = runTest {
        contactsRepository.listen(setOf(1, 2, 3))
    }

}