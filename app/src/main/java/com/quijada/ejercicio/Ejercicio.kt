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
}