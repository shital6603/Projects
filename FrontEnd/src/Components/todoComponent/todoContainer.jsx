import React, { useEffect, useRef } from "react";
import TodoComponent from "./todoComponent";

const TodoContainer = ({ tasks, setTaskArr }) => {
  const containerRef = useRef(null);
  let totalTask = useRef(tasks.length);

  useEffect(() => {
    if(totalTask.current < tasks.length)
      containerRef.current.scrollTo(0, containerRef.current.scrollHeight);
    
    totalTask.current = tasks.length;
  },[tasks])

  function deleteComponent(title) {
    let taskComponentArr = JSON.parse(localStorage.getItem("task"));
    delete taskComponentArr[title];

    localStorage.setItem("task", JSON.stringify(taskComponentArr));
    setTaskArr(() => tasks.filter((element) => title !== element.title));
  }

  return (
    <div ref={containerRef} className="p-8 grid grid-cols-4 gap-8 mid-desktop:grid-cols-3 tablet:grid-cols-2 large-mobile:grid-cols-1 overflow-auto">
      {tasks.map((element) => (
        <TodoComponent
          title={element.title}
          task={element.task}
          key={element.key}
          deleteComponent={deleteComponent}
        />
      ))}
    </div>
  );
};

export default TodoContainer;
