package com.pedroconsoni.DeveloperAllocator.Developer;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DeveloperService {

    private DeveloperRepository developerRepository;

    public DeveloperService(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
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

}
