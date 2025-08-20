import React, { useEffect, useState } from "react";
import Nav from "./Nav";
import Heading from "./Header";
import GetInputModal from "./generic/GetInputModal";
import TodoContainer from "./todoComponent/todoContainer";

export default function BaseLayout({ children }) {
  const [modalVisibility, setModalVisibility] = useState(1);
  
  function addNewTaskToLocalStorage(TaskTitle) {
    if (TaskTitle) {
      let task = localStorage.getItem("task");
      if (task) task = JSON.parse(task);

      let newTitle = {};
      newTitle[TaskTitle] = [];

      localStorage.setItem(
        "task",
        `${JSON.stringify({ ...task, ...newTitle })}`
      );

      setTaskArr([
        ...taskArr,
        { title: TaskTitle, task: [], key: Math.random() },
      ]);
    }
    setModalVisibility(1);
  }

  const [taskArr, setTaskArr] = useState(() => {
    let arr = JSON.parse(localStorage.getItem("task"));
    let tasks = [];
    for (const key in arr) {
      tasks.push({
        title: key,
        task: arr[key],
        key: Math.random(),
      });
    }
    return tasks;
  });

  return (
    <div className="flex flex-col w-full h-dvh justify-between bg-main-bg dark:bg-main-bg-dark text-black dark:text-white ">
      <div className="flex flex-col h-5/6">
        <Heading />
        <TodoContainer tasks={taskArr} setTaskArr={setTaskArr}/>
      </div>

      <div className="w-full flex justify-center p-4">
        <Nav setModalVisibility={setModalVisibility} />
      </div>
      <GetInputModal
        name={"Add New Title"}
        func={addNewTaskToLocalStorage}
        hidden={modalVisibility}
        setModalVisibility={setModalVisibility}
        width={"w-1/4"}
      />
    </div>
  );
}
