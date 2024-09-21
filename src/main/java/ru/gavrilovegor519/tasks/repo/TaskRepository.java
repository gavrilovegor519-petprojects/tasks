package ru.gavrilovegor519.tasks.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.gavrilovegor519.tasks.entity.Task;
import ru.gavrilovegor519.tasks.entity.User;

public interface TaskRepository extends
        JpaRepository<Task, Long> {
    // findById is default

    Page<Task> findAllByAuthor(User author,
                               Pageable pageable);

}