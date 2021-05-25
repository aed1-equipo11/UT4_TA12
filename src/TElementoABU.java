public class TElementoABU extends TElementoAB<Alumno> implements IElementoABU{
    public TElementoABU(String etiqueta, Alumno datos) {
        super(etiqueta, datos);
    }

    @Override
    public void indizar(Lista<Carrera> carreras) {
        if(hijoIzq != null){
            ((TElementoABU)hijoIzq).indizar(carreras);
        }
        if (hijoDer != null) {
            ((TElementoABU)hijoDer).indizar(carreras);
        }

        Nodo<Carrera> ndCarrera = carreras.buscar(this.getDatos().getCarrera());

        if (ndCarrera == null) {
            Carrera nuevaCarrera = new Carrera(this.getDatos().getCarrera());
            ndCarrera = new Nodo<Carrera>(this.getDatos().getCarrera(), nuevaCarrera);
            carreras.insertar(ndCarrera);
        }

        TElementoAB<Alumno> elemento = new TElementoAB<Alumno>(this.getDatos().getApellido(), this.getDatos());
        ndCarrera.getDato().getIndiceCarrera().insertar(elemento);
    }
}
