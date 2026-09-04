package com.quijada.ejercicio

fun obtenerDescuento(turno: String): Double{
    return when(turno.lowercase()){
        "mañana" -> 0.10
        "tarde" -> 0.15
        "noche" -> 0.20
        else -> 0.10
    }
}

fun obtenerCategoria(categoria: String, descuento: Double): Double{
    return when (categoria.lowercase()){
        "becado" -> 0.0
        "ordinario" -> descuento
        else -> descuento
    }
}

fun main(){
    print("Ingrese el aforo máximo de estudiantes: ")
    val aforo = readln().toInt()

    for (estudianteActual in 1..aforo) {
        println("Registro del aforo de $aforo estudiantes")

        print("Ingrese el nombre del estudiante: ")
        val nombre = readln()
        print("Ingrese la categoría del estudiante: ")
        val categoria = readln()
        print("Ingrese el turno del estudiante: ")
        val turno = readln()
        print("Ingrese el precio por cada credito: ")
        val precio = readln().toDouble()
        print("Ingrese la cantidad de cursos: ")
        val cantidadcursos = readln().toInt()

        val cursos = mutableListOf<String>()
        val creditos = mutableListOf<Int>()

        for (i in 1..cantidadcursos){
            println("Curso $i")
            print("Nombre del curso: ")
            val nombrecurso = readln()
            cursos.add(nombrecurso)
            print("Cantidad de creditos de: " )
            val credito = readln().toInt()
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

        val condicion1 = when{
            totalCreditos <= 12 -> "Aun falta"
            totalCreditos in 13..18 -> "Carga Completa"
            else -> "Requerimiento autorizado"
        }

        val cuotas = if (costoTotal > 2500){
            3 }
        else {
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
        println("Subtotal aplicado categoría: S/ $subtotal")
        println("IGV (%18): S/ $igv")
        println("Total a pagar: S/ $totalpago")
        println("Carga academica: $condicion1")
        println("Forma de pago: $cuotas")
    }

    println("Se ha alcanzado el limite del aforo")
}