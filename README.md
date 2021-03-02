# market
## Consumo servicios 


### Listar productos

```json
Method = GET
Url = localhost:8080/products
Content-Type = application/json

```

### Crea el carrito con una lista inicial de productos

```json
Method = POST
Url = localhost:8080/cart/nombre-carrito
Content-Type = application/json
Body = 
[
    {
        "product": {
            "id": 1,
            "name": "111asd",
            "sku": "Llaves para hacer duplicados",
            "description": "Llaves"
        },
        "quantity": 10
    }
]

```

### Listar todos los productos y su carrito asociado

```json
Method = GET
Url = localhost:8080/products/carts
Content-Type = application/json

```

