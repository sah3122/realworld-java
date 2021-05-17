package me.study.realworld.common.domain;

import lombok.Getter;

import javax.persistence.MappedSuperclass;
import java.util.function.Function;
import java.util.function.Supplier;

@Getter
@MappedSuperclass
public class BaseEntity<T> {

    @SuppressWarnings(value = "unchecked")
    public <U> U map(Function<? super T, ? extends U> mapper) {
        return mapper.apply((T) this);
    }
}
