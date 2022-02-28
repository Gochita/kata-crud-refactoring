import React, { useState,useEffect } from "react";
import { HOST_API } from "../App";



const TodoList = ({list}) => {

    const [todos, setTodos]= useState([]);
    useEffect(() => {

        fetch(HOST_API + "/todosbylistid/"+ list.id)
        .then(response => response.json())
        .then((l) => {
            setTodos(l)
        })
   
    }, [])
    
  return (
    <div>
      {/* {todos.map((todo) =>{
          return <div>
              {todo.name}
          </div>
      })} */}
    </div>
  )
}

export default TodoList
