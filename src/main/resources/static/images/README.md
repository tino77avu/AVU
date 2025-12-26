# Carpeta de Imágenes

Esta carpeta es para almacenar todas las imágenes que se usarán en tu web personal.

## Estructura recomendada

Puedes organizar tus imágenes en subcarpetas:

- `images/` - Imágenes generales
- `images/profile/` - Foto de perfil
- `images/projects/` - Imágenes de proyectos
- `images/backgrounds/` - Imágenes de fondo

## Cómo usar las imágenes en Thymeleaf

Para referenciar una imagen desde tus plantillas HTML:

```html
<img th:src="@{/images/nombre-imagen.jpg}" alt="Descripción" />
```

Ejemplo:
```html
<img th:src="@{/images/profile/foto-perfil.jpg}" alt="Mi foto de perfil" />
```

## Nota

Todas las imágenes en esta carpeta estarán disponibles públicamente en la ruta:
`http://localhost:8080/images/`

