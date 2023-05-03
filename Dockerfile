#IMAGEN BASE CON TOMCAT Y DEPENDENCIAS
FROM tomcat:9.0-alpine

#COPIA EL JAR COMPILADO EN LA CARPETA INTERNA
COPY /dist/TiendaServiciosWeb.war /usr/local/tomcat/webapps/

#ESTABLECEMOS PUERTO DE SALIDA
EXPOSE 8080

#CORREMOS EL JAR COMPILADO
CMD ["catalina.sh", "run"]

#CONSTRUIR IMAGEN
#docker build -t tiendaweb .

#PARA CORRERLO HAY QUE PUBLICAR HACIA AFUERA N INSTANCIAS
#docker run -it --publish 8081:8080 tiendaweb
#docker run -it --publish 8082:8080 tiendaweb