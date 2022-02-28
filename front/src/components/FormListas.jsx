import React, { Component, useContext, useState } from "react";
import { HOST_API } from "../App";
import { agregarListaContext } from "../contexts/ListContext";

export const Form = () => {
  const [lista, setLista] = useState("");
  const agregarLista=  useContext(agregarListaContext);
  const handleSubmit = (e) => {
    e.preventDefault();
    agregarLista(lista);
    setLista('');
  };
  return (
    <form onSubmit={handleSubmit}>
      <input
        type="text"
        placeholder="Ingrese lista"
        value={lista}
        className="me-3"
        onChange={(e) => setLista(e.target.value)}
      ></input>

      <button className="btn btn-success" type="submit">
        Agregar Lista
      </button>
    </form>
  );
};
