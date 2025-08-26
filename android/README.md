# android
A single module (for now) playground, based off of UiAutomator's sample code. 

# Realm vs Room
We're going with Room, since it's closer to JDBI which is what I'm more familiar with. Given the difficulty of figuring out a query log for Realm (unless there's dedicated tooling), opaque query construction and execution feels like a bad idea. I at least get the first with Room. 

Realm has cross platform support.
