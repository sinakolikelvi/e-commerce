package com.e_commerce.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is required!")
    @Size(min = 3,max = 100)
    private String name;

    @Size(min = 10,max = 500)
    private String description;

    @Min(1)
    private Integer price;

    @Column(name = "stock_quantity")
    @NotBlank(message = "Stock Quantity is required!")
    @Min(0)
    private Integer stockQuantity;

    @JoinColumn(name = "category_id",nullable = false)
    @NotBlank(message = "Category is required!")
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
