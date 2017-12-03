package com.teo.ttasks.api

import com.teo.ttasks.api.entities.TaskListsResponse
import com.teo.ttasks.api.entities.TasksResponse
import com.teo.ttasks.data.local.TaskFields
import com.teo.ttasks.data.local.TaskListFields
import com.teo.ttasks.data.model.Task
import com.teo.ttasks.data.model.TaskList
import io.reactivex.Flowable

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface TasksApi {

    /**
     * Get the user's task lists

     * @param ETag the ETag used to check if the data on the server has changed
     */
    @GET("users/@me/lists")
    fun getTaskLists(@Header("If-None-Match") ETag: String): Flowable<TaskListsResponse>

    /**
     * Create a new task list
     */
    @POST("users/@me/lists")
    fun insertTaskList(@Body taskListFields: TaskListFields): Flowable<TaskList>

    /**
     * Update a task list
     */
    @PATCH("users/@me/lists/{taskList}")
    fun updateTaskList(@Path("taskList") taskListId: String, @Body taskListFields: TaskListFields): Flowable<TaskList>

    /**
     * Delete a task list
     */
    @DELETE("users/@me/lists/{taskList}")
    fun deleteTaskList(@Path("taskList") taskListId: String): Flowable<Void>

    /**
     * Get the tasks associated with a given task list

     * @param taskListId the ID of the task list
     * *
     * @param ETag       the ETag used to check if the data on the server has changed
     */
    @GET("lists/{taskList}/tasks")
    fun getTasks(@Path("taskList") taskListId: String, @Header("If-None-Match") ETag: String): Flowable<TasksResponse>

    /**
     * Update a task from the specified task list

     * @param taskListId task list identifier
     * *
     * @param taskId     task identifier
     */
    @PATCH("lists/{taskList}/tasks/{task}/")
    fun updateTask(@Path("taskList") taskListId: String, @Path("task") taskId: String, @Body taskFields: TaskFields): Flowable<Task>

    @PUT("lists/{taskList}/tasks/{task}/")
    fun updateTask(@Path("taskList") taskListId: String, @Path("task") taskId: String, @Body task: Task): Flowable<Task>

    /**
     * Creates a new task on the specified task list

     * @param taskListId task list identifier
     * *
     * @param taskFields the new task
     */
    @POST("lists/{taskList}/tasks")
    fun insertTask(@Path("taskList") taskListId: String, @Body taskFields: TaskFields): Call<Task>

    /**
     * Delete a task from the Google servers and then remove the local copy as well.

     * @param taskListId task list identifier
     * *
     * @param taskId     task identifier
     */
    @DELETE("lists/{taskList}/tasks/{task}")
    fun deleteTask(@Path("taskList") taskListId: String, @Path("task") taskId: String): Call<Void>
}