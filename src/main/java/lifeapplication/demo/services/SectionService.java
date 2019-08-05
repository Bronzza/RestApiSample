package lifeapplication.demo.services;

import lifeapplication.demo.dto.SectionDto;
import lifeapplication.demo.dto.mapper.ManualSectionMapper;
import lifeapplication.demo.repositories.SectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SectionService implements BaseService<SectionDto> {

    private final SectionRepository sectionRepository;

    private final ManualSectionMapper sectionMapper;

    @Override
    public List<SectionDto> getAll() {
        return sectionRepository.findAll().stream()
                .map(sectionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public SectionDto getByName(String name) {
        return null;
    }

    @Override
    public SectionDto getById(Long id) {
        return null;
    }

    @Override
    public void save(SectionDto user) {

    }
}
