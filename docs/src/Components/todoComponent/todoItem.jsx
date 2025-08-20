import React, { useState } from "react";
import DeleteButton from "../generic/DeleteButton";
import EditButton from "../generic/EditButton";
import GetInputModal from "../generic/GetInputModal";

const TodoItem = ({ title, task, id, deleteTask, setTodoItemData, checked }) => {

const [modalVisibility, setModalVisibility] = useState(1)

function editTask()
{
    setModalVisibility(0)
}

function handleUpdateTask(newValue)
{
    if(newValue)
    {
        let taskInfo = JSON.parse(localStorage.getItem('task'))
        let arr = []
        taskInfo[title] = taskInfo[title].map(element => {
            let obj = JSON.parse(element);
            if(obj.id == id)
                obj.task = newValue;
            arr.push(obj);
            return JSON.stringify(obj);
        });

        localStorage.setItem('task', JSON.stringify(taskInfo));
        setTodoItemData(arr);
    }

    setModalVisibility(1)
}

function handleChecks()
{
    checked = !checked;
    let taskInfo = JSON.parse(localStorage.getItem('task'))
    let arr = []
    taskInfo[title] = taskInfo[title].map(element => {
        let obj = JSON.parse(element);
        if(obj.id == id)
            obj.checked = checked;
        arr.push(obj);
        return JSON.stringify(obj);
    });

    localStorage.setItem('task', JSON.stringify(taskInfo));
    setTodoItemData(arr);
}


return (
    <div className="flex justify-between items-center gap-4 w-full ">
      <div className="flex gap-2 items-center w-4/5">
        <input type="checkbox" name="todoItem" className="rounded-full" checked={checked} onChange={handleChecks}/>
        <h1 className={`line-clamp-2 w-full ${checked ? "line-through" : ""}`}>{task}</h1>
      </div>
      <div className="flex gap-2">
        <EditButton onClick={editTask}/>
        <DeleteButton onClick={()=>{deleteTask(id)}}/>
      </div>
      <GetInputModal name={"Done"} func={handleUpdateTask} hidden={modalVisibility}
    setModalVisibility={setModalVisibility}/>
    </div>
  );
};

export default TodoItem;
