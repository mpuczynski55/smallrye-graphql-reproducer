package com.example;

import com.example.scalar.LongBigInteger;
import io.smallrye.graphql.api.AdaptToScalar;
import io.smallrye.graphql.api.Scalar;
import lombok.Data;
import org.eclipse.microprofile.graphql.Name;

@Data
@Name("PaginationParams")
public class PaginationParams {

    @Name("size")
    private LongBigInteger size;

    @Name("before")
    @AdaptToScalar(Scalar.String.class)
    private Integer before;

}