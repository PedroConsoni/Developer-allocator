package com.pedroconsoni.DeveloperAllocator.Developer;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DeveloperService {

    private DeveloperRepository developerRepository;
    private DeveloperMapper developerMapper;

    public DeveloperService(DeveloperRepository developerRepository, DeveloperMapper developerMapper) {
        this.developerRepository = developerRepository;
        this.developerMapper = developerMapper;
    }

    // List all developers
    public List<DeveloperModel> listDeveloper() {
        return developerRepository.findAll();
    }

    // List developers by ID
    public DeveloperModel listDeveloperByID(Long id) {
        Optional<DeveloperModel> developerByID = developerRepository.findById(id);
        return developerByID.orElse(null);
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
    public DeveloperModel updateDeveloperByID(Long id, DeveloperModel updatedDeveloper) {
        if (developerRepository.existsById(id)) {
            updatedDeveloper.setId(id);
            return developerRepository.save(updatedDeveloper);
        }
        return null;
    }


}
