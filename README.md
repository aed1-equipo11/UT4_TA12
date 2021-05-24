# UT4_TA12

## Ejercicio 1

####SEUDOCÓDIGO

```
void  armarIndicesCarrreras (Lista<Carrera>carreras)
COM
    SI raiz <> nulo ENTONCES                                        O(1)
        raiz.indizar(carreras)
    FIN SI
FIN
```

```
TElementoAB indizar (Lista<Carrera> carreras)
COM
    SI (hijoIzq <> nulo) ENTONCES                                   O(1)
        hijoIzq.indizar(carreras)                                   
    FIN SI
    
    SI (hijoDer <> nulo) ENTONCES                                   O(1)
        hijoDer.indizar(carreras)                                   
    FIN SI
    
    Nodo ndCarrera <- carreras.buscar(this.dato.carrera)            O(P)
    elementoTemp <- nuevo Elemento(this.dato.apellido, this.dato)   O(1)
    SI ndCarrera <> nulo ENTONCES                                   O(1)
        ndCarrera.dato.insertar(elementoTemp)                       O(log N)
    SINO
        Arbol trAlumnos <- nuevo Arbol                              O(1)
        trAlumnos.insertar(elementoTemp)                            O(log N)
        carreras.insertar(nuevo Nodo(this.dato.carrera, trAlumnos)  O(P)
    FIN SI
FIN
```

####PRECONDICIONES
* La lista pasada por parámetro no puede ser nula
* El arbol a recorrer debe contener elementos de tipo Alumno

####POSTCONDICIONES
* La lista debe contener al menos un nodo si el arbol sí tenía
* El arbol que contiene los alumnos no afecta su estado.
* La lista deberá tener la misma o menor cantidad de elementos que el arbol inicial.

####ORDEN DE TIEMPO DE EJECUCIÓN

El tiempo de orden de ejecucion es cuadrático de O(M * P) por regla de la suma ya que se repite M veces 
debido a la recursividad, siendo M los elementos del arbol. Ya que los dos primeros bloques 
SI son de O(1), y el ultimo bloque es de O(P).