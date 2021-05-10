package org.tms.adapters.persistence.documents;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class CarDocument {
    @Id
    private String licensePlate;
    private Double price;
}
