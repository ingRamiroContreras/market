# market

## Instalación de la aplicación:

 - Descargar el proyecto y abrir la carpeta market-tul en el editor de preferencia para la parte Kotlin.
 - Ejecutar el comando **./mvnw clean install** para que se ejecuten  se genere el JAR.
 - validar que el puerto 8080 no esté ocupado ya que el JAR se despliega en el puerto 8080.
 - Ejecutar el JAR creado en la Carpeta target con el comando java -jar <nombre del jar>
 
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

### Listar todos los productos por el id del carrito
```json
Method = GET
Url = localhost:8080/products/carts/{id_cart}
Content-Type = application/json

```

### Actualiza los productos por el id del carrito

```json
Method = PUT
Url = localhost:8080/products/carts/1
Content-Type = application/json
Body = 
[
    {
        "product": {
            "id": 2,
            "name": "Candado YALE",
            "sku": "777asd",
            "description": "Candado de seguridad"
        },
        "quantity": 10
    }
]
```

### Elimina la lsita de productos por el id del carrito

```json
Method = DELETE
Url = localhost:8080/products/carts/{id_cart}
Content-Type = application/json

```

### Retorna un carrito por su id

```json
Method = DELETE
Url = localhost:8080/carts/{id_cart}
Content-Type = application/json

```

### Cambia el estado de un carrito por su id

```json
Method = DELETE
Url = localhost:8080/carts/{id_cart}
Content-Type = application/json

```

