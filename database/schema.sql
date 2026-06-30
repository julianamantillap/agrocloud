-- AgroCloud - Esquema inicial de base de datos
-- PostgreSQL
-- Autora: Juliana Priscilla Mantilla Puente

-- Extensión necesaria para generar UUIDs
CREATE EXTENSION IF NOT EXISTS "pgcrypto";

-- =========================================
-- Tabla: usuario
-- =========================================
CREATE TABLE usuario (
    id              UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nombre          VARCHAR(120) NOT NULL,
    email           VARCHAR(150) NOT NULL UNIQUE,
    password_hash   VARCHAR(255) NOT NULL,
    rol             VARCHAR(20) NOT NULL CHECK (rol IN ('propietario', 'administrador', 'trabajador')),
    modo_offline_activo BOOLEAN NOT NULL DEFAULT FALSE,
    creado_en       TIMESTAMP NOT NULL DEFAULT now()
);

-- =========================================
-- Tabla: lote
-- =========================================
CREATE TABLE lote (
    id              UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    codigo          VARCHAR(30) NOT NULL UNIQUE,
    capacidad       INTEGER,
    estado          VARCHAR(20) NOT NULL DEFAULT 'activo' CHECK (estado IN ('activo', 'inactivo')),
    descripcion     TEXT,
    archivo_adjunto_url TEXT,
    creado_en       TIMESTAMP NOT NULL DEFAULT now()
);

-- =========================================
-- Tabla: animal
-- =========================================
CREATE TABLE animal (
    id                  UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    codigo              VARCHAR(30) NOT NULL UNIQUE,
    especie             VARCHAR(50) NOT NULL,
    raza                VARCHAR(50),
    sexo                VARCHAR(10) NOT NULL CHECK (sexo IN ('macho', 'hembra')),
    fecha_nacimiento    DATE,
    peso_actual         NUMERIC(6,2),
    lote_id             UUID REFERENCES lote(id) ON DELETE SET NULL,
    estado              VARCHAR(20) NOT NULL DEFAULT 'activo' CHECK (estado IN ('activo', 'vendido', 'fallecido')),
    sincronizado        BOOLEAN NOT NULL DEFAULT TRUE,
    creado_en           TIMESTAMP NOT NULL DEFAULT now()
);

-- =========================================
-- Tabla: ordeño (producción de leche)
-- =========================================
CREATE TABLE ordeno (
    id              UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    animal_id       UUID NOT NULL REFERENCES animal(id) ON DELETE CASCADE,
    lote_id         UUID REFERENCES lote(id) ON DELETE SET NULL,
    fecha           DATE NOT NULL,
    litros          NUMERIC(6,2) NOT NULL CHECK (litros >= 0),
    observaciones   TEXT,
    registrado_por_usuario_id UUID REFERENCES usuario(id) ON DELETE SET NULL,
    sincronizado    BOOLEAN NOT NULL DEFAULT TRUE,
    creado_en       TIMESTAMP NOT NULL DEFAULT now()
);

-- =========================================
-- Tabla: pesaje
-- =========================================
CREATE TABLE pesaje (
    id              UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    animal_id       UUID NOT NULL REFERENCES animal(id) ON DELETE CASCADE,
    fecha           DATE NOT NULL,
    peso            NUMERIC(6,2) NOT NULL CHECK (peso > 0),
    observaciones   TEXT,
    registrado_por_usuario_id UUID REFERENCES usuario(id) ON DELETE SET NULL,
    sincronizado    BOOLEAN NOT NULL DEFAULT TRUE,
    creado_en       TIMESTAMP NOT NULL DEFAULT now()
);

-- =========================================
-- Tabla: nacimiento (genealogía)
-- =========================================
CREATE TABLE nacimiento (
    id                  UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    animal_id           UUID NOT NULL REFERENCES animal(id) ON DELETE CASCADE,
    madre_id            UUID REFERENCES animal(id) ON DELETE SET NULL,
    padre_id            UUID REFERENCES animal(id) ON DELETE SET NULL,
    fecha_nacimiento    DATE NOT NULL,
    observaciones       TEXT,
    creado_en           TIMESTAMP NOT NULL DEFAULT now()
);

-- =========================================
-- Tabla: vacuna (registro sanitario)
-- =========================================
CREATE TABLE vacuna (
    id                  UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    animal_id           UUID NOT NULL REFERENCES animal(id) ON DELETE CASCADE,
    tipo_tratamiento     VARCHAR(80) NOT NULL,
    medicamento         VARCHAR(100),
    dosis               VARCHAR(50),
    fecha               DATE NOT NULL,
    observaciones       TEXT,
    registrado_por_usuario_id UUID REFERENCES usuario(id) ON DELETE SET NULL,
    creado_en           TIMESTAMP NOT NULL DEFAULT now()
);

-- =========================================
-- Índices recomendados para consultas frecuentes
-- =========================================
CREATE INDEX idx_animal_lote ON animal(lote_id);
CREATE INDEX idx_ordeno_animal ON ordeno(animal_id);
CREATE INDEX idx_ordeno_fecha ON ordeno(fecha);
CREATE INDEX idx_pesaje_animal ON pesaje(animal_id);
CREATE INDEX idx_vacuna_animal ON vacuna(animal_id);
CREATE INDEX idx_nacimiento_animal ON nacimiento(animal_id);
