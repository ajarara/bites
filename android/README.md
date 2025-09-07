# android
A single module (for now) playground, based off of UiAutomator's sample code. 

# pending
come up with an app skeleton that has:
- room for persistence
- androidx subclasses, AppCompatActivity, Fragment base classes
- kotlin coroutines
- retrofit for networking
- instrumentation tests
- unit tests
- multi module
- versions managed in buildSrc

We have most of this already, we just need to clean up the configuration.

# demonstration through API
http://www3.septa.org/#/ real time, free, a rich enough model.

# general architecture
general architecture is a bad name: a specific stack/paradigm has its place and niche. They are designed for different things. It would be great if we could all adopt a single source of truth sqlite database, having network requests write to said database and refreshing as the data comes in. A place where that really falls apart is paginated feeds: users don't have the expectation that their feeds are persisted or available offline. However they definitely expect their _messages_ to be persisted and available offline, that's where a client side table makes sense.

Another nuance is view recreation: android may kill your activity or your application. You get around the first through saved instance state, but you cannot get around the second without filesystem persistence. And if you want to preserve the backstack, god help you, there's probably no way to do that in sqlite.

For the places where users have the expectation, the common paradigm is the client side database as the client's source of truth: a network call initiated by the client deposits those rows (instead of ferrying them to the view), and then room requeries (using a table level trigger).

For the main app, we use:
- retrofit for the network requests
- hilt (for now) for DI, maybe in a couple days move onto dagger
- coroutines
