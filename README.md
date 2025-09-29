# HappyFeet Veterinaria

Proyecto Java conectado a MySQL.

## Configuración

1. Crear la base de datos en MySQL:

```sql
CREATE DATABASE HappyFeet;
```

2. Usa tu usuario `campus2023` con contraseña `campus2023`.

3. Compilar y ejecutar:

```bash
mvn clean package
java -cp target/HappyFeet-1.0-SNAPSHOT.jar com.happyfeet.Main
```

## Funcionalidades

- Listar dueños (`duenos`)
- Listar mascotas (`mascotas`)
