﻿# save-to-many

 A "save to many" repository in Spring Jpa for reference use.

- POST on localhost:8080/products
 ```
{
  "name": "Produto novo",
  "price": 1000.0,
  "categories": [
    {
    "id": 2
    },
    {
    "id": 3
    }
  ]
}
```
