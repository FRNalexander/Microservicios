package com.microservicios.serviciocompras.repository;

import com.microservicios.serviciocompras.entity.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceItemsRepository extends JpaRepository<InvoiceItem,Long> {
}
