package com.pedroconsoni.DeveloperAllocator.Developer;
import org.springframework.stereotype.Service;
import java.util.List;

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

}
