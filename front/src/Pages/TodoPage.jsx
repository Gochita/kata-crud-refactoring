import React, { useState, useEffect, useContext } from "react";
import { HOST_API } from "../App";
import Todos from "../components/Todos";
import { eliminarListaContext } from "../contexts/ListContext";

const TodoPage = ({ lista }) => {
  const [todos, setTodos] = useState([]);

  const deleteList  = useContext (eliminarListaContext);
  return (
    <div className="border">
      <br></br>
      <h3>
        {lista.name}
        <button className="ms-5 btn btn-danger" onClick={() => deleteList (lista.id)}>Eliminar</button>
      </h3>

      <Todos list={lista} />
    </div>
  );
};
export default TodoPage;
