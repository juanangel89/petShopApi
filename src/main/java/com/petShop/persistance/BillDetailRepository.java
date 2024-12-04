package com.petShop.persistance;

import com.petShop.domain.dto.BillDetailDTO;
import com.petShop.domain.repository.BillDetailDomainRepository;
import com.petShop.persistance.crud.BillDetailCrudRepository;
import com.petShop.persistance.entity.BillDetail;
import com.petShop.persistance.mapper.BillDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class BillDetailRepository implements BillDetailDomainRepository {

    @Autowired
    private BillDetailCrudRepository billDetailCrudRepository;

    @Autowired
    private BillDetailMapper mapper;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Iterable<BillDetailDTO> getAll() {
        Iterable<BillDetail> billDetails = billDetailCrudRepository.findAll();
        return ((List<BillDetail>) billDetails).stream()
                .map(mapper::toBillDetailDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BillDetailDTO> getBillDetailById(int id) {
        Optional<BillDetail> billDetail = billDetailCrudRepository.findById(id);
        return billDetail.map(mapper::toBillDetailDTO);
    }
    @Override
    public BillDetailDTO save(BillDetailDTO billDetailDTO) {
        // Validar que al menos uno de los IDs no sea null
        if (billDetailDTO.getIdCita() == null && billDetailDTO.getIdProducto() == null) {
            throw new IllegalArgumentException("Debe especificar al menos una cita (idCita) o un producto (idProducto).");
        }

        // Convertir el DTO a la entidad
        BillDetail billDetail = mapper.toEntity(billDetailDTO);

        // Validar que las relaciones opcionales existen en caso de tener sus IDs
        if (billDetailDTO.getIdCita() != null && !appointmentRepository.existsAppointment(billDetailDTO.getIdCita())) {
            throw new IllegalArgumentException("El ID de cita proporcionado no existe.");
        }

        if (billDetailDTO.getIdProducto() != null && !productRepository.existsProduct(billDetailDTO.getIdProducto())) {
            throw new IllegalArgumentException("El ID de producto proporcionado no existe.");
        }

        // Guardar en la base de datos
        BillDetail savedBillDetail = billDetailCrudRepository.save(billDetail);

        // Retornar el DTO del objeto guardado
        return mapper.toBillDetailDTO(savedBillDetail);
    }
//    @Override
//    public BillDetailDTO save(BillDetailDTO billDetailDTO) {
//        validateForeignKeys(billDetailDTO);
//        BillDetail billDetail = mapper.toEntity(billDetailDTO);
//        BillDetail savedBillDetail = billDetailCrudRepository.save(billDetail);
//        return mapper.toBillDetailDTO(savedBillDetail);
//    }

    @Override
    public BillDetailDTO update(BillDetailDTO billDetailDTO) {
        if (billDetailDTO.getIdFacturaDetalle() == null) {
            throw new IllegalArgumentException("El ID de factura detalle es obligatorio para la actualización.");
        }

        // Validar que al menos uno de los IDs no sea null
        if (billDetailDTO.getIdCita() == null && billDetailDTO.getIdProducto() == null) {
            throw new IllegalArgumentException("Debe especificar al menos una cita (idCita) o un producto (idProducto).");
        }

        // Validar existencia del detalle a actualizar
        if (!billDetailCrudRepository.existsById(billDetailDTO.getIdFacturaDetalle())) {
            throw new IllegalArgumentException("El detalle de factura especificado no existe.");
        }

        // Validaciones similares a las de save
        if (billDetailDTO.getIdCita() != null && !appointmentRepository.existsAppointment(billDetailDTO.getIdCita())) {
            throw new IllegalArgumentException("El ID de cita proporcionado no existe.");
        }

        if (billDetailDTO.getIdProducto() != null && !productRepository.existsProduct(billDetailDTO.getIdProducto())) {
            throw new IllegalArgumentException("El ID de producto proporcionado no existe.");
        }

        // Actualizar y retornar
        BillDetail billDetail = mapper.toEntity(billDetailDTO);
        BillDetail updatedBillDetail = billDetailCrudRepository.save(billDetail);
        return mapper.toBillDetailDTO(updatedBillDetail);
    }

//    @Override
//    public BillDetailDTO update(BillDetailDTO billDetailDTO) {
//        validateForeignKeys(billDetailDTO);
//        BillDetail billDetail = mapper.toEntity(billDetailDTO);
//        if (!billDetailCrudRepository.existsById(billDetail.getIdBillDetail())) {
//            throw new IllegalArgumentException("El registro no existe");
//        }
//        BillDetail updatedBillDetail = billDetailCrudRepository.save(billDetail);
//        return mapper.toBillDetailDTO(updatedBillDetail);
//    }

    @Override
    public void delete(int id) {
        if (!billDetailCrudRepository.existsById(id)) {
            throw new IllegalArgumentException("El registro no existe");
        }
        billDetailCrudRepository.deleteById(id);
    }

    @Override
    public boolean existsBillDetail(int idBillDetail) {
        return billDetailCrudRepository.existsById(idBillDetail);
    }

    @Override
    public long countAll() {
        return billDetailCrudRepository.count();
    }
}