package org.ejemplo.validations;

import org.ejemplo.exceptions.ProductoException;
import org.ejemplo.modelos.Producto;
import org.ejemplo.repository.ProductoRepository;
import org.springframework.http.HttpStatus;

public class ProductoValidations {
    private final ProductoRepository productoRepository;

    public ProductoValidations(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public void validateExistingProduct(String codigo) throws ProductoException {
        if (productoRepository.findById(codigo).isPresent()) {
            throw new ProductoException (HttpStatus.PRECONDITION_FAILED, "El producto ya existe", "ProductoExeption") ;
        }
    }

    public Boolean productoExists(String codigo) {
        return productoRepository.findById(codigo).isPresent();
    }





    public void validateProductoData(Producto producto) throws ProductoException {
        if (producto.getCodigo() == null  ||  producto.getCodigo().isEmpty()) {
            throw new ProductoException(HttpStatus.PRECONDITION_FAILED, "El código del producto es requerido", "ProductoExeption");
        }
        if (producto.getNombre() == null  ||  producto.getNombre().isEmpty()) {
            throw new ProductoException(HttpStatus.PRECONDITION_FAILED, "EL nombre del codigo es requerido", "ProductoExeption") ;
        }
        if (producto.getDescripcion() == null || producto.getDescripcion().isEmpty()) {
            throw new ProductoException(HttpStatus.PRECONDITION_FAILED, "La descripcion del codigo es requerido", "ProductoExeption") ;
        }
        if (producto.getStock() == null) {
            throw new ProductoException(HttpStatus.PRECONDITION_FAILED, "El stock del codigo es requerido", "ProductoExeption") ;
        }
        if (producto.getPrecio() == null) {
            throw new ProductoException(HttpStatus.PRECONDITION_FAILED, "El precio del codigo es requerido", "ProductoExeption") ;
        }
    }


}
