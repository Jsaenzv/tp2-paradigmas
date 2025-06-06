package main.java.tp2.modelo;

public enum Elemento {
    FUEGO,
    AGUA,
    VIENTO,
    TIERRA,
    OSCURIDAD,
    LUZ;

    @Override
    public String toString() {
        // Capitaliza solo la primera letra, el resto en minúscula
        String nombre = name().toLowerCase();
        return nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
    }

    public static Elemento fromString(String texto) {
        return switch (texto.trim().toLowerCase()) {
            case "fuego" -> FUEGO;
            case "agua" -> AGUA;
            case "viento" -> VIENTO;
            case "tierra" -> TIERRA;
            case "oscuridad" -> OSCURIDAD;
            case "luz" -> LUZ;
            default -> throw new IllegalArgumentException("Elemento inválido: " + texto);
        };
    }
}

