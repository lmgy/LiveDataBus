# LiveDataBusSample
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2Flmgy%2FLiveDataBus.svg?type=shield)](https://app.fossa.io/projects/git%2Bgithub.com%2Flmgy%2FLiveDataBus?ref=badge_shield)


[![](https://jitpack.io/v/lmgy/LiveDataBus.svg)](https://jitpack.io/#lmgy/LiveDataBus)

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

## Install

Step 1. Add the JitPack repository to your build file

``` groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency

``` groovy
dependencies {
	implementation 'com.github.lmgy:LiveDataBus:1.0.0'
}
```

## Requirements

* Minimum Android version: >= 4.1 (API 16)

## License
-------

Copyright (C) 2018 lmgy

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements.  See the NOTICE file distributed with this work for
additional information regarding copyright ownership.  The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License.  You may obtain a copy of
the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
License for the specific language governing permissions and limitations under
the License.


[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2Flmgy%2FLiveDataBus.svg?type=large)](https://app.fossa.io/projects/git%2Bgithub.com%2Flmgy%2FLiveDataBus?ref=badge_large)