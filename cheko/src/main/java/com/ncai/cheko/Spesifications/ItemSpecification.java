package com.ncai.cheko.Spesifications;

import com.ncai.cheko.entity.Item;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import org.springframework.data.jpa.domain.Specification;

import net.kaczmarzyk.spring.data.jpa.domain.In;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@And({@Spec(path = "category.id", params = "categoryId", spec = In.class)})
@Or({
    @Spec(path = "name", params = "search", spec = LikeIgnoreCase.class),
    @Spec(path = "description", params = "search", spec = LikeIgnoreCase.class)
})
public interface ItemSpecification extends Specification<Item> {}
