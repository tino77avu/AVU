# Guía de Despliegue en Render

## Archivos Docker Creados

1. **Dockerfile**: Configuración para construir la imagen Docker
2. **.dockerignore**: Archivos que se excluyen del build
3. **render.yaml**: Configuración opcional para Render

## Pasos para Desplegar en Render

### Opción 1: Usando el Dashboard de Render

1. **Crear una cuenta en Render** (si no tienes una)
   - Ve a https://render.com
   - Regístrate o inicia sesión

2. **Crear un nuevo Web Service**
   - En el dashboard, haz clic en "New +"
   - Selecciona "Web Service"

3. **Conectar tu repositorio**
   - Conecta tu repositorio de GitHub/GitLab/Bitbucket
   - O sube el código directamente

4. **Configurar el servicio**
   - **Name**: `avu-web` (o el nombre que prefieras)
   - **Environment**: `Docker`
   - **Dockerfile Path**: `AVU/Dockerfile`
   - **Docker Context**: `AVU`
   - **Plan**: Free (o el plan que prefieras)

5. **Variables de Entorno** (opcional)
   - `PORT`: Render lo asigna automáticamente
   - `JAVA_OPTS`: `-Xmx512m -Xms256m` (para limitar memoria)
   - Si usas base de datos externa, agrega las variables correspondientes

6. **Desplegar**
   - Haz clic en "Create Web Service"
   - Render construirá y desplegará tu aplicación automáticamente

### Opción 2: Usando render.yaml

Si tienes el archivo `render.yaml` en tu repositorio:
1. Render detectará automáticamente el archivo
2. Sigue las instrucciones en el dashboard para usar la configuración del archivo

## Configuración de Base de Datos

### Para Producción en Render:

1. **Crear una base de datos PostgreSQL** (recomendado para Render)
   - En Render, crea un nuevo "PostgreSQL" service
   - Copia las credenciales de conexión

2. **Actualizar application.properties** o usar variables de entorno:
   ```properties
   spring.datasource.url=${DATABASE_URL}
   spring.datasource.username=${DB_USER}
   spring.datasource.password=${DB_PASSWORD}
   spring.datasource.driver-class-name=org.postgresql.Driver
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Agregar variables de entorno en Render**:
   - `DATABASE_URL`: URL completa de la base de datos
   - `DB_USER`: Usuario de la base de datos
   - `DB_PASSWORD`: Contraseña de la base de datos

## Construcción Local del Docker

Para probar localmente antes de desplegar:

```bash
# Construir la imagen
docker build -t avu-app ./AVU

# Ejecutar el contenedor
docker run -p 8080:8080 avu-app
```

## Notas Importantes

- **Puerto**: Render asigna automáticamente el puerto mediante la variable `PORT`
- **Memoria**: El plan gratuito tiene límites de memoria, ajusta `JAVA_OPTS` si es necesario
- **Base de Datos**: H2 en memoria no es adecuado para producción, usa PostgreSQL o MySQL
- **Logs**: Puedes ver los logs en tiempo real desde el dashboard de Render

## Solución de Problemas

### Error de puerto
- Asegúrate de que `application.properties` use `${PORT:8080}`

### Error de memoria
- Ajusta `JAVA_OPTS` en las variables de entorno
- Considera actualizar a un plan con más recursos

### Error de base de datos
- Verifica que las variables de entorno estén correctamente configuradas
- Asegúrate de que la base de datos esté accesible desde Render

