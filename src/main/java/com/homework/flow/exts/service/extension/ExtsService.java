package com.homework.flow.exts.service.extension;

import com.homework.flow.exts.domain.Extension;

import java.util.List;
import java.util.Optional;

public interface ExtsService {

    Extension save(Extension extension);

    void update(Extension extension);

    Optional<Extension> findById(Long id);

    List<Extension> findAll();

}
