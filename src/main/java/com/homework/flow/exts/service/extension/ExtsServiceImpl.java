package com.homework.flow.exts.service.extension;

import com.homework.flow.exts.domain.Extension;
import com.homework.flow.exts.dto.extension.ExtensionDTO;
import com.homework.flow.exts.repository.extension.ExtsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExtsServiceImpl implements ExtsService {

    private final ExtsRepository repository;

    @Override
    public Extension save(Extension extension) {
        return repository.save(extension);
    }

    @Override
    public void update(ExtensionDTO extensionDTO) {
        repository.update(extensionDTO);
    }

    @Override
    public Optional<Extension> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Extension> findAll() {
        return repository.findAll();
    }
}
