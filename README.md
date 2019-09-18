# LiveDataBusSample

## How to use

- Subscribe

``` kotlin
LiveDataBus.with(Event::class.java).observe(this, Observer {

    Toast.makeText(this, it.message + System.currentTimeMillis(), Toast.LENGTH_LONG).show()

})
```

- Publish

``` kotlin
LiveDataBus.with(Event::class.java).post(Event("post"))
```

- Publish(Sticky)

``` kotlin
LiveDataBus.with(Event::class.java).postSticky(Event("postSticky"))

```

## Requirements

* Minimum Android version: >= 4.1 (API 16)
