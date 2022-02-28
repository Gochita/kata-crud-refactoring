import React, { createContext,useState } from "react";
import { HOST_API } from "../App";
export const todoContext = createContext();

export const TodoContextProvider = (props) => {
  const [todos, setTodos] = useState({ todoList: [] });
  const readTodos = () => {
    fetch(HOST_API + "/todos")
    .then(response => response.json())
    .then((t) => {
        setTodos({...todos, todolist:t })
    })

  };

  return <todoContext.Provider value={{todos,readTodos}}>
        {props.children}
  </todoContext.Provider>
};
