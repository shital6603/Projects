import React, { useEffect, useRef, useState } from "react";
import TodoTitle from "../generic/AddTitle";
import TodoItem from "./todoItem";
import TodoAddButton from "../generic/AddButton";
import DeleteButton from "../generic/DeleteButton";
import GetInputModal from "../generic/GetInputModal";

const TodoComponent = ({ title, task, deleteComponent }) => {
  // creating array of tasks from task string
  let taskArr = [];
  task.forEach((elem) => {
    taskArr.push(JSON.parse(elem));
  });

  const componentRef = useRef(null);

  // initializing state of component
  const [TodoItemData, setTodoItemData] = useState(taskArr);
  const [modalVisibility, setModalVisibility] = useState(1);

  // funcation to deleteTask
  function deleteTask(id) {
    let arr = TodoItemData.filter((element) => element.id !== id);
    setTaskToLocalStorage(arr);
    setTodoItemData(arr);
  }

  function setTaskToLocalStorage(arr) {
    let taskToString = [];
    arr.forEach((task) => {
      taskToString.push(JSON.stringify(task) + " ");
    });

    let data = localStorage.getItem("task");
    if (data) data = { ...JSON.parse(data) };

    let newData = {};
    newData[title] = taskToString;
    localStorage.setItem("task", `${JSON.stringify({ ...data, ...newData })}`);
  }

  function generateTodoItemData(task)
  {
      if(task)
      {   
          let key = Math.random();
          let data = {
              id : key,
              key,
              task,
              checked : false
          }
          let arr = [...TodoItemData, data];
          setTaskToLocalStorage(arr);
          setTodoItemData(arr);
      }
      
      setModalVisibility(1);
  }

  return (
    <div ref={componentRef} className=" bg-todo-bg dark:bg-todo-bg-dark text-todo-text dark:text-todo-text-dark border dark:border-0 p-8 flex flex-col gap-6 rounded-xl relative overflow-hidden h-max min-h-full leftToRight">
      <TodoTitle title={title} />
      {TodoItemData.map((item) => {
        return (
          <TodoItem
            title={title}
            id={item.id}
            key={item.key}
            task={item.task}
            checked={item.checked}
            deleteTask={deleteTask}
            setTodoItemData = {setTodoItemData}
          />
        );
      })}
      <TodoAddButton onClick={() => setModalVisibility(0)} name={"Add Item"} />
      <GetInputModal
        hidden={modalVisibility}
        setModalVisibility={setModalVisibility}
        func={generateTodoItemData}
        name={"Add Item"}
      />
      <DeleteButton className="absolute right-1 top-1 p-2 rounded-full bg-sidebar-button-bg dark:bg-black dark:border-0 hover:cursor-pointer" onClick={() => {
          componentRef.current.classList.remove("leftToRight");
          componentRef.current.classList.add("topToBottom");
          setTimeout(() => {
            deleteComponent(title);
          }, 950);
        }}/>
    </div>
  );
};

export default TodoComponent;
