package com.quijada.ejercicio

fun obtenerDescuento(turno: String): Double {
    return when (turno.lowercase()) {
        "mañana" -> 0.10
        "tarde" -> 0.15
        "noche" -> 0.20
        else -> 0.10
    }
}

fun obtenerCategoria(categoria: String, descuento: Double): Double {
    return when (categoria.lowercase()) {
        "becado", "becario" -> 0.0
        "ordinario" -> descuento
        else -> descuento
    }
}

fun main() {
    var aforo = 0
    while (aforo <= 0) {
        print("¿Cuantos estudiantes quiere ingresar?: ")
        val entrada = readln()
        val aforoConvertido = entrada.toIntOrNull()

        if (aforoConvertido != null && aforoConvertido > 0) {
            aforo = aforoConvertido
        } else {
            println("Ingrese un numero mayor a 0")
        }
    }

    println("----------------------------------")
    println("Registro del aforo de estudiantes")
    println("----------------------------------")

    for (estudianteActual in 1..aforo) {
        var nombre = ""
        while (nombre.isEmpty() || !nombre.all { it.isLetter() || it.isWhitespace() }) {
            print("Ingrese el nombre del estudiante: ")
            nombre = readln().trim()
            if (nombre.isEmpty() || !nombre.all { it.isLetter() || it.isWhitespace() }) {
                println("El nombre debe contener solo letras")
            }
        }

        var categoria = ""
        while (categoria.isEmpty() || !categoria.all { it.isLetter() || it.isWhitespace() }) {
            print("Ingrese la categoria del estudiante: ")
            categoria = readln().trim()
            if (categoria.isEmpty() || !categoria.all { it.isLetter() || it.isWhitespace() }) {
                println("La categoria debe contener solo letras")
            }
        }

        var turno = ""
        while (turno.isEmpty() || !turno.all { it.isLetter() || it.isWhitespace() }) {
            print("Ingrese el turno del estudiante: ")
            turno = readln().trim()
            if (turno.isEmpty() || !turno.all { it.isLetter() || it.isWhitespace() }) {
                println("El turno debe contener solo letras")
            }
        }

        var precio = 0.0
        while (precio <= 0.0) {
            print("Ingrese el precio por cada credito: ")
            val entradaPrecio = readln()
            val precioConvertido = entradaPrecio.toDoubleOrNull()

            if (precioConvertido != null && precioConvertido > 0.0) {
                precio = precioConvertido
            } else {
                println("El precio por credito debe ser mayor a 0")
            }
        }

        var cantidadcursos = 0
        while (cantidadcursos <= 0) {
            print("Ingrese la cantidad de cursos: ")
            val entradaCursos = readln()
            val cursosConvertidos = entradaCursos.toIntOrNull()

            if (cursosConvertidos != null && cursosConvertidos >= 1) {
                cantidadcursos = cursosConvertidos
            } else {
                println("La cantidad de cursos debe ser mayor o igual a 1")
            }
        }

        val cursos = mutableListOf<String>()
        val creditos = mutableListOf<Int>()

        for (i in 1..cantidadcursos) {
            println("Curso $i")

            var nombrecurso = ""
            while (nombrecurso.isEmpty() || !nombrecurso.all { it.isLetter() || it.isWhitespace() }) {
                print("Nombre del curso: ")
                nombrecurso = readln().trim()
                if (nombrecurso.isEmpty() || !nombrecurso.all { it.isLetter() || it.isWhitespace() }) {
                    println("El nombre del curso debe contener solo letras")
                }
            }
            cursos.add(nombrecurso)

            var credito = 0
            while (credito <= 0) {
                print("Cantidad de creditos de: ")
                val entradaCredito = readln()
                val creditoConvertido = entradaCredito.toIntOrNull()

                if (creditoConvertido != null && creditoConvertido > 0) {
                    credito = creditoConvertido
                } else {
                    println("La cantidad de creditos debe ser mayor a 0")
                }
            }
            creditos.add(credito)
        }
        val totalCreditos = creditos.sum()
        val costoTotal = totalCreditos * precio

        val porcentajeDescuento = obtenerDescuento(turno)
        val montoDescuento = costoTotal * porcentajeDescuento
        val costoDescuento = costoTotal - montoDescuento

        val subtotal = obtenerCategoria(categoria, costoDescuento)

        val igv = subtotal * 0.18
        val totalpago = subtotal + igv

        val condicion1 = when {
            totalCreditos <= 12 -> "Aun falta"
            totalCreditos in 13..18 -> "Carga Completa"
            else -> "Requerimiento autorizado"
        }

        val cuotas = if (costoTotal > 2500) {
            3
        } else {
            2
        }

        println("Estudiante: $nombre")
        println("Turno: $turno")
        println("Curso - Creditos - Costo")

        for (i in cursos.indices) {
            val costoCurso = creditos[i] * precio
            println("${cursos[i]} - ${creditos[i]} - S/ $costoCurso")
        }

        println("Cursos matriculados en total: ${cursos.size}")
        println("Total creditos: $totalCreditos")
        println("Subtotal aplicado categoria: S/ $subtotal")
        println("IGV (%18): S/ $igv")
        println("Total a pagar: S/ $totalpago")
        println("Carga academica: $condicion1")
        println("Forma de pago: $cuotas")
    }

    println("Se ha alcanzado el limite del aforo")
}