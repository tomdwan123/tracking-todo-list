package com.lifung.trackingtask.tracking;

import com.lifung.trackingtask.utils.DateTimeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;

    @Override
    public List<Task> findAll() {
        return repository.findAll();
    }

    @Override
    public void add(Task task) {
        task.setStatus(TaskStatusEnum.BACK_LOG.toString());
        String now = DateTimeUtils.simpleDateTimeFormat.format(new Date());
        task.setCreatedAt(now);
        task.setUpdatedAt(now);

        repository.save(task);
    }
}
