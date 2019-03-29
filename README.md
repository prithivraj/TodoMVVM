# TodoMVVM

This is a sample app that is build according to the six core tenets of modern MVVM as heard on the Fragmented Podcast

1. Screens are driven by a single viewmodel. They have a one to one relationship. 
2. Screen listen to a an observable that emits a viewstate.
3. Screens also listen to a an observable called view effects that emits fire-and-forget operations.
4. All view events are funnelled into a single method in the viewmodel.
5. Break chain in the UI when it's time to render.
6. Test the heck out of this system to the point that you practically don't need instrumentation tests. 

The app is split into two modules and by following a similar approach, each screen of your app can be self-containing modules.

Some of these modules may even depend on a common networking/database module.

Roadmap : 
A sample with a network call.
A sample with a database call.
