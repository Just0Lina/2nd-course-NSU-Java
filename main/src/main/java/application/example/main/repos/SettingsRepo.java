package application.example.main.repos;

import application.example.main.domain.Settings;
import application.example.main.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SettingsRepo extends JpaRepository<Settings, Long> {
    List<Settings> findByTag(String tag);

}