package application.example.main.repos;

import application.example.main.domain.Settings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SettingsRepo extends JpaRepository<Settings, Long> {
    List<Settings> findByTag(String tag);

    List<Settings> findByUser_id(long id);

    List<Settings> findByUser_idAndTag(long id, String tag);


    void deleteByUser_id(Long valueOf);
}