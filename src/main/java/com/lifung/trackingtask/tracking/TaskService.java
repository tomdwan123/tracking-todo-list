package com.lifung.trackingtask.tracking;

import java.util.List;

public interface TaskService {

    public List<Task> findAll();
    public void add(Task task);

}
