import React, { createContext, useState, useReducer, useEffect } from "react";
import { HOST_API } from "../App";

export const ListContext = createContext();
export const agregarListaContext = createContext();
export const eliminarListaContext = createContext();

const reducer = (listas, action) => {
  switch (action.type) {
    case "add-list":
      return [...listas, action.lista];
    case "delete-list":
      return listas.filter((lista) => lista.id !== action.listId);
    case "post-todo":
      return [...listas, action.lista];

    default:
      return listas;
  }
};

export const ListContextProvider = ({ children }) => {
  const [listas, dispatch] = useReducer(reducer, []);
  const [todoListas, setTodoListas] = useState(listas);

  useEffect(() => {
    fetch(HOST_API + "/listaTodos")
      .then((response) => response.json())
      .then((list) => {
        setTodoListas(list);
      });
  }, [listas]);

  const eliminarLista = (listId) => {
    fetch(HOST_API + "/todolist/" + listId, {
      method: "DELETE",
    }).then(() => dispatch({ type: "delete-list", listId: listId }));
  };

  const agregarTodo = (listId) => {
    fetch(HOST_API + "/todo/" + listId, {
      method: "POST",
    }).then(() => dispatch({ type: "post-todo", listId: listId }));
  };

  const agregarLista = (nombreLista) => {
    const request = {
      id: null,
      name: nombreLista,
    };

    fetch(HOST_API + "/todolist", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(request),
    })
      .then((response) => response.json())
      .then((list) => {
        //setTodoListas(list);
        dispatch({ type: "add-list", lista: list });
      });
  };

  return (
    <ListContext.Provider value={todoListas}>
      <agregarListaContext.Provider value={agregarLista}>
        <eliminarListaContext.Provider value={eliminarLista}>
          {children}
        </eliminarListaContext.Provider>
      </agregarListaContext.Provider>
    </ListContext.Provider>
  );
};
