package com.homework.flow.exts.repository.extension;

import com.homework.flow.exts.domain.Extension;
import com.homework.flow.exts.dto.extension.ExtensionDTO;

import java.util.List;
import java.util.Optional;

public interface ExtsRepository {
    Extension save(Extension extension);

    void update(ExtensionDTO extensionDTO);

    Optional<Extension> findById(Long id);

    List<Extension> findAll();
}
