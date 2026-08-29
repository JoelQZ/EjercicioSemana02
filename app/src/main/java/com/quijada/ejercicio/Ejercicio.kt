package com.quijada.ejercicio

fun main(){
    print("Ingrese el nombre del estudiante: ");
    val nombre = readln()
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
        print("Cantidad de creditos de:" )
        val credito = readln().toInt()
        creditos.add(credito)
    }
    val totalCreditos = creditos.sum()
    val costoTotal = totalCreditos * precio

    val condicion1 = when{
        totalCreditos <= 12 -> "Forma de pago"
        totalCreditos in 13..18 -> "Carga Completa"
        else -> "Requeriiento autorizado"
    }

    val cuotas = if (costoTotal > 2500){
        3 }
    else {
        2
    }

    println("estudiante: $nombre")
    println("Curso - Creditos - Costo")
    for (i in cursos.indices) {
        val costoCurso = creditos[i] * precio
        println("${cursos[i]} - ${creditos[i]} - $costoCurso")
    }

    println("cursos matriculados en total: ${cursos.size}")
    println("total creditos: $totalCreditos")
    println("total a pagar: $costoTotal")
    println("carga academica: $condicion1")
    println("forma de pago: $cuotas")
}