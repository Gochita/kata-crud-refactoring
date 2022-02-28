import React, { useState, useEffect } from "react";
import { HOST_API } from "../App";
import TodoList from "../components/TodoList";

const TodoPage = ({ lista }) => {
  const [todos, setTodos] = useState([]);


  return (
    <div>
      <h3>{lista.name}</h3>
      <TodoList list={lista}/>
    </div>
  );
};
export default TodoPage;
