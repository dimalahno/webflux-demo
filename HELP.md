# Web Flux Demo

## Rest Api

### Common RESTs

* GET : http://localhost:8080/math/square/5
* GET : http://localhost:8080/math/table/5

### Reactive RESTs
* GET : http://localhost:8080/reactive-math/square/5
* GET : http://localhost:8080/reactive-math/table/5
* GET : http://localhost:8080/reactive-math/table/{input}/stream
* POST : http://localhost:8080/reactive-math/multiply Body: {"first": 5,"second": 5}

### Functional RESTs
* GET : http://localhost:8080/router/square/5
* GET : http://localhost:8080/router/table/5
* GET : http://localhost:8080/router/table/{input}/stream
* POST : http://localhost:8080/router/multiply Body: {"first": 5,"second": 5}
