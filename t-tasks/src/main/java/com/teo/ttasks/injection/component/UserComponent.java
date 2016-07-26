package com.teo.ttasks.injection.component;

import com.teo.ttasks.injection.module.UserModule;
import com.teo.ttasks.ui.activities.edit_task.EditTaskActivity;
import com.teo.ttasks.ui.activities.main.MainActivity;
import com.teo.ttasks.ui.activities.task_detail.TaskDetailActivity;
import com.teo.ttasks.ui.fragments.tasks.TasksFragment;

import javax.inject.Singleton;

import dagger.Subcomponent;

@Singleton
@Subcomponent(modules = UserModule.class)
public interface UserComponent {

    void inject(MainActivity mainActivity);

    void inject(TaskDetailActivity taskDetailActivity);

    void inject(EditTaskActivity editTaskActivity);

    void inject(TasksFragment tasksFragment);
}