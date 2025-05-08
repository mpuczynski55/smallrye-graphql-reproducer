package com.example.scalar;

import graphql.scalars.ExtendedScalars;
import graphql.schema.Coercing;
import io.smallrye.graphql.api.CustomIntScalar;
import io.smallrye.graphql.api.CustomScalar;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigInteger;
import java.util.Optional;
import java.util.function.Function;

@CustomScalar(LongBigInteger.LONG_NAME)
@EqualsAndHashCode
@Getter
public class LongBigInteger implements CustomIntScalar {

    static final String LONG_NAME = "Long";

    private final Long internalValue;

    @SuppressWarnings({"unused", "deprecation"})
    public LongBigInteger(Long inputValue) {
        this.internalValue = Optional.ofNullable(inputValue)
                .map(value -> getCoercing().parseValue(value))
                .orElse(null);
    }

    @SuppressWarnings({"unused", "deprecation"})
    private LongBigInteger(BigInteger inputValue) {
        this.internalValue = Optional.ofNullable(inputValue)
                .map(value -> getCoercing().parseValue(value))
                .orElse(null);
    }

    @SuppressWarnings("unchecked")
    protected Coercing<Long, Long> getCoercing() {
        return (Coercing<Long, Long>) ExtendedScalars.GraphQLLong.getCoercing();
    }

    @Override
    public BigInteger intValueForSerialization() {
        return getValueForSerialization();
    }

    @SuppressWarnings("deprecation")
    protected BigInteger getValueForSerialization() {
        return Optional.ofNullable(internalValue)
                .map(value -> toOutputValue().apply(getCoercing().serialize(value)))
                .orElse(null);
    }

    protected Function<Long, BigInteger> toOutputValue() {
        return BigInteger::valueOf;
    }

}