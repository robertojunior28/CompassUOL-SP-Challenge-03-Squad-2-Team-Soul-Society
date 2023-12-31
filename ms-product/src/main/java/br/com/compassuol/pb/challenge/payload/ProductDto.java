package br.com.compassuol.pb.challenge.payload;

import br.com.compassuol.pb.challenge.entity.Category;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;
    @NotEmpty
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;
    @NotEmpty
    @Positive
    private BigDecimal price;
    @NotEmpty
    @Size(min = 5, message = "Description should have at least 5 characters")
    private String description;
//    @NotEmpty

    private Set<Category> category;
    private String date;
    private String imgUrl;
}
