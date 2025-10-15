Create database BDServicioIntegral;
go
use BDServicioIntegral;
go
-- TABLAS PRINCIPALES E INDEPENDIENTES --
-- Tabla para todos los usuarios (Clientes y Profesionales)
CREATE TABLE Usuario (
    Usuario_ID INT PRIMARY KEY IDENTITY(1,1),
    Nombre_Completo NVARCHAR(150) NOT NULL,
    Correo_Electronico NVARCHAR(100) UNIQUE NOT NULL,
    Contrasena_Hash NVARCHAR(255) NOT NULL,
    Rol NVARCHAR(50) NOT NULL CHECK (Rol IN ('Cliente', 'Profesional')),
    Fecha_Registro DATETIME NOT NULL DEFAULT GETDATE()
);

-- Tabla de Catálogo para las categorías de servicios
CREATE TABLE Categorias (
    Categoria_ID INT PRIMARY KEY IDENTITY(1,1),
    Nombre NVARCHAR(100) NOT NULL UNIQUE,
    Descripcion NVARCHAR(255)
);

-- Tabla de Catálogo para las habilidades específicas
CREATE TABLE Habilidades (
    Habilidad_ID INT PRIMARY KEY IDENTITY(1,1),
    Nombre NVARCHAR(100) NOT NULL UNIQUE
);

--------------------------------------------------------------------------------

-- TABLAS DEPENDIENTES DE USUARIO Y CATÁLOGOS --

-- Tabla con la información extendida solo para usuarios con Rol 'Profesional'
CREATE TABLE Profesionales (
    Usuario_ID INT PRIMARY KEY,
    Titulo NVARCHAR(150),
    Descripcion_Servicio NVARCHAR(MAX),
    Anos_Experiencia INT,
    Foto_Perfil_URL NVARCHAR(255),
    Telefono NVARCHAR(20),
    Ubicacion NVARCHAR(100),
    Idiomas NVARCHAR(150),
    Estado NVARCHAR(50) DEFAULT 'Activo' CHECK (Estado IN ('Activo', 'Inactivo', 'Ocupado')),
    Promedio_Calificacion DECIMAL(3,2) DEFAULT 0.0,
    Ultima_Conexion DATETIME,
    Tarifa_Hora_Min DECIMAL(10,2),
    Tarifa_Hora_Max DECIMAL(10,2),
    Tarifa_Proyecto_Pequeno_Min DECIMAL(10,2),
    Tarifa_Proyecto_Pequeno_Max DECIMAL(10,2),
    Tarifa_Proyecto_Mediano_Min DECIMAL(10,2),
    Tarifa_Proyecto_Mediano_Max DECIMAL(10,2),
    FOREIGN KEY (Usuario_ID) REFERENCES Usuario(Usuario_ID)
);

-- Tablas de Unión (Muchos a Muchos)
CREATE TABLE Profesional_Categorias (
    Usuario_ID INT NOT NULL,
    Categoria_ID INT NOT NULL,
    PRIMARY KEY (Usuario_ID, Categoria_ID),
    FOREIGN KEY (Usuario_ID) REFERENCES Profesionales(Usuario_ID),
    FOREIGN KEY (Categoria_ID) REFERENCES Categorias(Categoria_ID)
);

CREATE TABLE Profesional_Habilidades (
    Usuario_ID INT NOT NULL,
    Habilidad_ID INT NOT NULL,
    PRIMARY KEY (Usuario_ID, Habilidad_ID),
    FOREIGN KEY (Usuario_ID) REFERENCES Profesionales(Usuario_ID),
    FOREIGN KEY (Habilidad_ID) REFERENCES Habilidades(Habilidad_ID)
);

--------------------------------------------------------------------------------

-- TABLAS TRANSACCIONALES (SOLICITUDES, PROPUESTAS, CALIFICACIONES) --

-- Tabla para solicitudes que un Cliente envía directamente a un Profesional
CREATE TABLE Solicitudes_Directas (
    Solicitud_ID INT PRIMARY KEY IDENTITY(1,1),
    Cliente_ID INT NOT NULL,
    Profesional_ID INT NOT NULL,
    Titulo NVARCHAR(200) NOT NULL,
    Descripcion_Problema NVARCHAR(MAX),
    Presupuesto_Min DECIMAL(10,2),
    Presupuesto_Max DECIMAL(10,2),
    Urgencia NVARCHAR(50) CHECK (Urgencia IN ('Baja', 'Media', 'Alta')),
    Estado NVARCHAR(50) DEFAULT 'Nueva' CHECK (Estado IN ('Nueva', 'En Revisión', 'Aceptada', 'Rechazada', 'Completada', 'Cancelada')),
    Fecha_Creacion DATETIME NOT NULL DEFAULT GETDATE(),
    Fecha_Actualizacion DATETIME,
    FOREIGN KEY (Cliente_ID) REFERENCES Usuario(Usuario_ID),
    FOREIGN KEY (Profesional_ID) REFERENCES Profesionales(Usuario_ID)
);

-- Tabla para proyectos que un Cliente publica en el "marketplace"
CREATE TABLE Solicitudes_Publicas (
    Solicitud_Publica_ID INT PRIMARY KEY IDENTITY(1,1),
    Cliente_ID INT NOT NULL,
    Categoria_ID INT NOT NULL,
    Titulo NVARCHAR(200) NOT NULL,
    Descripcion NVARCHAR(MAX),
    Presupuesto_Min DECIMAL(10,2),
    Presupuesto_Max DECIMAL(10,2),
    Urgencia NVARCHAR(50) CHECK (Urgencia IN ('Baja', 'Media', 'Alta')),
    Ubicacion NVARCHAR(100),
    Plazo_Entrega NVARCHAR(100),
    Estado NVARCHAR(50) DEFAULT 'Abierta' CHECK (Estado IN ('Abierta', 'En Proceso', 'Cerrada', 'Cancelada')),
    Fecha_Publicacion DATETIME NOT NULL DEFAULT GETDATE(),
    FOREIGN KEY (Cliente_ID) REFERENCES Usuario(Usuario_ID),
    FOREIGN KEY (Categoria_ID) REFERENCES Categorias(Categoria_ID)
);

-- Tabla para las propuestas que los Profesionales envían a las Solicitudes Públicas
CREATE TABLE Propuestas (
    Propuesta_ID INT PRIMARY KEY IDENTITY(1,1),
    Solicitud_Publica_ID INT NOT NULL,
    Profesional_ID INT NOT NULL,
    Mensaje_Propuesta NVARCHAR(MAX),
    Monto_Ofertado DECIMAL(10,2),
    Tiempo_Estimado NVARCHAR(100),
    Fecha_Envio DATETIME NOT NULL DEFAULT GETDATE(),
    Estado NVARCHAR(50) DEFAULT 'Enviada' CHECK (Estado IN ('Enviada', 'Vista', 'Aceptada', 'Rechazada')),
    FOREIGN KEY (Solicitud_Publica_ID) REFERENCES Solicitudes_Publicas(Solicitud_Publica_ID),
    FOREIGN KEY (Profesional_ID) REFERENCES Profesionales(Usuario_ID)
);

-- Tabla para las calificaciones que los Clientes dan a los Profesionales al finalizar un trabajo
CREATE TABLE Calificaciones (
    Calificacion_ID INT PRIMARY KEY IDENTITY(1,1),
    Profesional_ID INT NOT NULL,
    Cliente_ID INT NOT NULL,
    Solicitud_ID INT NULL, -- ID de Solicitud_Directas si el trabajo fue directo
    Propuesta_ID INT NULL, -- ID de Propuestas si el trabajo fue a través de una propuesta
    Puntuacion INT NOT NULL CHECK (Puntuacion BETWEEN 1 AND 5),
    Comentario NVARCHAR(1000),
    Fecha_Calificacion DATETIME NOT NULL DEFAULT GETDATE(),
    FOREIGN KEY (Profesional_ID) REFERENCES Profesionales(Usuario_ID),
    FOREIGN KEY (Cliente_ID) REFERENCES Usuario(Usuario_ID),
    FOREIGN KEY (Solicitud_ID) REFERENCES Solicitudes_Directas(Solicitud_ID),
    FOREIGN KEY (Propuesta_ID) REFERENCES Propuestas(Propuesta_ID)
);