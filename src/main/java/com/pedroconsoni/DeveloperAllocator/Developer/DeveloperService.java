package com.pedroconsoni.DeveloperAllocator.Developer;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeveloperService {

    private DeveloperRepository developerRepository;
    private DeveloperMapper developerMapper;

    public DeveloperService(DeveloperRepository developerRepository, DeveloperMapper developerMapper) {
        this.developerRepository = developerRepository;
        this.developerMapper = developerMapper;
    }

    // List all developers
    public List<DeveloperDTO> listDeveloper() {
        List<DeveloperModel> developers = developerRepository.findAll();
        return developers.stream()
                .map(developerMapper::map)
                .collect(Collectors.toList());
    }

    // List developers by ID
    public DeveloperDTO listDeveloperByID(Long id) {
        Optional<DeveloperModel> developerByID = developerRepository.findById(id);
        return developerByID.map(developerMapper::map).orElse(null);
    }

    // Create new developer
    public DeveloperDTO createDeveloper(DeveloperDTO developerDTO) {
        DeveloperModel developer = developerMapper.map(developerDTO);
        developer = developerRepository.save(developer);
        return developerMapper.map(developer);
    }

    // Delete developer by ID
    public void deleteDeveloperByID(Long id) {
        developerRepository.deleteById(id);
    }

    // Update developer
    public DeveloperDTO updateDeveloperByID(Long id, DeveloperDTO developerDTO) {
        Optional<DeveloperModel> existingDeveloper = developerRepository.findById(id);
        if (existingDeveloper.isPresent()) {
            DeveloperModel updatedDeveloper = developerMapper.map(developerDTO);
            updatedDeveloper.setId(id);
            DeveloperModel developerSaved = developerRepository.save(updatedDeveloper);
            return developerMapper.map(developerSaved);
        }
        return null;
    }


}
