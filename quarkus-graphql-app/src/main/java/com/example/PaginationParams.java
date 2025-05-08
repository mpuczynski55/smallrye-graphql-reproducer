package com.example;

import com.example.scalar.LongBigInteger;
import lombok.Data;
import org.eclipse.microprofile.graphql.Name;

@Data
@Name("PaginationParams")
public class PaginationParams {

    @Name("size")
    private LongBigInteger size;

}