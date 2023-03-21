# Taller 2 - Angie Tatiana Peña

## Parte 1 - REST PASEOS


### Instalación

Para correr e instalar las dependencias de proyecto se debe dirigir a la carpeta server y ejecutar los siguientes comandos

```bash
mvn clean install
```

### Punto 1

Imprimir la lista de paseos disponibles en el lado del servidor.

```bash
curl http://localhost:8080/paseos/getAll
```

### Punto 2

Borrar un paseo utilizando como argumento el identificador del mismo. La próxima vez que se consulte la lista de paseos, el paseo eliminado no deberá aparecer.

```bash
curl http://localhost:8080/paseos/deleteById?id=30
```

### Punto 3

Modificar el origen y destino de un paseo.

```bash
curl -X POST -H "Content-type: application/json" -d '{"ID": "11","origen": "Bogotaaaa","destino": "Bebe"}' http://localhost:8080/paseos/add
```

### Punto 4

Construir un paseo y enviarlo en formato JSON hacia el servidor a través de un mensaje POST. La próxima vez que se consulte la lista de paseos, el paseo creado debe estar disponible y debe haber sido guardado en la lista del servidor

```bash
curl -X POST -H "Content-type: application/json" -d '{"ID": "11","origen": "Bogota","destino": "Manizales"}' http://localhost:8080/paseos/edit
```

## Parte 2 - Spring Cloud


### Instalación

Para correr estos proyectos se debe dirigir a cada una de las carpetas correspondientes siguiendo los siguientes pasos:

1. Correr el Server
   Dirigirse a la carpeta de myServer y ejecutar los siguientes comandos:
```bash
mvn clean install
mvn spring-boot:run
```
2. Correr la calculadora
   Dirigirse a la carpeta de calculator y ejecutar los siguientes comandos:
```bash
mvn clean install
mvn spring-boot:run
```
3. Correr cada uno de los servicios de la calculadora
   En este caso se debe ir a cada una de las carpetas de los microservicios (addition,substraction,multiply, divisor) y ejecutar los siguientes comandos:
```bash
mvn clean install
mvn spring-boot:run
```

### Punto 1 y 2

Agregue una funcionalidad a cada operación para que persista cada una de las invocaciones que se hacen, la fecha de la invocación y el nombre del usuario que hizo la consulta.
Modifique la calculadora para que consuma los nuevos servicios de las operaciones con las uris:
*calculadora/resta?a=34&b=9985&user=Julio
*calculadora/multip?a=34&b=454&user=Jaime
*calculadora/div?a=34&b=0 &user=Mariela

Esta URI nos sirve para usar el servicio de division desde la calculadora usando el load balancer segun los parametros exigidos:

```
http://localhost:8777/calculadora/divisor?a=10&b=21&user=tatis
```

La siguiente URI es para hacer uso directamente del servicio sin pasar por el load balancer segun los parametros exigidos:

```
http://localhost:9092/multiply?a=10&b=21&user=tatis
```

> Para usar otro servcio simplemente de debe cambiar en este caso el multiply, por cualquiera de los otros servicios (divisor, substraction, addition)

### Punto 3

Agregue una nueva funcionalidad a la calculadora que permita consultar el historial de utilización de cada operación. La respuesta debe mostrarse en JSON en el navegador.

Accediendo a esta URI se pueden observar los logs de todas las operaciones

```
http://localhost:8777/calculadora/logs
```

Para acceder a los logs de un servicio en especifico se debe usar la siguiente URI

```
http://localhost:port/logs
```
>En este debemos especificar el puerto del servicio del cual queremos mirar los logs
