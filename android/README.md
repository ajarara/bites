# android
A single module (for now) playground, based off of UiAutomator's sample code. 

# Realm vs Room
We're going with Room, since it's closer to JDBI which is what I'm more familiar with. Given the difficulty of figuring out a query log for Realm (unless there's dedicated tooling), opaque query construction and execution feels like a bad idea. I at least get the first with Room. 

Realm has cross platform support.

# demonstration through API
https://github.com/r-spacex/SpaceX-API
here's a relatively rich one with a deep entity stack. We can simulate updates artificially, just increment a number or something.

# general architecture
Any given view subscribes to table(s) -- room has this built in, I think all I need to do is have the dao reference the tables. We need a way to mark the end of data -- sql rows don't tell us anything: the only real way I can think of to communicate page requests is through something that listens to EOF and terminates the flow. 

Maybe flow is not the right approach for paginated queries -- at least not a flatMap. There are some techniques that make the sqlite database single source of truth. How well does that work with pagination and stale entries?
